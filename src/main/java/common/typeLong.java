package common;

public class typeLong implements Type {

    public typeLong() {

    }

    @Override
    public int getType() {
        return Types.LONG;
    }

    @Override
    public String getTypeName() {
        return Tokens.LONG;
    }

    @Override
    public int getDataSize() {
        return 8;
    }

    @Override
    public void setSize(int size) {

    }
}
