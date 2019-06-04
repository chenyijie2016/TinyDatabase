package query.statement;

import database.DataBase;
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

    public CreateTableStatement(String databaseName, String tableName, Column[] columns, Constraint[] constraints) {
        this.databaseName = databaseName;
        this.tableName = tableName;
        this.columns = columns;
        this.constraints = constraints;
    }

    @Override
    public Result execute(SchemaManager schemaManager) throws IllegalArgumentException {
        DataBase db;
        if (databaseName != null) {
            db = Schema.getSchema().getDatabaseByName(databaseName);
        } else {
            db = schemaManager.getCurrentDataBase();
        }
        try {
            if (db != null) {

                db.createTable(new Table(db, tableName, columns, constraints));
            } else {
                throw new IllegalArgumentException("SQL Execute Error [create table]: Database not specified (Default database is not available)");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("SQL Execute Error [create table]: Unknown Error");
        }
//        if (databaseName.equals("")) {
//            System.out.println("Creating table in current database:");
//        } else {
//            System.out.println("Creating table in database: " + databaseName);
//        }
//        System.out.println("    name: " + tableName);
//        for (Column c : columns) {
//            System.out.println("        columns: " + c.getName() + "  type: " + c.getColumnType().type().name());
//        }
//        for (Constraint c : constraints) {
//            System.out.println("        constraints: " + c.getColumnName() + "  type: " + c.getType().name());
//        }
        return null;
    }
}
