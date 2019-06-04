package schema;

import database.DataBase;

public class SchemaManager {
    private int id;
    private static int uid = 0;
    private DataBase currentDataBase;

    private SchemaManager(int id) {
        this.id = id;
        currentDataBase = Schema.getSchema().getDefaultDatabase();
    }

    public static SchemaManager getNewSchemaManger() {
        uid++;
        return new SchemaManager(uid);
    }

    public DataBase getCurrentDataBase() {
        return currentDataBase;
    }


}
