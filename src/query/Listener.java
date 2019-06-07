package query;

import data.Type;
import org.antlr.v4.runtime.misc.Interval;
import query.resultColumn.ResultColumn;
import query.statement.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import table.*;
import common.Tokens;
import query.expression.*;

public class Listener extends TinySQLBaseListener {
    private List<Statement> statementList;
    private Statement statement;
    private Stack<ValueExpression> valueExpressionStack = new Stack<>();
    private Stack<CompareExpression> compareExpressionStack = new Stack<>();
    private BaseData baseExpressionValue;
    private List<ResultColumn> resultColumnList = new ArrayList<>();
    private List<String> tableNamesForSelect = new ArrayList<>();
    private List<SelectTableStatement.JOIN_TYPE> joinOperatorsForSelect = new ArrayList<>();

    // TODO: remove it
    private List<String> expressionToInsertList;

    public List<Statement> getStatementList() {
        return statementList;
    }


    @Override
    public void enterSqlStatementList(TinySQLParser.SqlStatementListContext ctx) {
        statementList = new ArrayList<>();
        // System.out.println(ctx.start);
    }


    // DEAL WITH EXPRESSIONS
    @Override
    public void enterLiteralValue(TinySQLParser.LiteralValueContext ctx) {
        if (ctx.NUMERIC_LITERAL() != null) {
            baseExpressionValue = new BaseData(BaseData.BASE_DATA_TYPE.NUMBER, ctx.NUMERIC_LITERAL().getText());

            if (ctx.getParent().getParent() instanceof TinySQLParser.InsertTableStmtContext) {
                expressionToInsertList.add(ctx.NUMERIC_LITERAL().getText());
            }
        } else if (ctx.STRING_LITERAL() != null) {
            String str = ctx.STRING_LITERAL().getText();
            baseExpressionValue = new BaseData(BaseData.BASE_DATA_TYPE.STRING, str.substring(1, str.length() - 1));
            if (ctx.getParent().getParent() instanceof TinySQLParser.InsertTableStmtContext) {
                expressionToInsertList.add(str.substring(1, str.length() - 1));
            }

        } else {
            baseExpressionValue = new BaseData();
            if (ctx.getParent().getParent() instanceof TinySQLParser.InsertTableStmtContext) {
                expressionToInsertList.add(null);
            }
        }
    }


    @Override
    public void exitValueExpression(TinySQLParser.ValueExpressionContext ctx) {
        valueExpressionStack.push(new ValueExpression(baseExpressionValue));
    }


    @Override
    public void exitTableColumnExpression(TinySQLParser.TableColumnExpressionContext ctx) {
        String tableName = ctx.tableName() == null ? null : ctx.tableName().getText().toUpperCase();
        baseExpressionValue = new BaseData(tableName, ctx.columnName().getText().toUpperCase());
        valueExpressionStack.push(new ValueExpression(baseExpressionValue));
    }


    @Override
    public void exitUnaryExpression(TinySQLParser.UnaryExpressionContext ctx) {
        int rule_type = ctx.unaryOperator().getRuleIndex();
        ValueExpression.SUB_TYPE subType;
        switch (rule_type) {
            case 0:
                subType = ValueExpression.SUB_TYPE.NEG;
                break;
            case 1:
                subType = ValueExpression.SUB_TYPE.POS;
                break;
            case 2:
                subType = ValueExpression.SUB_TYPE.BIT_REVERSE;
                break;
            default:
                subType = ValueExpression.SUB_TYPE.NOT;
                break;
        }
        valueExpressionStack.push(new ValueExpression(subType, valueExpressionStack.pop()));
    }


    @Override
    public void exitAddSubExpression(TinySQLParser.AddSubExpressionContext ctx) {
        ValueExpression b = valueExpressionStack.pop();
        ValueExpression a = valueExpressionStack.pop();
        if (ctx.getChild(1).getText().charAt(0) == '+') {
            valueExpressionStack.push(new ValueExpression(ValueExpression.SUB_TYPE.ADD, a, b));
        } else {
            valueExpressionStack.push(new ValueExpression(ValueExpression.SUB_TYPE.MINUS, a, b));
        }
    }


