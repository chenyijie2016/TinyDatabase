import common.*;

import java.io.*;
import java.util.*;

public class Table {
    private DataBase database;
    private String tableName;

    private int nRows;
    private List<Row> Rows;
    private List<Row> toInsertRows;
    private List<Row> toDeleteRows;
    private List<Column> indexColumns;
    private RandomAccessFile dataFile;
    private RandomAccessFile[] indexFile;
    private Constraint[] constraints;
    private Column[] columns;
    private boolean hasPrimaryKey = false;
    private Object[] indexs;
    private Object[] indexs_hashmap;
    private int uniqueID;

    public Table(DataBase database, String tableName, Column[] columns, Constraint[] constraints) {
        this.database = database;
        this.tableName = tableName;
        this.columns = columns;
        this.constraints = constraints;

        Rows = new ArrayList<Row>();
        indexColumns = new ArrayList<Column>();


        for (int i = 0; i < constraints.length; i++) {
            if (constraints[i].getType() == Constraint.Type.PRIMARY_KEY) {
                hasPrimaryKey = true;
                if (getColumnByName(constraints[i].getColumnName()) != null) {
                    this.indexColumns.add(getColumnByName(constraints[i].getColumnName()));
                }
            }
        }


        if (!hasPrimaryKey) { // 没有主键约束就自己创建一个 默认INT
            Column c = new Column(new typeInt(), "IDX").setAuto(true);

            uniqueID = 1;
            createPrimaryKey(c);

        }
        this.indexs = new Object[indexColumns.size()];
        this.indexs_hashmap = new Object[indexColumns.size()];
        String dataFileName = database.getName() + "_" + this.tableName + ".data";
        try {
            dataFile = new RandomAccessFile(dataFileName, "rw");
            indexFile = new RandomAccessFile[this.indexColumns.size()];
            for (int i = 0; i < indexColumns.size(); i++) {
                String indexFileName = database.getName() + "_" + this.tableName + "_" + indexColumns.get(i).getName() + ".index";
                indexFile[i] = new RandomAccessFile(indexFileName, "rw");
            }
//            indexFile = new RandomAccessFile(indexFileName, "rw");
//            if (dataFile.length() == 0) {
//                dataFile.writeInt(-1);
//            }
            readIndex();
        } catch (IOException e) {
            System.out.println(e);
        }


    }


    private Column getColumnByName(String name) {
        for (Column c : columns) {
            if (name == c.getName()) {
                return c;
            }
        }
        return null;
    }

    private void createPrimaryKey(Column column) {
        this.indexColumns.add(column);
    }

    // 索引文件结构
    /*
    对于只有默认主键的表来说，还会在索引文件的前4个字节存放自增的ID数据(int)
    key (n byte)主键值 : position(4 byte) 对应行的文件位置(int)
*/

