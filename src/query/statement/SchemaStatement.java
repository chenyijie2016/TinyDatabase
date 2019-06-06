package query.statement;

import data.Type;
import data.intData;
import data.stringData;
import database.DataBase;
import exception.SQLExecuteException;
import query.Result;
import schema.SchemaManager;
import table.Column;
import table.Row;
import table.Table;

import java.io.IOException;

public class SchemaStatement extends Statement {
    private String databaseName;
    private String tableName;

    public SchemaStatement(int type) {
        this.type = type;
    }

    @Override
    public Result execute(SchemaManager schemaManager) throws SQLExecuteException {
        Result result = null;
        switch (this.type) {
            case CREATE_DATABASE:
                schemaManager.schema().createDatabaseByName(databaseName);
                result = Result.setInfo("successfully create database: " + databaseName);
                break;
            case DROP_DATABASE:
                schemaManager.schema().dropDataBaseByName(databaseName);
                result = Result.setInfo("successfully drop database: " + databaseName);
                break;
            case DROP_TABLE:
                DataBase db;
                if (databaseName != null) {
                    db = schemaManager.schema().getDatabaseByName(databaseName);
                } else {
                    db = schemaManager.getCurrentDataBase();
                }
                db.dropTableByName(tableName);
                result = Result.setInfo("successfully drop table: " + tableName);
                break;
            case SHOW_DATABASE_TABLE:
                DataBase db_ = schemaManager.schema().getDatabaseByName(databaseName);
                if (db_ == null) {
                    throw new SQLExecuteException("[show database]: No Such Database");
                }
                result = new Result();
                result.setColumns(new Column[]{new Column(Type.intType(), "ID"), new Column(Type.stringType(32), "table")});
                for (Table table : db_.getTables()) {
                    result.addRow(new Row(result, new Object[]{db_.getTables().indexOf(table), table.getTableName()}));
                }
                break;
            case SHOW_DATABASES:
                result = new Result();
                result.setColumns(new Column[]{new Column(Type.intType(), "ID"), new Column(Type.stringType(32), "NAME")});
                int id = 1;
                for (DataBase dataBase : schemaManager.schema().getDataBases()) {
                    result.addRow(new Row(result, new Object[]{id, dataBase.getName()}));
                    id++;
                }
                break;

        }
        return result;
    }

    public SchemaStatement setDatabaseName(String databaseName) {
        this.databaseName = databaseName.toUpperCase();
        return this;
    }

    public SchemaStatement setTableName(String tableName) {
        this.tableName = tableName.toUpperCase();
        return this;
    }
}
