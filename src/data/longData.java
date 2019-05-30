package data;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class longData extends typedData {
    private Long data;

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
    public typedData getTypedData() {
        return this;
    }

    @Override
    public void setData(Object data) {
        this.data = (long) data;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = new byte[8];
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        buf.putLong(data);
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
    public int getDataSize() {
        return 8;
    }

    @Override
    public String toString() {
        return data.toString();
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
