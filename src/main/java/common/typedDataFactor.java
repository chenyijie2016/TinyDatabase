package common;

public class typedDataFactor {
    public static typedData getTypedData(int type) throws Exception {
        switch (type) {
            case Types.INT:
                return new intData();
            case Types.DOUBLE:
                return new doubleData();
            case Types.FLOAT:
                return new floatData();
            case Types.LONG:
                return new longData();
            case Types.STRING:
                return new stringData();
        }
        throw new Exception("No matched type");
    }
}
