package query;

import data.Type;
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
                for (int i = 0; i < column.getColumnType().size(); i++) {
                    builder.append(" ");
                }
            }
        }
        builder.append("|\n");
        for (Row row : rows) {
            builder.append(row.toString());
            builder.append("|\n");
        }
        return builder.toString();
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public static Result setInfo(String message) {
        Result res = new Result().setColumns(new Column[]{new Column(Type.stringType((long) message.length()), "message")});
        res.addRow(new Row(res, new Object[]{message}));
        return res;
    }
}
