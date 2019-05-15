package data;

import java.io.IOException;
import java.io.RandomAccessFile;

public class stringData extends typedData {
    private String data;
    private long size;

    public stringData() {
    }

    public stringData(String data) {
        this.data = data;
    }

    public stringData setSize(long size) {
        this.size = size;
        return this;
    }

    @Override
    public Type getType() {
        return Type.stringType(size);
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
        byte[] bytes = new byte[(int) size];
        raf.read(bytes, 0, (int) size);
        data = new String(bytes);
        return this;
    }

    @Override
    public typedData fromBytes(byte[] data) {
        this.data = new String(data);
        return this;
    }

    @Override
    public int getDataSize() {
        return (int) size;
    }

    @Override
    public String toString() {
        return data;
    }

    @Override
    public boolean equals(Object t) {
        if (!(t instanceof stringData))
            return false;
        stringData z = (stringData) t;
        return data.equals(z.getData());
    }


}
