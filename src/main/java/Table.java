import data.Type;
import data.typedData;
import data.typedDataFactor;


import index.BPlusTree;
import index.BPlusTree;

import java.io.RandomAccessFile;
import java.io.IOException;
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
    private int uniqueID; // 自增主键当前值
    private long freeListPointer = -1;
    private List<BPlusTree> indexTrees;


    public Table(DataBase database, String tableName, Column[] columns, Constraint[] constraints) {
        this.database = database;
        this.tableName = tableName;
        this.columns = Arrays.asList(columns);

        this.constraints = constraints;

        Rows = new ArrayList<>();
        indexColumns = new ArrayList<>();


        for (Constraint constraint : constraints) {
            if (constraint.getType() == Constraint.Type.PRIMARY_KEY) {
                hasPrimaryKey = true;
                if (getColumnByName(constraint.getColumnName()) != null) {
                    this.indexColumns.add(getColumnByName(constraint.getColumnName()));
                }
            }
        }


        if (!hasPrimaryKey) { // 没有主键约束就自己创建一个 默认INT
            Column c = new Column(Type.intType(), "IDX");
            uniqueID = 1;
            createPrimaryKey(c);

        }
        String dataFileName = database.getName() + "_" + this.tableName + ".data";
        try {
            dataFile = new RandomAccessFile(dataFileName, "rw");
            if (dataFile.length() > 8) {
                freeListPointer = dataFile.readLong();
            } else {
                dataFile.writeLong(freeListPointer);
            }
            indexTrees = new ArrayList<>();
            for (Column idxColumn : indexColumns) {
                String indexFileName = database.getName() + "_" + this.tableName + "_" + idxColumn.getName() + ".index";
                indexTrees.add(new BPlusTree(idxColumn.getColumnType(), indexFileName));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
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

    // 读取单行数据
    public Row readRow(Row row) throws IOException {
        // if (row.cachedStatus == Row.STATUS.OnlyInDisk) {
        dataFile.seek(row.position);
        for (Column c : columns) {
            typedData d = typedDataFactor.getTypedData(c.getColumnType());
            d.readFromFile(dataFile);
            row.setDataByColumn(c, d);
        }
        row.cachedStatus = Row.STATUS.MemoryDisk;
        //  }
        return row;
    }

    /*
     * 删除已经查询到的元组
     *
     */
    public void deleteRow(Row row) throws IOException {

        // 先删除索引


        for (Column c : indexColumns) {
            boolean removed = indexTrees.get(indexColumns.indexOf(c)).remove(row.getDataByColumn(c));
            System.out.println("Index Removed=" + removed);
        }
        // 如果删除的元组存在于磁盘上，则需要改写freeListPointer
        if (row.cachedStatus == Row.STATUS.OnlyInDisk || row.cachedStatus == Row.STATUS.MemoryDisk) {
            dataFile.seek(row.position);
            dataFile.writeLong(freeListPointer);
            freeListPointer = row.position;
        }
    }

//    public void writeRows() {
//        for (Row row : Rows) {
//            if (row.cachedStatus == Row.STATUS.OnlyInMemory) {
//                writeSingleRow(row);
//                row.cachedStatus = Row.STATUS.MemoryDisk;
//            }
//        }
//    }


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


    public void insertRow(Row row) throws IOException {
        // 先检查约束
        // TODO
        // 插入数据

        for (Column c : indexColumns) {
            Long pos = indexTrees.get(indexColumns.indexOf(c)).scanEqual(row.getDataByColumn(c));
            if (pos != null) {
                System.out.println("Can not insert Primary key! [Key already exists!]");
                return;
            }
        }

        writeSingleRow(row);
        row.setStatus(Row.STATUS.MemoryDisk);
        // 插入索引
        for (Column c : indexColumns) {
            indexTrees.get(indexColumns.indexOf(c)).insert(row.getDataByColumn(c), row.position);
        }

    }

    public final int getRowSize() {
        int sum = 0;
        for (Column t : columns) {
            sum += t.getColumnType().size();
        }
        return sum;
    }

    public void commit() {

        try {
            dataFile.seek(0);
            dataFile.writeLong(freeListPointer);
        } catch (IOException e) {
            System.out.println("Write freelist pointer failed");
        }
    }


    public RowIterator scanAll() throws IOException {
        return new RowIndexIterator(this, indexTrees.get(0).scanAll());
    }

    public Row scanEqual(Column column, typedData key) throws IOException {
        // 查询指定属性的值等于key的元组， 暂时只返回一个
        Long position = null;
        for (Column c : indexColumns) {
            if (c.equals(column)) { // 要查询在索引列
                position = indexTrees.get(indexColumns.indexOf(c)).scanEqual(key);
                if (position != null) {
                    return readRow(new Row(this, position));
                } else {
                    return null;
                }
            }
        }

        RowIterator iter = scanAll();
        while (iter.hasNext()) {
            Row row = iter.next();
            if (row.getDataByColumn(column).compareTo(key) == 0)
                return row;
        }

        return null;
    }

    RowIterator getIndexIterator(Table t, BPlusTree.BPlusTreeIterator iter) {
        return new RowIndexIterator(t, iter);
    }

    abstract class RowIterator implements Iterator {
        abstract public boolean hasNext();

        abstract public Row next();
    }

    // 用来作普通元组的迭代器
    class RowNormalIterator extends RowIterator {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Row next() {
            return null;
        }
    }


    // 用来作索引的迭代器
    class RowIndexIterator extends RowIterator {
        private BPlusTree.BPlusTreeIterator iter;
        private Table table;

        RowIndexIterator(Table t, BPlusTree.BPlusTreeIterator iter) {
            this.iter = iter;
            this.table = t;
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public Row next() {
            try {
                return readRow(new Row(table, iter.next()));
            } catch (IOException e) {
                System.out.println("Can not Iterator Row");
                System.exit(0);
            }
            return null;

        }
    }

}
