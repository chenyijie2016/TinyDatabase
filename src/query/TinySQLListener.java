// Generated from C:/Users/cyj/Desktop/TinyDatabase/src/main/java/query\TinySQL.g4 by ANTLR 4.7.2
package query;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TinySQLParser}.
 */
public interface TinySQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#entry}.
	 * @param ctx the parse tree
	 */
	void enterEntry(TinySQLParser.EntryContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#entry}.
	 * @param ctx the parse tree
	 */
	void exitEntry(TinySQLParser.EntryContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#sql_stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterSql_stmt_list(TinySQLParser.Sql_stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#sql_stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitSql_stmt_list(TinySQLParser.Sql_stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#sql_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSql_stmt(TinySQLParser.Sql_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#sql_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSql_stmt(TinySQLParser.Sql_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#create_database_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCreate_database_stmt(TinySQLParser.Create_database_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#create_database_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCreate_database_stmt(TinySQLParser.Create_database_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#create_table_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCreate_table_stmt(TinySQLParser.Create_table_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#create_table_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCreate_table_stmt(TinySQLParser.Create_table_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#drop_database_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDrop_database_stmt(TinySQLParser.Drop_database_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#drop_database_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDrop_database_stmt(TinySQLParser.Drop_database_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#drop_table_stmt}.
	 * @param ctx the parse tree
	 */
	void enterDrop_table_stmt(TinySQLParser.Drop_table_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#drop_table_stmt}.
	 * @param ctx the parse tree
	 */
	void exitDrop_table_stmt(TinySQLParser.Drop_table_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#use_database_stmt}.
	 * @param ctx the parse tree
	 */
	void enterUse_database_stmt(TinySQLParser.Use_database_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#use_database_stmt}.
	 * @param ctx the parse tree
	 */
	void exitUse_database_stmt(TinySQLParser.Use_database_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#column_def}.
	 * @param ctx the parse tree
	 */
	void enterColumn_def(TinySQLParser.Column_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#column_def}.
	 * @param ctx the parse tree
	 */
	void exitColumn_def(TinySQLParser.Column_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void enterTable_constraint(TinySQLParser.Table_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#table_constraint}.
	 * @param ctx the parse tree
	 */
	void exitTable_constraint(TinySQLParser.Table_constraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#type_name}.
	 * @param ctx the parse tree
	 */
	void enterType_name(TinySQLParser.Type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#type_name}.
	 * @param ctx the parse tree
	 */
	void exitType_name(TinySQLParser.Type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#signed_number}.
	 * @param ctx the parse tree
	 */
	void enterSigned_number(TinySQLParser.Signed_numberContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#signed_number}.
	 * @param ctx the parse tree
	 */
	void exitSigned_number(TinySQLParser.Signed_numberContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#column_constraint}.
	 * @param ctx the parse tree
	 */
	void enterColumn_constraint(TinySQLParser.Column_constraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#column_constraint}.
	 * @param ctx the parse tree
	 */
	void exitColumn_constraint(TinySQLParser.Column_constraintContext ctx);
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
	 * Enter a parse tree produced by {@link TinySQLParser#database_name}.
	 * @param ctx the parse tree
	 */
	void enterDatabase_name(TinySQLParser.Database_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#database_name}.
	 * @param ctx the parse tree
	 */
	void exitDatabase_name(TinySQLParser.Database_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_name(TinySQLParser.Table_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#table_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_name(TinySQLParser.Table_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#table_or_index_name}.
	 * @param ctx the parse tree
	 */
	void enterTable_or_index_name(TinySQLParser.Table_or_index_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#table_or_index_name}.
	 * @param ctx the parse tree
	 */
	void exitTable_or_index_name(TinySQLParser.Table_or_index_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void enterColumn_name(TinySQLParser.Column_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#column_name}.
	 * @param ctx the parse tree
	 */
	void exitColumn_name(TinySQLParser.Column_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link TinySQLParser#any_name}.
	 * @param ctx the parse tree
	 */
	void enterAny_name(TinySQLParser.Any_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link TinySQLParser#any_name}.
	 * @param ctx the parse tree
	 */
	void exitAny_name(TinySQLParser.Any_nameContext ctx);
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