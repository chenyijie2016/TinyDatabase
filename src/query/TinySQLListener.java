// Generated from query/TinySQL.g4 by ANTLR 4.7.2
package query;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinySQLParser}.
 */
public interface TinySQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#parse}.
	 * @param ctx the parse tree
	 */
	void enterParse(TinySQLParser.ParseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#parse}.
	 * @param ctx the parse tree
	 */
	void exitParse(TinySQLParser.ParseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#error}.
	 * @param ctx the parse tree
	 */
	void enterError(TinySQLParser.ErrorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#error}.
	 * @param ctx the parse tree
	 */
	void exitError(TinySQLParser.ErrorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#sqlStatementList}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatementList(TinySQLParser.SqlStatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#sqlStatementList}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatementList(TinySQLParser.SqlStatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void enterSqlStatement(TinySQLParser.SqlStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#sqlStatement}.
	 * @param ctx the parse tree
	 */
	void exitSqlStatement(TinySQLParser.SqlStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#showDatabasesStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowDatabasesStmt(TinySQLParser.ShowDatabasesStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#showDatabasesStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowDatabasesStmt(TinySQLParser.ShowDatabasesStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#showDatabaseTablesStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowDatabaseTablesStmt(TinySQLParser.ShowDatabaseTablesStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#showDatabaseTablesStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowDatabaseTablesStmt(TinySQLParser.ShowDatabaseTablesStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#showTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterShowTableStmt(TinySQLParser.ShowTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#showTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitShowTableStmt(TinySQLParser.ShowTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#createDatabaseStmt}.
	 * @param ctx the parse tree
	 */
	void enterCreateDatabaseStmt(TinySQLParser.CreateDatabaseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#createDatabaseStmt}.
	 * @param ctx the parse tree
	 */
	void exitCreateDatabaseStmt(TinySQLParser.CreateDatabaseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#createTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterCreateTableStmt(TinySQLParser.CreateTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#createTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitCreateTableStmt(TinySQLParser.CreateTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void enterColumnDefinition(TinySQLParser.ColumnDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#columnDefinition}.
	 * @param ctx the parse tree
	 */
	void exitColumnDefinition(TinySQLParser.ColumnDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#tableConstraint}.
	 * @param ctx the parse tree
	 */
	void enterTableConstraint(TinySQLParser.TableConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#tableConstraint}.
	 * @param ctx the parse tree
	 */
	void exitTableConstraint(TinySQLParser.TableConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#indexedColumn}.
	 * @param ctx the parse tree
	 */
	void enterIndexedColumn(TinySQLParser.IndexedColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#indexedColumn}.
	 * @param ctx the parse tree
	 */
	void exitIndexedColumn(TinySQLParser.IndexedColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#insertTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterInsertTableStmt(TinySQLParser.InsertTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#insertTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitInsertTableStmt(TinySQLParser.InsertTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valueExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterValueExpression(TinySQLParser.ValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valueExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitValueExpression(TinySQLParser.ValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpression(TinySQLParser.AddSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpression(TinySQLParser.AddSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisExpression(TinySQLParser.ParenthesisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisExpression(TinySQLParser.ParenthesisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(TinySQLParser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(TinySQLParser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tableColumnExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTableColumnExpression(TinySQLParser.TableColumnExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tableColumnExpression}
	 * labeled alternative in {@link TinySQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTableColumnExpression(TinySQLParser.TableColumnExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessGreaterExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterLessGreaterExpression(TinySQLParser.LessGreaterExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessGreaterExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitLessGreaterExpression(TinySQLParser.LessGreaterExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(TinySQLParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(TinySQLParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(TinySQLParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(TinySQLParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isOrNotExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterIsOrNotExpression(TinySQLParser.IsOrNotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isOrNotExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitIsOrNotExpression(TinySQLParser.IsOrNotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisConditionExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisConditionExpression(TinySQLParser.ParenthesisConditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisConditionExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisConditionExpression(TinySQLParser.ParenthesisConditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualExpression(TinySQLParser.EqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualExpression(TinySQLParser.EqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isNullExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterIsNullExpression(TinySQLParser.IsNullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isNullExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitIsNullExpression(TinySQLParser.IsNullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isNotNullExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void enterIsNotNullExpression(TinySQLParser.IsNotNullExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isNotNullExpression}
	 * labeled alternative in {@link TinySQLParser#conditionExpression}.
	 * @param ctx the parse tree
	 */
	void exitIsNotNullExpression(TinySQLParser.IsNotNullExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterUnaryOperator(TinySQLParser.UnaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#unaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitUnaryOperator(TinySQLParser.UnaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void enterLiteralValue(TinySQLParser.LiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#literalValue}.
	 * @param ctx the parse tree
	 */
	void exitLiteralValue(TinySQLParser.LiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#selectTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterSelectTableStmt(TinySQLParser.SelectTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#selectTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitSelectTableStmt(TinySQLParser.SelectTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#resultColumn}.
	 * @param ctx the parse tree
	 */
	void enterResultColumn(TinySQLParser.ResultColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#resultColumn}.
	 * @param ctx the parse tree
	 */
	void exitResultColumn(TinySQLParser.ResultColumnContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void enterJoinClause(TinySQLParser.JoinClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#joinClause}.
	 * @param ctx the parse tree
	 */
	void exitJoinClause(TinySQLParser.JoinClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#joinConstraint}.
	 * @param ctx the parse tree
	 */
	void enterJoinConstraint(TinySQLParser.JoinConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#joinConstraint}.
	 * @param ctx the parse tree
	 */
	void exitJoinConstraint(TinySQLParser.JoinConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#joinOperator}.
	 * @param ctx the parse tree
	 */
	void enterJoinOperator(TinySQLParser.JoinOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#joinOperator}.
	 * @param ctx the parse tree
	 */
	void exitJoinOperator(TinySQLParser.JoinOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#updateTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterUpdateTableStmt(TinySQLParser.UpdateTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#updateTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitUpdateTableStmt(TinySQLParser.UpdateTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#deleteTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeleteTableStmt(TinySQLParser.DeleteTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#deleteTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeleteTableStmt(TinySQLParser.DeleteTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#dropDatabaseStmt}.
	 * @param ctx the parse tree
	 */
	void enterDropDatabaseStmt(TinySQLParser.DropDatabaseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#dropDatabaseStmt}.
	 * @param ctx the parse tree
	 */
	void exitDropDatabaseStmt(TinySQLParser.DropDatabaseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#dropTableStmt}.
	 * @param ctx the parse tree
	 */
	void enterDropTableStmt(TinySQLParser.DropTableStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#dropTableStmt}.
	 * @param ctx the parse tree
	 */
	void exitDropTableStmt(TinySQLParser.DropTableStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#useDatabaseStmt}.
	 * @param ctx the parse tree
	 */
	void enterUseDatabaseStmt(TinySQLParser.UseDatabaseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#useDatabaseStmt}.
	 * @param ctx the parse tree
	 */
	void exitUseDatabaseStmt(TinySQLParser.UseDatabaseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(TinySQLParser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(TinySQLParser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#signedNumber}.
	 * @param ctx the parse tree
	 */
	void enterSignedNumber(TinySQLParser.SignedNumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#signedNumber}.
	 * @param ctx the parse tree
	 */
	void exitSignedNumber(TinySQLParser.SignedNumberContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#columnConstraint}.
	 * @param ctx the parse tree
	 */
	void enterColumnConstraint(TinySQLParser.ColumnConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#columnConstraint}.
	 * @param ctx the parse tree
	 */
	void exitColumnConstraint(TinySQLParser.ColumnConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(TinySQLParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(TinySQLParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#databaseName}.
	 * @param ctx the parse tree
	 */
	void enterDatabaseName(TinySQLParser.DatabaseNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#databaseName}.
	 * @param ctx the parse tree
	 */
	void exitDatabaseName(TinySQLParser.DatabaseNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(TinySQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(TinySQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void enterColumnName(TinySQLParser.ColumnNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#columnName}.
	 * @param ctx the parse tree
	 */
	void exitColumnName(TinySQLParser.ColumnNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#anyName}.
	 * @param ctx the parse tree
	 */
	void enterAnyName(TinySQLParser.AnyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#anyName}.
	 * @param ctx the parse tree
	 */
	void exitAnyName(TinySQLParser.AnyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(TinySQLParser.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(TinySQLParser.KeywordContext ctx);
}