package common;

import java.io.IOException;
import java.io.RandomAccessFile;

public abstract class typedData {

    abstract int getType();


    abstract public Object getData();

    abstract public void setData(Object data);

    abstract public byte[] toBytes();

    abstract public void readFromFile(RandomAccessFile raf) throws IOException;
}
