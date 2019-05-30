import data.Type;
import data.intData;
import data.typedData;
import data.typedDataFactor;

import index.BPlusTree;


import java.io.RandomAccessFile;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.*;


public class Table {
    private static final String DATA_EXTENSION = ".data";
    private static final String INDEX_EXTENSION = ".idx";

    private DataBase database; // 所属的数据库
    private String tableName; // 表名
    private List<Column> indexColumns; // 索引属性列表
    private RandomAccessFile dataFile; // 数据源文件
    private Constraint[] constraints; // 约束
    private List<Column> columns; // 属性列表
    private boolean hasPrimaryKey = false; // 是否指定了主键
    private int uniqueID = 0; // 默认的自增主键当前值
    private long freeListPointer = -1;
    private List<BPlusTree> indexTrees;


    public Table(DataBase database, String tableName, Column[] columns, Constraint[] constraints) throws IOException {
        this.database = database;
        this.tableName = tableName;
        this.columns = Arrays.asList(columns);
        this.constraints = constraints;
        indexColumns = new ArrayList<>();


        for (Constraint constraint : constraints) {
            if (constraint.getType() == Constraint.ConstraintType.PRIMARY_KEY) {
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


        String dataFileName = database.getName() + "_" + this.tableName + DATA_EXTENSION;
        dataFile = new RandomAccessFile(dataFileName, "rw");
        if (dataFile.length() > (Long.BYTES + Integer.BYTES)) {
            readDataFileHeader();
        } else {
            writeDataFileHeader();
        }
        indexTrees = new ArrayList<>();
        for (Column idxColumn : indexColumns) {
            String indexFileName = database.getName() + "_" + this.tableName + "_" + idxColumn.getName() + INDEX_EXTENSION;
            indexTrees.add(new BPlusTree(idxColumn.getColumnType(), indexFileName));
        }

    }

    public String getTableName() {
        return tableName;
    }

    /**
     * 读取数据文件的文件头
     *
     * @throws IOException 读取失败
     */
    private void readDataFileHeader() throws IOException {
        freeListPointer = dataFile.readLong();
        uniqueID = dataFile.readInt();
    }

    /**
     * 写入数据文件的文件头
     *
     * @throws IOException 写入失败
     */
    private void writeDataFileHeader() throws IOException {
        dataFile.writeLong(freeListPointer);
        dataFile.writeInt(uniqueID);
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

    /**
     * 读取单行数据
     *
     * @param row 新建的元组
     * @return 读取完数据的元组
     * @throws IOException
     */
    public Row readRow(Row row) throws IOException {
        dataFile.seek(row.position);
        for (Column c : columns) {
            typedData data = typedDataFactor.getTypedData(c.getColumnType());
            data.readFromFile(dataFile);
            row.setDataByColumn(c, data);
        }

        return row;
    }

    /**
     * 删除已经查询到的元组
     *
     * @param row 待删除的元组
     */
    public void deleteRow(Row row) throws IOException {

        // 先删除索引
        for (Column column : indexColumns) {
            boolean removed = indexTrees.get(indexColumns.indexOf(column)).remove(row.getDataByColumn(column));

        }
        // 如果删除的元组存在于磁盘上，则需要改写freeListPointer
        //if (row.cachedStatus == Row.STATUS.OnlyInDisk || row.cachedStatus == Row.STATUS.MemoryDisk) {
        dataFile.seek(row.position);
        dataFile.writeLong(freeListPointer);
        freeListPointer = row.position;
        //}
    }

    /**
     * 写入单行元组
     *
     * @param row 待写入的元组
     */
    private void writeSingleRow(Row row) throws IOException {

        if (freeListPointer == -1) {
            dataFile.seek(dataFile.length());
        } else {
            dataFile.seek(freeListPointer);
            long nextFreeListPoint = dataFile.readLong();
            dataFile.seek(freeListPointer);
            freeListPointer = nextFreeListPoint;
        }
        row.setPosition(dataFile.getFilePointer());
        dataFile.write(row.toBytes());

    }

    public List<Column> getColumns() {
        return columns;
    }

    /**
     * 更新一行数据，先删除再插入
     *
     * @param oldRow 老的一行元组
     * @param newRow 新的元组
     * @throws IOException 写入失败
     */
    public void updateRow(Row oldRow, Row newRow) throws IOException {
        deleteRow(oldRow);
        insertRow(newRow);
    }


    public void insertRow(Row row) throws IOException {
        // 先检查约束
        // TODO
        // 插入数据

        for (Column column : indexColumns) {
            Long pos = indexTrees.get(indexColumns.indexOf(column)).scanEqual(row.getDataByColumn(column));
            if (pos != null) {
                System.out.println("Can not insert Primary key! [Key already exists!]");
                return;
            }
        }

        writeSingleRow(row);
        // 插入索引
        if (hasPrimaryKey) {
            for (Column column : indexColumns) {
                indexTrees.get(indexColumns.indexOf(column)).insert(row.getDataByColumn(column), row.position);
            }
        } else {
            indexTrees.get(0).insert(new intData(uniqueID), row.position);
            uniqueID++;
        }

    }

    public final int getRowSize() {
        int sum = 0;
        for (Column column : columns) {
            sum += column.getColumnType().size();
        }
        return sum;
    }

    byte[] toSchemaBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put("TABLE".getBytes()); // Magic Number
        buffer.putInt(tableName.length());
        buffer.put(tableName.getBytes());
        buffer.putInt(columns.size());
        for (Column column : columns) {
            switch (column.getColumnType().type()) {
                case INT:
                    buffer.put((byte) 1);
                    break;
                case LONG:
                    buffer.put((byte) 2);
                    break;
                case DOUBLE:
                    buffer.put((byte) 3);
                    break;
                case FLOAT:
                    buffer.put((byte) 4);
                    break;
                case STRING:
                    buffer.put((byte) 5);
                    buffer.putInt(column.getColumnType().size());
                    break;
            }
            buffer.putShort((short) column.getName().length());
            buffer.put(column.getName().getBytes());
        }
        buffer.putInt(constraints.length);
        for (Constraint constraint : constraints) {
            switch (constraint.getType()) {
                case NOT_NULL:
                    buffer.put((byte) 1);
                    break;
                case PRIMARY_KEY:
                    buffer.put((byte) 0);
                    break;
            }
            buffer.putShort((short) constraint.getColumnName().length());
            buffer.put(constraint.getColumnName().getBytes());
        }
        return buffer.array();
    }

    /**
     * @param db     数据库
     * @param schema 元数据Byte
     * @return 表
     * @throws IllegalArgumentException 元数据有误
     * @throws IOException              元数据有误
     */
    static Table fromSchemaBytes(DataBase db, byte[] schema) throws IllegalArgumentException, IOException {
        ByteBuffer buffer = ByteBuffer.wrap(schema);
        byte[] magic = new byte[5];
        buffer.get(magic, 0, 5);
        if (!new String(magic).equals("TABLE")) {
            throw new IllegalArgumentException("Not valid schema data");
        }
        int tableNameSize = buffer.getInt();
        byte[] name = new byte[tableNameSize];
        buffer.get(name);
        String tableName = new String(name);
        int columnSize = buffer.getInt();
        Column[] columns = new Column[columnSize];
        for (int i = 0; i < columnSize; i++) {
            Type type;
            byte flag = buffer.get();
            switch (flag) {
                case 1:
                    type = Type.intType();
                    break;
                case 2:
                    type = Type.longType();
                    break;
                case 3:
                    type = Type.doubleType();
                    break;
                case 4:
                    type = Type.floatType();
                    break;
                case 5:
                    int stringSize = buffer.getInt();
                    type = Type.stringType(stringSize);
                    break;
                default:
                    throw new IOException("Not valid column type flag");
            }
            short nameSize = buffer.getShort();
            byte[] columnName = new byte[(int) nameSize];
            buffer.get(columnName);
            columns[i] = new Column(type, new String(columnName));
        }
        int constraintSize = buffer.getInt();
        Constraint[] constraints = new Constraint[constraintSize];
        for (int i = 0; i < constraintSize; i++) {
            Constraint.ConstraintType constraintType;
            switch (buffer.get()) {
                case 0:
                    constraintType = Constraint.ConstraintType.PRIMARY_KEY;
                    break;
                case 1:
                    constraintType = Constraint.ConstraintType.NOT_NULL;
                    break;
                default:
                    throw new IOException("Not valid constraint type flag");
            }
            short columnNameSize = buffer.getShort();
            byte[] columnName = new byte[columnNameSize];
            buffer.get(columnName);
            constraints[i] = new Constraint(constraintType, new String(columnName));
        }

        return new Table(db, tableName, columns, constraints);
    }

    /**
     * 保证数据完整性的必须操作，完整写回数据
     */
    public void commit() throws IOException {
        dataFile.seek(0);
        writeDataFileHeader();
    }

    /**
     * 获取全体的元组的迭代器，利用第一个索引的全体迭代器实现
     */
    RowIterator scanAll() throws IOException {
        return new RowIndexIterator(this, indexTrees.get(0).scanAll());
    }

    RowIterator scanEqual(Column column, typedData key) throws IOException {
        // 查询指定属性的值等于key的元组， 如果查询在索引列的话暂时只返回一个
        Long position;
        if (indexColumns.indexOf(column) != -1) {
            position = indexTrees.get(indexColumns.indexOf(column)).scanEqual(key);
            if (position != null) {
                List<Row> list = new ArrayList<>();
                list.add(readRow(new Row(this, position)));
                return new RowNormalIterator(list.iterator());
            } else {
                return new RowNormalIterator(new ArrayList<Row>().iterator());
            }

        }
        RowCondition dataEqualCondition = (row) -> row.getDataByColumn(column).equals(key);

        RowIterator iter = scanAll();
        return new RowConditionIterator(iter, dataEqualCondition);
    }

    /**
     * 查询大于等于该属性的元组
     * 返回迭代器
     */
    public RowIterator scanGreaterEqual(Column column, typedData key) throws IOException {
        if (indexColumns.indexOf(column) != -1) {
            return new RowIndexIterator(this, indexTrees.get(indexColumns.indexOf(column)).scanGreaterEqual(key));
        }
        RowCondition dataGreaterEqual = (row) -> row.getDataByColumn(column).compareTo(key) >= 0;
        return new RowConditionIterator(scanAll(), dataGreaterEqual);
    }


    RowIterator getIndexIterator(Table t, BPlusTree.BPlusTreeIterator iter) {
        return new RowIndexIterator(t, iter);
    }

    abstract class RowIterator implements Iterator<Row> {
        abstract public boolean hasNext();

        abstract public Row next();
    }

    interface RowCondition {
        boolean checkColumnData(Row row);
    }

    // 用来作普通元组的迭代器
    class RowNormalIterator extends RowIterator {
        Iterator<Row> iter;

        RowNormalIterator(Iterator<Row> iter) {
            this.iter = iter;
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public Row next() {
            if (iter.hasNext())
                return iter.next();
            return null;
        }
    }


    // 用来作索引的迭代器
    class RowIndexIterator extends RowIterator {
        private BPlusTree.BPlusTreeIterator iter;
        private Table table;

        RowIndexIterator(Table table, BPlusTree.BPlusTreeIterator iter) {
            this.iter = iter;
            this.table = table;
        }

        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public Row next() {
            if (iter.hasNext()) {
                try {
                    return readRow(new Row(table, iter.next()));
                } catch (IOException e) {
                    System.out.println("Can not Iterator Row");
                    System.exit(0);
                }
                return null;
            } else
                return null;
        }
    }

    // 通常用作遍历中带条件判断
    class RowConditionIterator extends RowIterator {
        RowIterator iter;
        RowCondition condition;


        RowConditionIterator(RowIterator iter, RowCondition condition) {
            this.iter = iter;
            this.condition = condition;

        }

        /**
         * *************      注意       *************
         * 对于此类迭代器，在任何情况下不要调用此方法来判断接下来是不是能返回值
         * 应该连续调用此类的next()方法来判断返回的是不是null来判断结束
         *
         * @see RowConditionIterator
         */
        @Override
        public boolean hasNext() {
            return iter.hasNext();
        }

        @Override
        public Row next() {
            while (iter.hasNext()) {
                Row row = iter.next();
                if (condition.checkColumnData(row))
                    return row;
            }
            return null;
        }
    }


}