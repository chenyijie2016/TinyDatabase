package query.statement;

import query.Result;

public class CreateTableStatement extends Statement {
    public String tableName;


    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public Result execute() {
        return null;
    }
}
