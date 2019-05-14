package data;

import java.io.IOException;



public class typedDataFactor {
    public static typedData getTypedData(Type type) throws IOException {
        switch (type.type()) {
            case INT:
                return new intData();
            case DOUBLE:
                return new doubleData();
            case FLOAT:
                return new floatData();
            case LONG:
                return new longData();
            case STRING:
                return new stringData();
        }
        throw new IOException("No matched type");
    }
}
