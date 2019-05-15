package data;

public class Type {
    private TYPE type;
    private long size;

    public enum TYPE {
        INT,
        LONG,
        DOUBLE,
        FLOAT,
        STRING
    }

    Type(TYPE t) {
        type = t;
        switch (t) {
            case LONG:
            case DOUBLE:
                size = 8;
                break;
            case INT:
            case FLOAT:
                size = 4;
                break;
        }

    }

    Type(TYPE t, long size) {
        type = t;
        this.size = size;
    }

    public TYPE type() {
        return this.type;
    }

    public int size() {
        return (int) this.size;
    }

    public static Type intType() {
        return new Type(TYPE.INT);
    }

    public static Type longType() {
        return new Type(TYPE.LONG);
    }

    public static Type floatType() {
        return new Type(TYPE.FLOAT);
    }

    public static Type doubleType() {
        return new Type(TYPE.DOUBLE);
    }

    public static Type stringType(long s) {
        return new Type(TYPE.STRING, s);
    }

    public boolean equals(Type obj){
        return this.size == obj.size && this.type == obj.type;
    }
}
