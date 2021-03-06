package database;

import exception.SQLExecuteException;
import table.Table;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private static final String SCHEMA_EXTENSION = ".meta";
    private String databaseName;
    private List<Table> tables;

    public DataBase(String name) throws IOException {
        this.databaseName = name;
        tables = new ArrayList<>();
        updateSchema();
    }

    private DataBase() {
        tables = new ArrayList<>();
    }

    public String getName() {
        return this.databaseName;
    }

    public List<Table> getTables() {
        return tables;
    }

    /**
     * 根据表名获取表
     *
     * @param name 表名
     * @return
     */
    public Table getTableByName(String name) throws SQLExecuteException {
        for (Table table : tables) {
            if (table.getTableName().equals(name)) {
                return table;
            }
        }
        throw new SQLExecuteException("No Such Table: " + name);
    }

    /**
     * 解决在执行更新元数据操作后无法立即删除的BUG :https://stackoverflow.com/questions/12096002/close-a-file-created-with-fileoutputstream-for-a-next-delete
     * @throws IOException
     */
    private void updateSchema() throws IOException {

        FileOutputStream outputStream = new FileOutputStream(databaseName + SCHEMA_EXTENSION);
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeInt(tables.size());
        for (Table table : tables) {
            out.writeInt(table.toSchemaBytes().length);
            out.write(table.toSchemaBytes());
        }
        out.close();
        outputStream.close();
        out = null; // For a bug of java's GC, WTF?
        System.gc();
    }

    public static DataBase readFromFile(String name) throws IOException, SQLExecuteException {

        FileInputStream inputStream = new FileInputStream(name + SCHEMA_EXTENSION);
        DataInputStream in = new DataInputStream(inputStream);
        DataBase db = new DataBase();
        db.databaseName = name;
        int tableNumber = in.readInt();
        for (int i = 0; i < tableNumber; i++) {
            int tableSchemaLength = in.readInt();
            byte[] tableSchema = new byte[tableSchemaLength];
            in.read(tableSchema);
            db.tables.add(Table.fromSchemaBytes(db, tableSchema));
        }

        return db;
    }

    public void createTable(Table table) throws IOException, SQLExecuteException {
        for (Table t : tables) {
            if (t.getTableName().equals(table.getTableName())) {
                throw new SQLExecuteException("SQL Execute Error [create table]: Cannot create a table with the same name as an existing table");
            }
        }
        tables.add(table);
        updateSchema();
    }

    public void dropTableByName(String tableName) throws SQLExecuteException {
        if (tableName == null) {
            throw new SQLExecuteException("[drop table]: Null Table Name");
        }
        Table table = getTableByName(tableName);
        if (table == null) {
            throw new SQLExecuteException("[drop table]: No Such Name");
        }
        try {
            table.drop();
            tables.remove(table);
            updateSchema();
        } catch (IOException e) {
            throw new SQLExecuteException("[drop table]: Unknown Error");
        }
    }

    public void dropAllTable() throws IOException {
        for (Table table : tables) {
            table.drop();
        }
        tables.clear();
        updateSchema();
    }

    public boolean drop() throws IOException, SQLExecuteException {
        dropAllTable();
        File file = new File(databaseName + SCHEMA_EXTENSION);
        if (file.exists()) {
            return file.delete();
        }
        throw new SQLExecuteException("No DataBase file to delete");
    }


}
