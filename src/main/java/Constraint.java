public class Constraint {
    public enum ConstraintType {
        PRIMARY_KEY,
        NOT_NULL
    }

    private ConstraintType type;
    private String columnName;

    Constraint(Constraint.ConstraintType t, String s) {
        type = t;
        columnName = s;
    }

    public String getColumnName() {
        return columnName;
    }

    public ConstraintType getType() {
        return type;
    }
}
