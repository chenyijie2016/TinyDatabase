package database;

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

    /**
     * 根据表名获取表
     *
     * @param name 表名
     * @return
     */
    public Table getTableByName(String name) {
        for (Table table : tables) {
            if (table.getTableName().equals(name)) {
                return table;
            }
        }
        return null;
    }

    private void updateSchema() throws IOException {

        FileOutputStream outputStream = new FileOutputStream(this.databaseName + SCHEMA_EXTENSION);
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeInt(tables.size());
        for (Table table : tables) {
            System.out.println("table bytes length" + table.toSchemaBytes().length);
            out.writeInt(table.toSchemaBytes().length);
            out.write(table.toSchemaBytes());
        }
        out.close();
        outputStream.close();
    }

     public static DataBase readFromFile(String name) throws IOException {

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

    public void createTable(Table table) throws IOException {
        tables.add(table);
        updateSchema();
    }

    public void dropTable(Table table) throws IOException {
        table.drop();
        tables.remove(table);
        updateSchema();
    }

}
