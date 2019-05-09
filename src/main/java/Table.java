import common.*;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private DataBase database;
    private String tableName;
    private int nColumns;
    private int nRows;
    private String[] columnNames;
    private Type[] types;
    private String indexFileName;
    private String dataFileName;
    private List<Row> Rows;
    private List<Row> toInsertRows;
    private List<Row> toDeleteRows;
    private RandomAccessFile dataFile;
    private RandomAccessFile indexFile;
    public Table(DataBase db, String tablename) {
        database = db;
        tableName = tablename;
        indexFileName = database.getName() + "_" + this.tableName + ".index";
        dataFileName = database.getName() + "_" + this.tableName + ".data";
        try {
            dataFile = new RandomAccessFile(this.dataFileName, "rw");
            indexFile = new RandomAccessFile(this.indexFileName, "rw");
            if (dataFile.length() == 0) {
                dataFile.writeInt(-1);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        Rows = new ArrayList<Row>();

    }

    public final void dumpToDisk() {

    }

    public void readRows() {
        try {
            dataFile.seek(4); // For free list
            long length = dataFile.length();
            long rowSize = getRowSize();
            for (long i = 4; i < length; i += rowSize) {
                Object[] objs = new Object[types.length];
                for (int j = 0; j < types.length; j++) {
                    switch (types[j].getType()) {
                        case Types.INT:
                            objs[j] = dataFile.readInt();
                            break;
                        case Types.LONG:
                            objs[j] = dataFile.readLong();
                            break;
                        case Types.DOUBLE:
                            objs[j] = dataFile.readDouble();
                            break;
                        case Types.FLOAT:
                            objs[j] = dataFile.readFloat();
                            break;
                        case Types.STRING:
                            byte[] bytes = new byte[(int) types[j].getDataSize()];
                            dataFile.read(bytes, 0, (int) types[j].getDataSize());
                            objs[j] = new String(bytes);
                            break;
                    }
                }
                Row row = new Row(this);
                row.setPosition(i);
                row.isCached = false;
                insertRow(row);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writeRows() {
        for (Row row : Rows) {
            if (row.isCached) {
                writeSingleRow(row);
            }
        }
    }

    private void writeSingleRow(Row row) {
        try {
            dataFile.seek(0);
            int freeList = dataFile.readInt();
            int lastfreeNode = freeList;
            while (freeList != -1) {
                lastfreeNode = freeList;
                dataFile.seek(freeList);
                freeList = dataFile.readInt();
            }
            dataFile.writeBytes(new String(row.getRawData()));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void updateRow() {

    }

    public void insertRow(Row row) {
        Rows.add(row);
        nRows++;
    }

    public final int getRowSize() {
        int sum = 0;
        for (Type t : types) {
            sum += t.getDataSize();
        }
        return sum;
    }

    public void commit() {

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
        table.readRows();
        Row[] rows = new Row[10];
        int i = 0;
        long l = 1231L;
        float f = 41.266f;
        double d = 451.1244;
        String s = "1233153";
        rows[0] = new Row(table);
        rows[0].setData(new Object[]{i, l, f, d, s});
        System.out.println(rows[0].getRawData());
        System.out.println(table.getRowSize());
        table.insertRow(rows[0]);
        table.writeRows();
        System.out.println(table.nRows);
    }
}
