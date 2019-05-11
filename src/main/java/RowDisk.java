import common.*;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RowDisk {
    public RowDisk(Table t) {
        table = t;
    }

    public long position;
    private Table table;
    public typedData[] data;

    public void setPosition(long position) {
        this.position = position;
    }


    public final byte[] getRawData() {
        int totalSize = 0;
        for (Column c : table.getColumns()) {
            totalSize += c.getType().getDataSize();
        }
        byte[] bytes = new byte[totalSize];
        Arrays.fill(bytes, (byte) 0);
        ByteBuffer buf = ByteBuffer.wrap(bytes);

        for (int i = 0; i < data.length; i++) {
            buf.put(data[i].toBytes());
        }
        return bytes;
    }

    public final void debugDump() {

    }

    public void setData(Object[] d) {
        data = new typedData[d.length];
        for (int i = 0; i < d.length; i++) {
            switch (table.getColumns()[i].getType().getType()) {
                case Types.INT:
                    data[i] = new intData();
                    break;
                case Types.DOUBLE:
                    data[i] = new doubleData();
                    break;
                case Types.FLOAT:
                    data[i] = new floatData();
                    break;
                case Types.LONG:
                    data[i] = new longData();
                    break;
                case Types.STRING:
                    data[i] = new stringData().setSize(table.getColumns()[i].getType().getDataSize());
                    break;
            }
            data[i].setData(d[i]);
        }

    }

    public static void main(String[] args) {

    }
}
