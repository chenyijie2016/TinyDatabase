import common.*;

import java.io.*;
import java.util.*;

public class Table {
    private DataBase database; // 所属的数据库
    private String tableName; // 表名


    private List<Row> Rows; // 元组列表
    private List<Row> toInsertRows;
    private List<Row> toDeleteRows;
    private List<Column> indexColumns; // 索引属性列表
    private RandomAccessFile dataFile; // 数据源文件
    private RandomAccessFile[] indexFile; //索引源文件
    private Constraint[] constraints; // 约束
    private List<Column> columns; // 属性列表
    private boolean hasPrimaryKey = false; // 是否指定了主键
    private List<BxTree<typedData, Row>> indexs; // B+树索引列表
    private List<HashMap<typedData, Row>> indexs_hashmap;
    private int uniqueID; // 自增主键当前值
    private long freeListPointer = -1;

    public Table(DataBase database, String tableName, Column[] columns, Constraint[] constraints) {
        this.database = database;
        this.tableName = tableName;
        this.columns = Arrays.asList(columns);

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
            Column c = new Column(new typeInt(), "IDX");

            uniqueID = 1;
            createPrimaryKey(c);

        }
        this.indexs = new ArrayList<BxTree<typedData, Row>>();
        this.indexs_hashmap = new ArrayList<HashMap<typedData, Row>>();
        String dataFileName = database.getName() + "_" + this.tableName + ".data";
        try {
            dataFile = new RandomAccessFile(dataFileName, "rw");
            if (dataFile.length() > 8) {
                freeListPointer = dataFile.readLong();
            } else {
                dataFile.writeLong(freeListPointer);
            }
            indexFile = new RandomAccessFile[this.indexColumns.size()];
            for (int i = 0; i < indexColumns.size(); i++) {
                String indexFileName = database.getName() + "_" + this.tableName + "_" + indexColumns.get(i).getName() + ".index";
                indexFile[i] = new RandomAccessFile(indexFileName, "rw");
            }
            readIndex();
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    public List<Row> getRows() {
        return Rows;
    }

    public int getRowsNumber() {
        return Rows.size();
    }

    private Column getColumnByName(String name) {
        for (Column c : columns) {
            if (name.equals(c.getName())) {
                return c;
            }
        }
        return null;
    }

    private void createPrimaryKey(Column column) {
        this.indexColumns.add(column);
    }


    /*   索引文件结构
     *   对于只有默认主键的表来说，还会在索引文件的前4个字节存放自增的ID数据(int)
     *   key (n byte)主键值 : position(4 byte) 对应行的文件位置(int)
     */

    private void readIndex() throws IOException {
        // 应该首先被调用
        for (int i = 0; i < indexColumns.size(); i++) {
            indexs.add(new BxTree<>(4, 4));
            indexs_hashmap.add(new HashMap<>());

            long keySize = indexColumns.get(i).getType().getDataSize();
            if (!hasPrimaryKey) { // 读取自增ID
                uniqueID = indexFile[i].readInt();
            }
            for (int j = 0; j < indexFile[i].length(); ) {
                j += keySize + 4;
                int pos;
                try {
                    typedData t = typedDataFactor.getTypedData(indexColumns.get(i).getType().type()).readFromFile(indexFile[i]);
                    pos = indexFile[i].readInt();
                    Row row = new Row(this, pos).setStatus(Row.STATUS.OnlyInDisk);
                    if (i == 0) {
                        this.Rows.add(row);
                    }
                    indexs.get(i).insert(t, row);
                    indexs_hashmap.get(i).put(t, row);
                    row.setDataByColumn(indexColumns.get(i), t);
                } catch (Exception e) {
                    System.out.println(e);
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
                Iterator iter = indexs_hashmap.get(i).keySet().iterator();
                while (iter.hasNext()) {
                    Object key = iter.next();
                    outputStream.write(((typedData) key).toBytes());
                    outputStream.writeInt((int) ((Row) ((HashMap) indexs_hashmap.get(i)).get(key)).position);
                }
            }
        } catch (
                IOException e) {
            System.out.println(e);
        }

    }

    // 读取单行数据
    public Row readRow(Row row) throws IOException, Exception {
        if (row.cachedStatus == Row.STATUS.OnlyInDisk) {
            dataFile.seek(row.position);
            for (Column c : columns) {
                typedData d = typedDataFactor.getTypedData(c.getType().type());
                d.readFromFile(dataFile);
                row.setDataByColumn(c, d);
            }
            row.cachedStatus = Row.STATUS.MemoryDisk;
        }
        return row;
    }


    public void deleteRow(Row row) throws IOException {
        Rows.remove(row);
        for (BxTree bxTree : indexs) {
            //TODO remove index from BxTree
        }
        for (Column c : indexColumns) {
            boolean removed = indexs_hashmap.get(indexColumns.indexOf(c)).remove(row.getDataByColumn(c), row);
            System.out.println("Removed=" + removed);
        }
        // 如果删除的元组存在于磁盘上，则需要改写freeListPointer
        if (row.cachedStatus == Row.STATUS.OnlyInDisk || row.cachedStatus == Row.STATUS.MemoryDisk) {
            dataFile.seek(row.position);
            dataFile.writeLong(freeListPointer);
            freeListPointer = row.position;
        }
    }

    public void writeRows() {
        for (Row row : Rows) {
            if (row.cachedStatus == Row.STATUS.OnlyInMemory) {
                writeSingleRow(row);
                row.cachedStatus = Row.STATUS.MemoryDisk;
            }
        }
    }


    private void writeSingleRow(Row row) {
        try {
            if (freeListPointer == -1) {
                dataFile.seek(dataFile.length());
            } else {
                dataFile.seek(freeListPointer);
                long nextFreeListPoint = dataFile.readLong();
                dataFile.seek(freeListPointer);
                freeListPointer = nextFreeListPoint;
            }
            row.setPosition(dataFile.getFilePointer());
            dataFile.write(row.getRawData());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void updateRow(Row oldRow, Row newRow) throws Exception {
        deleteRow(oldRow);
        insertRow(newRow);
    }

    public void insertRow(Row row) {
        // 先检查约束
        // TODO
        // 插入索引

        if (!hasPrimaryKey) {
            indexs.get(0).insert(new intData(uniqueID), row);
            indexs_hashmap.get(0).put(new intData(uniqueID), row);
            uniqueID++;
        } else {
            for (Column c : indexColumns) {
                indexs.get(indexColumns.indexOf(c)).insert(row.getDataByColumn(c), row);
                indexs_hashmap.get(indexColumns.indexOf(c)).put(row.getDataByColumn(c), row);
            }
        }
        // 插入数据
        Rows.add(row);
        row.setStatus(Row.STATUS.OnlyInMemory);
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
        try {
            dataFile.seek(0);
            dataFile.writeLong(freeListPointer);
        } catch (IOException e) {
            System.out.println("Write freelist pointer failed");
        }
    }

}
