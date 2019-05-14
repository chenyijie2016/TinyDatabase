
import data.typedData;
import data.intData;
import data.stringData;
import data.longData;
import data.floatData;
import data.doubleData;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RowDisk {
    public RowDisk(Table t) {
        table = t;
    }

    public RowDisk(Table t, int position) {
        this.table = t;
        this.position = position;
    }

    public long position;
    private Table table;
    public typedData[] data;

    public RowDisk setPosition(long position) {
        this.position = position;
        return this;
    }


    public final byte[] getRawData() {
        int totalSize = 0;
        for (Column c : table.getColumns()) {
            totalSize += c.getColumnType().size();
        }
        if (totalSize < 8) {
            totalSize = 8;
        } // 为了确保能够存下保存freelist指针
        byte[] bytes = new byte[totalSize];
        Arrays.fill(bytes, (byte) 0);
        ByteBuffer buf = ByteBuffer.wrap(bytes);

        for (int i = 0; i < data.length; i++) {
            buf.put(data[i].toBytes());
        }
        return bytes;
    }

    public void setDataByColumn(Column c, typedData d) {
        int index = table.getColumns().indexOf(c);
        if (data == null) {
            data = new typedData[table.getColumns().size()];
        }
        data[index] = d;
    }

    public typedData getDataByColumn(Column c) {
        return data[table.getColumns().indexOf(c)];
    }

    public void setData(Object[] d) {
        data = new typedData[d.length];
        for (int i = 0; i < d.length; i++) {
            switch (table.getColumns().get(i).getColumnType().type()) {
                case INT:
                    data[i] = new intData();
                    break;
                case DOUBLE:
                    data[i] = new doubleData();
                    break;
                case FLOAT:
                    data[i] = new floatData();
                    break;
                case LONG:
                    data[i] = new longData();
                    break;
                case STRING:
                    data[i] = new stringData().setSize(table.getColumns().get(i).getColumnType().size());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + table.getColumns().get(i).getColumnType().type());
            }
            data[i].setData(d[i]);
        }

    }

    public static void main(String[] args) {

    }
}
