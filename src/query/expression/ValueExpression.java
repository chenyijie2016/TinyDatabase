package query.expression;

import data.Type;
import exception.SQLExecuteException;
import table.Column;
import table.Row;
import table.Table;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    private List<BaseData> data = new ArrayList<>();  // 只有在ATOM的时候才有值
    private List<ValueExpression> expressionList = new ArrayList<>();

    private boolean isChecked = false;  // 用来判断有没有被检查过，如果被检查过了，那就直接在这里的ATOM的位置记录下来它的值/Column
    private Table[] tableInfos = null;
    public boolean isAtom() {  // subType是不是atom
        return subType == SUB_TYPE.ATOM;
    }
    public boolean isAtomColumn() {
        return isAtom() && data.get(0).getDataType() == BaseData.DATA_TYPE.COLUMN;
    }
    public boolean isAtomData() {  // NUMBER/STRING/NULL
        return isAtom() && data.get(0).getDataType() == BaseData.DATA_TYPE.BASE;
    }
    private Column realColumn = null;  // 如果check过了，并且是column，这里会有
    private Table realTable = null;
    private boolean isSimplifiedData = false;  // 表达式可以化简的那种data
    private BaseData simplifiedData = null;  // 如果是simplifiedData，有值

    public boolean getIsSimplifiedData() {
        return isSimplifiedData;
    }

    private BaseData calculateByData(BaseData aData, BaseData bData) throws SQLExecuteException {
        if (aData.getBaseDataType() == BaseData.BASE_DATA_TYPE.STRING || (bData != null &&
                bData.getBaseDataType() == BaseData.BASE_DATA_TYPE.STRING)) {
            throw new SQLExecuteException("[expression]: Can't do operators to string");
        }
        BaseData thisSimplifiedData;
        if (aData.getBaseDataType() == BaseData.BASE_DATA_TYPE.NULL || (bData != null &&
                bData.getBaseDataType() == BaseData.BASE_DATA_TYPE.NULL)) {
            thisSimplifiedData = new BaseData();
        }
        else {
            Double aValue = aData.getNumberData();
            Double bValue = bData == null ? null : bData.getNumberData();
            switch (subType) {
                case NEG:
                    thisSimplifiedData = new BaseData(-aValue);
                    break;
                case BIT_REVERSE:
                    if (!aData.isInt()) {
                        throw new SQLExecuteException("[expression]: Can't bit reverse a double");
                    }
                    thisSimplifiedData = new BaseData(~(aValue.longValue()));
                    break;
                case NOT:
                    // TODO: CHECK DO WE NEED NOT
                    throw new SQLExecuteException("[expression]: Not boolean type");
                case ADD:
                    thisSimplifiedData = new BaseData(aValue + bValue);
                    break;
                case MINUS:
                    thisSimplifiedData = new BaseData(aValue - bValue);
                    break;
                default:  // case POS
                    thisSimplifiedData = new BaseData(aValue);
            }
        }
        return thisSimplifiedData;
    }

    // 用一个表的时候，进行check
    private void checkBase() throws SQLExecuteException {
        if (isChecked) {
            return;
        }
        // CHECK NUM OF DATA
        switch (subType) {
            case ATOM:
                if (data.size() != 1) {
                    throw new SQLExecuteException("[expression]: Internal error: expression data number need to be 1");
                }
                break;
            case NEG:
            case POS:
            case BIT_REVERSE:
                if (expressionList.size() != 1) {
                    throw new SQLExecuteException("[expression]: Internal error: expression number need to be 1");
                }
                break;
            case ADD:
            case MINUS:
                if (expressionList.size() != 2) {
                    throw new SQLExecuteException("[expression]: Internal error: expression number need to be 2");
                }
                break;
            default:
            // case NOT:
                throw new SQLExecuteException("[expression]: Not supported operator");
        }
        if (!isAtom()) {
            // 检查一下下面的是不是都能化简
            // 如果可以的话，就把这个expression也化简，保存在simplifiedData里
            boolean allDatas = true;
            for (ValueExpression e: expressionList) {
                e.check(tableInfos);
                if (!e.isSimplifiedData) {
                    allDatas = false;
                }
            }
            if (allDatas) {
                isSimplifiedData = true;
                BaseData aData = expressionList.get(0).simplifiedData;
                BaseData bData = expressionList.size() > 1 ? expressionList.get(1).simplifiedData : null;
                simplifiedData = calculateByData(aData, bData);
            }
        }
        else if (isAtomData()) {
            isSimplifiedData = true;
            simplifiedData = data.get(0);
        }
        else if (isAtomColumn()) {
            BaseData thisData = data.get(0);
            int tableInfoLength = tableInfos.length;
            if (tableInfoLength == 0) {
                throw new SQLExecuteException("[expression]: Can't put column here");
            }
            else if (tableInfoLength == 1) {
                if (thisData.getTableName() != null) {
                    String baseTableNameString = thisData.getTableName();
                    if (!baseTableNameString.equals(tableInfos[0].getTableName())) {
                        throw new SQLExecuteException("[expression]: Here can't use table " + baseTableNameString);
                    }
                }
                realTable = tableInfos[0];
                realColumn = realTable.getColumnByName(thisData.getColumnName());  // here will throw exception
            }
            else {
                String baseTableNameString = thisData.getTableName();
                if (baseTableNameString == null) {
                    throw new SQLExecuteException("[expression]: Here need to specify table here");
                }
                for (Table t: tableInfos) {
                    if (baseTableNameString.equals(t.getTableName())) {
                        realTable = t;
                        break;
                    }
                }
                if (realTable == null) {
                    throw new SQLExecuteException("[expression]: Here can't use table " + baseTableNameString);
                }
                realColumn = realTable.getColumnByName(thisData.getColumnName());  // here will throw exception
            }
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

    public BaseData calculate(Map<Table, Row> tableRowMap) throws SQLExecuteException {
        if (!isChecked) {
            throw new SQLExecuteException("[expression]: Need to be checked first!");
        }
        if (isSimplifiedData) {
            return simplifiedData;
        }
        if (isAtomColumn()) {
            Row data = tableRowMap.get(realTable);
            if (data == null) {
                // Means data is NULL
                return new BaseData();
            }
            if (data.getDataByColumn(realColumn).isNull()) {
                return new BaseData();
            }
            switch (realColumn.getColumnType().type()) {
                case STRING:
                    return new BaseData(BaseData.BASE_DATA_TYPE.STRING, (String)data.getDataByColumn(realColumn).getData());
                case DOUBLE:
                case FLOAT:
                    return new BaseData((Double)data.getDataByColumn(realColumn).getData());
                case INT:
                case LONG:
                    return new BaseData((Long)data.getDataByColumn(realColumn).getData());
                default:
                    return new BaseData();
            }
        }
        BaseData aData = expressionList.get(0).calculate(tableRowMap);
        BaseData bData = expressionList.size() > 1 ? expressionList.get(1).calculate(tableRowMap) : null;
        return calculateByData(aData, bData);
    }

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

    public boolean isColumnInfoWithTable() {
        if (subType != ValueExpression.SUB_TYPE.ATOM || data.size() != 1) {
            return false;
        }
        return data.get(0).isColumnInfoWithTable();
    }
}
