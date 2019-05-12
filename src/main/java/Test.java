import common.*;

public class Test {
    static Table table;

    public static void createTableWuthMetaData() {
        DataBase testDB = new DataBase(1, "database");
        table = new Table(
                testDB,
                "testTable",
                new Column[]{
                        new Column(new typeInt(), "id"),
                        new Column(new typeLong(), "zzz"),
                        new Column(new typeFloat(), "fff"),
                        new Column(new typeDouble(), "id_long"),
                        new Column(new typeString(20), "name"),
                },
                new Constraint[]{new Constraint(Constraint.Type.PRIMARY_KEY, "id")});
    }

    public static void insetTestData() {
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
        System.out.println("Table has " + table.getRowsNumber() + " rows");
        try {
            Row a = table.getRows().get(0);
            // System.out.println("Row[0] data length = " + a.data.length);
            table.deleteRow(a);
        } catch (Exception e) {
            System.out.println("Can not read row 0 " + e);
        }

    }

    public static void main(String[] args) {
        createTableWuthMetaData();
        //insetTestData();
        table.commit();
        //testDelete();
        table.commit();
    }
}
