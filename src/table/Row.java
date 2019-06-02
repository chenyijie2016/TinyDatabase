package table;

import data.typedData;
import data.intData;
import data.stringData;
import data.longData;
import data.floatData;
import data.doubleData;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Row {
    public long position;
    private Table table;
    public typedData[] data;

    public Row(Table t, long position) {
        this.table = t;
        this.position = position;
    }

    public Row(Table t, Object[] objs) {
        this.table = t;
        setData(objs);
    }

    public Row(Row another) {
        table = another.getTable();
        position = -1L;
        this.data = new typedData[another.getData().length];
        for (int i = 0; i < another.getData().length; i++) {
            this.data[i] = another.getData()[i];
        }
    }


    public Row setPosition(long position) {
        this.position = position;
        return this;
    }

    public Table getTable() {
        return table;
    }

    public boolean typeCheck(Object[] objs) {
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
        }
        assert (TypeCheck) : "类型检查失败";
        return SizeCheck && TypeCheck;
    }

    public final typedData[] getData() {
        return data;
    }

    public final byte[] toBytes() {
        int totalSize = 0;
        for (Column c : table.getColumns()) {
            totalSize += c.getColumnType().size();
        }
        if (totalSize < Long.BYTES) {
            totalSize = Long.BYTES;
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

    public Row setData(Object[] objs) {
        if (!typeCheck(objs)) {
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