    private void readIndex() throws IOException {
        // 应该首先被调用
        for (int i = 0; i < indexColumns.size(); i++) {
            switch (indexColumns.get(i).getType().getType()) {
                case Types.INT:
                    indexs[i] = new BxTree<Integer, Row>(10);
                    indexs_hashmap[i] = new HashMap<Integer, Row>();
                    break;
                case Types.LONG:
                    indexs[i] = new BxTree<Long, Row>(10);
                    indexs_hashmap[i] = new HashMap<Long, Row>();
                    break;
                case Types.DOUBLE:
                    indexs[i] = new BxTree<Double, Row>(10);
                    indexs_hashmap[i] = new HashMap<Double, Row>();
                    break;
                case Types.FLOAT:
                    indexs[i] = new BxTree<Float, Row>(10);
                    indexs_hashmap[i] = new HashMap<Float, Row>();
                    break;
                case Types.STRING:
                    indexs[i] = new BxTree<String, Row>(10);
                    indexs_hashmap[i] = new HashMap<String, Row>();
                    break;

            }

            long keySize = indexColumns.get(i).getType().getDataSize();
            if (!hasPrimaryKey) { // 读取自增ID
                uniqueID = indexFile[i].readInt();
            }
            for (int j = 0; j < indexFile[i].length(); ) {
                //Object[] objs = new Object[columns.length];
                j += keySize + 4;
                int pos;
                switch (indexColumns.get(i).getType().getType()) {
                    case Types.INT:
                        int integer = indexFile[i].readInt();
                        pos = indexFile[i].readInt();
                        ((BxTree) indexs[i]).insert(integer, pos);
                        ((HashMap) indexs_hashmap[i]).put(integer, pos);
                        break;
                    case Types.LONG:
                        long l = indexFile[i].readLong();
                        pos = indexFile[i].readInt();
                        ((BxTree) indexs[i]).insert(l, pos);
                        ((HashMap) indexs_hashmap[i]).put(l, pos);
                        break;
                    case Types.DOUBLE:
                        double d = indexFile[i].readDouble();
                        pos = indexFile[i].readInt();
                        ((BxTree) indexs[i]).insert(d, pos);
                        ((HashMap) indexs_hashmap[i]).put(d, pos);
                        break;
                    case Types.FLOAT:
                        float f = indexFile[i].readFloat();
                        pos = indexFile[i].readInt();
                        ((BxTree) indexs[i]).insert(f, pos);
                        ((HashMap) indexs_hashmap[i]).put(f, pos);
                        break;
                    case Types.STRING:
                        pos = indexFile[i].readInt();
                        byte[] bytes = new byte[(int) indexColumns.get(i).getType().getDataSize()];
                        dataFile.read(bytes, 0, (int) indexColumns.get(i).getType().getDataSize());
                        ((BxTree) indexs[i]).insert(new String(bytes), pos);
                        ((HashMap) indexs_hashmap[i]).put(new String(bytes), pos);
                        break;
                }
            }
        }

    }

    public void writeIndex() {
        try {
            for (int i = 0; i < indexColumns.size(); i++) {
                String indexFileName = database.getName() + "_" + this.tableName + "_" + indexColumns.get(i).getName() + ".index";
                DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(indexFileName));
                if (!hasPrimaryKey) {
                    outputStream.writeInt(uniqueID);
                }
                Iterator iter = ((HashMap) indexs_hashmap[i]).keySet().iterator();
                while (iter.hasNext()) {
                    switch (indexColumns.get(i).getType().getType()) {
                        case Types.INT:
                            int key = (Integer) iter.next();
                            outputStream.writeInt(key);
                            outputStream.writeInt((int)((Row)((HashMap) indexs_hashmap[i]).get(key)).position);
                            break;
                        case Types.LONG:
                            long key2 = (long) iter.next();
                            outputStream.writeLong(key2);
                            outputStream.writeInt((int)((Row)((HashMap) indexs_hashmap[i]).get(key2)).position);
                            break;
//                        case Types.DOUBLE:
//                            outputStream.writeDouble((double) key);
//                            break;
//                        case Types.FLOAT:
//                            outputStream.writeFloat((float) key);
//                            break;
//                        case Types.STRING:
//                            outputStream.writeBytes((String) key);
//                            break;
                    }
//                    ;
//                    System.out.println(key + "=" + ((HashMap) indexs_hashmap[i]).get(key));
//                    //
//                    switch (indexColumns.get(i).getType().getType()) {
//                        case Types.INT:
//                            // System.out.println("KEY: "+key);
//                            outputStream.writeInt((int) key);
//                            break;
//                        case Types.LONG:
//                            outputStream.writeLong((long) key);
//                            break;
//                        case Types.DOUBLE:
//                            outputStream.writeDouble((double) key);
//                            break;
//                        case Types.FLOAT:
//                            outputStream.writeFloat((float) key);
//                            break;
//                        case Types.STRING:
//                            outputStream.writeBytes((String) key);
//                            break;
//                    }
                }
            }


        } catch (IOException e) {
            System.out.println(e);
        }

    }

    // 读取单行数据
    public void readRow(Row row) throws IOException {
        dataFile.seek(row.position);
        row.isOnlyInMemory = false;


        // TODO
    }

