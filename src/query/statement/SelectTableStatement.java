package query.statement;


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
            SingleTableWhereClause where = new SingleTableWhereClause(compareExpression, targetTable);
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

            boolean needCheckAns = where.getNeedCheckAns();

            Row row = ans.next();
            Map<Table, Row> tableRowMap = new HashMap<>();

            if (allColumnsOutput) {
                result.setColumns(targetTable.getColumns());
                while (row != null) {
                    boolean satisfied = true;
                    if (needCheckAns) {
                        tableRowMap.put(targetTable, row);
                        satisfied = compareExpression.getCompareAns(tableRowMap);
                    }
                    if (satisfied) {
                        result.addRow(row, addRowOrderReverse, distinct);
                    }
                    row = ans.next();
                }
            }
            else {
                result.setColumns(columnsForOutput);
                int columnsForOutputSize = columnsForOutput.size();
                while (row != null) {
                    boolean satisfied = true;
                    if (needCheckAns) {
                        tableRowMap.put(targetTable, row);
                        satisfied = compareExpression.getCompareAns(tableRowMap);
                    }
                    if (satisfied) {
                        Object[] rowData = new Object[columnsForOutputSize];
                        for (int i = 0; i < columnsForOutputSize; i++) {
                            rowData[i] = row.getDataByColumn(columnsForOutput.get(i)).getData();
                        }
                        Row newRow = new Row(result, rowData);
                        result.addRow(newRow, addRowOrderReverse, distinct);
                    }
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
            List<CompareExpression> baseOnExpressions = new ArrayList<>();
            for (CompareExpression onExpressionBase: onExpressions) {
                if (onExpressionBase.isAndOr()) {
                    baseOnExpressions.addAll(onExpressionBase.getBaseCompareExpressionsForOnClause());
                } else {
                    baseOnExpressions.add(onExpressionBase);
                }
            }
            // Check on expression
            for (CompareExpression onExpression: baseOnExpressions) {
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
            if (compareExpression != null) {
                // 处理where
                Table[] tables1 = new Table[tables.size()];
                tables.toArray(tables1);
                compareExpression.check(tables1);
                // check完毕之后：
                // 下面会有check
            }
            // TODO: 优化
            // 找到所有的indexed column并且是and关系
            // 排序
            // 将on和where的条件看作是一个
            // 将所有and的条件排序，用and的规律
            // 使得后面的table的列（并且是indexed的列）在符号前面，



            Result result = new Result();
            List<List<TYPE_COLUMNS>> columns = new ArrayList<>();
            List<List<Integer>> showColumns = new ArrayList<>();
            // showColumns里面，存储对应的index，如果不出现，就直接为负数
            for (int i = 0; i < tableNames.length; i++) {
                List<TYPE_COLUMNS> columnInfo = new ArrayList<>();
                List<Integer> showColumnInfo = new ArrayList<>();
                List<Column> tableColumns = tables.get(i).getColumns();
                for (int j = 0; j < tableColumns.size(); j++) {
                    if (columnInfos.get(tableColumns.get(j).getName()).size() > 1) {
                        columnInfo.add(TYPE_COLUMNS.TABLE_COLUMN_NAME);
                    }
                    else {
                        columnInfo.add(TYPE_COLUMNS.ONLY_COLUMN_NAME);
                    }
                    showColumnInfo.add(-1);
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
            Integer showColumnIndex = 0;
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
                            showColumns.get(tableIndex).set(i, showColumnIndex);
                            showColumnIndex++;
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
                        showColumns.get(tableIndex2).set(columnIndex, showColumnIndex);
                        showColumnIndex++;
                    default:
                        break;
                }
            }

            List<Column> ansColumns = new ArrayList<>();
            if (showColumnIndex >= 0) {
                for (int i = 0; i < showColumnIndex; i++) {
                    ansColumns.add(null);
                }
            }
            for (int i = 0; i < tableNames.length; i++) {
                List<TYPE_COLUMNS> columnInfo = columns.get(i);
                List<Integer> showColumnInfo = showColumns.get(i);
                List<Column> tableColumns = tables.get(i).getColumns();
                for (int j = 0; j < tableColumns.size(); j++) {
                    if (!allColumnsOutput && showColumnInfo.get(j) >= 0) {
                        Column newColumn = new Column(tableColumns.get(j).getColumnType(), tables.get(i).getTableName() + "." + tableColumns.get(j).getName());
                        ansColumns.set(showColumnInfo.get(j), newColumn);
                    }
                    else if (allColumnsOutput && columnInfo.get(j) == TYPE_COLUMNS.TABLE_COLUMN_NAME) {
                        Column newColumn = new Column(tableColumns.get(j).getColumnType(), tables.get(i).getTableName() + "." + tableColumns.get(j).getName());
                        ansColumns.add(newColumn);
                    }
                    else if (allColumnsOutput && columnInfo.get(j) == TYPE_COLUMNS.ONLY_COLUMN_NAME) {
                        Column newColumn = new Column(tableColumns.get(j).getColumnType(), tableColumns.get(j).getName());
                        ansColumns.add(newColumn);
                    }
                }
            }
            result.setColumns(ansColumns);

            Map<Table, Row> tableRowMap = new HashMap<>();
            while (true) {
                if (nowIteratorIndex == tableNames.length - 1) {
                    // 应该来进行继续的遍历
                    if (rows[nowIteratorIndex] == null) {
                        // 已经遍历完了
                        nowIteratorIndex --;
                        rows[nowIteratorIndex] = iterators[nowIteratorIndex].next();
                        tableRowMap.put(tables.get(nowIteratorIndex), rows[nowIteratorIndex]);
                    }
                    else {
                        boolean ok=true;
                        for (OnCondition onCondition: otherOnConditionList) {
                            if (!rows[onCondition.ia].getDataByColumn(onCondition.ca).equals(
                                    rows[onCondition.ib].getDataByColumn(onCondition.cb)
                            )) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok && compareExpression != null) {
                            ok = compareExpression.getCompareAns(tableRowMap);
                        }
                        if (ok) {
                            // set data
                            Object[] objs = new Object[ansColumns.size()];
                            int index = 0;
                            for (int i = 0; i < tableNames.length; i++) {
                                List<TYPE_COLUMNS> columnInfo = columns.get(i);
                                List<Integer> showColumnInfo = showColumns.get(i);
                                List<Column> tableColumns = tables.get(i).getColumns();
                                for (int j = 0; j < tableColumns.size(); j++) {
                                    if (!allColumnsOutput && showColumnInfo.get(j) >= 0) {
                                        objs[showColumnInfo.get(j)] = rows[i].getDataByColumn(tableColumns.get(j)).getData();
                                    }
                                    else if (allColumnsOutput && (columnInfo.get(j) == TYPE_COLUMNS.TABLE_COLUMN_NAME || columnInfo.get(j) == TYPE_COLUMNS.ONLY_COLUMN_NAME)) {
                                        objs[index] = rows[i].getDataByColumn(tableColumns.get(j)).getData();
                                        index ++;
                                    }
                                }
                            }
                            Row row = new Row(result, objs);
                            result.addRow(row, false, distinct);
                        }
                        rows[nowIteratorIndex] = iterators[nowIteratorIndex].next();
                        tableRowMap.put(tables.get(nowIteratorIndex), rows[nowIteratorIndex]);
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
                        tableRowMap.put(tables.get(nowIteratorIndex), rows[nowIteratorIndex]);
                    }
                    else {
                        if (nowIteratorIndex == 0) {
                            break;
                        }
                        nowIteratorIndex--;
                        rows[nowIteratorIndex] = iterators[nowIteratorIndex].next();
                        tableRowMap.put(tables.get(nowIteratorIndex), rows[nowIteratorIndex]);
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
