package query;

import org.antlr.v4.runtime.misc.Interval;
import query.statement.*;


import java.util.ArrayList;
import java.util.List;

public class Listener extends TinySQLBaseListener {
    private List<Statement> statementList;
    private Statement statement;
    private List<String> expressionValueList;

    public List<Statement> getStatementList() {
        return statementList;
    }


    @Override
    public void enterSqlStatementList(TinySQLParser.SqlStatementListContext ctx) {
        statementList = new ArrayList<>();
        // System.out.println(ctx.start);
    }


//    @Override
//    public void enterCreateDatabaseStmt(TinySQLParser.CreateDatabaseStmtContext ctx) {
//        super.enterCreateDatabaseStmt(ctx);
//        statement = new CreateDatabaseStatement(ctx.databaseName().getText());
//    }


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
    public void enterLiteralValue(TinySQLParser.LiteralValueContext ctx) {
        if (ctx.NUMERIC_LITERAL() != null) {
            //System.out.println(ctx.NUMERIC_LITERAL().getText());
            expressionValueList.add(ctx.NUMERIC_LITERAL().getText());
        } else if (ctx.STRING_LITERAL() != null) {
            //System.out.println(ctx.STRING_LITERAL().getText());
            String str = ctx.STRING_LITERAL().getText();
            expressionValueList.add(str.substring(1, str.length() - 1));
        } else if (ctx.K_NULL() != null) {
            expressionValueList.add(null);
        }
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
}
