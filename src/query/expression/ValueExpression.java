package query.expression;

import java.util.ArrayList;
import java.util.List;

public class ValueExpression extends Expression{
    public enum SUB_TYPE {
        ATOM,
        NEG,    // unary '-'
        POS,    // unary '+'
        BIT_REVERSE,    // unary '~'
        NOT,    // unary NOT
        ADD,    // +
        MINUS,  // -
    }

    private SUB_TYPE subType;
    private List<BaseData> data = new ArrayList<>();
    private List<Expression> expressionList = new ArrayList<>();

    public ValueExpression(BaseData data) {
        super(BASE_TYPE.VALUE);
        this.subType = SUB_TYPE.ATOM;
        this.data.add(data);
    }

    public ValueExpression(SUB_TYPE subType, Expression expression) {
        super(BASE_TYPE.VALUE);
        this.subType = subType;
        this.expressionList.add(expression);
    }

    public ValueExpression(SUB_TYPE subType, Expression a, Expression b) {
        super(BASE_TYPE.VALUE);
        this.subType = subType;
        this.expressionList.add(a);
        this.expressionList.add(b);
    }
}
