package common;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class doubleData extends typedData {
    private Double data;

    public doubleData() {
    }

    public doubleData(double data) {
        this.data = data;
    }

    @Override
    public int getType() {
        return Types.DOUBLE;
    }

    @Override
    public int compareTo(typedData o) {
        return data.compareTo((Double) o.getData());
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
    public typedData readFromFile(RandomAccessFile raf) throws IOException {
        data = raf.readDouble();
        return this;
    }

}
