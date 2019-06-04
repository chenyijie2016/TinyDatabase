package query.statement;

import query.Result;
import query.expression.CompareExpression;
import query.expression.Expression;
import query.resultColumn.ResultColumn;
import schema.Schema;
import schema.SchemaManager;
import table.Column;
import table.Constraint;

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
    public Result execute(SchemaManager schemaManager) {
        return null;
    }
}
