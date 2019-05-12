package common;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class longData extends typedData {
    private Long data;
    public longData(){}
    public longData(long data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return Types.LONG;
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
}
