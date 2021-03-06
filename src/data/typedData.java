package data;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class typedData implements Comparable<typedData> {

    abstract public Type getType();

    public abstract int compareTo(typedData o);

    abstract public Object getData();


    abstract public void setData(Object data);

    abstract public byte[] toBytes();

    abstract public typedData readFromFile(RandomAccessFile raf) throws IOException;

    abstract public typedData fromBytes(byte[] data);

    abstract public boolean isNull();

    abstract public String toString();

    abstract public boolean equals(Object t);
}
