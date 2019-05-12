package common;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class intData extends typedData {
    private Integer data;

    public intData() {
    }

    public intData(int data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return Types.INT;
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
}
