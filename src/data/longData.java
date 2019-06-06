package data;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class longData extends typedData {
    private Long data = null;

    public longData() {
    }

    public longData(longData another) {
        data = another.data;
    }

    public longData(long data) {
        this.data = data;
    }

    @Override
    public Type getType() {
        return Type.longType();
    }

    @Override
    public int compareTo(typedData o) {
        return data.compareTo((Long) o.getData());
    }

    @Override
    public Object getData() {
        return data;
    }



    @Override
    public void setData(Object data) {
        this.data = data == null ? null : (Long) data;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = new byte[Long.BYTES];
        if (data != null) {
            ByteBuffer buf = ByteBuffer.wrap(bytes);
            buf.putLong(data);
        }
        return bytes;
    }

    @Override
    public typedData readFromFile(RandomAccessFile raf) throws IOException {
        data = raf.readLong();
        return this;
    }

    @Override
    public typedData fromBytes(byte[] data) {
        ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
        buffer.put(data);
        buffer.flip();
        this.data = buffer.getLong();
        return this;
    }

    @Override
    public boolean isNull() {
        return data == null;
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
        if (!(t instanceof longData)) {
            return false;
        }
        longData z = (longData) t;
        return data.equals(z.getData());
    }
}
