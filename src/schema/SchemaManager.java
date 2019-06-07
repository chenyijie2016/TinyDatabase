package schema;

import database.DataBase;
import exception.SQLExecuteException;


public class SchemaManager {
    private int id;
    private static int uid = 0;
    private DataBase currentDataBase;

    private SchemaManager(int id) {
        this.id = id;
        currentDataBase = Schema.getSchema().getDefaultDatabase();
    }


    public Schema schema() {
        return Schema.getSchema();
    }

    public static SchemaManager getNewSchemaManger() {
        uid++;
        return new SchemaManager(uid);
    }

    public DataBase getCurrentDataBase() throws SQLExecuteException {
        if (currentDataBase == null) {
            throw new SQLExecuteException("No Database Specified");
        }
        return currentDataBase;
    }

    public DataBase switchDataBase(String name) throws SQLExecuteException {
        DataBase db = Schema.getSchema().getDatabaseByName(name);
        if (db != null) {
            currentDataBase = db;
            return currentDataBase;
        } else {
            throw new SQLExecuteException("[use database]: No such database");
        }
    }

    public boolean dropDataBaseByName(String name) throws SQLExecuteException {

        return Schema.getSchema().dropDataBaseByName(name);

    }


}
