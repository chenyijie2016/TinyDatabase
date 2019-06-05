package query.statement;

import data.Type;
import data.typedData;
import data.stringData;
import data.intData;
import data.longData;
import data.doubleData;
import data.floatData;
import database.DataBase;
import exception.SQLExecuteException;
import query.Result;
import query.expression.BaseData;
import query.expression.CompareExpression;
import query.expression.Expression;
import query.expression.ValueExpression;
import query.resultColumn.ResultColumn;
import schema.Schema;
import schema.SchemaManager;
import table.Column;
import table.Constraint;
import table.Row;
import table.Table;

import java.io.IOException;
import java.util.*;

public class SelectTableStatement extends Statement {
    public enum JOIN_TYPE {
        NATURAL_LEFT_OUTER,
        NATURAL_INNER,
        LEFT_OUTER,
        INNER,
        CROSS  // just ,
    }

    public enum SELECT_TYPE {
        DISTINCT,
        ALL
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

    public BaseData checkValueExpressionIsColumn(ValueExpression leftEnd) throws SQLExecuteException {
        if (leftEnd.getSubType() != ValueExpression.SUB_TYPE.ATOM || leftEnd.getData().size() != 1) {
            throw new SQLExecuteException("[select table]: Where clause wrong: need column name on the left");
        }
        BaseData leftEndData = leftEnd.getData().get(0);
        if (leftEndData.getDataType() != BaseData.DATA_TYPE.COLUMN) {
            throw new SQLExecuteException("[select table]: Where clause wrong: need column name on the left");
        }
        return leftEndData;
    }

    @Override
    public Result execute(SchemaManager schemaManager) throws SQLExecuteException {
        DataBase db = schemaManager.getCurrentDataBase();
        if (tableNames.length == 1) {
            String tableName = tableNames[0];
            Table targetTable = db.getTableByName(tableName);
            if (targetTable == null) {
                throw new SQLExecuteException("[select table]: Table " + tableName + " not exist");
            }
            Table.RowIterator ans;

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

            if (compareExpression != null) {
                List<ValueExpression> valueExpressionList = compareExpression.getValueExpressionList();
                if (valueExpressionList.size() != 2) {
                    throw new SQLExecuteException("[select table]: Internal error: where clause wrong");
                }

                // Check right end
                ValueExpression rightEnd = valueExpressionList.get(1);
                BaseData rightEndData;
                try {
                    rightEndData = rightEnd.simplifyValueDataThatIsNotColumn();
                } catch (IllegalArgumentException e) {
                    throw new SQLExecuteException("[select table]: Right end error: " + e.getMessage());
                }

                // Check left end to get column
                ValueExpression leftEnd = valueExpressionList.get(0);
                BaseData leftEndData = checkValueExpressionIsColumn(leftEnd);
                String tableNameGot = leftEndData.getTableName();
                if (tableNameGot != null && !tableNameGot.equals(tableName)) {
                    throw new SQLExecuteException("[select table]: Column's table not exist in from clause");
                }
                String columnName = leftEndData.getColumnName();
                if (columnName == null) {
                    throw new SQLExecuteException("[select table]: Internal error: Column's name not exist in from clause");
                }
                Column targetColumn = targetTable.getColumnByName(columnName);
                if (targetColumn == null) {
                    throw new SQLExecuteException("[select table]: Column " + columnName + " not exist");
                }


                // GOT COLUMN and VALUE
                typedData queryData;
                switch (targetColumn.getColumnType().type()) {
                    case STRING:
                        if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.STRING) {
                            // TODO: add null search
                            throw new SQLExecuteException("[select data]: Need string here");
                        }
                        queryData = new stringData(rightEndData.getData());
                        break;
                    case INT:
                        if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                            // TODO: add null search
                            throw new SQLExecuteException("[select data]: Need string here");
                        }
                        queryData = new intData(rightEndData.getNumberData().intValue());
                        break;
                    case LONG:
                        if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                            // TODO: add null search
                            throw new SQLExecuteException("[select data]: Need string here");
                        }
                        queryData = new longData(rightEndData.getNumberData().longValue());
                        break;
                    case DOUBLE:
                        if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                            // TODO: add null search
                            throw new SQLExecuteException("[select data]: Need string here");
                        }
                        queryData = new doubleData(rightEndData.getNumberData());
                        break;
                    case FLOAT:
                        if (rightEndData.getBaseDataType() != BaseData.BASE_DATA_TYPE.NUMBER) {
                            // TODO: add null search
                            throw new SQLExecuteException("[select data]: Need string here");
                        }
                        queryData = new floatData(rightEndData.getNumberData().floatValue());
                        break;
                    default:
                        throw new SQLExecuteException("[select data]: Column type wrong");
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
                            break;
                        case LTE:
                            ans = targetTable.scanLessEqual(targetColumn, queryData);
                            break;
                        case GT:
                            ans = targetTable.scanGreaterThan(targetColumn, queryData);
                            break;
                        default: //case GTE:
                            ans = targetTable.scanGreaterEqual(targetColumn, queryData);
                            break;
                    }
                } catch (IOException e) {
                    throw new SQLExecuteException("[select table]: IOException: " + e.getMessage());
                }
            }
            else {
                try {
                    ans = targetTable.scanAll();
                } catch (IOException e) {
                    throw new SQLExecuteException("[select table]: IOException: " + e.getMessage());
                }
            }

            Result result = new Result();

            Row row = ans.next();
            if (allColumnsOutput) {
                result.setColumns(targetTable.getColumns());
                while (row != null) {
                    result.addRow(row);
                    row = ans.next();
                }
            }
            else {
                result.setColumns(columnsForOutput);
                int columnsForOutputSize = columnsForOutput.size();
                while (row != null) {
                    Object[] rowData = new Object[columnsForOutputSize];
                    for (int i = 0; i < columnsForOutputSize; i++) {
                        rowData[i] = row.getDataByColumn(columnsForOutput.get(i));
                    }
                    Row newRow = new Row(result, rowData);
                    result.addRow(newRow);
                    row = ans.next();
                }
            }
            return result;
        }
        else if (tableNames.length > 1) {
            List<Table> tables = new ArrayList<>();
            Map<String, List<Table>> columnInfos = new HashMap<>();
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
                for (Column c : temp.getColumns()) {
                    String columnName = c.getName();
                    List<Table> columnTableNames = columnInfos.get(columnName);
                    if (columnTableNames == null) {
                        columnTableNames = new ArrayList<>();
                    }
                    columnTableNames.add(temp);
                }
            }
            // TODO: support more tables
            throw new SQLExecuteException("[select table]: Now only support single table action check");
        }
        else {
            throw new SQLExecuteException("[select table]: No table name provided");
        }

//        return null;
    }
}
