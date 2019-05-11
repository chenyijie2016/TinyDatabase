package common;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class intData extends typedData {
    private int data;

    @Override
    public int getType() {
        return Types.INT;
    }

    @Override
    public Object getData() {
        return data;
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
    public void readFromFile(RandomAccessFile raf) throws IOException {
        data = raf.readInt();
    }
}
