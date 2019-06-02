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
        System.out.println(ctx.start);
    }


    @Override
    public void enterCreateTableStmt(TinySQLParser.CreateTableStmtContext ctx) {
        super.enterCreateTableStmt(ctx);
        String databaseName = ctx.databaseName() == null ? "" : ctx.databaseName().getText();
        int columnNum = ctx.columnDefinition().size();
        String[] columnsName = new String[columnNum];
        String[] columnsTypeName = new String[columnNum];
        Boolean[] columnsIsNotNull = new Boolean[columnNum];
        for (int i = 0; i < columnNum; i++) {
            columnsName[i] = ctx.columnDefinition(i).columnName().getText();
            columnsTypeName[i] = ctx.columnDefinition(i).typeName().getText();






        }
        String[] primaryKeys;
        Boolean[] primaryKeysAsc;
        int primaryKeySize = 0;
        if (ctx.tableConstraint() != null) {
            primaryKeySize = ctx.tableConstraint().indexedColumn().size();
            primaryKeys = new String[primaryKeySize];
            primaryKeysAsc = new Boolean[primaryKeySize];
            for (int i = 0; i < primaryKeySize; i++) {
                primaryKeys[i] = ctx.tableConstraint().indexedColumn(i).columnName().getText();
                primaryKeysAsc[i] = (ctx.tableConstraint().indexedColumn(i).K_DESC() == null);
            }
        }
        else {
            primaryKeys = new String[0];
            primaryKeysAsc = new Boolean[0];
        }
        statement = new query.statement.CreateTableStatement(databaseName, ctx.tableName().getText(),
                                                             columnNum, columnsName, columnsTypeName,
                                                             primaryKeySize, primaryKeys, primaryKeysAsc);
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
