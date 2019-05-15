package data;

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
    public Type getType() {
        return Type.doubleType();
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

    @Override
    public typedData fromBytes(byte[] data) {
        ByteBuffer buffer = ByteBuffer.allocate(Double.BYTES);
        buffer.put(data);
        buffer.flip();
        this.data = buffer.getDouble();
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
        if (!(t instanceof doubleData))
            return false;
        doubleData z = (doubleData) t;
        return data.equals(z.getData());
    }


}
