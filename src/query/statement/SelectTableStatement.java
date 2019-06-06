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
