package data;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class floatData extends typedData {
    private Float data = null;

    public floatData() {
    }

    public floatData(floatData another) {
        this.data = another.data;
    }

    public floatData(float data) {
        this.data = data;
    }

    @Override
    public Type getType() {
        return Type.floatType();
    }

    @Override
    public int compareTo(typedData o) {
        return data.compareTo((Float) o.getData());
    }

    @Override
    public Object getData() {
        return data;
    }


    @Override
    public void setData(Object data) {
        this.data = data == null ? null : (Float) data;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = new byte[Float.BYTES];
        if (data != null) {
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            buf.putFloat(data);
        }
        return bytes;
    }

    @Override
    public typedData readFromFile(RandomAccessFile raf) throws IOException {
        data = raf.readFloat();
        return this;
    }

    @Override
    public typedData fromBytes(byte[] data) {
        ByteBuffer buffer = ByteBuffer.allocate(Float.BYTES);
        buffer.put(data);
        buffer.flip();
        this.data = buffer.getFloat();
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
        if (!(t instanceof floatData))
            return false;
        floatData z = (floatData) t;

        return data.equals(z.getData());
    }

    @Override
    public boolean isNull() {
        return data == null;
    }
}
