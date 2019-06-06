package query.statement;

import exception.SQLExecuteException;
import query.Result;
import schema.SchemaManager;
import table.Column;
import table.Row;
import table.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InsertTableStatement extends Statement {

    private String tableName;
    private Map<String, String> insertedData = new HashMap<>(); // 对应的属性与值(字符串形式)
    private boolean specifiedAttribute;
    private List<String> data;

    public InsertTableStatement(String tableName) {
        this.tableName = tableName;
        this.type = INSERT_TABLE;
    }

    public Map<String, String> getInsertedData() {
        return insertedData;
    }

    public boolean isSpecifiedAttribute() {
        return specifiedAttribute;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public void setSpecifiedAttribute(boolean specifiedAttribute) {
        this.specifiedAttribute = specifiedAttribute;
    }

    @Override
    public Result execute(SchemaManager schemaManager) throws SQLExecuteException {
//        if (specifiedAttribute) {
//            throw new SQLExecuteException("[NOTE]: The specified attribute in INSERT statement is temporarily not supported, requiring NULL value supported first");
//        }
        Table table = schemaManager.getCurrentDataBase().getTableByName(tableName);

        if (!specifiedAttribute) {
            if (table.getColumns().size() != data.size()) {
                throw new SQLExecuteException("[insert]: Cannot match Column Size");
            }
        }

        List<Object> dataList = new ArrayList<>();
        for (Column column : table.getColumns()) {
            int index = table.getColumns().indexOf(column);
            if (data.get(index) == null) {
                dataList.add(null);
                continue;
            }
            switch (column.getColumnType().type()) {
                case STRING:
                    if (data.get(index).length() < column.getColumnType().size()) {
                        dataList.add(data.get(index));
                    } else {
                        throw new SQLExecuteException("[insert]: String length exceeds limit");
                    }
                    break;
                case LONG:
                    try {
                        dataList.add(Long.parseLong(data.get(index)));
                    } catch (NumberFormatException e) {
                        throw new SQLExecuteException("[insert]: Column type mismatch, LONG expected");
                    }
                    break;
                case INT:
                    try {
                        dataList.add(Integer.parseInt(data.get(index)));
                    } catch (NumberFormatException e) {
                        throw new SQLExecuteException("[insert]: Column type mismatch, INT expected");
                    }
                    break;
                case FLOAT:
                    try {
                        dataList.add(Float.parseFloat(data.get(index)));
                    } catch (NumberFormatException e) {
                        throw new SQLExecuteException("[insert]: Column type mismatch, FLOAT expected");
                    }
                    break;
                case DOUBLE:
                    try {
                        dataList.add(Double.parseDouble(data.get(index)));
                    } catch (NumberFormatException e) {
                        throw new SQLExecuteException("[insert]: Column type mismatch, DOUBLE expected");
                    }
                    break;
            }
        }
        try {
            Object[] temp = new Object[dataList.size()];
            dataList.toArray(temp);
            table.insertRow(new Row(table, temp));
        } catch (IOException e) {
            throw new SQLExecuteException("[insert] Unknown Error in IO operation");
        }
        return Result.setInfo("Successfully insert 1 row");
    }
}
