package query.expression;

public abstract class Expression {
    public enum EXPRESSION_BASE_TYPE {
        COMPARE,
        VALUE
    }

    private EXPRESSION_BASE_TYPE baseType;

    public Expression(EXPRESSION_BASE_TYPE baseType) {
        this.baseType = baseType;
    }

    public EXPRESSION_BASE_TYPE getBaseType() {
        return baseType;
    }
}
