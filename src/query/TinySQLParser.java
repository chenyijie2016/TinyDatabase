// Generated from query/TinySQL.g4 by ANTLR 4.7.2
package query;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinySQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		STRING_LITERAL=18, SINGLE_LINE_COMMENT=19, MULTILINE_COMMENT=20, SPACES=21, 
		NUMERIC_LITERAL=22, K_CREATE=23, K_DATABASE=24, K_TABLE=25, K_DROP=26, 
		K_SELECT=27, K_UPDATE=28, K_DELETE=29, K_INSERT=30, K_PRIMARY=31, K_KEY=32, 
		K_NOT=33, K_NULL=34, K_WHERE=35, K_INTO=36, K_FROM=37, K_USE=38, K_ASC=39, 
		K_DESC=40, K_VALUES=41, K_DATABASES=42, K_SHOW=43, K_ON=44, K_JOIN=45, 
		K_NATURAL=46, K_DISTINCT=47, K_ALL=48, K_OUTER=49, K_LEFT=50, K_INNER=51, 
		K_SET=52, K_AND=53, K_OR=54, IDENTIFIER=55, UNEXPECTED_CHAR=56;
	public static final int
		RULE_parse = 0, RULE_error = 1, RULE_sqlStatementList = 2, RULE_sqlStatement = 3, 
		RULE_showDatabasesStmt = 4, RULE_showDatabaseTablesStmt = 5, RULE_createDatabaseStmt = 6, 
		RULE_createTableStmt = 7, RULE_columnDefinition = 8, RULE_tableConstraint = 9, 
		RULE_indexedColumn = 10, RULE_insertTableStmt = 11, RULE_expression = 12, 
		RULE_conditionExpression = 13, RULE_unaryOperator = 14, RULE_literalValue = 15, 
		RULE_selectTableStmt = 16, RULE_resultColumn = 17, RULE_joinClause = 18, 
		RULE_joinConstraint = 19, RULE_joinOperator = 20, RULE_updateTableStmt = 21, 
		RULE_deleteTableStmt = 22, RULE_dropDatabaseStmt = 23, RULE_dropTableStmt = 24, 
		RULE_useDatabaseStmt = 25, RULE_typeName = 26, RULE_signedNumber = 27, 
		RULE_columnConstraint = 28, RULE_name = 29, RULE_databaseName = 30, RULE_tableName = 31, 
		RULE_columnName = 32, RULE_anyName = 33, RULE_keyword = 34;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "error", "sqlStatementList", "sqlStatement", "showDatabasesStmt", 
			"showDatabaseTablesStmt", "createDatabaseStmt", "createTableStmt", "columnDefinition", 
			"tableConstraint", "indexedColumn", "insertTableStmt", "expression", 
			"conditionExpression", "unaryOperator", "literalValue", "selectTableStmt", 
			"resultColumn", "joinClause", "joinConstraint", "joinOperator", "updateTableStmt", 
			"deleteTableStmt", "dropDatabaseStmt", "dropTableStmt", "useDatabaseStmt", 
			"typeName", "signedNumber", "columnConstraint", "name", "databaseName", 
			"tableName", "columnName", "anyName", "keyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'.'", "'('", "','", "')'", "'+'", "'-'", "'<'", "'<='", 
			"'>'", "'>='", "'='", "'=='", "'!='", "'<>'", "'~'", "'*'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, "STRING_LITERAL", "SINGLE_LINE_COMMENT", 
			"MULTILINE_COMMENT", "SPACES", "NUMERIC_LITERAL", "K_CREATE", "K_DATABASE", 
			"K_TABLE", "K_DROP", "K_SELECT", "K_UPDATE", "K_DELETE", "K_INSERT", 
			"K_PRIMARY", "K_KEY", "K_NOT", "K_NULL", "K_WHERE", "K_INTO", "K_FROM", 
			"K_USE", "K_ASC", "K_DESC", "K_VALUES", "K_DATABASES", "K_SHOW", "K_ON", 
			"K_JOIN", "K_NATURAL", "K_DISTINCT", "K_ALL", "K_OUTER", "K_LEFT", "K_INNER", 
			"K_SET", "K_AND", "K_OR", "IDENTIFIER", "UNEXPECTED_CHAR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TinySQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TinySQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ParseContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TinySQLParser.EOF, 0); }
		public List<SqlStatementListContext> sqlStatementList() {
			return getRuleContexts(SqlStatementListContext.class);
		}
		public SqlStatementListContext sqlStatementList(int i) {
			return getRuleContext(SqlStatementListContext.class,i);
		}
		public List<ErrorContext> error() {
			return getRuleContexts(ErrorContext.class);
		}
		public ErrorContext error(int i) {
			return getRuleContext(ErrorContext.class,i);
		}
		public ParseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parse; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterParse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitParse(this);
		}
	}

	public final ParseContext parse() throws RecognitionException {
		ParseContext _localctx = new ParseContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_parse);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << K_CREATE) | (1L << K_DROP) | (1L << K_SELECT) | (1L << K_UPDATE) | (1L << K_DELETE) | (1L << K_INSERT) | (1L << K_USE) | (1L << K_SHOW) | (1L << UNEXPECTED_CHAR))) != 0)) {
				{
				setState(72);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case K_CREATE:
				case K_DROP:
				case K_SELECT:
				case K_UPDATE:
				case K_DELETE:
				case K_INSERT:
				case K_USE:
				case K_SHOW:
					{
					setState(70);
					sqlStatementList();
					}
					break;
				case UNEXPECTED_CHAR:
					{
					setState(71);
					error();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(77);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ErrorContext extends ParserRuleContext {
		public Token UNEXPECTED_CHAR;
		public TerminalNode UNEXPECTED_CHAR() { return getToken(TinySQLParser.UNEXPECTED_CHAR, 0); }
		public ErrorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_error; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterError(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitError(this);
		}
	}

	public final ErrorContext error() throws RecognitionException {
		ErrorContext _localctx = new ErrorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_error);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			((ErrorContext)_localctx).UNEXPECTED_CHAR = match(UNEXPECTED_CHAR);

			      throw new RuntimeException("UNEXPECTED_CHAR=" + (((ErrorContext)_localctx).UNEXPECTED_CHAR!=null?((ErrorContext)_localctx).UNEXPECTED_CHAR.getText():null));
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlStatementListContext extends ParserRuleContext {
		public List<SqlStatementContext> sqlStatement() {
			return getRuleContexts(SqlStatementContext.class);
		}
		public SqlStatementContext sqlStatement(int i) {
			return getRuleContext(SqlStatementContext.class,i);
		}
		public SqlStatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterSqlStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitSqlStatementList(this);
		}
	}

	public final SqlStatementListContext sqlStatementList() throws RecognitionException {
		SqlStatementListContext _localctx = new SqlStatementListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sqlStatementList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(82);
				match(T__0);
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			sqlStatement();
			setState(97);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(90); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(89);
						match(T__0);
						}
						}
						setState(92); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__0 );
					setState(94);
					sqlStatement();
					}
					} 
				}
				setState(99);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(100);
					match(T__0);
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlStatementContext extends ParserRuleContext {
		public CreateDatabaseStmtContext createDatabaseStmt() {
			return getRuleContext(CreateDatabaseStmtContext.class,0);
		}
		public ShowDatabasesStmtContext showDatabasesStmt() {
			return getRuleContext(ShowDatabasesStmtContext.class,0);
		}
		public ShowDatabaseTablesStmtContext showDatabaseTablesStmt() {
			return getRuleContext(ShowDatabaseTablesStmtContext.class,0);
		}
		public CreateTableStmtContext createTableStmt() {
			return getRuleContext(CreateTableStmtContext.class,0);
		}
		public InsertTableStmtContext insertTableStmt() {
			return getRuleContext(InsertTableStmtContext.class,0);
		}
		public SelectTableStmtContext selectTableStmt() {
			return getRuleContext(SelectTableStmtContext.class,0);
		}
		public UpdateTableStmtContext updateTableStmt() {
			return getRuleContext(UpdateTableStmtContext.class,0);
		}
		public DeleteTableStmtContext deleteTableStmt() {
			return getRuleContext(DeleteTableStmtContext.class,0);
		}
		public DropDatabaseStmtContext dropDatabaseStmt() {
			return getRuleContext(DropDatabaseStmtContext.class,0);
		}
		public DropTableStmtContext dropTableStmt() {
			return getRuleContext(DropTableStmtContext.class,0);
		}
		public UseDatabaseStmtContext useDatabaseStmt() {
			return getRuleContext(UseDatabaseStmtContext.class,0);
		}
		public SqlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterSqlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitSqlStatement(this);
		}
	}

	public final SqlStatementContext sqlStatement() throws RecognitionException {
		SqlStatementContext _localctx = new SqlStatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sqlStatement);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				createDatabaseStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				showDatabasesStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(108);
				showDatabaseTablesStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(109);
				createTableStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(110);
				insertTableStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(111);
				selectTableStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(112);
				updateTableStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(113);
				deleteTableStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(114);
				dropDatabaseStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(115);
				dropTableStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(116);
				useDatabaseStmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowDatabasesStmtContext extends ParserRuleContext {
		public TerminalNode K_SHOW() { return getToken(TinySQLParser.K_SHOW, 0); }
		public TerminalNode K_DATABASES() { return getToken(TinySQLParser.K_DATABASES, 0); }
		public ShowDatabasesStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showDatabasesStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterShowDatabasesStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitShowDatabasesStmt(this);
		}
	}

	public final ShowDatabasesStmtContext showDatabasesStmt() throws RecognitionException {
		ShowDatabasesStmtContext _localctx = new ShowDatabasesStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_showDatabasesStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(K_SHOW);
			setState(120);
			match(K_DATABASES);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShowDatabaseTablesStmtContext extends ParserRuleContext {
		public TerminalNode K_SHOW() { return getToken(TinySQLParser.K_SHOW, 0); }
		public TerminalNode K_DATABASE() { return getToken(TinySQLParser.K_DATABASE, 0); }
		public DatabaseNameContext databaseName() {
			return getRuleContext(DatabaseNameContext.class,0);
		}
		public ShowDatabaseTablesStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showDatabaseTablesStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterShowDatabaseTablesStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitShowDatabaseTablesStmt(this);
		}
	}

	public final ShowDatabaseTablesStmtContext showDatabaseTablesStmt() throws RecognitionException {
		ShowDatabaseTablesStmtContext _localctx = new ShowDatabaseTablesStmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_showDatabaseTablesStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(K_SHOW);
			setState(123);
			match(K_DATABASE);
			setState(124);
			databaseName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateDatabaseStmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(TinySQLParser.K_CREATE, 0); }
		public TerminalNode K_DATABASE() { return getToken(TinySQLParser.K_DATABASE, 0); }
		public DatabaseNameContext databaseName() {
			return getRuleContext(DatabaseNameContext.class,0);
		}
		public CreateDatabaseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createDatabaseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterCreateDatabaseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitCreateDatabaseStmt(this);
		}
	}

	public final CreateDatabaseStmtContext createDatabaseStmt() throws RecognitionException {
		CreateDatabaseStmtContext _localctx = new CreateDatabaseStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_createDatabaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(K_CREATE);
			setState(127);
			match(K_DATABASE);
			setState(128);
			databaseName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreateTableStmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(TinySQLParser.K_CREATE, 0); }
		public TerminalNode K_TABLE() { return getToken(TinySQLParser.K_TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public List<ColumnDefinitionContext> columnDefinition() {
			return getRuleContexts(ColumnDefinitionContext.class);
		}
		public ColumnDefinitionContext columnDefinition(int i) {
			return getRuleContext(ColumnDefinitionContext.class,i);
		}
		public DatabaseNameContext databaseName() {
			return getRuleContext(DatabaseNameContext.class,0);
		}
		public TableConstraintContext tableConstraint() {
			return getRuleContext(TableConstraintContext.class,0);
		}
		public CreateTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterCreateTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitCreateTableStmt(this);
		}
	}

	public final CreateTableStmtContext createTableStmt() throws RecognitionException {
		CreateTableStmtContext _localctx = new CreateTableStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_createTableStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(K_CREATE);
			setState(131);
			match(K_TABLE);
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(132);
				databaseName();
				setState(133);
				match(T__1);
				}
				break;
			}
			setState(137);
			tableName();
			{
			setState(138);
			match(T__2);
			setState(139);
			columnDefinition();
			setState(144);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(140);
					match(T__3);
					setState(141);
					columnDefinition();
					}
					} 
				}
				setState(146);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(147);
				match(T__3);
				setState(148);
				tableConstraint();
				}
			}

			setState(151);
			match(T__4);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnDefinitionContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<ColumnConstraintContext> columnConstraint() {
			return getRuleContexts(ColumnConstraintContext.class);
		}
		public ColumnConstraintContext columnConstraint(int i) {
			return getRuleContext(ColumnConstraintContext.class,i);
		}
		public ColumnDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterColumnDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitColumnDefinition(this);
		}
	}

	public final ColumnDefinitionContext columnDefinition() throws RecognitionException {
		ColumnDefinitionContext _localctx = new ColumnDefinitionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			columnName();
			setState(154);
			typeName();
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_PRIMARY || _la==K_NOT) {
				{
				{
				setState(155);
				columnConstraint();
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableConstraintContext extends ParserRuleContext {
		public List<IndexedColumnContext> indexedColumn() {
			return getRuleContexts(IndexedColumnContext.class);
		}
		public IndexedColumnContext indexedColumn(int i) {
			return getRuleContext(IndexedColumnContext.class,i);
		}
		public TerminalNode K_PRIMARY() { return getToken(TinySQLParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(TinySQLParser.K_KEY, 0); }
		public TableConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterTableConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitTableConstraint(this);
		}
	}

	public final TableConstraintContext tableConstraint() throws RecognitionException {
		TableConstraintContext _localctx = new TableConstraintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_tableConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(161);
			match(K_PRIMARY);
			setState(162);
			match(K_KEY);
			}
			setState(164);
			match(T__2);
			setState(165);
			indexedColumn();
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(166);
				match(T__3);
				setState(167);
				indexedColumn();
				}
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(173);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexedColumnContext extends ParserRuleContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TerminalNode K_ASC() { return getToken(TinySQLParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(TinySQLParser.K_DESC, 0); }
		public IndexedColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexedColumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterIndexedColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitIndexedColumn(this);
		}
	}

	public final IndexedColumnContext indexedColumn() throws RecognitionException {
		IndexedColumnContext _localctx = new IndexedColumnContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_indexedColumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			columnName();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(176);
				_la = _input.LA(1);
				if ( !(_la==K_ASC || _la==K_DESC) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InsertTableStmtContext extends ParserRuleContext {
		public TerminalNode K_INSERT() { return getToken(TinySQLParser.K_INSERT, 0); }
		public TerminalNode K_INTO() { return getToken(TinySQLParser.K_INTO, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode K_VALUES() { return getToken(TinySQLParser.K_VALUES, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public InsertTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insertTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterInsertTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitInsertTableStmt(this);
		}
	}

	public final InsertTableStmtContext insertTableStmt() throws RecognitionException {
		InsertTableStmtContext _localctx = new InsertTableStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_insertTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(K_INSERT);
			setState(180);
			match(K_INTO);
			setState(181);
			tableName();
			setState(193);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(182);
				match(T__2);
				setState(183);
				columnName();
				setState(188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(184);
					match(T__3);
					setState(185);
					columnName();
					}
					}
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(191);
				match(T__4);
				}
			}

			{
			setState(195);
			match(K_VALUES);
			setState(196);
			match(T__2);
			setState(197);
			expression(0);
			setState(202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(198);
				match(T__3);
				setState(199);
				expression(0);
				}
				}
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(205);
			match(T__4);
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(206);
				match(T__3);
				setState(207);
				match(T__2);
				setState(208);
				expression(0);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(209);
					match(T__3);
					setState(210);
					expression(0);
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(216);
				match(T__4);
				}
				}
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ValueExpressionContext extends ExpressionContext {
		public LiteralValueContext literalValue() {
			return getRuleContext(LiteralValueContext.class,0);
		}
		public ValueExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitValueExpression(this);
		}
	}
	public static class AddSubExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AddSubExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterAddSubExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitAddSubExpression(this);
		}
	}
	public static class ParenthesisExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ParenthesisExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterParenthesisExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitParenthesisExpression(this);
		}
	}
	public static class UnaryExpressionContext extends ExpressionContext {
		public UnaryOperatorContext unaryOperator() {
			return getRuleContext(UnaryOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitUnaryExpression(this);
		}
	}
	public static class TableColumnExpressionContext extends ExpressionContext {
		public ColumnNameContext columnName() {
			return getRuleContext(ColumnNameContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TableColumnExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterTableColumnExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitTableColumnExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new ValueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(224);
				literalValue();
				}
				break;
			case 2:
				{
				_localctx = new TableColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(225);
					tableName();
					setState(226);
					match(T__1);
					}
					break;
				}
				setState(230);
				columnName();
				}
				break;
			case 3:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				unaryOperator();
				setState(232);
				expression(3);
				}
				break;
			case 4:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(234);
				match(T__2);
				setState(235);
				expression(0);
				setState(236);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AddSubExpressionContext(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(240);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(241);
					_la = _input.LA(1);
					if ( !(_la==T__5 || _la==T__6) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(242);
					expression(3);
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConditionExpressionContext extends ParserRuleContext {
		public ConditionExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionExpression; }
	 
		public ConditionExpressionContext() { }
		public void copyFrom(ConditionExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LessGreaterExpressionContext extends ConditionExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LessGreaterExpressionContext(ConditionExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterLessGreaterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitLessGreaterExpression(this);
		}
	}
	public static class OrExpressionContext extends ConditionExpressionContext {
		public List<ConditionExpressionContext> conditionExpression() {
			return getRuleContexts(ConditionExpressionContext.class);
		}
		public ConditionExpressionContext conditionExpression(int i) {
			return getRuleContext(ConditionExpressionContext.class,i);
		}
		public TerminalNode K_OR() { return getToken(TinySQLParser.K_OR, 0); }
		public OrExpressionContext(ConditionExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitOrExpression(this);
		}
	}
	public static class AndExpressionContext extends ConditionExpressionContext {
		public List<ConditionExpressionContext> conditionExpression() {
			return getRuleContexts(ConditionExpressionContext.class);
		}
		public ConditionExpressionContext conditionExpression(int i) {
			return getRuleContext(ConditionExpressionContext.class,i);
		}
		public TerminalNode K_AND() { return getToken(TinySQLParser.K_AND, 0); }
		public AndExpressionContext(ConditionExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitAndExpression(this);
		}
	}
	public static class ParenthesisConditionExpressionContext extends ConditionExpressionContext {
		public ConditionExpressionContext conditionExpression() {
			return getRuleContext(ConditionExpressionContext.class,0);
		}
		public ParenthesisConditionExpressionContext(ConditionExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterParenthesisConditionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitParenthesisConditionExpression(this);
		}
	}
	public static class EqualExpressionContext extends ConditionExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EqualExpressionContext(ConditionExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterEqualExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitEqualExpression(this);
		}
	}

	public final ConditionExpressionContext conditionExpression() throws RecognitionException {
		return conditionExpression(0);
	}

	private ConditionExpressionContext conditionExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionExpressionContext _localctx = new ConditionExpressionContext(_ctx, _parentState);
		ConditionExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_conditionExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(261);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				_localctx = new LessGreaterExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(249);
				expression(0);
				setState(250);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(251);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new EqualExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				expression(0);
				setState(254);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(255);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new ParenthesisConditionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				match(T__2);
				setState(258);
				conditionExpression(0);
				setState(259);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new AndExpressionContext(new ConditionExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionExpression);
						setState(263);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(264);
						match(K_AND);
						setState(265);
						conditionExpression(3);
						}
						break;
					case 2:
						{
						_localctx = new OrExpressionContext(new ConditionExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionExpression);
						setState(266);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(267);
						match(K_OR);
						setState(268);
						conditionExpression(2);
						}
						break;
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryOperatorContext extends ParserRuleContext {
		public TerminalNode K_NOT() { return getToken(TinySQLParser.K_NOT, 0); }
		public UnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterUnaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitUnaryOperator(this);
		}
	}

	public final UnaryOperatorContext unaryOperator() throws RecognitionException {
		UnaryOperatorContext _localctx = new UnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__15) | (1L << K_NOT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralValueContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(TinySQLParser.NUMERIC_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(TinySQLParser.STRING_LITERAL, 0); }
		public TerminalNode K_NULL() { return getToken(TinySQLParser.K_NULL, 0); }
		public LiteralValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterLiteralValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitLiteralValue(this);
		}
	}

	public final LiteralValueContext literalValue() throws RecognitionException {
		LiteralValueContext _localctx = new LiteralValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_literalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << STRING_LITERAL) | (1L << NUMERIC_LITERAL) | (1L << K_NULL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectTableStmtContext extends ParserRuleContext {
		public TerminalNode K_SELECT() { return getToken(TinySQLParser.K_SELECT, 0); }
		public List<ResultColumnContext> resultColumn() {
			return getRuleContexts(ResultColumnContext.class);
		}
		public ResultColumnContext resultColumn(int i) {
			return getRuleContext(ResultColumnContext.class,i);
		}
		public TerminalNode K_FROM() { return getToken(TinySQLParser.K_FROM, 0); }
		public TerminalNode K_WHERE() { return getToken(TinySQLParser.K_WHERE, 0); }
		public ConditionExpressionContext conditionExpression() {
			return getRuleContext(ConditionExpressionContext.class,0);
		}
		public TerminalNode K_DISTINCT() { return getToken(TinySQLParser.K_DISTINCT, 0); }
		public TerminalNode K_ALL() { return getToken(TinySQLParser.K_ALL, 0); }
		public List<TableNameContext> tableName() {
			return getRuleContexts(TableNameContext.class);
		}
		public TableNameContext tableName(int i) {
			return getRuleContext(TableNameContext.class,i);
		}
		public JoinClauseContext joinClause() {
			return getRuleContext(JoinClauseContext.class,0);
		}
		public SelectTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterSelectTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitSelectTableStmt(this);
		}
	}

	public final SelectTableStmtContext selectTableStmt() throws RecognitionException {
		SelectTableStmtContext _localctx = new SelectTableStmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_selectTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(278);
			match(K_SELECT);
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_DISTINCT || _la==K_ALL) {
				{
				setState(279);
				_la = _input.LA(1);
				if ( !(_la==K_DISTINCT || _la==K_ALL) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(282);
			resultColumn();
			setState(287);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(283);
				match(T__3);
				setState(284);
				resultColumn();
				}
				}
				setState(289);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_FROM) {
				{
				setState(290);
				match(K_FROM);
				setState(300);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
				case 1:
					{
					setState(291);
					tableName();
					setState(296);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(292);
						match(T__3);
						setState(293);
						tableName();
						}
						}
						setState(298);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(299);
					joinClause();
					}
					break;
				}
				}
			}

			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(304);
				match(K_WHERE);
				setState(305);
				conditionExpression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ResultColumnContext extends ParserRuleContext {
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ResultColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resultColumn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterResultColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitResultColumn(this);
		}
	}

	public final ResultColumnContext resultColumn() throws RecognitionException {
		ResultColumnContext _localctx = new ResultColumnContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_resultColumn);
		try {
			setState(315);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				match(T__16);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(310);
				tableName();
				setState(311);
				match(T__1);
				setState(312);
				match(T__16);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(314);
				expression(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinClauseContext extends ParserRuleContext {
		public List<TableNameContext> tableName() {
			return getRuleContexts(TableNameContext.class);
		}
		public TableNameContext tableName(int i) {
			return getRuleContext(TableNameContext.class,i);
		}
		public List<JoinOperatorContext> joinOperator() {
			return getRuleContexts(JoinOperatorContext.class);
		}
		public JoinOperatorContext joinOperator(int i) {
			return getRuleContext(JoinOperatorContext.class,i);
		}
		public List<JoinConstraintContext> joinConstraint() {
			return getRuleContexts(JoinConstraintContext.class);
		}
		public JoinConstraintContext joinConstraint(int i) {
			return getRuleContext(JoinConstraintContext.class,i);
		}
		public JoinClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterJoinClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitJoinClause(this);
		}
	}

	public final JoinClauseContext joinClause() throws RecognitionException {
		JoinClauseContext _localctx = new JoinClauseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_joinClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(317);
			tableName();
			setState(324);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << K_JOIN) | (1L << K_NATURAL) | (1L << K_LEFT) | (1L << K_INNER))) != 0)) {
				{
				{
				setState(318);
				joinOperator();
				setState(319);
				tableName();
				setState(320);
				joinConstraint();
				}
				}
				setState(326);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinConstraintContext extends ParserRuleContext {
		public TerminalNode K_ON() { return getToken(TinySQLParser.K_ON, 0); }
		public ConditionExpressionContext conditionExpression() {
			return getRuleContext(ConditionExpressionContext.class,0);
		}
		public JoinConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterJoinConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitJoinConstraint(this);
		}
	}

	public final JoinConstraintContext joinConstraint() throws RecognitionException {
		JoinConstraintContext _localctx = new JoinConstraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_joinConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ON) {
				{
				setState(327);
				match(K_ON);
				setState(328);
				conditionExpression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JoinOperatorContext extends ParserRuleContext {
		public TerminalNode K_JOIN() { return getToken(TinySQLParser.K_JOIN, 0); }
		public TerminalNode K_NATURAL() { return getToken(TinySQLParser.K_NATURAL, 0); }
		public TerminalNode K_LEFT() { return getToken(TinySQLParser.K_LEFT, 0); }
		public TerminalNode K_INNER() { return getToken(TinySQLParser.K_INNER, 0); }
		public TerminalNode K_OUTER() { return getToken(TinySQLParser.K_OUTER, 0); }
		public JoinOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_joinOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterJoinOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitJoinOperator(this);
		}
	}

	public final JoinOperatorContext joinOperator() throws RecognitionException {
		JoinOperatorContext _localctx = new JoinOperatorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_joinOperator);
		int _la;
		try {
			setState(343);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(331);
				match(T__3);
				}
				break;
			case K_JOIN:
			case K_NATURAL:
			case K_LEFT:
			case K_INNER:
				enterOuterAlt(_localctx, 2);
				{
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(332);
					match(K_NATURAL);
					}
				}

				setState(340);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(335);
					match(K_LEFT);
					setState(337);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(336);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(339);
					match(K_INNER);
					}
					break;
				case K_JOIN:
					break;
				default:
					break;
				}
				setState(342);
				match(K_JOIN);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UpdateTableStmtContext extends ParserRuleContext {
		public TerminalNode K_UPDATE() { return getToken(TinySQLParser.K_UPDATE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode K_SET() { return getToken(TinySQLParser.K_SET, 0); }
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode K_WHERE() { return getToken(TinySQLParser.K_WHERE, 0); }
		public ConditionExpressionContext conditionExpression() {
			return getRuleContext(ConditionExpressionContext.class,0);
		}
		public UpdateTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_updateTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterUpdateTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitUpdateTableStmt(this);
		}
	}

	public final UpdateTableStmtContext updateTableStmt() throws RecognitionException {
		UpdateTableStmtContext _localctx = new UpdateTableStmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_updateTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(K_UPDATE);
			setState(346);
			tableName();
			setState(347);
			match(K_SET);
			setState(348);
			columnName();
			setState(349);
			match(T__11);
			setState(350);
			expression(0);
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(351);
				match(T__3);
				setState(352);
				columnName();
				setState(353);
				match(T__11);
				setState(354);
				expression(0);
				}
				}
				setState(360);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(363);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(361);
				match(K_WHERE);
				setState(362);
				conditionExpression(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeleteTableStmtContext extends ParserRuleContext {
		public TerminalNode K_DELETE() { return getToken(TinySQLParser.K_DELETE, 0); }
		public TerminalNode K_FROM() { return getToken(TinySQLParser.K_FROM, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public TerminalNode K_WHERE() { return getToken(TinySQLParser.K_WHERE, 0); }
		public ConditionExpressionContext conditionExpression() {
			return getRuleContext(ConditionExpressionContext.class,0);
		}
		public DeleteTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deleteTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterDeleteTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitDeleteTableStmt(this);
		}
	}

	public final DeleteTableStmtContext deleteTableStmt() throws RecognitionException {
		DeleteTableStmtContext _localctx = new DeleteTableStmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_deleteTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			match(K_DELETE);
			setState(366);
			match(K_FROM);
			setState(367);
			tableName();
			setState(368);
			match(K_WHERE);
			setState(369);
			conditionExpression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropDatabaseStmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(TinySQLParser.K_DROP, 0); }
		public TerminalNode K_DATABASE() { return getToken(TinySQLParser.K_DATABASE, 0); }
		public DatabaseNameContext databaseName() {
			return getRuleContext(DatabaseNameContext.class,0);
		}
		public DropDatabaseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropDatabaseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterDropDatabaseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitDropDatabaseStmt(this);
		}
	}

	public final DropDatabaseStmtContext dropDatabaseStmt() throws RecognitionException {
		DropDatabaseStmtContext _localctx = new DropDatabaseStmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_dropDatabaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			match(K_DROP);
			setState(372);
			match(K_DATABASE);
			setState(373);
			databaseName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DropTableStmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(TinySQLParser.K_DROP, 0); }
		public TerminalNode K_TABLE() { return getToken(TinySQLParser.K_TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public DropTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dropTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterDropTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitDropTableStmt(this);
		}
	}

	public final DropTableStmtContext dropTableStmt() throws RecognitionException {
		DropTableStmtContext _localctx = new DropTableStmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_dropTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(K_DROP);
			setState(376);
			match(K_TABLE);
			setState(377);
			tableName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UseDatabaseStmtContext extends ParserRuleContext {
		public TerminalNode K_USE() { return getToken(TinySQLParser.K_USE, 0); }
		public DatabaseNameContext databaseName() {
			return getRuleContext(DatabaseNameContext.class,0);
		}
		public UseDatabaseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDatabaseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterUseDatabaseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitUseDatabaseStmt(this);
		}
	}

	public final UseDatabaseStmtContext useDatabaseStmt() throws RecognitionException {
		UseDatabaseStmtContext _localctx = new UseDatabaseStmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_useDatabaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(K_USE);
			setState(380);
			databaseName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public SignedNumberContext signedNumber() {
			return getRuleContext(SignedNumberContext.class,0);
		}
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(382);
			name();
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(383);
				match(T__2);
				setState(384);
				signedNumber();
				setState(385);
				match(T__4);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SignedNumberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(TinySQLParser.NUMERIC_LITERAL, 0); }
		public SignedNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signedNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterSignedNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitSignedNumber(this);
		}
	}

	public final SignedNumberContext signedNumber() throws RecognitionException {
		SignedNumberContext _localctx = new SignedNumberContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_signedNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__6) {
				{
				setState(389);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__6) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(392);
			match(NUMERIC_LITERAL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnConstraintContext extends ParserRuleContext {
		public TerminalNode K_PRIMARY() { return getToken(TinySQLParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(TinySQLParser.K_KEY, 0); }
		public TerminalNode K_ASC() { return getToken(TinySQLParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(TinySQLParser.K_DESC, 0); }
		public TerminalNode K_NOT() { return getToken(TinySQLParser.K_NOT, 0); }
		public TerminalNode K_NULL() { return getToken(TinySQLParser.K_NULL, 0); }
		public ColumnConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterColumnConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitColumnConstraint(this);
		}
	}

	public final ColumnConstraintContext columnConstraint() throws RecognitionException {
		ColumnConstraintContext _localctx = new ColumnConstraintContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_columnConstraint);
		int _la;
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_PRIMARY:
				enterOuterAlt(_localctx, 1);
				{
				setState(394);
				match(K_PRIMARY);
				setState(395);
				match(K_KEY);
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ASC || _la==K_DESC) {
					{
					setState(396);
					_la = _input.LA(1);
					if ( !(_la==K_ASC || _la==K_DESC) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
				}

				}
				break;
			case K_NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(399);
				match(K_NOT);
				setState(400);
				match(K_NULL);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			anyName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatabaseNameContext extends ParserRuleContext {
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
		}
		public DatabaseNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_databaseName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterDatabaseName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitDatabaseName(this);
		}
	}

	public final DatabaseNameContext databaseName() throws RecognitionException {
		DatabaseNameContext _localctx = new DatabaseNameContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_databaseName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			anyName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableNameContext extends ParserRuleContext {
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			anyName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnNameContext extends ParserRuleContext {
		public AnyNameContext anyName() {
			return getRuleContext(AnyNameContext.class,0);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(409);
			anyName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnyNameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TinySQLParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public AnyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterAnyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitAnyName(this);
		}
	}

	public final AnyNameContext anyName() throws RecognitionException {
		AnyNameContext _localctx = new AnyNameContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_anyName);
		try {
			setState(413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(411);
				match(IDENTIFIER);
				}
				break;
			case K_CREATE:
			case K_DATABASE:
			case K_TABLE:
			case K_DROP:
			case K_SELECT:
			case K_UPDATE:
			case K_DELETE:
			case K_INSERT:
			case K_PRIMARY:
			case K_KEY:
			case K_NOT:
			case K_NULL:
			case K_WHERE:
			case K_INTO:
			case K_FROM:
			case K_USE:
			case K_ASC:
			case K_DESC:
			case K_VALUES:
			case K_DATABASES:
			case K_SHOW:
			case K_LEFT:
			case K_INNER:
			case K_SET:
			case K_AND:
			case K_OR:
				enterOuterAlt(_localctx, 2);
				{
				setState(412);
				keyword();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(TinySQLParser.K_CREATE, 0); }
		public TerminalNode K_DATABASE() { return getToken(TinySQLParser.K_DATABASE, 0); }
		public TerminalNode K_TABLE() { return getToken(TinySQLParser.K_TABLE, 0); }
		public TerminalNode K_DROP() { return getToken(TinySQLParser.K_DROP, 0); }
		public TerminalNode K_SELECT() { return getToken(TinySQLParser.K_SELECT, 0); }
		public TerminalNode K_UPDATE() { return getToken(TinySQLParser.K_UPDATE, 0); }
		public TerminalNode K_DELETE() { return getToken(TinySQLParser.K_DELETE, 0); }
		public TerminalNode K_INSERT() { return getToken(TinySQLParser.K_INSERT, 0); }
		public TerminalNode K_PRIMARY() { return getToken(TinySQLParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(TinySQLParser.K_KEY, 0); }
		public TerminalNode K_NOT() { return getToken(TinySQLParser.K_NOT, 0); }
		public TerminalNode K_NULL() { return getToken(TinySQLParser.K_NULL, 0); }
		public TerminalNode K_WHERE() { return getToken(TinySQLParser.K_WHERE, 0); }
		public TerminalNode K_INTO() { return getToken(TinySQLParser.K_INTO, 0); }
		public TerminalNode K_FROM() { return getToken(TinySQLParser.K_FROM, 0); }
		public TerminalNode K_USE() { return getToken(TinySQLParser.K_USE, 0); }
		public TerminalNode K_ASC() { return getToken(TinySQLParser.K_ASC, 0); }
		public TerminalNode K_DESC() { return getToken(TinySQLParser.K_DESC, 0); }
		public TerminalNode K_VALUES() { return getToken(TinySQLParser.K_VALUES, 0); }
		public TerminalNode K_DATABASES() { return getToken(TinySQLParser.K_DATABASES, 0); }
		public TerminalNode K_SHOW() { return getToken(TinySQLParser.K_SHOW, 0); }
		public TerminalNode K_LEFT() { return getToken(TinySQLParser.K_LEFT, 0); }
		public TerminalNode K_INNER() { return getToken(TinySQLParser.K_INNER, 0); }
		public TerminalNode K_SET() { return getToken(TinySQLParser.K_SET, 0); }
		public TerminalNode K_AND() { return getToken(TinySQLParser.K_AND, 0); }
		public TerminalNode K_OR() { return getToken(TinySQLParser.K_OR, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitKeyword(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CREATE) | (1L << K_DATABASE) | (1L << K_TABLE) | (1L << K_DROP) | (1L << K_SELECT) | (1L << K_UPDATE) | (1L << K_DELETE) | (1L << K_INSERT) | (1L << K_PRIMARY) | (1L << K_KEY) | (1L << K_NOT) | (1L << K_NULL) | (1L << K_WHERE) | (1L << K_INTO) | (1L << K_FROM) | (1L << K_USE) | (1L << K_ASC) | (1L << K_DESC) | (1L << K_VALUES) | (1L << K_DATABASES) | (1L << K_SHOW) | (1L << K_LEFT) | (1L << K_INNER) | (1L << K_SET) | (1L << K_AND) | (1L << K_OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 13:
			return conditionExpression_sempred((ConditionExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean conditionExpression_sempred(ConditionExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u01a4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\7\2K\n\2\f\2\16\2N\13\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\4\7\4V\n\4\f\4\16\4Y\13\4\3\4\3\4\6\4]\n\4\r\4\16\4^\3\4\7\4"+
		"b\n\4\f\4\16\4e\13\4\3\4\7\4h\n\4\f\4\16\4k\13\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\5\5x\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\t\5\t\u008a\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u0091"+
		"\n\t\f\t\16\t\u0094\13\t\3\t\3\t\5\t\u0098\n\t\3\t\3\t\3\n\3\n\3\n\7\n"+
		"\u009f\n\n\f\n\16\n\u00a2\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13"+
		"\u00ab\n\13\f\13\16\13\u00ae\13\13\3\13\3\13\3\f\3\f\5\f\u00b4\n\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00bd\n\r\f\r\16\r\u00c0\13\r\3\r\3\r\5\r"+
		"\u00c4\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u00cb\n\r\f\r\16\r\u00ce\13\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\7\r\u00d6\n\r\f\r\16\r\u00d9\13\r\3\r\3\r\7\r\u00dd"+
		"\n\r\f\r\16\r\u00e0\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u00e7\n\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00f1\n\16\3\16\3\16\3\16\7\16"+
		"\u00f6\n\16\f\16\16\16\u00f9\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0108\n\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\7\17\u0110\n\17\f\17\16\17\u0113\13\17\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\5\22\u011b\n\22\3\22\3\22\3\22\7\22\u0120\n\22\f\22\16\22\u0123"+
		"\13\22\3\22\3\22\3\22\3\22\7\22\u0129\n\22\f\22\16\22\u012c\13\22\3\22"+
		"\5\22\u012f\n\22\5\22\u0131\n\22\3\22\3\22\5\22\u0135\n\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\5\23\u013e\n\23\3\24\3\24\3\24\3\24\3\24\7\24"+
		"\u0145\n\24\f\24\16\24\u0148\13\24\3\25\3\25\5\25\u014c\n\25\3\26\3\26"+
		"\5\26\u0150\n\26\3\26\3\26\5\26\u0154\n\26\3\26\5\26\u0157\n\26\3\26\5"+
		"\26\u015a\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\7\27\u0167\n\27\f\27\16\27\u016a\13\27\3\27\3\27\5\27\u016e\n\27\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\34\3\34\3\34\3\34\3\34\5\34\u0186\n\34\3\35\5\35\u0189\n"+
		"\35\3\35\3\35\3\36\3\36\3\36\5\36\u0190\n\36\3\36\3\36\5\36\u0194\n\36"+
		"\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\5#\u01a0\n#\3$\3$\3$\2\4\32\34%\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\n"+
		"\3\2)*\3\2\b\t\3\2\n\r\3\2\16\21\5\2\b\t\22\22##\5\2\24\24\30\30$$\3\2"+
		"\61\62\4\2\31-\648\2\u01bb\2L\3\2\2\2\4Q\3\2\2\2\6W\3\2\2\2\bw\3\2\2\2"+
		"\ny\3\2\2\2\f|\3\2\2\2\16\u0080\3\2\2\2\20\u0084\3\2\2\2\22\u009b\3\2"+
		"\2\2\24\u00a3\3\2\2\2\26\u00b1\3\2\2\2\30\u00b5\3\2\2\2\32\u00f0\3\2\2"+
		"\2\34\u0107\3\2\2\2\36\u0114\3\2\2\2 \u0116\3\2\2\2\"\u0118\3\2\2\2$\u013d"+
		"\3\2\2\2&\u013f\3\2\2\2(\u014b\3\2\2\2*\u0159\3\2\2\2,\u015b\3\2\2\2."+
		"\u016f\3\2\2\2\60\u0175\3\2\2\2\62\u0179\3\2\2\2\64\u017d\3\2\2\2\66\u0180"+
		"\3\2\2\28\u0188\3\2\2\2:\u0193\3\2\2\2<\u0195\3\2\2\2>\u0197\3\2\2\2@"+
		"\u0199\3\2\2\2B\u019b\3\2\2\2D\u019f\3\2\2\2F\u01a1\3\2\2\2HK\5\6\4\2"+
		"IK\5\4\3\2JH\3\2\2\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2MO\3\2\2\2"+
		"NL\3\2\2\2OP\7\2\2\3P\3\3\2\2\2QR\7:\2\2RS\b\3\1\2S\5\3\2\2\2TV\7\3\2"+
		"\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2XZ\3\2\2\2YW\3\2\2\2Zc\5\b\5"+
		"\2[]\7\3\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2\2`b\5\b"+
		"\5\2a\\\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2di\3\2\2\2ec\3\2\2\2fh\7"+
		"\3\2\2gf\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\7\3\2\2\2ki\3\2\2\2lx"+
		"\5\16\b\2mx\5\n\6\2nx\5\f\7\2ox\5\20\t\2px\5\30\r\2qx\5\"\22\2rx\5,\27"+
		"\2sx\5.\30\2tx\5\60\31\2ux\5\62\32\2vx\5\64\33\2wl\3\2\2\2wm\3\2\2\2w"+
		"n\3\2\2\2wo\3\2\2\2wp\3\2\2\2wq\3\2\2\2wr\3\2\2\2ws\3\2\2\2wt\3\2\2\2"+
		"wu\3\2\2\2wv\3\2\2\2x\t\3\2\2\2yz\7-\2\2z{\7,\2\2{\13\3\2\2\2|}\7-\2\2"+
		"}~\7\32\2\2~\177\5> \2\177\r\3\2\2\2\u0080\u0081\7\31\2\2\u0081\u0082"+
		"\7\32\2\2\u0082\u0083\5> \2\u0083\17\3\2\2\2\u0084\u0085\7\31\2\2\u0085"+
		"\u0089\7\33\2\2\u0086\u0087\5> \2\u0087\u0088\7\4\2\2\u0088\u008a\3\2"+
		"\2\2\u0089\u0086\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\5@!\2\u008c\u008d\7\5\2\2\u008d\u0092\5\22\n\2\u008e\u008f\7\6"+
		"\2\2\u008f\u0091\5\22\n\2\u0090\u008e\3\2\2\2\u0091\u0094\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0097\3\2\2\2\u0094\u0092\3\2"+
		"\2\2\u0095\u0096\7\6\2\2\u0096\u0098\5\24\13\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\7\2\2\u009a\21\3\2\2"+
		"\2\u009b\u009c\5B\"\2\u009c\u00a0\5\66\34\2\u009d\u009f\5:\36\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\23\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7!\2\2\u00a4\u00a5"+
		"\7\"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\5\2\2\u00a7\u00ac\5\26\f\2"+
		"\u00a8\u00a9\7\6\2\2\u00a9\u00ab\5\26\f\2\u00aa\u00a8\3\2\2\2\u00ab\u00ae"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b0\7\7\2\2\u00b0\25\3\2\2\2\u00b1\u00b3\5B\"\2"+
		"\u00b2\u00b4\t\2\2\2\u00b3\u00b2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\27"+
		"\3\2\2\2\u00b5\u00b6\7 \2\2\u00b6\u00b7\7&\2\2\u00b7\u00c3\5@!\2\u00b8"+
		"\u00b9\7\5\2\2\u00b9\u00be\5B\"\2\u00ba\u00bb\7\6\2\2\u00bb\u00bd\5B\""+
		"\2\u00bc\u00ba\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf"+
		"\3\2\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7\7\2\2\u00c2"+
		"\u00c4\3\2\2\2\u00c3\u00b8\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\3\2"+
		"\2\2\u00c5\u00c6\7+\2\2\u00c6\u00c7\7\5\2\2\u00c7\u00cc\5\32\16\2\u00c8"+
		"\u00c9\7\6\2\2\u00c9\u00cb\5\32\16\2\u00ca\u00c8\3\2\2\2\u00cb\u00ce\3"+
		"\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cf\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00de\7\7\2\2\u00d0\u00d1\7\6\2\2\u00d1\u00d2\7\5"+
		"\2\2\u00d2\u00d7\5\32\16\2\u00d3\u00d4\7\6\2\2\u00d4\u00d6\5\32\16\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\7\7\2\2\u00db"+
		"\u00dd\3\2\2\2\u00dc\u00d0\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2"+
		"\2\2\u00de\u00df\3\2\2\2\u00df\31\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2"+
		"\b\16\1\2\u00e2\u00f1\5 \21\2\u00e3\u00e4\5@!\2\u00e4\u00e5\7\4\2\2\u00e5"+
		"\u00e7\3\2\2\2\u00e6\u00e3\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\3\2"+
		"\2\2\u00e8\u00f1\5B\"\2\u00e9\u00ea\5\36\20\2\u00ea\u00eb\5\32\16\5\u00eb"+
		"\u00f1\3\2\2\2\u00ec\u00ed\7\5\2\2\u00ed\u00ee\5\32\16\2\u00ee\u00ef\7"+
		"\7\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00e1\3\2\2\2\u00f0\u00e6\3\2\2\2\u00f0"+
		"\u00e9\3\2\2\2\u00f0\u00ec\3\2\2\2\u00f1\u00f7\3\2\2\2\u00f2\u00f3\f\4"+
		"\2\2\u00f3\u00f4\t\3\2\2\u00f4\u00f6\5\32\16\5\u00f5\u00f2\3\2\2\2\u00f6"+
		"\u00f9\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\33\3\2\2"+
		"\2\u00f9\u00f7\3\2\2\2\u00fa\u00fb\b\17\1\2\u00fb\u00fc\5\32\16\2\u00fc"+
		"\u00fd\t\4\2\2\u00fd\u00fe\5\32\16\2\u00fe\u0108\3\2\2\2\u00ff\u0100\5"+
		"\32\16\2\u0100\u0101\t\5\2\2\u0101\u0102\5\32\16\2\u0102\u0108\3\2\2\2"+
		"\u0103\u0104\7\5\2\2\u0104\u0105\5\34\17\2\u0105\u0106\7\7\2\2\u0106\u0108"+
		"\3\2\2\2\u0107\u00fa\3\2\2\2\u0107\u00ff\3\2\2\2\u0107\u0103\3\2\2\2\u0108"+
		"\u0111\3\2\2\2\u0109\u010a\f\4\2\2\u010a\u010b\7\67\2\2\u010b\u0110\5"+
		"\34\17\5\u010c\u010d\f\3\2\2\u010d\u010e\78\2\2\u010e\u0110\5\34\17\4"+
		"\u010f\u0109\3\2\2\2\u010f\u010c\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\35\3\2\2\2\u0113\u0111\3\2\2\2\u0114"+
		"\u0115\t\6\2\2\u0115\37\3\2\2\2\u0116\u0117\t\7\2\2\u0117!\3\2\2\2\u0118"+
		"\u011a\7\35\2\2\u0119\u011b\t\b\2\2\u011a\u0119\3\2\2\2\u011a\u011b\3"+
		"\2\2\2\u011b\u011c\3\2\2\2\u011c\u0121\5$\23\2\u011d\u011e\7\6\2\2\u011e"+
		"\u0120\5$\23\2\u011f\u011d\3\2\2\2\u0120\u0123\3\2\2\2\u0121\u011f\3\2"+
		"\2\2\u0121\u0122\3\2\2\2\u0122\u0130\3\2\2\2\u0123\u0121\3\2\2\2\u0124"+
		"\u012e\7\'\2\2\u0125\u012a\5@!\2\u0126\u0127\7\6\2\2\u0127\u0129\5@!\2"+
		"\u0128\u0126\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b"+
		"\3\2\2\2\u012b\u012f\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u012f\5&\24\2\u012e"+
		"\u0125\3\2\2\2\u012e\u012d\3\2\2\2\u012f\u0131\3\2\2\2\u0130\u0124\3\2"+
		"\2\2\u0130\u0131\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0133\7%\2\2\u0133"+
		"\u0135\5\34\17\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135#\3\2\2"+
		"\2\u0136\u013e\3\2\2\2\u0137\u013e\7\23\2\2\u0138\u0139\5@!\2\u0139\u013a"+
		"\7\4\2\2\u013a\u013b\7\23\2\2\u013b\u013e\3\2\2\2\u013c\u013e\5\32\16"+
		"\2\u013d\u0136\3\2\2\2\u013d\u0137\3\2\2\2\u013d\u0138\3\2\2\2\u013d\u013c"+
		"\3\2\2\2\u013e%\3\2\2\2\u013f\u0146\5@!\2\u0140\u0141\5*\26\2\u0141\u0142"+
		"\5@!\2\u0142\u0143\5(\25\2\u0143\u0145\3\2\2\2\u0144\u0140\3\2\2\2\u0145"+
		"\u0148\3\2\2\2\u0146\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\'\3\2\2\2"+
		"\u0148\u0146\3\2\2\2\u0149\u014a\7.\2\2\u014a\u014c\5\34\17\2\u014b\u0149"+
		"\3\2\2\2\u014b\u014c\3\2\2\2\u014c)\3\2\2\2\u014d\u015a\7\6\2\2\u014e"+
		"\u0150\7\60\2\2\u014f\u014e\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0156\3"+
		"\2\2\2\u0151\u0153\7\64\2\2\u0152\u0154\7\63\2\2\u0153\u0152\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0157\7\65\2\2\u0156\u0151\3"+
		"\2\2\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u015a\7/\2\2\u0159\u014d\3\2\2\2\u0159\u014f\3\2\2\2\u015a+\3\2\2\2\u015b"+
		"\u015c\7\36\2\2\u015c\u015d\5@!\2\u015d\u015e\7\66\2\2\u015e\u015f\5B"+
		"\"\2\u015f\u0160\7\16\2\2\u0160\u0168\5\32\16\2\u0161\u0162\7\6\2\2\u0162"+
		"\u0163\5B\"\2\u0163\u0164\7\16\2\2\u0164\u0165\5\32\16\2\u0165\u0167\3"+
		"\2\2\2\u0166\u0161\3\2\2\2\u0167\u016a\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169\u016d\3\2\2\2\u016a\u0168\3\2\2\2\u016b\u016c\7%"+
		"\2\2\u016c\u016e\5\34\17\2\u016d\u016b\3\2\2\2\u016d\u016e\3\2\2\2\u016e"+
		"-\3\2\2\2\u016f\u0170\7\37\2\2\u0170\u0171\7\'\2\2\u0171\u0172\5@!\2\u0172"+
		"\u0173\7%\2\2\u0173\u0174\5\34\17\2\u0174/\3\2\2\2\u0175\u0176\7\34\2"+
		"\2\u0176\u0177\7\32\2\2\u0177\u0178\5> \2\u0178\61\3\2\2\2\u0179\u017a"+
		"\7\34\2\2\u017a\u017b\7\33\2\2\u017b\u017c\5@!\2\u017c\63\3\2\2\2\u017d"+
		"\u017e\7(\2\2\u017e\u017f\5> \2\u017f\65\3\2\2\2\u0180\u0185\5<\37\2\u0181"+
		"\u0182\7\5\2\2\u0182\u0183\58\35\2\u0183\u0184\7\7\2\2\u0184\u0186\3\2"+
		"\2\2\u0185\u0181\3\2\2\2\u0185\u0186\3\2\2\2\u0186\67\3\2\2\2\u0187\u0189"+
		"\t\3\2\2\u0188\u0187\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018a\3\2\2\2\u018a"+
		"\u018b\7\30\2\2\u018b9\3\2\2\2\u018c\u018d\7!\2\2\u018d\u018f\7\"\2\2"+
		"\u018e\u0190\t\2\2\2\u018f\u018e\3\2\2\2\u018f\u0190\3\2\2\2\u0190\u0194"+
		"\3\2\2\2\u0191\u0192\7#\2\2\u0192\u0194\7$\2\2\u0193\u018c\3\2\2\2\u0193"+
		"\u0191\3\2\2\2\u0194;\3\2\2\2\u0195\u0196\5D#\2\u0196=\3\2\2\2\u0197\u0198"+
		"\5D#\2\u0198?\3\2\2\2\u0199\u019a\5D#\2\u019aA\3\2\2\2\u019b\u019c\5D"+
		"#\2\u019cC\3\2\2\2\u019d\u01a0\79\2\2\u019e\u01a0\5F$\2\u019f\u019d\3"+
		"\2\2\2\u019f\u019e\3\2\2\2\u01a0E\3\2\2\2\u01a1\u01a2\t\t\2\2\u01a2G\3"+
		"\2\2\2.JLW^ciw\u0089\u0092\u0097\u00a0\u00ac\u00b3\u00be\u00c3\u00cc\u00d7"+
		"\u00de\u00e6\u00f0\u00f7\u0107\u010f\u0111\u011a\u0121\u012a\u012e\u0130"+
		"\u0134\u013d\u0146\u014b\u014f\u0153\u0156\u0159\u0168\u016d\u0185\u0188"+
		"\u018f\u0193\u019f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}