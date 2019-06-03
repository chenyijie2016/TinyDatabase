package table;

import java.util.List;

public class TableBase {
    protected String tableName; // 表名
    protected List<Column> columns; // 属性列表

    public List<Column> getColumns() {
        return columns;
    }
}
