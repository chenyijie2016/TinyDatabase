package common;

public class typeInt implements Type {
    public typeInt() {

    }

    @Override
    public int getDataSize() {
        return 4;
    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public int getType() {
        return Types.INT;
    }

    @Override
    public String getTypeName() {
        return Tokens.INT;
    }
}
