package query.statement;

import data.*;
import database.DataBase;
import exception.SQLExecuteException;
import query.Result;
import query.expression.BaseData;
import query.expression.CompareExpression;
import query.expression.ValueExpression;
import schema.SchemaManager;
import table.Column;
import table.Row;
import table.Table;

import java.io.IOException;

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
        WhereClause where = new WhereClause(whereCondition, table);
        Table.RowIterator ans = where.parseSingleTableColumnAndValue();

        Row row = ans.next();
        int count = 0;
        while (row != null) {
            try {
                table.deleteRow(row);
            }
            catch (IOException e) {
                throw new SQLExecuteException("[delete table]: IOException: " + e.getMessage());
            }
            count++;
            row = ans.next();
        }
        return Result.setInfo("Deleted " + String.valueOf(count) + " rows");
    }

    public void setWhereCondition(CompareExpression whereCondition) {
        this.whereCondition = whereCondition;
    }
}
