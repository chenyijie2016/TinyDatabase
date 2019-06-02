package query;

import org.antlr.v4.runtime.misc.Interval;
import query.statement.*;

import java.util.ArrayList;
import java.util.List;

public class Listener extends TinySQLBaseListener {
    private List<Statement> statementList;
    private Statement statement;

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
    public void enterCreateTableStmt(TinySQLParser.CreateTableStmtContext ctx) {
        CreateTableStatement stmt = new CreateTableStatement();


        statement = stmt;
    }
}
