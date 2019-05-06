package common;

public class typeFloat implements Type {
    public typeFloat() {
    }

    @Override
    public int getType() {
        return Types.FLOAT;
    }

    @Override
    public String getTypeName() {
        return Tokens.FLOAT;
    }

    @Override
    public long getDataSize() {
        return 4;
    }

    @Override
    public void setSize(int size) {

    }
}
