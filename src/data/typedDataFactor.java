package data;

public class typedDataFactor {
    public static typedData getTypedData(Type type) {
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
                return new stringData().setMaxSize(type.size());
            default:
                return null;
        }
    }
}
