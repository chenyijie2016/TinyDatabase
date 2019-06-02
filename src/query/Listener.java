package query;

import org.antlr.v4.runtime.misc.Interval;
import query.statement.Statement;

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
        System.out.println(ctx.start);
    }


    @Override
    public void enterSqlStatement(TinySQLParser.SqlStatementContext ctx) {
        super.enterSqlStatement(ctx);
        //statement = new Statement();
        int a = ctx.start.getStartIndex();
        int b = ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        statement.setSql(ctx.start.getInputStream().getText(interval));
        System.out.println(ctx.getRuleIndex());
    }

    @Override
    public void exitSqlStatement(TinySQLParser.SqlStatementContext ctx) {
        statementList.add(statement);
        statement = null;
    }
}
