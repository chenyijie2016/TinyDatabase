package common;

import java.io.IOException;
import java.io.RandomAccessFile;

public class stringData extends typedData {
    private String data;
    private int size;

    public stringData() {
    }

    public stringData(String data) {
        this.data = data;
    }

    public stringData setSize(int size) {
        this.size = size;
        return this;
    }

    @Override
    public int getType() {
        return Types.STRING;
    }

    @Override
    public int compareTo(typedData o) {
        return data.compareTo((String) o.getData());
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
        this.data = (String) data;
    }

    @Override
    public byte[] toBytes() {
        return data.getBytes();
    }

    @Override
    public typedData readFromFile(RandomAccessFile raf) throws IOException {
        byte[] bytes = new byte[size];
        raf.read(bytes, 0, size);
        data = new String(bytes);
        return this;
    }
}
