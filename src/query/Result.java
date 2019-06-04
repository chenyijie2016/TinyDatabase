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


    Result() {
        this.tableName = "result";
        rows = new ArrayList<>();
    }

    Result(String name) {
        this.tableName = name;
        rows = new ArrayList<>();
    }

    public void setColumns(Column[] columns) {
        this.columns = Arrays.asList(columns);
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
}
