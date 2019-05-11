package common;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class doubleData extends typedData {
    private double data;

    @Override
    public int getType() {
        return Types.DOUBLE;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = (double) data;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = new byte[8];
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        buf.putDouble(data);
        return bytes;
    }

    @Override
    public void readFromFile(RandomAccessFile raf) throws IOException {
        data = raf.readDouble();
    }
}
