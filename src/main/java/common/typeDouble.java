package common;

public class typeDouble implements Type {
    public typeDouble() {

    }

    @Override
    public int getType() {
        return Types.DOUBLE;
    }

    @Override
    public String getTypeName() {
        return Tokens.DOUBLE;
    }

    @Override
    public int getDataSize() {
        return 8;
    }

    @Override
    public void setSize(int size) {

    }
}
