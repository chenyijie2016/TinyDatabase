package query.expression;

public class BaseData {
    public enum DATA_TYPE {
        BASE,
        COLUMN
    }

    public enum BASE_DATA_TYPE {
        NUMBER,
        STRING,
        NULL
    }

    private String data = "";
    private DATA_TYPE dataType;
    private BASE_DATA_TYPE baseDataType;

    private String tableName = "";
    private String columnName = "";

    public BaseData(BASE_DATA_TYPE baseDataType, String data) {
        this.dataType = DATA_TYPE.BASE;
        this.baseDataType = baseDataType;
        this.data = data;
    }

    public BaseData() {
        this.dataType = DATA_TYPE.BASE;
        this.baseDataType = BASE_DATA_TYPE.NULL;
    }

    public BaseData(String tableName, String columnName) {
        this.dataType = DATA_TYPE.COLUMN;
        this.baseDataType = BASE_DATA_TYPE.NULL;
        this.tableName = tableName;
        this.columnName = columnName;
    }
}
