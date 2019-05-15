import data.*;

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
                        new Column(Type.stringType(20), "name"),
                        new Column(Type.stringType(20), "dept_name"),
                        new Column(Type.intType(), "salary")
                        ,
                },
                new Constraint[]{new Constraint(Constraint.ConstraintType.PRIMARY_KEY, "id")});
    }

    public static void insetTestData() throws IOException {


        System.out.println("Row size = " + table.getRowSize());
        table.insertRow(new Row(table, new Object[]{10101, "Srinivasan", "Comp. Sci.", 65000}));
        table.insertRow(new Row(table, new Object[]{12121, "Wu", "Finance", 90000}));
        table.insertRow(new Row(table, new Object[]{15151, "Mozart", "Music", 40000}));
        table.insertRow(new Row(table, new Object[]{22222, "Einstein", "Physics", 95000}));
        table.insertRow(new Row(table, new Object[]{32343, "El Said", "History", 60000}));
        table.insertRow(new Row(table, new Object[]{33456, "Gold", "Physics", 87000}));
        table.insertRow(new Row(table, new Object[]{45565, "Katz", "Comp.Sci.", 75000}));
        table.insertRow(new Row(table, new Object[]{58583, "Califieri", "History", 62000}));
        table.insertRow(new Row(table, new Object[]{76543, "Singh", "Finance", 80000}));
        table.insertRow(new Row(table, new Object[]{76766, "Crick", "Biology", 72000}));
        table.insertRow(new Row(table, new Object[]{98345, "Kim", "Elec.Eng.", 80000}));
        table.insertRow(new Row(table, new Object[]{83821, "Brandt", "Comp.Sci.", 92000}));

    }

    public static void testDelete() {
        try {
            Table.RowIterator a = table.scanEqual(new Column(Type.intType(), "id"), new intData(12121));
            // System.out.println("Row[0] data length = " + a.data.length);
            Row b = a.next();
            while (b != null) {
                System.out.println("Found Row:" + b);
                b = a.next();
            }
        } catch (Exception e) {
            System.out.println("Can not read row 0 " + e);
        }

    }

    public static void testSearch() throws IOException {
        // Case One: equal search
        System.out.println("== Case 1: Find id=12121");
        Table.RowIterator a = table.scanEqual(new Column(Type.intType(), "id"), new intData(12121));
        Row b = a.next();
        while (b != null) {
            System.out.println(b);
            b = a.next();
        }

        System.out.println("== Case 2: Find salary>=80000");
        a = table.scanGreaterEqual(new Column(Type.intType(), "salary"), new intData(80000));
        b = a.next();
        while (b != null) {
            System.out.println(b);
            b = a.next();
        }

        System.out.println("== Case 3: Find who's dept_name=='Comp.Sci.'");
        a = table.scanEqual(new Column(Type.stringType(20), "dept_name"), new stringData("Comp.Sci."));
        b = a.next();
        while (b != null) {
            System.out.println(b);
            b = a.next();
        }
        System.out.println("== Case 4: Find who's id> 30000 ");
        a = table.scanGreaterEqual(new Column(Type.intType(), "id"), new intData(30000));
        b = a.next();
        while (b != null) {
            System.out.println(b);
            b = a.next();
        }
    }

    public static void main(String[] args) throws IOException {
        createTableWithMetaData();
        insetTestData();
        table.commit();
        testSearch();
//        testDelete();
        table.commit();
    }
}