    @Override
    public void exitLessGreaterExpression(TinySQLParser.LessGreaterExpressionContext ctx) {
        ValueExpression b = valueExpressionStack.pop();
        ValueExpression a = valueExpressionStack.pop();
        switch (ctx.getChild(1).getText()) {
            case "<":
                compareExpressionStack.push(new CompareExpression(CompareExpression.COMPARE_SUB_TYPE.LT, a, b));
                break;
            case "<=":
                compareExpressionStack.push(new CompareExpression(CompareExpression.COMPARE_SUB_TYPE.LTE, a, b));
                break;
            case ">":
                compareExpressionStack.push(new CompareExpression(CompareExpression.COMPARE_SUB_TYPE.GT, a, b));
                break;
            default:
                compareExpressionStack.push(new CompareExpression(CompareExpression.COMPARE_SUB_TYPE.GTE, a, b));
                break;
        }
    }

    @Override
    public void exitAndExpression(TinySQLParser.AndExpressionContext ctx) {
        CompareExpression b = compareExpressionStack.pop();
        CompareExpression a = compareExpressionStack.pop();
        compareExpressionStack.push(new CompareExpression(CompareExpression.COMPARE_TYPE.AND, a, b));
    }

    @Override
    public void exitOrExpression(TinySQLParser.OrExpressionContext ctx) {
        CompareExpression b = compareExpressionStack.pop();
        CompareExpression a = compareExpressionStack.pop();
        compareExpressionStack.push(new CompareExpression(CompareExpression.COMPARE_TYPE.OR, a, b));
    }


    @Override
    public void exitEqualExpression(TinySQLParser.EqualExpressionContext ctx) {
        ValueExpression b = valueExpressionStack.pop();
        ValueExpression a = valueExpressionStack.pop();
        switch (ctx.getChild(1).getText()) {
            case "=":
            case "==":
                compareExpressionStack.push(new CompareExpression(CompareExpression.COMPARE_SUB_TYPE.EQ, a, b));
                break;
            default:
                compareExpressionStack.push(new CompareExpression(CompareExpression.COMPARE_SUB_TYPE.NEQ, a, b));
                break;
        }
    }


    @Override
    public void enterCreateTableStmt(TinySQLParser.CreateTableStmtContext ctx) {
        String databaseName = ctx.databaseName() == null ? null : ctx.databaseName().getText();
        int columnNum = ctx.columnDefinition().size();
        Column[] columns = new Column[columnNum];
        List<Constraint> constraints = new ArrayList<>();
        boolean gotPrimaryKey = false;  // Is there a primary key in the declaration of columns?
        for (int i = 0; i < columnNum; i++) {
            String columnTypeStr = ctx.columnDefinition(i).typeName().name().getText().toUpperCase();
            String columnName = ctx.columnDefinition(i).columnName().getText().toUpperCase();
            if (ctx.columnDefinition(i).typeName().signedNumber() == null) {
                switch (columnTypeStr) {
                    case Tokens.DOUBLE:
                        columns[i] = new Column(Type.doubleType(), columnName);
                        break;
                    case Tokens.FLOAT:
                        columns[i] = new Column(Type.floatType(), columnName);
                        break;
                    case Tokens.INT:
                        columns[i] = new Column(Type.intType(), columnName);
                        break;
                    case Tokens.LONG:
                        columns[i] = new Column(Type.longType(), columnName);
                        break;
                    default:
                        statement = new CreateTableStatement().setValid(false).setMessage("Type parsing error!");
                        return;
                }
            } else {
                if (columnTypeStr.equals(Tokens.STRING)) {
                    long string_size;
                    try {
                        string_size = Integer.parseInt(ctx.columnDefinition(i).typeName().signedNumber().getText());
                    } catch (NumberFormatException e) {
                        statement = new CreateTableStatement().setValid(false).setMessage("Param of the length info cannot be parsed!");
                        return;
                    }
                    if (string_size <= 0) {
                        statement = new CreateTableStatement().setValid(false).setMessage("Length of string must be positive!");
                        return;
                    }
                    columns[i] = new Column(Type.stringType(string_size), columnName);
                } else {
                    statement = new CreateTableStatement().setValid(false).setMessage("Type parsing error!");
                    return;
                }
            }
            // Parsed all kinds of columns, BUT NOT CHECKING duplicate names
            for (TinySQLParser.ColumnConstraintContext data : ctx.columnDefinition(i).columnConstraint()) {
                if (data.K_PRIMARY() != null) {
                    if (gotPrimaryKey) {
                        statement = new CreateTableStatement().setValid(false).setMessage("Duplicate primary keys!");
                        return;
                    }
                    gotPrimaryKey = true;
                    boolean primaryKeyAsc = (data.K_DESC() == null);
                    constraints.add(new Constraint(primaryKeyAsc ? Constraint.Order.ASC : Constraint.Order.DESC,
                            columnName));
                } else {
                    constraints.add(new Constraint(Constraint.ConstraintType.NOT_NULL, columnName));
                }
            }
        }
        if (ctx.tableConstraint() != null) {
            if (gotPrimaryKey) {
                statement = new CreateTableStatement().setValid(false).setMessage("Duplicate primary keys!");
                return;
            }
            for (TinySQLParser.IndexedColumnContext data : ctx.tableConstraint().indexedColumn()) {
                boolean primaryKeyAsc = (data.K_DESC() == null);
                constraints.add(new Constraint(primaryKeyAsc ? Constraint.Order.ASC : Constraint.Order.DESC,
                        data.columnName().getText().toUpperCase()));
            }
        }
        Constraint[] constraintsArray = new Constraint[constraints.size()];
        constraints.toArray(constraintsArray);
        statement = new query.statement.CreateTableStatement(databaseName, ctx.tableName().getText().toUpperCase(), columns,
                constraintsArray);
    }


