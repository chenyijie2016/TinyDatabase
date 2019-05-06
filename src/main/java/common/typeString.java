package common;

public class typeString implements Type {
    private int size = 0;

    public typeString(int s) {
        size = s;
    }

    @Override
    public int getType() {
        return Types.STRING;
    }

    @Override
    public String getTypeName() {
        return Tokens.STRING;
    }

    @Override
    public long getDataSize() {
        return size;
    }

    @Override
    public void setSize(int s) {
        size = s;
    }
}
