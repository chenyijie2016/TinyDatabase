package common;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class typedData implements Comparable<typedData> {

    abstract int getType();

    public abstract int compareTo(typedData o);

    abstract public Object getData();

    abstract public typedData getTypedData();

    abstract public void setData(Object data);

    abstract public byte[] toBytes();

    abstract public typedData readFromFile(RandomAccessFile raf) throws IOException;
}
