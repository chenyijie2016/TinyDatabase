public class DataBase {
    private int id;
    private String databaseName;

    public DataBase(int id, String name) {
        this.id = id;
        this.databaseName = name;
    }
    public String getName(){
        return this.databaseName;
    }
    
}
