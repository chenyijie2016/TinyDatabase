import common.*;

import java.nio.ByteBuffer;

public class Table {
    private DataBase database;
    // private int id;
    private String tableName;
    private int nColumns;
    private int nRows;
    private Type[] types;

    public final void dumpToDisk() {

    }

    public Table(DataBase database, String tablename) {
        this.database = database;
        this.tableName = tablename;
    }

    public void setTypes(Type[] t) {
        this.nColumns = t.length;
        this.types = t;
    }

    public Type[] getTypes() {
        return types;
    }


    public static void main(String[] args) {
        DataBase testDB = new DataBase(1, "database");
        Table table = new Table(testDB, "testTable");
        Type[] a = new Type[5];
        a[0] = new typeInt();
        a[1] = new typeLong();
        a[2] = new typeFloat();
        a[3] = new typeDouble();
        a[4] = new typeString(10);
        table.setTypes(a);
        Row[] rows = new Row[10];
        Integer i = 0;
        Long l = 1231L;
        float f = 41.266f;
        double d = 451.1244;
        String s = "1233123";
        rows[0] = new Row(table);
        rows[0].setData(new Object[]{i, l, f, d, s});
        System.out.println(rows[0].getRawData());
    }
}
