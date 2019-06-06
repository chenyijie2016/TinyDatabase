package query.statement;

import data.*;
import database.DataBase;
import exception.SQLExecuteException;
import query.Result;
import query.expression.*;
import schema.SchemaManager;
import table.Column;
import table.Row;
import table.Table;

import java.io.IOException;

public class UpdateTableStatement extends Statement {
    private String tableName;
    private String[] columnNames;

    private ValueExpression[] data;
    private CompareExpression whereCondition;

    public UpdateTableStatement(String tableName, String[] columnNames) {
        this.tableName = tableName;
        this.columnNames = columnNames;
    }

    @Override
    public Result execute(SchemaManager schemaManager) throws SQLExecuteException {
        DataBase db = schemaManager.getCurrentDataBase();
        Table table = db.getTableByName(tableName);
        if (table == null) {
            throw new SQLExecuteException("[update table]: Table " + tableName + " not exist");
        }
        WhereClause where = new WhereClause(whereCondition, table);
        Table.RowIterator ans = where.parseSingleTableColumnAndValue();

        if (columnNames.length != data.length) {
            throw new SQLExecuteException("[update table]: Internal error: Data num and column num not match");
        }
        Column[] columns = new Column[columnNames.length];
        typedData[] newData = new typedData[columnNames.length];
        for (int i = 0; i < columnNames.length; i++) {
            columns[i] = table.getColumnByName(columnNames[i]);
            if (columns[i] == null) {
                throw new SQLExecuteException("[update table]: Column " + columnNames[i] + " not exist");
            }
            BaseData baseData;
            try {
                baseData = data[i].simplifyValueDataThatIsNotColumn();
            }
            catch (IllegalArgumentException e) {
                throw new SQLExecuteException("[update table]: New data error: " + e.getMessage());
            }

            switch (columns[i].getColumnType().type()) {
                case STRING:
                    if (baseData.getBaseDataType() != BaseData.BASE_DATA_TYPE.STRING) {
                        // TODO: add null search
                        throw new SQLExecuteException("[where clause]: Need string here");
                    }
                    newData[i] = new stringData(baseData.getData(), columns[i].getColumnType().size());
                    break;
                case INT:
                    if (baseData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                        // TODO: add null search
                        throw new SQLExecuteException("[where clause]: Need int here");
                    }
                    newData[i] = new intData(baseData.getNumberData().intValue());
                    break;
                case LONG:
                    if (baseData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                        // TODO: add null search
                        throw new SQLExecuteException("[where clause]: Need long here");
                    }
                    newData[i] = new longData(baseData.getNumberData().longValue());
                    break;
                case DOUBLE:
                    if (baseData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                        // TODO: add null search
                        throw new SQLExecuteException("[where clause]: Need double here");
                    }
                    newData[i] = new doubleData(baseData.getNumberData());
                    break;
                case FLOAT:
                    if (baseData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                        // TODO: add null search
                        throw new SQLExecuteException("[where clause]: Need float here");
                    }
                    newData[i] = new floatData(baseData.getNumberData().floatValue());
                    break;
                default:
                    throw new SQLExecuteException("[where clause]: Column type wrong");
            }
        }

        Row row = ans.next();
        int count = 0;
        while (row != null) {
            Row update = new Row(row);
            for (int i = 0; i < columns.length; i++) {
                update.setDataByColumn(columns[i], newData[i]);
            }
            count++;
            try {
                table.updateRow(row, update);
            }
            catch (IOException e) {
                throw new SQLExecuteException("[update table]: IOException: " + e.getMessage());
            }
            row = ans.next();
        }
        return Result.setInfo("Updated " + String.valueOf(count) + " rows");
    }

    public void setData(ValueExpression[] data) {
        this.data = data;
    }

    public void setWhereCondition(CompareExpression whereCondition) {
        this.whereCondition = whereCondition;
    }
}
