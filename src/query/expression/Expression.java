package query.expression;

public abstract class Expression {
    public enum BASE_TYPE {
        COMPARE,
        VALUE
    }

    private BASE_TYPE baseType;

    public Expression(BASE_TYPE baseType) {
        this.baseType = baseType;
    }
}
