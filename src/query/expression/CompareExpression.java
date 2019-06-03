package query.expression;

import java.util.ArrayList;
import java.util.List;

public class CompareExpression extends Expression{
    public enum COMPARE_SUB_TYPE {
        GT,
        GTE,
        LT,
        LTE,
        EQ,
        NEQ
    }

    private COMPARE_SUB_TYPE compareSubType;
    private List<ValueExpression> valueExpressionList = new ArrayList<>();

    public CompareExpression(COMPARE_SUB_TYPE compareSubType, ValueExpression a, ValueExpression b) {
        super(BASE_TYPE.COMPARE);
        this.compareSubType = compareSubType;
        this.valueExpressionList.add(a);
        this.valueExpressionList.add(b);
    }
}
