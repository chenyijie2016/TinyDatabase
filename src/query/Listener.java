package query;

import data.Type;
import org.antlr.v4.runtime.misc.Interval;
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
    private List<String> expressionValueList;

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
            expressionValueList.add(ctx.NUMERIC_LITERAL().getText());
        }
        else if (ctx.STRING_LITERAL() != null) {
            String str = ctx.STRING_LITERAL().getText();
            baseExpressionValue = new BaseData(BaseData.BASE_DATA_TYPE.STRING, str.substring(1, str.length() - 1));
            expressionValueList.add(str.substring(1, str.length() - 1));
        }
        else {
            baseExpressionValue = new BaseData();
            expressionValueList.add(null);
        }
    }


    @Override
    public void exitValueExpression(TinySQLParser.ValueExpressionContext ctx) {
        valueExpressionStack.push(new ValueExpression(baseExpressionValue));
    }


    @Override
    public void exitTableColumnExpression(TinySQLParser.TableColumnExpressionContext ctx) {
        String tableName = ctx.tableName() == null ? "" : ctx.tableName().getText();
        baseExpressionValue = new BaseData(tableName, ctx.columnName().getText());
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
        }
        else {
            valueExpressionStack.push(new ValueExpression(ValueExpression.SUB_TYPE.MINUS, a, b));
        }
    }


    @Override
    public void exitLessZGreaterExpression(TinySQLParser.LessZGreaterExpressionContext ctx) {
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
    public void exitEuqalExpression(TinySQLParser.EuqalExpressionContext ctx) {
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
    public void enterCreateTableStmt(TinySQLParser.CreateTableStmtContext ctx) throws IllegalArgumentException {
        String databaseName = ctx.databaseName() == null ? "" : ctx.databaseName().getText();
        int columnNum = ctx.columnDefinition().size();
        Column[] columns = new Column[columnNum];
        List<Constraint> constraints = new ArrayList<>();
        boolean gotPrimaryKey = false;  // Is there a primary key in the declaration of columns?
        for (int i = 0; i < columnNum; i++) {
            String columnTypeStr = ctx.columnDefinition(i).typeName().name().getText().toUpperCase();
            String columnName = ctx.columnDefinition(i).columnName().getText();
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
                        throw new IllegalArgumentException("Type parsing error!");
                }
            }
            else {
                if (columnTypeStr.equals(Tokens.STRING)) {
                    long string_size;
                    try {
                        string_size = Integer.parseInt(ctx.columnDefinition(i).typeName().signedNumber().getText());
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Param of the length info cannot be parsed!");
                    }
                    if (string_size <= 0) {
                        throw new IllegalArgumentException("Length of string must be positive!");
                    }
                    columns[i] = new Column(Type.stringType(string_size), columnName);
                }
                else {
                    throw new IllegalArgumentException("Type parsing error!");
                }
            }
            // Parsed all kinds of columns, BUT NOT CHECKING duplicate names
            for (TinySQLParser.ColumnConstraintContext data: ctx.columnDefinition(i).columnConstraint()) {
                if (data.K_PRIMARY() != null) {
                    if (gotPrimaryKey) {
                        throw new IllegalArgumentException("Duplicate primary keys!");
                    }
                    gotPrimaryKey = true;
                    boolean primaryKeyAsc = (data.K_DESC() == null);
                    constraints.add(new Constraint(primaryKeyAsc ? Constraint.Order.ASC : Constraint.Order.DESC,
                                    columnName));
                }
                else {
                    constraints.add(new Constraint(Constraint.ConstraintType.NOT_NULL, columnName));
                }
            }
        }
        if (ctx.tableConstraint() != null) {
            if (gotPrimaryKey) {
                throw new IllegalArgumentException("Duplicate primary keys!");
            }
            for (TinySQLParser.IndexedColumnContext data: ctx.tableConstraint().indexedColumn()) {
                boolean primaryKeyAsc = (data.K_DESC() == null);
                constraints.add(new Constraint(primaryKeyAsc ? Constraint.Order.ASC : Constraint.Order.DESC,
                                               data.columnName().getText()));
            }
        }
        Constraint[] constraintsArray = new Constraint[constraints.size()];
        constraints.toArray(constraintsArray);
        statement = new query.statement.CreateTableStatement(databaseName, ctx.tableName().getText(), columns,
                                                             constraintsArray);
    }


    @Override
    public void enterUpdateTableStmt(TinySQLParser.UpdateTableStmtContext ctx) {
        String tableName = ctx.tableName().getText();
        int newDataLength = ctx.columnName().size();
        String[] columns = new String[newDataLength];
        for (int i = 0; i < newDataLength; i++) {
            columns[i] = ctx.columnName(i).getText();
        }
        statement = new query.statement.UpdateTableStatement(tableName, columns);
    }


    @Override
    public void exitUpdateTableStmt(TinySQLParser.UpdateTableStmtContext ctx) {
        ValueExpression[] data = new ValueExpression[valueExpressionStack.size()];
        valueExpressionStack.copyInto(data);
        valueExpressionStack.clear();
        ((UpdateTableStatement)statement).setData(data);
        ((UpdateTableStatement)statement).setWhereCondition(compareExpressionStack.pop());
    }


    @Override
    public void enterDeleteTableStmt(TinySQLParser.DeleteTableStmtContext ctx) {
        String tableName = ctx.tableName().getText();
        statement = new query.statement.DeleteTableStatement(tableName);
    }


    @Override
    public void exitDeleteTableStmt(TinySQLParser.DeleteTableStmtContext ctx) {
        ((DeleteTableStatement)statement).setWhereCondition(compareExpressionStack.pop());
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
        InsertTableStatement stmt = new InsertTableStatement();
        stmt.setTableName(ctx.tableName().getText());
        if (ctx.columnName().size() > 0 && ctx.columnName().size() != ctx.expression().size()) {
            stmt.setValid(false);
            stmt.setMessage("SQL Parse Error in [Insert Statement]: number of column must equals to number of values");
        } else if (ctx.columnName().size() > 0) {
            stmt.setSpecifiedAttribute(true);
        }

        expressionValueList = new ArrayList<>();
        statement = stmt;
    }

    @Override
    public void exitInsertTableStmt(TinySQLParser.InsertTableStmtContext ctx) {
        InsertTableStatement stmt = (InsertTableStatement) statement;
        if (stmt.isSpecifiedAttribute()) {

            for (TinySQLParser.ColumnNameContext column : ctx.columnName()) {
                if (stmt.getInsertedData().containsKey(column.getText())) {
                    stmt.setValid(false);
                    stmt.setMessage("SQL parse Error in [Insert Statement]: duplicate column name");
                    return;
                } else {
                    stmt.getInsertedData().put(column.getText(), expressionValueList.get(ctx.columnName().indexOf(column)));
                }
            }
        }
        expressionValueList = null;

    }

    @Override
    public void enterCreateDatabaseStmt(TinySQLParser.CreateDatabaseStmtContext ctx) {
        statement = new SchemaStatement(Statement.CREATE_DATABASE).setDatabaseName(ctx.databaseName().getText());
    }

    @Override
    public void enterShowDatabasesStmt(TinySQLParser.ShowDatabasesStmtContext ctx) {
        statement = new SchemaStatement(Statement.SHOW_DATABASES);
    }

    @Override
    public void enterShowDatabaseTablesStmt(TinySQLParser.ShowDatabaseTablesStmtContext ctx) {
        statement = new SchemaStatement(Statement.SHOW_DATABASE_TABLE).setDatabaseName(ctx.databaseName().getText());
    }


    @Override
    public void enterDropDatabaseStmt(TinySQLParser.DropDatabaseStmtContext ctx) {
        statement = new SchemaStatement(Statement.DROP_DATABASE).setDatabaseName(ctx.databaseName().getText());
    }

    @Override
    public void enterDropTableStmt(TinySQLParser.DropTableStmtContext ctx) {
        statement = new SchemaStatement(Statement.DROP_TABLE).setTableName(ctx.tableName().getText());
    }

    @Override
    public void exitSqlStatementList(TinySQLParser.SqlStatementListContext ctx) {
        for (Statement s: statementList) {
            s.execute();
        }
    }
}
