package table;

import data.*;
import exception.SQLExecuteException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Row {
    public long position;
    private TableBase table;
    public List<typedData> data;
    private typedData additionalData = null;  // 用于没有primarykey或者多个primarykey的情况

    public Row(TableBase t, long position) {
        this.table = t;
        this.position = position;
        this.data = new ArrayList<>();
    }

    public Row(TableBase t, Object[] objs) throws SQLExecuteException {
        this.table = t;
        this.data = new ArrayList<>();
        setData(objs);
    }

    public Row(TableBase t, Object[] objs, typedData additionalData) throws SQLExecuteException {
        this.table = t;
        this.data = new ArrayList<>();
        setData(objs);
        this.additionalData = additionalData;
    }

    public Row(Row another) {
        table = another.getTable();
        position = -1L;
        this.data = new ArrayList<>(another.data);
        this.additionalData = another.additionalData;
    }


    public void setPosition(long position) {
        this.position = position;
    }

    public TableBase getTable() {
        return table;
    }

    public boolean typeCheck(Object[] objs) {
        boolean SizeCheck = objs.length == table.getColumns().size();
        boolean TypeCheck = true;
        for (int i = 0; i < table.getColumns().size(); i++) {
            if (objs[i] != null)
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
        return SizeCheck && TypeCheck;
    }

    public final List<typedData> getData() {
        return data;
    }

    public typedData getAdditionalData() {
        return additionalData;
    }

    public int occupation() {
        int totalSize = 0;
        for (Column c : table.getColumns()) {
            totalSize += c.getColumnType().size();
        }
        totalSize += table.getColumns().size();
        if (table instanceof Table) {
            if (((Table) table).getMultiPrimaryKey() || !((Table) table).getHasPrimaryKey()) {
                data.Type dataType = ((Table) table).getIndexColumns().get(0).getColumnType();
                totalSize += dataType.size();
            }
        }
        if (totalSize < Long.BYTES) {
            totalSize = Long.BYTES;
        } // 为了确保能够存下保存freelist指针
        return totalSize;
    }

    public final byte[] toProtocolBytes() throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        for (typedData td : data) {
            stream.write(ByteBuffer.allocate(Integer.BYTES).putInt(td.toString().length()).array());
            stream.write(td.toString().getBytes());
        }
        // TODO: CHECK if we need it
//        if (table instanceof Table) {
//            if (((Table) table).getMultiPrimaryKey() || !((Table) table).getHasPrimaryKey()) {
//                stream.write(additionalData.toBytes());
//            }
//        }
        return stream.toByteArray();
    }

    public final byte[] toBytes() {

        byte[] bytes = new byte[occupation()];
        Arrays.fill(bytes, (byte) 0);
        ByteBuffer buf = ByteBuffer.wrap(bytes);

        for (typedData datum : data) {
            buf.put(datum.isNull() ? (byte) 1 : (byte) 0);
            buf.put(datum.toBytes());
        }
        if (table instanceof Table) {
            if (((Table) table).getMultiPrimaryKey() || !((Table) table).getHasPrimaryKey()) {
                buf.put(additionalData.toBytes());
            }
        }
        return bytes;
    }

    public Row fromBytes(byte[] raw) throws SQLExecuteException {
        if (raw.length != occupation()) {
            throw new SQLExecuteException("Unknown Error");
        }
        ByteBuffer buffer = ByteBuffer.wrap(raw);
        for (Column column : table.getColumns()) {
            byte isNull = buffer.get();
            byte[] columnData = new byte[column.getColumnType().size()];
            buffer.get(columnData);
            if (isNull == 1) {
                data.add(typedDataFactor.getTypedData(column.getColumnType()));
            } else {
                data.add(typedDataFactor.getTypedData(column.getColumnType()).fromBytes(columnData));
            }
        }
        if (table instanceof Table) {
            if (((Table) table).getMultiPrimaryKey() || !((Table) table).getHasPrimaryKey()) {
                data.Type dataType = ((Table) table).getIndexColumns().get(0).getColumnType();
                byte[] bufferData = new byte[dataType.size()];
                buffer.get(bufferData);
                additionalData = typedDataFactor.getTypedData(dataType).fromBytes(bufferData);
            }
        }
        return this;
    }

    public void setDataByColumn(Column column, typedData typedData) {
        int index = table.getColumns().indexOf(column);
        if (data == null) {
            data = new ArrayList<>();
        }
        if (index == -1 && table instanceof Table) {
            index = ((Table)table).getIndexColumns().indexOf(column);
            assert (index != -1) : "没有找到该属性";
            additionalData = typedData;
            return;
        }
        assert (index != -1);
        data.set(index, typedData);
    }

    public typedData getDataByColumn(Column column) {
        int index = table.getColumns().indexOf(column);
        if (index == -1 && table instanceof Table) {
            index = ((Table)table).getIndexColumns().indexOf(column);
            assert (index != -1) : "没有找到该属性";
            return additionalData;
        }
        assert (index != -1) : "没有找到该属性";
        return data.get(index);
    }

    public Row setData(Object[] objs) throws SQLExecuteException {
        if (!typeCheck(objs)) {
            throw new SQLExecuteException("Row Type check failed");
        }
        for (int i = 0; i < objs.length; i++) {
            switch (table.getColumns().get(i).getColumnType().type()) {
                case INT:
                    data.add(new intData());
                    break;
                case DOUBLE:
                    data.add(new doubleData());
                    break;
                case FLOAT:
                    data.add(new floatData());
                    break;
                case LONG:
                    data.add(new longData());
                    break;
                case STRING:
                    data.add(new stringData().setMaxSize(table.getColumns().get(i).getColumnType().size()));
                    break;
                default:
                    throw new SQLExecuteException("Unexpected value: " + table.getColumns().get(i).getColumnType().type());
            }
            data.get(i).setData(objs[i]);
        }
        return this;
    }

    public Row setData(Object[] objs, typedData additionalData) throws SQLExecuteException {
        this.setData(objs);
        this.additionalData = additionalData;
        return this;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("| ");
        for (typedData d : data) {
            str.append(d.toString()).append(" | ");
        }
        return str.toString();
    }

    public void setAdditionalData(typedData data) {
        additionalData = data;
    }

}
