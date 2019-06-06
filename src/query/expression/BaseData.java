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

    private String tableName = null;
    private String columnName = null;
    private Double numberData = null;

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
        this.tableName = tableName == null ? null : tableName.toUpperCase();
        this.columnName = columnName.toUpperCase();
    }

    public BaseData(Double numberData) {
        this.numberData = numberData;
        this.dataType = DATA_TYPE.BASE;
        this.baseDataType = BASE_DATA_TYPE.NUMBER;
        this.data = String.valueOf(numberData);
    }

    public BaseData(Long numberData) {
        this.numberData = new Double(numberData);
        this.dataType = DATA_TYPE.BASE;
        this.baseDataType = BASE_DATA_TYPE.NUMBER;
        this.data = String.valueOf(numberData);
    }

    public DATA_TYPE getDataType() {
        return dataType;
    }

    public BASE_DATA_TYPE getBaseDataType() {
        return baseDataType;
    }

    public String getTableName() {
        return tableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public Double getNumberData() {
        if (numberData != null) {
            return numberData;
        }

        try {
            numberData = Double.valueOf(data);
        }
        catch (Exception e) {
            numberData = null;
        }
        return numberData;
    }

    public boolean isInt() {
        return baseDataType == BASE_DATA_TYPE.NUMBER && !this.data.contains(".");
    }

    public String getData() {
        return data;
    }

    public boolean isColumnInfoWithTable() {
        return dataType == DATA_TYPE.COLUMN && tableName != null && columnName != null;
    }
}