    @Override
    public void exitResultColumn(TinySQLParser.ResultColumnContext ctx) {
        if (ctx.tableName() != null) {
            resultColumnList.add(new ResultColumn(ctx.tableName().getText().toUpperCase()));
        } else if (ctx.expression() != null) {
            resultColumnList.add(new ResultColumn(valueExpressionStack.pop()));
        } else {
            resultColumnList.add(new ResultColumn());
        }
    }


    @Override
    public void exitJoinClause(TinySQLParser.JoinClauseContext ctx) {
        for (TinySQLParser.TableNameContext tableName : ctx.tableName()) {
            tableNamesForSelect.add(tableName.getText().toUpperCase());
        }
        for (TinySQLParser.JoinOperatorContext joinOperator : ctx.joinOperator()) {
            SelectTableStatement.JOIN_TYPE type;
            // TODO: check for whether there is on clause
            if (joinOperator.K_JOIN() == null) {
                type = SelectTableStatement.JOIN_TYPE.CROSS;
            } else {
                if (joinOperator.K_LEFT() != null) {
                    type = SelectTableStatement.JOIN_TYPE.LEFT_OUTER;
                } else if (joinOperator.K_NATURAL() != null) {
                    type = SelectTableStatement.JOIN_TYPE.NATURAL;
                } else {
                    type = SelectTableStatement.JOIN_TYPE.INNER_ON;
                }
            }
            joinOperatorsForSelect.add(type);
        }
    }


    @Override
    public void exitSelectTableStmt(TinySQLParser.SelectTableStmtContext ctx) {
        int tableNamesSize = ctx.tableName().size();
        CompareExpression whereCondition = ctx.conditionExpression() == null ? null : compareExpressionStack.pop();
        if (ctx.joinClause() == null) {
            for (int i = 0; i < tableNamesSize; i++) {
                tableNamesForSelect.add(ctx.tableName(i).getText().toUpperCase());
                joinOperatorsForSelect.add(SelectTableStatement.JOIN_TYPE.CROSS);
            }
            if (tableNamesSize > 0) {
                joinOperatorsForSelect.remove(0);
            }
        }
        SelectTableStatement.SELECT_TYPE selectType = ctx.K_DISTINCT() == null ? SelectTableStatement.SELECT_TYPE.ALL :
                SelectTableStatement.SELECT_TYPE.DISTINCT;
        ResultColumn[] resultColumns = new ResultColumn[resultColumnList.size()];
        resultColumnList.toArray(resultColumns);
        String[] tableNamesForSelectStrs = new String[tableNamesForSelect.size()];
        tableNamesForSelect.toArray(tableNamesForSelectStrs);
        SelectTableStatement.JOIN_TYPE[] joinOperatorsForSelects =
                new SelectTableStatement.JOIN_TYPE[joinOperatorsForSelect.size()];
        joinOperatorsForSelect.toArray(joinOperatorsForSelects);
        CompareExpression[] joinConstraints = new CompareExpression[compareExpressionStack.size()];
        compareExpressionStack.toArray(joinConstraints);
        statement = new query.statement.SelectTableStatement(selectType, resultColumns,
                tableNamesForSelectStrs,
                joinOperatorsForSelects,
                joinConstraints,  // joinConstraint
                whereCondition);
        resultColumnList.clear();
        compareExpressionStack.clear();
        tableNamesForSelect.clear();
        joinOperatorsForSelect.clear();
    }


