package query.statement;

import data.*;
import database.DataBase;
import exception.SQLExecuteException;
import query.Result;
import query.expression.BaseData;
import query.expression.CompareExpression;
import query.expression.Expression;
import query.expression.ValueExpression;
import query.resultColumn.ResultColumn;
import schema.SchemaManager;
import table.Column;
import table.Row;
import table.Table;

import java.io.IOException;
import java.util.*;

public class SelectTableStatement extends Statement {
    public enum JOIN_TYPE {
        NATURAL,
        LEFT_OUTER,
        LEFT_OUTER_ON,
        INNER,
        INNER_ON,
        CROSS  // just ,
    }

    public enum SELECT_TYPE {
        DISTINCT,
        ALL
    }

    // 对于多个表join的情况，需要判断产生的列的名称
    public enum TYPE_COLUMNS {
        ONLY_COLUMN_NAME,  // 普通的不在join条件中，也不重复的列
        TABLE_COLUMN_NAME,  // 如果被join了，但是不是on里面或者natual join里面的
        NOT_SHOWN   // 当一个列与别的表中的相同，此时这个列仅仅需要在前面的表这里显示出来
    }

    public class OnCondition {
        // 表示谁和谁相等
        public Table ta, tb;
        public Column ca, cb;
        public int ia, ib;

        public OnCondition(Table ta, Column ca, int a, Table tb, Column cb, int b) {
            this.ta = ta;
            this.tb = tb;
            this.ca = ca;
            this.cb = cb;
            this.ia = a;
            this.ib = b;
        }
    }

    private SELECT_TYPE selectType;
    private String[] tableNames;  // from ...
    private CompareExpression[] onExpressions;
    private ResultColumn[] resultColumns;  // resultColumn列表
    private CompareExpression compareExpression;  // where
    private JOIN_TYPE[] joinTypes;

    public SelectTableStatement(SELECT_TYPE selectType, ResultColumn[] resultColumns, String[] tableNames,
                                JOIN_TYPE[] joinTypes, CompareExpression[] onExpressions, CompareExpression compareExpression) {
        this.selectType = selectType;
        this.resultColumns = resultColumns;
        this.tableNames = tableNames;
        this.joinTypes = joinTypes;
        this.onExpressions = onExpressions;
        this.compareExpression = compareExpression;
    }

