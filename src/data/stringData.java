package data;


import java.io.IOException;
import java.io.RandomAccessFile;


public class stringData extends typedData {
    private String data;
    private long maxSize;

    public stringData() {
    }

    public stringData(stringData another) {
        data = another.data;
        maxSize = another.maxSize;
    }

    public stringData(String data) {
        this.data = data;

    }

    public stringData(String data, long size) {
        this.data = data;
        this.maxSize = size;

    }

    public stringData setMaxSize(long maxSize) {
        this.maxSize = maxSize;
        return this;
    }

    @Override
    public Type getType() {
        return Type.stringType(maxSize);
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
        byte[] bytes = new byte[(int) maxSize];
        System.arraycopy(data.getBytes(), 0, bytes, 0, data.length());
        return bytes;
    }

    @Override
    public typedData readFromFile(RandomAccessFile raf) throws IOException {
        byte[] bytes = new byte[(int) maxSize];
        raf.read(bytes, 0, (int) maxSize);
        int i;
        for (i = 0; i < maxSize; i++) {
            if (bytes[i] == 0x0)
                break;
        }
        byte[] valid = new byte[i];
        System.arraycopy(bytes, 0, valid, 0, i);
        data = new String(valid);
        return this;
    }

    @Override
    public typedData fromBytes(byte[] data) {
        this.data = new String(data);
        return this;
    }

    @Override
    public int getDataSize() {
        return (int) maxSize;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(data);
        for (int i = data.length(); i < maxSize; i++)
            builder.append(" ");
        return builder.toString();
    }

    @Override
    public boolean equals(Object t) {
        if (!(t instanceof stringData))
            return false;
        stringData z = (stringData) t;
        return data.equals(z.getData());
    }


}
