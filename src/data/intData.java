package data;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class intData extends typedData {
    private Integer data = null;

    public intData() {

    }

    public intData(intData another) {
        data = another.data;
    }

    public intData(int data) {
        this.data = data;
    }

    @Override
    public Type getType() {
        return Type.intType();
    }

    @Override
    public int compareTo(typedData o) {
        return data.compareTo((Integer) o.getData());
    }

    @Override
    public Object getData() {
        return data;
    }


    @Override
    public void setData(Object data) {
        this.data = data == null ? null : (Integer) data;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = new byte[Integer.BYTES];
        if (data != null) {
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            buf.putInt(data);
        }
        return bytes;
    }

    @Override
    public typedData readFromFile(RandomAccessFile raf) throws IOException {
        data = raf.readInt();
        return this;
    }

    @Override
    public typedData fromBytes(byte[] data) {
        ByteBuffer buffer = ByteBuffer.allocate(Integer.BYTES);
        buffer.put(data);
        buffer.flip();
        this.data = buffer.getInt();
        return this;
    }


    @Override
    public String toString() {
        if (data != null) {
            return data.toString();
        } else {
            return "NULL";
        }
    }

    @Override
    public boolean equals(Object t) {
        if (!(t instanceof intData))
            return false;
        intData z = (intData) t;
        return data != null && data.equals(z.getData());
    }
    @Override
    public boolean isNull() {
        return data == null;
    }

}
