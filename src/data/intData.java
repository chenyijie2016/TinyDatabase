package data;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class intData extends typedData {
    private Integer data;

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
    public typedData getTypedData() {
        return this;
    }

    @Override
    public void setData(Object data) {
        this.data = (int) data;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = new byte[4];
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        buf.putInt(data);
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
    public int getDataSize() {
        return 4;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public boolean equals(Object t) {
        if (!(t instanceof intData))
            return false;
        intData z = (intData) t;
        return data.equals(z.getData());
    }


}
