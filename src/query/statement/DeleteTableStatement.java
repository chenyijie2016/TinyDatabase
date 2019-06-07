package query.statement;

import database.DataBase;
import exception.SQLExecuteException;
import query.Result;
import query.expression.CompareExpression;
import schema.SchemaManager;
import table.Row;
import table.Table;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DeleteTableStatement extends Statement {
    private String tableName;

    private CompareExpression whereCondition;

    public DeleteTableStatement(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public Result execute(SchemaManager schemaManager) throws SQLExecuteException {
        DataBase db = schemaManager.getCurrentDataBase();
        Table table = db.getTableByName(tableName);
        if (table == null) {
            throw new SQLExecuteException("[delete table]: Table " + tableName + " not exist");
        }
        SingleTableWhereClause where = new SingleTableWhereClause(whereCondition, table);
        Table.RowIterator ans = where.parseSingleTableColumnAndValue();
        boolean needCheckAns = where.getNeedCheckAns();

        Row row = ans.next();
        int count = 0;
        Map<Table, Row> tableRowMap = new HashMap<>();
        while (row != null) {
            boolean satisfied = true;
            if (needCheckAns) {
                tableRowMap.put(table, row);
                satisfied = whereCondition.getCompareAns(tableRowMap);
            }
            if (satisfied) {
                try {
                    table.deleteRow(row);
                } catch (IOException e) {
                    throw new SQLExecuteException("[delete table]: IOException: " + e.getMessage());
                }
                count++;
            }
            row = ans.next();
        }
        return Result.setInfo("Deleted " + String.valueOf(count) + " rows");
    }

    public void setWhereCondition(CompareExpression whereCondition) {
        this.whereCondition = whereCondition;
    }
}
