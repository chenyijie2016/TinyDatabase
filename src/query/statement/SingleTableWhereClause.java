package query.statement;

import data.*;
import exception.SQLExecuteException;
import query.expression.BaseData;
import query.expression.CompareExpression;
import query.expression.Expression;
import query.expression.ValueExpression;
import query.resultColumn.ResultColumn;
import table.Column;
import table.Table;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SingleTableWhereClause {
    private CompareExpression compareExpression;
    private boolean onlyOneTable;
    private Table[] tables;
    private SelectTableStatement.JOIN_TYPE[] joinTypes = null;
    private boolean needCheckAns = false;

    private boolean addRowOrderReverse = false;

    // Single table
    public SingleTableWhereClause(CompareExpression compareExpression, Table table) throws SQLExecuteException {
        this.compareExpression = compareExpression;
        onlyOneTable = true;
        tables = new Table[1];
        tables[0] = table;
        joinTypes = null;
        if (this.compareExpression != null) {
            this.compareExpression.check(this.tables);
        }
    }

    // Multi tables
    public SingleTableWhereClause(CompareExpression compareExpression, Table[] tables, SelectTableStatement.JOIN_TYPE[] joinTypes) throws SQLExecuteException {
        this.compareExpression = compareExpression;
        this.onlyOneTable = false;
        this.tables = tables;
        this.joinTypes = joinTypes;
        if (this.compareExpression != null) {
            this.compareExpression.check(this.tables);
        }
    }

    public Table.RowIterator parseSingleTableColumnAndValue() throws SQLExecuteException {
        if (onlyOneTable) {
            Table targetTable = tables[0];
            if (targetTable == null) {
                throw new SQLExecuteException("[where clause]: table not exist");
            }
            String tableName = targetTable.getTableName();
            Table.RowIterator ans;

            if (compareExpression != null) {
                boolean canUseSingleScan = !compareExpression.isAndOr() &&
                        compareExpression.getCompareSubType() != CompareExpression.COMPARE_SUB_TYPE.ISNULL &&
                        compareExpression.getCompareSubType() != CompareExpression.COMPARE_SUB_TYPE.ISNOTNULL;
                List<ValueExpression> valueExpressionList = null;
                BaseData rightEndData = null;
                if (canUseSingleScan) {
                    valueExpressionList = compareExpression.getValueExpressionList();
                    if (valueExpressionList.size() != 2) {
                        throw new SQLExecuteException("[where clause]: Internal error: where clause wrong");
                    }

                    // Check right end
                    ValueExpression rightEnd = valueExpressionList.get(1);

                    try {
                        rightEndData = rightEnd.simplifyValueDataThatIsNotColumn();
                    } catch (IllegalArgumentException e) {
                        canUseSingleScan = false;
                    }
                }
                if (canUseSingleScan) {
                    // Check left end to get column
                    ValueExpression leftEnd = valueExpressionList.get(0);
                    BaseData leftEndData;
                    try {
                        leftEndData = leftEnd.getColumnInfo();
                    } catch (IllegalArgumentException e) {
                        throw new SQLExecuteException("[where clause]: Left end of equal is not a column");
                    }
                    String tableNameGot = leftEndData.getTableName();
                    if (tableNameGot != null && !tableNameGot.equals(tableName)) {
                        throw new SQLExecuteException("[where clause]: Column's table not exist in the left end of equal");
                    }
                    String columnName = leftEndData.getColumnName();
                    if (columnName == null) {
                        throw new SQLExecuteException("[where clause]: Internal error: Column's name not exist in the left end of equal");
                    }
                    Column targetColumn = targetTable.getColumnByName(columnName);
                    if (targetColumn == null) {
                        throw new SQLExecuteException("[where clause]: Column " + columnName + " not exist");
                    }


                    // GOT COLUMN and VALUE
                    typedData queryData;
                    switch (targetColumn.getColumnType().type()) {
                        case STRING:
                            if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.STRING) {
                                // TODO: add null search
                                throw new SQLExecuteException("[where clause]: Need string here");
                            }
                            queryData = new stringData(rightEndData.getData());
                            break;
                        case INT:
                            if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                                // TODO: add null search
                                throw new SQLExecuteException("[where clause]: Need int here");
                            }
                            queryData = new intData(rightEndData.getNumberData().intValue());
                            break;
                        case LONG:
                            if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                                // TODO: add null search
                                throw new SQLExecuteException("[where clause]: Need long here");
                            }
                            queryData = new longData(rightEndData.getNumberData().longValue());
                            break;
                        case DOUBLE:
                            if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                                // TODO: add null search
                                throw new SQLExecuteException("[where clause]: Need double here");
                            }
                            queryData = new doubleData(rightEndData.getNumberData());
                            break;
                        case FLOAT:
                            if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                                // TODO: add null search
                                throw new SQLExecuteException("[where clause]: Need float here");
                            }
                            queryData = new floatData(rightEndData.getNumberData().floatValue());
                            break;
                        default:
                            throw new SQLExecuteException("[where clause]: Column type wrong");
                    }
                    try {
                        switch (compareExpression.getCompareSubType()) {
                            case EQ:
                                ans = targetTable.scanEqual(targetColumn, queryData);
                                break;
                            case NEQ:
                                ans = targetTable.scanNotEqual(targetColumn, queryData);
                                break;
                            case LT:
                                ans = targetTable.scanLessThan(targetColumn, queryData);
                                if (targetTable.getIndexColumns().indexOf(targetColumn) >= 0) {
                                    addRowOrderReverse = true;
                                }
                                break;
                            case LTE:
                                ans = targetTable.scanLessEqual(targetColumn, queryData);
                                if (targetTable.getIndexColumns().indexOf(targetColumn) >= 0) {
                                    addRowOrderReverse = true;
                                }
                                break;
                            case GT:
                                ans = targetTable.scanGreaterThan(targetColumn, queryData);
                                break;
                            default: //case GTE:
                                ans = targetTable.scanGreaterEqual(targetColumn, queryData);
                                break;
                        }
                    } catch (IOException e) {
                        throw new SQLExecuteException("[where clause]: IOException: " + e.getMessage());
                    }
                }
                else {
                    try {
                        ans = targetTable.scanAll();
                        needCheckAns = true;
                    } catch (IOException e) {
                        throw new SQLExecuteException("[where clause]: IOException: " + e.getMessage());
                    }
                }
            }
            else {
                try {
                    ans = targetTable.scanAll();
                } catch (IOException e) {
                    throw new SQLExecuteException("[where clause]: IOException: " + e.getMessage());
                }
            }
            return ans;
        }
        else {
            throw new SQLExecuteException("[where clause]: Function call error: Only one table conditions can call this function!");
        }
    }

    public boolean getAddRowOrderReverse() {
        return addRowOrderReverse;
    }

    public boolean getNeedCheckAns() {
        return needCheckAns;
    }
}
