package common;

public class typeFloat implements Type {
    public typeFloat() {
    }

    @Override
    public int type() {
        return Types.FLOAT;
    }

    @Override
    public String getTypeName() {
        return Tokens.FLOAT;
    }

    @Override
    public int getDataSize() {
        return 4;
    }

    @Override
    public void setSize(int size) {

    }
}
