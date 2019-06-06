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
    private List<ValueExpression> expressionList = new ArrayList<>();

    public ValueExpression(BaseData data) {
        super(EXPRESSION_BASE_TYPE.VALUE);
        this.subType = SUB_TYPE.ATOM;
        this.data.add(data);
    }

    public ValueExpression(SUB_TYPE subType, ValueExpression expression) {
        super(EXPRESSION_BASE_TYPE.VALUE);
        this.subType = subType;
        this.expressionList.add(expression);
    }

    public ValueExpression(SUB_TYPE subType, ValueExpression a, ValueExpression b) {
        super(EXPRESSION_BASE_TYPE.VALUE);
        this.subType = subType;
        this.expressionList.add(a);
        this.expressionList.add(b);
    }

    public SUB_TYPE getSubType() {
        return subType;
    }

    public List<BaseData> getData() {
        return data;
    }

    public BaseData simplifyValueDataThatIsNotColumn() throws IllegalArgumentException {
        if (subType == SUB_TYPE.ATOM) {
            if (data.size() != 1) {
                throw new IllegalArgumentException("Value expression size illegal");
            }
            BaseData ans = data.get(0);
            if (ans.getDataType() == BaseData.DATA_TYPE.COLUMN) {
                throw new IllegalArgumentException("Value expression size illegal! Contains column!");
            }
            return ans;
        }
        if (!(((subType == SUB_TYPE.ADD || subType == SUB_TYPE.MINUS) && expressionList.size() == 2) ||
                expressionList.size() == 1)) {
            throw new IllegalArgumentException("Value expression size illegal");
        }

        // simplifyValueDataThatIsNotColumn得到的肯定不是column
        ValueExpression a = expressionList.get(0);
        BaseData aData = a.simplifyValueDataThatIsNotColumn();
        if (aData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
            throw new IllegalArgumentException("Value expression size illegal! Only number can calculate!");
        }
        BaseData bData = null;
        if (subType == SUB_TYPE.ADD || subType == SUB_TYPE.MINUS) {
            bData = expressionList.get(1).simplifyValueDataThatIsNotColumn();
            if (bData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                throw new IllegalArgumentException("Value expression size illegal! Only number can calculate!");
            }
        }
        Double aValue = aData.getNumberData();
        Double bValue = bData == null ? null : bData.getNumberData();

        switch (subType) {
            case NEG:
                return new BaseData(-aValue);
            case BIT_REVERSE:
                if (!aData.isInt()) {
                    throw new IllegalArgumentException("Can't bit reverse a double");
                }
                return new BaseData(~(aValue.longValue()));
            case NOT:
                // TODO: CHECK DO WE NEED NOT
                throw new IllegalArgumentException("Type error, not boolean type");
            case ADD:
                return new BaseData(aValue + bValue);
            case MINUS:
                return new BaseData(aValue - bValue);
            default:  // case POS
                return a.simplifyValueDataThatIsNotColumn();
        }
    }

    public BaseData getColumnInfo() throws IllegalArgumentException {
        if (subType != ValueExpression.SUB_TYPE.ATOM || data.size() != 1) {
            throw new IllegalArgumentException("need column name");
        }
        BaseData leftEndData = data.get(0);
        if (leftEndData.getDataType() != BaseData.DATA_TYPE.COLUMN) {
            throw new IllegalArgumentException("need column name");
        }
        return leftEndData;
    }
}
