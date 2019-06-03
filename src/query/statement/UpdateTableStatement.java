package query.statement;

import query.Result;
import query.expression.*;
import table.Column;

public class UpdateTableStatement extends Statement {
    private String tableName;
    private String[] columns;

    private ValueExpression[] data;
    private CompareExpression whereCondition;

    public UpdateTableStatement(String tableName, String[] columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    @Override
    public Result execute() {
        System.out.println("Updating table name: " + tableName);
        for (String c: columns) {
            System.out.println("        columns: " + c);
        }
        return null;
    }

    public void setData(ValueExpression[] data) {
        this.data = data;
    }

    public void setWhereCondition(CompareExpression whereCondition) {
        this.whereCondition = whereCondition;
    }
}
