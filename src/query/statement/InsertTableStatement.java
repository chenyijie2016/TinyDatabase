package query.statement;

import data.typedData;
import query.Result;

import java.util.HashMap;
import java.util.Map;

public class InsertTableStatement extends Statement {

    private String tableName;
    private Map<String, String> insertedData = new HashMap<>(); // 对应的属性与值(字符串形势)
    private boolean specifiedAttribute;
    public InsertTableStatement() {
        this.type = INSERT_TABLE;
    }

    @Override
    public Result execute() {
        return null;
    }

    public InsertTableStatement setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public Map<String, String> getInsertedData() {
        return insertedData;
    }

    public boolean isSpecifiedAttribute() {
        return specifiedAttribute;
    }

    public void setSpecifiedAttribute(boolean specifiedAttribute) {
        this.specifiedAttribute = specifiedAttribute;
    }
}
