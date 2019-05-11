import common.Type;

public class Column {
    private Type type;
    private String name;
    private boolean auto;
    Column(Type type, String name){
        this.type=type;
        this.name=name;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Column setAuto(boolean auto) {
        this.auto = auto;
        return this;
    }
}
