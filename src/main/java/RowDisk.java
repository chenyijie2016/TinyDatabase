
import data.typedData;
import data.intData;
import data.stringData;
import data.longData;
import data.floatData;
import data.doubleData;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RowDisk {


    public RowDisk(Table t, long position) {
        this.table = t;
        this.position = position;
    }

    public RowDisk(Table t, Object[] objs) {
        this.table = t;

        setData(objs);
    }

    public long position;
    private Table table;
    public typedData[] data;

    public RowDisk setPosition(long position) {
        this.position = position;
        return this;
    }

    public boolean typecheck(Object[] objs) {
        boolean SizeCheck = objs.length == table.getColumns().size();
        assert (SizeCheck) : "设定的数据长度错误";
        boolean TypeCheck = true;
        for (int i = 0; i < table.getColumns().size(); i++) {
            switch (table.getColumns().get(i).getColumnType().type()) {
                case DOUBLE:
                    TypeCheck &= objs[i] instanceof Double;
                    break;
                case FLOAT:
                    TypeCheck &= objs[i] instanceof Float;
                    break;
                case INT:
                    TypeCheck &= objs[i] instanceof Integer;
                    break;
                case LONG:
                    TypeCheck &= objs[i] instanceof Long;
                    break;
                case STRING:
                    TypeCheck &= objs[i] instanceof String;
                    break;
            }
//            TypeCheck = TypeCheck && table.getColumns().get(i).getColumnType().equals(((typedData) objs[i]).getType());
        }
        assert (TypeCheck) : "类型检查失败";
        return SizeCheck && TypeCheck;
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
        assert (index != -1);
        data[index] = d;
    }

    public typedData getDataByColumn(Column c) {
        int index = table.getColumns().indexOf(c);
        assert (index != -1) : "没有找到该属性";
        return data[index];
    }

    public RowDisk setData(Object[] objs) {
        if (!typecheck(objs)) {
            System.out.println("Illegal Assignment!");
            return this;
        }
        data = new typedData[objs.length];

        for (int i = 0; i < objs.length; i++) {
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
                    data[i] = new stringData().setMaxSize(table.getColumns().get(i).getColumnType().size());
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + table.getColumns().get(i).getColumnType().type());
            }
            data[i].setData(objs[i]);
        }
        return this;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("| ");
        for (typedData d : data) {
            str.append(d.toString()).append(" | ");
        }
        return str.toString();
    }

}
