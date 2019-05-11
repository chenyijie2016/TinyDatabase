public class Constraint {
    public enum Type {
        PRIMARY_KEY,
        NOT_NULL
    }

    private Type type;
    private String columnName;

    Constraint(Constraint.Type t, String s) {
        type = t;
        columnName = s;
    }

    public String getColumnName() {
        return columnName;
    }

    public Type getType() {
        return type;
    }
}
