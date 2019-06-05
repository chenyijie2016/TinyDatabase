package query.statement;

import database.DataBase;
import exception.SQLExecuteException;
import query.Result;
import schema.Schema;
import schema.SchemaManager;
import table.*;

import java.io.IOException;

public class CreateTableStatement extends Statement {
    private String databaseName;
    private String tableName;
    private Column[] columns; // 属性列表
    private Constraint[] constraints; // 约束

    public CreateTableStatement() {
        this.type = CREATE_TABLE;
    }

    public CreateTableStatement(String databaseName, String tableName, Column[] columns, Constraint[] constraints) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.columns = columns;
        this.constraints = constraints;
        this.type = CREATE_TABLE;
    }

    @Override
    public Result execute(SchemaManager schemaManager) throws SQLExecuteException {
        DataBase db;
        if (databaseName != null) {
            db = schemaManager.schema().getDatabaseByName(databaseName);
        } else {
            db = schemaManager.getCurrentDataBase();
        }
        try {
            if (db != null) {
                db.createTable(new Table(db, tableName, columns, constraints));
            } else {
                throw new SQLExecuteException("[create table]: Database not specified (Default database is not available)");
            }
        } catch (IOException e) {
            throw new SQLExecuteException("[create table]: Unknown Error");
        }
        return Result.setInfo("successfully create table " + tableName);
    }
}
