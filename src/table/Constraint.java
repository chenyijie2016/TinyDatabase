package table;

public class Constraint {
    public enum ConstraintType {
        PRIMARY_KEY,
        NOT_NULL
    }

    private ConstraintType type;
    private String columnName;

    public Constraint(ConstraintType type, String columnName) {
        this.type = type;
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public ConstraintType getType() {
        return type;
    }
}
