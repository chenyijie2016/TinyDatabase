package query.statement;

import query.Result;
import query.expression.CompareExpression;
import query.expression.ValueExpression;

public class DeleteTableStatement extends Statement {
    private String tableName;

    private CompareExpression whereCondition;

    public DeleteTableStatement(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public Result execute() {
        System.out.println("Updating table name: " + tableName);
        return null;
    }

    public void setWhereCondition(CompareExpression whereCondition) {
        this.whereCondition = whereCondition;
    }
}
