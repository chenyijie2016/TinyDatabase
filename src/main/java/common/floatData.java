package common;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class floatData extends typedData {
    private float data;

    @Override
    public int getType() {
        return Types.FLOAT;
    }

    @Override
    public Object getData() {
        return data;
    }

    @Override
    public void setData(Object data) {
        this.data = (float) data;
    }

    @Override
    public byte[] toBytes() {
        byte[] bytes = new byte[4];
        ByteBuffer buf = ByteBuffer.wrap(bytes);
        buf.putFloat(data);
        return bytes;
    }

    @Override
    public void readFromFile(RandomAccessFile raf) throws IOException {
        data = raf.readFloat();
    }
}
