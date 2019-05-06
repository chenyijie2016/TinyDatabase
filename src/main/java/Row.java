import common.Type;
import common.Types;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Row {
    public Row(Table t) {
        table = t;
    }

    private long position;
    private Table table;
    private Object[] data;


    public final byte[] getRawData() {
        int totalSize = 0;
        for (Type t : table.getTypes()) {
            totalSize += t.getDataSize();
        }
        byte[] bytes = new byte[totalSize];
        Arrays.fill(bytes, (byte) 0);
        ByteBuffer buf = ByteBuffer.wrap(bytes);

        for (int i = 0; i < data.length; i++) {
            switch (table.getTypes()[i].getType()) {
                case Types.INT:
                    buf.putInt((int) data[i]);
                    break;
                case Types.LONG:
                    buf.putLong((long) data[i]);
                    break;
                case Types.FLOAT:
                    buf.putFloat((float) data[i]);
                    break;
                case Types.DOUBLE:
                    buf.putDouble((double) data[i]);
                    break;
                case Types.STRING:
                    if (((String) data[i]).length() < table.getTypes()[i].getDataSize()) {
                        buf.put(((String) data[i]).getBytes());
                    }
                    break;
            }
        }
        return bytes;
    }

    public final void debugDump() {

    }

    public void setData(Object[] d) {
        data = new Object[d.length];
        System.arraycopy(d, 0, data, 0, d.length);
    }

    public static void main(String[] args) {

    }
}
