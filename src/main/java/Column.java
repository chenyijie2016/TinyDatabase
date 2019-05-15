import data.Type;

public class Column {
    private Type type;
    private String name;

    Column(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public Type getColumnType() {
        return type;
    }

    public String getName() {
        return name;
    }


    public boolean equals(Column obj) {
        return type.equals(obj.type) && name.equals(obj.name);
    }
}
