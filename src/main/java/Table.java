public class Table {
    private DataBase database;
    // private int id;
    private String tableName;

    public Table(DataBase database, String tablename) {
        this.database = database;
        this.tableName = tablename;
    }
}
