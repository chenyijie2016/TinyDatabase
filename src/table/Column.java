package table;

import data.Type;

public class Column {
    private Type type;
    private String name;

    public Column(Type type, String name) {
        this.type = type;
        this.name = name.toUpperCase();
    }

    public Type getColumnType() {
        return type;
    }

    public String getName() {
        return name;
    }


    public boolean equals(Object obj) {
        if (!(obj instanceof Column))
            return false;
        Column c = (Column) obj;
        return type.equals(c.type) && name.equals(c.name);
    }
}
