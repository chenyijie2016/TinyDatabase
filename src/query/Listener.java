package query;

import data.Type;
import org.antlr.v4.runtime.misc.Interval;
import query.statement.*;

import java.util.ArrayList;
import java.util.List;

import table.*;
import common.Tokens;

public class Listener extends TinySQLBaseListener {
    private List<Statement> statementList;
    private Statement statement;

    public List<Statement> getStatementList() {
        return statementList;
    }

    @Override
    public void enterSqlStatementList(TinySQLParser.SqlStatementListContext ctx) {
        statementList = new ArrayList<>();
        System.out.println(ctx.start);
    }


    @Override
    public void enterCreateTableStmt(TinySQLParser.CreateTableStmtContext ctx) throws IllegalArgumentException {
        super.enterCreateTableStmt(ctx);
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
                    // TODO: ADD primaryKeyAsc into constraints
                    constraints.add(new Constraint(Constraint.ConstraintType.PRIMARY_KEY, columnName));
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
                // TODO: ADD primaryKeyAsc into constraints
                constraints.add(new Constraint(Constraint.ConstraintType.PRIMARY_KEY, data.columnName().getText()));
            }
        }
        Constraint[] constraintsArray = new Constraint[constraints.size()];
        constraints.toArray(constraintsArray);
        statement = new query.statement.CreateTableStatement(databaseName, ctx.tableName().getText(), columns,
                                                             constraintsArray);
    }


    @Override
    public void exitSqlStatement(TinySQLParser.SqlStatementContext ctx) {
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        statement.setSql(ctx.start.getInputStream().getText(interval));
        System.out.println(ctx.getRuleIndex());
        statementList.add(statement);
        statement = null;
    }


    @Override
    public void exitSqlStatementList(TinySQLParser.SqlStatementListContext ctx) {
        for (Statement s: statementList) {
            s.execute();
        }
    }
}