    @Override
    public void enterUpdateTableStmt(TinySQLParser.UpdateTableStmtContext ctx) {
        String tableName = ctx.tableName().getText().toUpperCase();
        int newDataLength = ctx.columnName().size();
        String[] columns = new String[newDataLength];
        for (int i = 0; i < newDataLength; i++) {
            columns[i] = ctx.columnName(i).getText().toUpperCase();
        }
        statement = new query.statement.UpdateTableStatement(tableName, columns);
    }


    @Override
    public void exitUpdateTableStmt(TinySQLParser.UpdateTableStmtContext ctx) {
        ValueExpression[] data = new ValueExpression[valueExpressionStack.size()];
        valueExpressionStack.copyInto(data);
        valueExpressionStack.clear();
        ((UpdateTableStatement) statement).setData(data);
        ((UpdateTableStatement) statement).setWhereCondition(compareExpressionStack.pop());
    }


    @Override
    public void enterDeleteTableStmt(TinySQLParser.DeleteTableStmtContext ctx) {
        String tableName = ctx.tableName().getText().toUpperCase();
        statement = new query.statement.DeleteTableStatement(tableName);
    }


    @Override
    public void exitDeleteTableStmt(TinySQLParser.DeleteTableStmtContext ctx) {
        ((DeleteTableStatement) statement).setWhereCondition(compareExpressionStack.pop());
        compareExpressionStack.clear();
    }


    @Override
    public void exitSqlStatement(TinySQLParser.SqlStatementContext ctx) {
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        statement.setSql(ctx.start.getInputStream().getText(interval));
        statementList.add(statement);
        statement = null;
    }


    @Override
    public void enterInsertTableStmt(TinySQLParser.InsertTableStmtContext ctx) {
        InsertTableStatement stmt = new InsertTableStatement(ctx.tableName().getText().toUpperCase());

        if (ctx.columnName().size() > 0 && ctx.columnName().size() != ctx.expression().size()) {
            stmt.setValid(false);
            stmt.setMessage("[Insert Statement]: number of column must equals to number of values");
        } else if (ctx.columnName().size() > 0) {
            stmt.setSpecifiedAttribute(true);
        }
        if (stmt.isSpecifiedAttribute()) {
            for (TinySQLParser.ColumnNameContext columnNameContext : ctx.columnName()) {
                stmt.getColumnNames().add(columnNameContext.getText().toUpperCase());
            }
        }

        expressionToInsertList = new ArrayList<>();
        statement = stmt;
    }

    @Override
    public void exitInsertTableStmt(TinySQLParser.InsertTableStmtContext ctx) {
        InsertTableStatement stmt = (InsertTableStatement) statement;
        stmt.setData(expressionToInsertList);
        expressionToInsertList = null;
        valueExpressionStack.clear();
    }

    @Override
    public void enterCreateDatabaseStmt(TinySQLParser.CreateDatabaseStmtContext ctx) {
        statement = new SchemaStatement(Statement.CREATE_DATABASE).setDatabaseName(ctx.databaseName().getText().toUpperCase());
    }

    @Override
    public void enterShowDatabasesStmt(TinySQLParser.ShowDatabasesStmtContext ctx) {
        statement = new SchemaStatement(Statement.SHOW_DATABASES);
    }

    @Override
    public void enterShowDatabaseTablesStmt(TinySQLParser.ShowDatabaseTablesStmtContext ctx) {
        statement = new SchemaStatement(Statement.SHOW_DATABASE_TABLE).setDatabaseName(ctx.databaseName().getText().toUpperCase());
    }


    @Override
    public void enterDropDatabaseStmt(TinySQLParser.DropDatabaseStmtContext ctx) {
        statement = new SchemaStatement(Statement.DROP_DATABASE).setDatabaseName(ctx.databaseName().getText().toUpperCase());
    }

    @Override
    public void enterUseDatabaseStmt(TinySQLParser.UseDatabaseStmtContext ctx) {
        statement = new SchemaStatement(Statement.USE_DATABASE).setDatabaseName(ctx.databaseName().getText().toUpperCase());
    }

    @Override
    public void enterDropTableStmt(TinySQLParser.DropTableStmtContext ctx) {
        statement = new SchemaStatement(Statement.DROP_TABLE).setTableName(ctx.tableName().getText().toUpperCase());
    }

    @Override
    public void exitSqlStatementList(TinySQLParser.SqlStatementListContext ctx) {
    }
}
