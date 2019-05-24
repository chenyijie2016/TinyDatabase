
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Schema {
    private static Schema schema;

    static {
        try {
            schema = new Schema();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final String METADATA_FILE = "schema";
    private List<DataBase> dataBases;

    private Schema() throws IOException {
        dataBases = new ArrayList<>();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(METADATA_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("initializing default database schema");
            System.out.println(inputStream);
        } finally {
            if (inputStream != null) {
                DataInputStream in = new DataInputStream(inputStream);
                int dataBaseNumber = in.readInt();
                for (int i = 0; i < dataBaseNumber; i++) {
                    int nameLength = in.readInt();
                    byte[] nameBytes = new byte[nameLength];
                    in.read(nameBytes);
                    dataBases.add(DataBase.readFromFile(new String(nameBytes)));
                }
            }
        }

    }

    public static Schema getSchema() {
        return schema;
    }

    private void updateSchema() throws IOException {
        FileOutputStream outputStream = new FileOutputStream(METADATA_FILE);
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeInt(dataBases.size());
        for (DataBase dataBase : dataBases) {
            out.writeInt(dataBase.getName().length());
            out.write(dataBase.getName().getBytes());
        }
        out.close();
        outputStream.close();
    }

    public void createDatabase(DataBase dataBase) throws IOException {
        dataBases.add(dataBase);
        updateSchema();
    }

    public DataBase getDatabaseByName(String name) {
        for (DataBase dataBase : dataBases) {
            if (dataBase.getName().equals(name)) {
                return dataBase;
            }
        }
        return null;
    }
}
