import data.Type;
import data.intData;

import java.io.IOException;


public class Test {
    static Table table;

    public static void createTableWithMetaData() {
        DataBase testDB = new DataBase(1, "test");
        table = new Table(
                testDB,
                "table",
                new Column[]{
                        new Column(Type.intType(), "id"),
                        new Column(Type.longType(), "zzz"),
                        new Column(Type.floatType(), "fff_"),
                        new Column(Type.doubleType(), "id_double"),
                        new Column(Type.stringType(20), "name"),
                },
                new Constraint[]{new Constraint(Constraint.Type.PRIMARY_KEY, "id")});
    }

    public static void insetTestData() throws IOException {
        Row[] rows = new Row[10];
        Integer i = 1;
        Long l = 1231L;
        Float f = 41.266f;
        Double d = 451.1244;
        String s = "This is a test";
        rows[0] = new Row(table);
        rows[1] = new Row(table);
        rows[2] = new Row(table);
        rows[0].setData(new Object[]{i, l, f, d, s});
        rows[1].setData(new Object[]{i + 1, l, f, d, s});
        rows[2].setData(new Object[]{i + 2, l, f, d, s});
        System.out.println("Row size = " + table.getRowSize());
        table.insertRow(rows[0]);
        table.insertRow(rows[1]);
        table.insertRow(rows[2]);
    }

    public static void testDelete() {
        try {
            Row a = table.scanEqual(new Column(Type.intType(), "id"), new intData(2));
            // System.out.println("Row[0] data length = " + a.data.length);
            if (a != null) {
                System.out.println("Found Row:" + a);
                table.deleteRow(a);
            }

        } catch (Exception e) {
            System.out.println("Can not read row 0 " + e);
        }

    }

    public static void main(String[] args) throws IOException {
        createTableWithMetaData();
        insetTestData();
        table.commit();
        testDelete();
        table.commit();
    }
}
