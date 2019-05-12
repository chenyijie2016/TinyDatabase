package common;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class floatData extends typedData {
    private Float data;

    public floatData(){}

    public floatData(float data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return Types.FLOAT;
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
    public typedData getTypedData() {
        return this;
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
    public typedData readFromFile(RandomAccessFile raf) throws IOException {
        data = raf.readFloat();
        return this;
    }
}
