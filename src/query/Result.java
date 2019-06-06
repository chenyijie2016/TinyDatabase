package query;

import data.Type;
import data.stringData;
import data.typedData;
import table.Column;
import table.Row;
import table.TableBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Result extends TableBase {
    private List<Row> rows;


    public Result() {
        this.tableName = "result";
        rows = new ArrayList<>();
    }

    public Result(String name) {
        this.tableName = name;
        rows = new ArrayList<>();
    }

    public Result setColumns(Column[] columns) {
        this.columns = Arrays.asList(columns);
        return this;
    }

    public Result setColumns(List<Column> columns) {
        this.columns = columns;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Column column : columns) {
            builder.append("| ");
            builder.append(column.getName());
            if (column.getColumnType().type() != Type.TYPE.STRING) {
                builder.append("   ");
            } else {
                builder.append(" ".repeat(Math.max(0, column.getColumnType().size())));
            }
        }
        builder.append("|\n");
        for (Row row : rows) {
            builder.append(row.toString());
            builder.append("\n");
        }
        return builder.toString();
    }

    public void addRow(Row row, boolean reverse, boolean distinct) {
        if (reverse) {
            if (distinct) {
                addRowDistinctReverse(row);
            }
            else {
                addRowReverse(row);
            }
        }
        else {
            if (distinct) {
                addRowDistinct(row);
            }
            else {
                addRow(row);
            }
        }
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public void addRowReverse(Row row) {
        rows.add(0, row);
    }

    public void addRowDistinct(Row row) {
        boolean found_same = false;
        for (Row other_row : rows) {
            boolean all_same = true;
            for (Column c : columns) {
                if (!other_row.getDataByColumn(c).equals(row.getDataByColumn(c))) {
                    all_same = false;
                }
            }
            if (all_same) {
                found_same = true;
                return;
            }
        }
        rows.add(row);
    }

    public void addRowDistinctReverse(Row row) {
        boolean found_same = false;
        for (Row other_row : rows) {
            boolean all_same = true;
            for (Column c : columns) {
                if (!other_row.getDataByColumn(c).equals(row.getDataByColumn(c))) {
                    all_same = false;
                }
            }
            if (all_same) {
                found_same = true;
                return;
            }
        }
        rows.add(0, row);
    }

    public static Result setInfo(String message) {
        Result res = new Result().setColumns(new Column[]{new Column(Type.stringType(message.length() + 1), "message")});
        res.addRow(new Row(res, new Object[]{message}));
        return res;
    }
}