    @Override
    public Result execute(SchemaManager schemaManager) throws SQLExecuteException {
        DataBase db = schemaManager.getCurrentDataBase();
        boolean distinct = selectType == SELECT_TYPE.DISTINCT;
        boolean addRowOrderReverse = false;  // if less than, it's true
        if (tableNames.length == 1) {
            String tableName = tableNames[0];
            Table targetTable = db.getTableByName(tableName);
            if (targetTable == null) {
                throw new SQLExecuteException("[select table]: Table " + tableName + " not exist");
            }
            WhereClause where = new WhereClause(compareExpression, targetTable);
            Table.RowIterator ans = where.parseSingleTableColumnAndValue();
            addRowOrderReverse = where.getAddRowOrderReverse();

            Result result = new Result();

            // Check ans columns
            boolean allColumnsOutput = false;
            List<Column> columnsForOutput = new ArrayList<>();
            for (ResultColumn rc : resultColumns) {
                switch (rc.getResultColumnType()) {
                    case ALL:
                        allColumnsOutput = true;
                        break;
                    case TABLE_NAME:
                        if (rc.getData().equals(tableName)) {
                            allColumnsOutput = true;
                        } else {
                            throw new SQLExecuteException("[select table]: Result table not found!");
                        }
                        break;
                    case EXPRESSION:
                        if (rc.getExpression().getBaseType() != Expression.EXPRESSION_BASE_TYPE.VALUE) {
                            throw new SQLExecuteException("[select table]: Result column need to be column!");
                        }
                        ValueExpression valueExpression = (ValueExpression) (rc.getExpression());
                        if (valueExpression.getSubType() != ValueExpression.SUB_TYPE.ATOM) {
                            throw new SQLExecuteException("[select table]: Result column need to be column!");
                        }
                        BaseData data = valueExpression.getData().get(0);
                        if (data.getDataType() != BaseData.DATA_TYPE.COLUMN) {
                            throw new SQLExecuteException("[select table]: Result column need to be column!");
                        }
                        if (data.getTableName() != null && !data.getTableName().equals(tableName)) {
                            throw new SQLExecuteException("[select table]: Result table not found!");
                        }
                        Column column = targetTable.getColumnByName(data.getColumnName());
                        if (column == null) {
                            throw new SQLExecuteException("[select table]: Result column not found!");
                        }
                        columnsForOutput.add(column);
                }
            }

            Row row = ans.next();
            if (allColumnsOutput) {
                result.setColumns(targetTable.getColumns());
                while (row != null) {
                    result.addRow(row, addRowOrderReverse, distinct);
                    row = ans.next();
                }
            }
            else {
                result.setColumns(columnsForOutput);
                int columnsForOutputSize = columnsForOutput.size();
                while (row != null) {
                    Object[] rowData = new Object[columnsForOutputSize];
                    for (int i = 0; i < columnsForOutputSize; i++) {
                        rowData[i] = row.getDataByColumn(columnsForOutput.get(i)).getData();
                    }
                    Row newRow = new Row(result, rowData);
                    result.addRow(newRow, addRowOrderReverse, distinct);
                    row = ans.next();
                }
            }
            return result;
        }
        else if (tableNames.length > 1) {
            List<Table> tables = new ArrayList<>();
            Map<String, List<Table>> columnInfos = new HashMap<>();
            List<OnCondition> onConditionList = new ArrayList<>();  // 记录一下，需要谁和谁相等
            List<OnCondition> otherOnConditionList = new ArrayList<>();  // 上面的是记录所有可以用来做scan条件的，这里是记录需要check的
            // TODO: think about change order of tables: NOW NOT SUPPORT CHANGE ORDER
            for (int i = 0; i < tableNames.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (tableNames[i].equals(tableNames[j])) {
                        throw new SQLExecuteException("[select table]: Duplicate table names");
                    }
                }
                Table temp = db.getTableByName(tableNames[i]);
                if (temp == null) {
                    throw new SQLExecuteException("[select table]: Table " + tableNames[i] + " not exist");
                }
                tables.add(temp);
                // 记录下来column对应的table的列表
                for (Column c : temp.getColumns()) {
                    String columnName = c.getName();
                    List<Table> columnTableNames = columnInfos.get(columnName);
                    if (columnTableNames == null) {
                        columnTableNames = new ArrayList<>();
                        columnInfos.put(columnName, columnTableNames);
                    }
                    columnTableNames.add(temp);
                }
            }
            // Check on expression
            for (CompareExpression onExpression : onExpressions) {
                if (!onExpression.isTwoColumnsEqualCheckForOnClause()) {
                    throw new SQLExecuteException("[select table]: On clause need to be two table's columns");
                }
                OnCondition onCondition;
                BaseData a = onExpression.getValueExpressionList().get(0).getColumnInfo();
                BaseData b = onExpression.getValueExpressionList().get(1).getColumnInfo();
                Table ta, tb;
                ta = db.getTableByName(a.getTableName());
                int taIndex = tables.indexOf(ta);
                tb = db.getTableByName(b.getTableName());
                int tbIndex = tables.indexOf(tb);
                if (taIndex == tbIndex) {
                    throw new SQLExecuteException("[select table]: On clause can't be the same table's comparision");
                }
                if (taIndex < 0 || tbIndex < 0) {
                    throw new SQLExecuteException("[select table]: Table in on clause not exist");
                }
                Column ca = ta.getColumnByName(a.getColumnName()), cb = tb.getColumnByName(b.getColumnName());
                if (ca == null || cb == null) {
                    throw new SQLExecuteException("[select table]: Column in on clause not exist");
                }
                if (taIndex < tbIndex) {
                    onCondition = new OnCondition(ta, ca, taIndex, tb, cb, tbIndex);
                }
                else {
                    onCondition = new OnCondition(tb, cb, tbIndex, ta, ca, taIndex);
                }
                boolean canAddToOnList = true;
                for (OnCondition onCondition1: onConditionList) {
                    if (onCondition1.ib == onCondition.ib) {
                        canAddToOnList = false;
                        break;
                    }
                }
                if (canAddToOnList) {
                    onConditionList.add(onCondition);
                }
                else {
                    otherOnConditionList.add(onCondition);
                }
            }

            for (int i = 0; i < joinTypes.length; i++) {
                switch (joinTypes[i]) {
                    case CROSS:
                        // 没有额外约束
                        // break;
                    case INNER_ON:
                        // 只有onClause的约束
                        break;
                    default:
                        throw new SQLExecuteException("[select table]: Now not support OUTER JOIN or NATURAL JOIN");
                }
            }

            Table.RowIterator[] iterators = new Table.RowIterator[tableNames.length];
            Row[] rows = new Row[tableNames.length];
            int nowIteratorIndex = -1;  // it varies from 0 to tableNames.length - 1



            int targetTableIndex = -1;
            Column targetColumn = null;
            typedData queryData = null;
            if (compareExpression != null) {
                // CHECK where clause
                List<ValueExpression> valueExpressionList = compareExpression.getValueExpressionList();
                if (valueExpressionList.size() != 2) {
                    throw new SQLExecuteException("[where clause]: Internal error: where clause wrong");
                }

                // Check right end
                ValueExpression rightEnd = valueExpressionList.get(1);
                BaseData rightEndData;
                try {
                    rightEndData = rightEnd.simplifyValueDataThatIsNotColumn();
                } catch (IllegalArgumentException e) {
                    throw new SQLExecuteException("[where clause]: Right end error: " + e.getMessage());
                }

                // Check left end to get column
                ValueExpression leftEnd = valueExpressionList.get(0);
                BaseData leftEndData;
                try {
                    leftEndData = leftEnd.getColumnInfo();
                } catch (IllegalArgumentException e) {
                    throw new SQLExecuteException("[where clause]: Left end of equal is not a column");
                }
                String tableNameGot = leftEndData.getTableName();
                if (tableNameGot == null) {
                    throw new SQLExecuteException("[where clause]: Column's table need to be provided");
                }
                for (int i = 0; i < tableNames.length; i++) {
                    if (tableNameGot.equals(tableNames[i])) {
                        targetTableIndex = i;
                        break;
                    }
                }
                if (targetTableIndex < 0) {
                    throw new SQLExecuteException("[where clause]: Column's table not exist in the left end of equal");
                }
                Table targetTable = db.getTableByName(tableNameGot);
                String columnName = leftEndData.getColumnName();
                if (columnName == null) {
                    throw new SQLExecuteException("[where clause]: Internal error: Column's name not exist in the left end of equal");
                }
                targetColumn = targetTable.getColumnByName(columnName);
                if (targetColumn == null) {
                    throw new SQLExecuteException("[where clause]: Column " + columnName + " not exist");
                }

                // GOT COLUMN and VALUE
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
            }

            // 现在有了targetTable和targetTableIndex
            // 有了targetColumn


            // 找到所有的indexed column并且是and关系
            // 排序
            // 将on和where的条件看作是一个
            // 将所有and的条件排序，用and的规律
            // 使得后面的table的列（并且是indexed的列）在符号前面，



            Result result = new Result();
            List<List<TYPE_COLUMNS>> columns = new ArrayList<>();
            List<List<TYPE_COLUMNS>> showColumns = new ArrayList<>();
            for (int i = 0; i < tableNames.length; i++) {
                List<TYPE_COLUMNS> columnInfo = new ArrayList<>();
                List<TYPE_COLUMNS> showColumnInfo = new ArrayList<>();
                List<Column> tableColumns = tables.get(i).getColumns();
                for (int j = 0; j < tableColumns.size(); j++) {
                    if (columnInfos.get(tableColumns.get(i).getName()).size() > 1) {
                        columnInfo.add(TYPE_COLUMNS.TABLE_COLUMN_NAME);
                    }
                    else {
                        columnInfo.add(TYPE_COLUMNS.ONLY_COLUMN_NAME);
                    }
                    showColumnInfo.add(TYPE_COLUMNS.NOT_SHOWN);
                }
                columns.add(columnInfo);
                showColumns.add(showColumnInfo);
            }
            for (OnCondition onCondition: onConditionList) {
                int columnIndex = tables.get(onCondition.ib).getColumns().indexOf(onCondition.cb);
                columns.get(onCondition.ib).set(columnIndex, TYPE_COLUMNS.NOT_SHOWN);
            }
            // Check ans columns
            boolean allColumnsOutput = false;
            for (ResultColumn rc : resultColumns) {
                switch (rc.getResultColumnType()) {
                    case ALL:
                        allColumnsOutput = true;
                        break;
                    case TABLE_NAME:
                        int tableIndex = -1;
                        for (int i = 0; i < tableNames.length; i++) {
                            if (rc.getData().equals(tableNames[i])) {
                                tableIndex = i;
                                break;
                            }
                        }
                        if (tableIndex < 0) {
                            throw new SQLExecuteException("[select table]: Result table not found!");
                        }
                        for (int i = 0; i < showColumns.get(tableIndex).size(); i++) {
                            showColumns.get(tableIndex).set(i, TYPE_COLUMNS.ONLY_COLUMN_NAME);
                        }
                        break;
                    case EXPRESSION:
                        if (rc.getExpression().getBaseType() != Expression.EXPRESSION_BASE_TYPE.VALUE) {
                            throw new SQLExecuteException("[select table]: Result column need to be column!");
                        }
                        ValueExpression valueExpression = (ValueExpression) (rc.getExpression());
                        if (valueExpression.getSubType() != ValueExpression.SUB_TYPE.ATOM) {
                            throw new SQLExecuteException("[select table]: Result column need to be column!");
                        }
                        BaseData data = valueExpression.getData().get(0);
                        if (data.getDataType() != BaseData.DATA_TYPE.COLUMN) {
                            throw new SQLExecuteException("[select table]: Result column need to be column!");
                        }
                        if (data.getTableName() == null) {
                            throw new SQLExecuteException("[select table]: Result table not specified!");
                        }
                        int tableIndex2 = -1;
                        for (int i = 0; i < tableNames.length; i++) {
                            if (data.getTableName().equals(tableNames[i])) {
                                tableIndex2 = i;
                                break;
                            }
                        }
                        if (tableIndex2 < 0) {
                            throw new SQLExecuteException("[select table]: Result table not found!");
                        }
                        Table targetResultTable = tables.get(tableIndex2);
                        Column column = targetResultTable.getColumnByName(data.getColumnName());
                        if (column == null) {
                            throw new SQLExecuteException("[select table]: Result column not found!");
                        }
                        int columnIndex = targetResultTable.getColumns().indexOf(column);
                        showColumns.get(tableIndex2).set(columnIndex, TYPE_COLUMNS.ONLY_COLUMN_NAME);
                    default:
                        break;
                }
            }

            List<Column> ansColumns = new ArrayList<>();
            for (int i = 0; i < tableNames.length; i++) {
                List<TYPE_COLUMNS> columnInfo = columns.get(i);
                List<TYPE_COLUMNS> showColumnInfo = showColumns.get(i);
                List<Column> tableColumns = tables.get(i).getColumns();
                for (int j = 0; j < tableColumns.size(); j++) {
                    if ((allColumnsOutput || showColumnInfo.get(j) != TYPE_COLUMNS.NOT_SHOWN) && columnInfo.get(j) == TYPE_COLUMNS.TABLE_COLUMN_NAME) {
                        Column newColumn = new Column(tableColumns.get(j).getColumnType(), tables.get(i).getTableName() + "." + tableColumns.get(j).getName());
                        ansColumns.add(newColumn);
                    }
                    else if ((allColumnsOutput || showColumnInfo.get(j) != TYPE_COLUMNS.NOT_SHOWN) && columnInfo.get(j) == TYPE_COLUMNS.ONLY_COLUMN_NAME) {
                        Column newColumn = new Column(tableColumns.get(j).getColumnType(), tableColumns.get(j).getName());
                        ansColumns.add(newColumn);
                    }
                }
            }
            result.setColumns(ansColumns);

            while (true) {
                if (nowIteratorIndex == tableNames.length - 1) {
                    // 应该来进行继续的遍历
                    if (rows[nowIteratorIndex] == null) {
                        // 已经遍历完了
                        nowIteratorIndex --;
                        rows[nowIteratorIndex] = iterators[nowIteratorIndex].next();
                    }
                    else {
                        boolean ok=true;
                        for (OnCondition onCondition: otherOnConditionList) {
                            if (!rows[onCondition.ia].getDataByColumn(onCondition.ca).equals(
                                    rows[onCondition.ia].getDataByColumn(onCondition.cb)
                            )) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok && compareExpression != null) {
                            int ans = rows[targetTableIndex].getDataByColumn(targetColumn).compareTo(queryData);
                            switch (compareExpression.getCompareSubType()) {
                                case EQ:
                                    ok = ans == 0;
                                    break;
                                case GT:
                                    ok = ans > 0;
                                    break;
                                case LT:
                                    ok = ans < 0;
                                    break;
                                case LTE:
                                    ok = ans <= 0;
                                    break;
                                case NEQ:
                                    ok = ans != 0;
                                    break;
                                case GTE:
                                    ok = ans >= 0;
                                    break;
                                default:
                                    ok = false;
                            }
                        }
                        if (ok) {
                            // set data
                            Object[] objs = new Object[ansColumns.size()];
                            int index = 0;
                            for (int i = 0; i < tableNames.length; i++) {
                                List<TYPE_COLUMNS> columnInfo = columns.get(i);
                                List<TYPE_COLUMNS> showColumnInfo = showColumns.get(i);
                                List<Column> tableColumns = tables.get(i).getColumns();
                                for (int j = 0; j < tableColumns.size(); j++) {
                                    if ((allColumnsOutput || showColumnInfo.get(j) != TYPE_COLUMNS.NOT_SHOWN) && (columnInfo.get(j) == TYPE_COLUMNS.TABLE_COLUMN_NAME || columnInfo.get(j) == TYPE_COLUMNS.ONLY_COLUMN_NAME)) {
                                        objs[index] = rows[i].getDataByColumn(tableColumns.get(j)).getData();
                                        index ++;
                                    }
                                }
                            }
                            Row row = new Row(result, objs);
                            result.addRow(row, false, distinct);
                        }
                        rows[nowIteratorIndex] = iterators[nowIteratorIndex].next();
                    }
                }
                else {
                    if (nowIteratorIndex < 0 || rows[nowIteratorIndex] != null) {
                        // 直接继续往下走
                        nowIteratorIndex++;
                        try {
                            iterators[nowIteratorIndex] = null;
                            for (OnCondition onCondition: onConditionList) {
                                if (onCondition.ib == nowIteratorIndex) {
                                    iterators[nowIteratorIndex] = tables.get(nowIteratorIndex).scanEqual(onCondition.cb,
                                            rows[onCondition.ia].getDataByColumn(onCondition.ca));
                                    break;
                                }
                            }
                            if (iterators[nowIteratorIndex] == null) {
                                iterators[nowIteratorIndex] = tables.get(nowIteratorIndex).scanAll();
                            }
                        }
                        catch (IOException e) {
                            throw new SQLExecuteException("[select table]: IOException: " + e.getMessage());
                        }
                        rows[nowIteratorIndex] = iterators[nowIteratorIndex].next();
                    }
                    else {
                        if (nowIteratorIndex == 0) {
                            break;
                        }
                        nowIteratorIndex--;
                        rows[nowIteratorIndex] = iterators[nowIteratorIndex].next();
                    }
                }
            }
            return result;
        }
        else {
            throw new SQLExecuteException("[select table]: No table name provided");
        }

//        return null;
    }
}