//    public void readAllRows() {
//        try {
//            // dataFile.seek(4); // For free list
//            long length = dataFile.length();
//            long rowSize = getRowSize();
//            for (long i = 0; i < length; i += rowSize) {
//                Object[] objs = new Object[columns.length];
//                for (int j = 0; j < columns.length; j++) {
//                    switch (columns[j].getType().getType()) {
//                        case Types.INT:
//                            objs[j] = dataFile.readInt();
//                            break;
//                        case Types.LONG:
//                            objs[j] = dataFile.readLong();
//                            break;
//                        case Types.DOUBLE:
//                            objs[j] = dataFile.readDouble();
//                            break;
//                        case Types.FLOAT:
//                            objs[j] = dataFile.readFloat();
//                            break;
//                        case Types.STRING:
//                            byte[] bytes = new byte[(int) columns[j].getType().getDataSize()];
//                            dataFile.read(bytes, 0, (int) columns[j].getType().getDataSize());
//                            objs[j] = new String(bytes);
//                            break;
//                    }
//                }
//                Row row = new Row(this);
//                row.isOnlyInMemory = false;
//                insertRow(row);
//            }
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//    }

    public void writeRows() {
        for (Row row : Rows) {
            if (row.isOnlyInMemory) {
                writeSingleRow(row);
            }
        }
//        try {
//            //dataFile.seek(0);
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }
    }


    private void writeSingleRow(Row row) {
        try {
            dataFile.seek(dataFile.length());
            row.setPosition(dataFile.getFilePointer());
            dataFile.writeBytes(new String(row.getRawData()));

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public Column[] getColumns() {
        return columns;
    }

    public void updateRow(Row oldref, Row newref) {
        // TODO
    }

    public void insertRow(Row row) {
        // 先检查约束

        // 插入索引

        if (!hasPrimaryKey) {
            ((BxTree) indexs[0]).insert(uniqueID, row);
            ((HashMap) indexs_hashmap[0]).put(uniqueID, row);
            uniqueID++;
        } else {
            for (int i = 0; i < indexColumns.size(); i++) {
                for (int j = 0; j < columns.length; j++) {
                    if (columns[j].getName().equals(indexColumns.get(i).getName())) {
                        ((BxTree) indexs[i]).insert((Integer) row.data[j].getData(), row);
                        ((HashMap) indexs_hashmap[0]).put(row.data[j].getData(), row);
                    }
                }
            }
        }
        // 插入数据
        Rows.add(row);
        nRows++;
    }

    public final int getRowSize() {
        int sum = 0;
        for (Column t : columns) {
            sum += t.getType().getDataSize();
        }
        return sum;
    }

    public void commit() {
        writeRows();
        writeIndex();
    }


    public static void main(String[] args) {
        DataBase testDB = new DataBase(1, "database");
        Table table = new Table(
                testDB,
                "testTable",
                new Column[]{
                        new Column(new typeInt(), "id"),
                        new Column(new typeLong(), "zzz"),
                        new Column(new typeFloat(), "fff"),
                        new Column(new typeDouble(), "id_long"),
                        new Column(new typeString(15), "name"),
                },
                new Constraint[]{new Constraint(Constraint.Type.PRIMARY_KEY,"id")});

//        table.readAllRows();
        Row[] rows = new Row[10];
        Integer i = 1231;
        Long l = 1231L;
        Float f = 41.266f;
        Double d = 451.1244;
        String s = "zzaaaaa";
        rows[0] = new Row(table);
        rows[1] = new Row(table);
        rows[0].setData(new Object[]{i, l, f, d, s});
        rows[1].setData(new Object[]{i+1, l, f, d, s});
        // System.out.println(rows[0].getRawData());
        System.out.println("Row size = " + table.getRowSize());
        table.insertRow(rows[0]);
        table.insertRow(rows[1]);
        table.commit();
        System.out.println(table.nRows);
    }
}
