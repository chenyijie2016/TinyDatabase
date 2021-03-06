package query.statement;

import exception.SQLExecuteException;
import query.Result;
import schema.SchemaManager;

public abstract class Statement {
    public static final int CREATE_DATABASE = 1;
    public static final int SHOW_DATABASES = 2;
    public static final int SHOW_DATABASE_TABLE = 3;
    public static final int CREATE_TABLE = 4;
    public static final int INSERT_TABLE = 5;
    public static final int SELECT_TABLE = 6;
    public static final int UPDATE_TABLE = 7;
    public static final int DELETE_TABLE = 8;
    public static final int DROP_TABLE = 9;
    public static final int DROP_DATABASE = 10;
    public static final int USE_DATABASE = 11;
    public static final int SHOW_TABLE = 12;


    public String sql;
    public int type;
    private boolean valid = true;
    private String message;

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    @Override
    public String toString() {
        return sql;
    }

    public abstract Result execute(SchemaManager schemaManager) throws SQLExecuteException;

    public boolean isValid() {
        return valid;
    }

    public Statement setValid(boolean valid) {
        this.valid = valid;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Statement setMessage(String message) {
        this.message = message;
        return this;
    }
}
