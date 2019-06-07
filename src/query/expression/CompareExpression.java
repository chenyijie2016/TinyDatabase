package query.expression;

import exception.SQLExecuteException;
import table.Row;
import table.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    private boolean isChecked = false;
    private Table[] tableInfos;

    public void checkBase() throws SQLExecuteException {
        if (isChecked) {
            return;
        }
        if (valueExpressionList.size() != 2) {
            throw new SQLExecuteException("[expression]: Internal error: Compare expression needs two data");
        }
        valueExpressionList.get(0).check(tableInfos);
        valueExpressionList.get(1).check(tableInfos);
        if (valueExpressionList.get(0).getIsSimplifiedData()) {
            throw new SQLExecuteException("[expression]: Compare expression need column in the left");
        }
        isChecked = true;
    }

    public void check(Table t) throws SQLExecuteException {
        tableInfos = new Table[1];
        tableInfos[0] = t;
        checkBase();
    }

    public void check(Table[] t) throws SQLExecuteException {
        tableInfos = t;
        checkBase();
    }

    public void check() throws SQLExecuteException {
        tableInfos = new Table[0];
        checkBase();
    }

    public boolean getCompareAns(Map<Table, Row> tableRowMap) throws SQLExecuteException {
        BaseData a = valueExpressionList.get(0).calculate(tableRowMap);
        BaseData b = valueExpressionList.get(1).calculate(tableRowMap);
        BaseData.BASE_DATA_TYPE aType = a.getBaseDataType(), bType = b.getBaseDataType();
        if (aType == BaseData.BASE_DATA_TYPE.NULL || bType == BaseData.BASE_DATA_TYPE.NULL) {
            return false;
        }
        if (aType != bType) {
            throw new SQLExecuteException("[expresion]: Can't compare different type");
        }
        int compareAns;
        if (aType == BaseData.BASE_DATA_TYPE.STRING) {
            compareAns = a.getData().compareTo(b.getData());
        }
        else {
            compareAns = a.getNumberData().compareTo(b.getNumberData());
        }
        switch (compareSubType) {
            case GTE:
                return compareAns >= 0;
            case NEQ:
                return compareAns != 0;
            case LTE:
                return compareAns <= 0;
            case LT:
                return compareAns < 0;
            case GT:
                return compareAns > 0;
            default:
                return compareAns == 0;
        }
    }

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
