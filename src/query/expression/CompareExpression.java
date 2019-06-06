package query.expression;

import exception.SQLExecuteException;

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
        super(EXPRESSION_BASE_TYPE.COMPARE);
        this.compareSubType = compareSubType;
        this.valueExpressionList.add(a);
        this.valueExpressionList.add(b);
    }

    public List<ValueExpression> getValueExpressionList() {
        return valueExpressionList;
    }

    public COMPARE_SUB_TYPE getCompareSubType() {
        return compareSubType;
    }

    public boolean isTwoColumnsEqualCheckForOnClause() throws SQLExecuteException {
        if (compareSubType != COMPARE_SUB_TYPE.EQ) {
            throw new SQLExecuteException("[on clause]: Need to be equal conditions");
        }
        if (valueExpressionList.size() != 2) {
            throw new SQLExecuteException("[compareexpression]: Internal error: Num of values not 2");
        }
        return valueExpressionList.get(0).isColumnInfoWithTable() && valueExpressionList.get(1).isColumnInfoWithTable();
    }
}
