package query.statement;

import query.Result;
import schema.SchemaManager;

public class SchemaStatement extends Statement {
    private String databaseName;
    private String tableName;

    public SchemaStatement(int type) {
        this.type = type;
    }

    @Override
    public Result execute(SchemaManager schemaManager) {
        switch (this.type) {
            case CREATE_DATABASE:
                break;

        }
        return null;
    }

    public SchemaStatement setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    public SchemaStatement setTableName(String tableName) {
        this.tableName = tableName;
        return this;
    }
}
