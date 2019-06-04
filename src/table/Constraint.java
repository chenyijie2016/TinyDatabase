package table;

public class Constraint {
    public enum ConstraintType {
        PRIMARY_KEY,
        NOT_NULL
    }

    public enum Order {
        ASC,
        DESC
    }

    private ConstraintType type;
    private String columnName;
    private Order order = Order.ASC;

    public Constraint(ConstraintType type, String columnName) {
        this.type = type;
        this.columnName = columnName;
    }

    public Constraint(Order order, String columnName) {
        this.type = ConstraintType.PRIMARY_KEY;
        this.order = order;
        this.columnName = columnName;
    }

    public Constraint(ConstraintType type, Order order, String columnName) {
        this.type = type;
        this.order = order;
        this.columnName = columnName;
    }

    public String getColumnName() {
        return columnName;
    }

    public ConstraintType getType() {
        return type;
    }

    public Order getOrder() {
        return order;
    }
}
