package query.resultColumn;

import query.expression.Expression;

public class ResultColumn {
    public enum RESULT_COLUMN_TYPE {
        ALL,
        TABLE_NAME,
        EXPRESSION
    }

    RESULT_COLUMN_TYPE resultColumnType;
    String data = "";
    Expression expression = null;

    public ResultColumn() {
        this.resultColumnType = RESULT_COLUMN_TYPE.ALL;
    }

    public ResultColumn(String name) {
        this.resultColumnType = RESULT_COLUMN_TYPE.TABLE_NAME;
        this.data = name;
    }

    public ResultColumn(Expression expression) {
        this.resultColumnType = RESULT_COLUMN_TYPE.EXPRESSION;
        this.expression = expression;
    }
}
