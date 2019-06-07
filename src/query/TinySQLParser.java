// Generated from C:/Users/cyj/Desktop/TinyDatabase/src/query\TinySQL.g4 by ANTLR 4.7.2
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
		K_SET=52, K_AND=53, K_OR=54, K_IS=55, K_ISNULL=56, K_NOTNULL=57, IDENTIFIER=58, 
		UNEXPECTED_CHAR=59;
	public static final int
		RULE_parse = 0, RULE_error = 1, RULE_sqlStatementList = 2, RULE_sqlStatement = 3, 
		RULE_showDatabasesStmt = 4, RULE_showDatabaseTablesStmt = 5, RULE_showTableStmt = 6, 
		RULE_createDatabaseStmt = 7, RULE_createTableStmt = 8, RULE_columnDefinition = 9, 
		RULE_tableConstraint = 10, RULE_indexedColumn = 11, RULE_insertTableStmt = 12, 
		RULE_expression = 13, RULE_conditionExpression = 14, RULE_unaryOperator = 15, 
		RULE_literalValue = 16, RULE_selectTableStmt = 17, RULE_resultColumn = 18, 
		RULE_joinClause = 19, RULE_joinConstraint = 20, RULE_joinOperator = 21, 
		RULE_updateTableStmt = 22, RULE_deleteTableStmt = 23, RULE_dropDatabaseStmt = 24, 
		RULE_dropTableStmt = 25, RULE_useDatabaseStmt = 26, RULE_typeName = 27, 
		RULE_signedNumber = 28, RULE_columnConstraint = 29, RULE_name = 30, RULE_databaseName = 31, 
		RULE_tableName = 32, RULE_columnName = 33, RULE_anyName = 34, RULE_keyword = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "error", "sqlStatementList", "sqlStatement", "showDatabasesStmt", 
			"showDatabaseTablesStmt", "showTableStmt", "createDatabaseStmt", "createTableStmt", 
			"columnDefinition", "tableConstraint", "indexedColumn", "insertTableStmt", 
			"expression", "conditionExpression", "unaryOperator", "literalValue", 
			"selectTableStmt", "resultColumn", "joinClause", "joinConstraint", "joinOperator", 
			"updateTableStmt", "deleteTableStmt", "dropDatabaseStmt", "dropTableStmt", 
			"useDatabaseStmt", "typeName", "signedNumber", "columnConstraint", "name", 
			"databaseName", "tableName", "columnName", "anyName", "keyword"
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
			"K_SET", "K_AND", "K_OR", "K_IS", "K_ISNULL", "K_NOTNULL", "IDENTIFIER", 
			"UNEXPECTED_CHAR"
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
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << K_CREATE) | (1L << K_DROP) | (1L << K_SELECT) | (1L << K_UPDATE) | (1L << K_DELETE) | (1L << K_INSERT) | (1L << K_USE) | (1L << K_SHOW) | (1L << UNEXPECTED_CHAR))) != 0)) {
				{
				setState(74);
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
					setState(72);
					sqlStatementList();
					}
					break;
				case UNEXPECTED_CHAR:
					{
					setState(73);
					error();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(79);
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
			setState(81);
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
			setState(87);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(84);
				match(T__0);
				}
				}
				setState(89);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(90);
			sqlStatement();
			setState(99);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(91);
						match(T__0);
						}
						}
						setState(94); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__0 );
					setState(96);
					sqlStatement();
					}
					} 
				}
				setState(101);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(102);
					match(T__0);
					}
					} 
				}
				setState(107);
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
		public ShowTableStmtContext showTableStmt() {
			return getRuleContext(ShowTableStmtContext.class,0);
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
			setState(120);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				createDatabaseStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				showDatabasesStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				showDatabaseTablesStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				showTableStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				createTableStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(113);
				insertTableStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(114);
				selectTableStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(115);
				updateTableStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(116);
				deleteTableStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(117);
				dropDatabaseStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(118);
				dropTableStmt();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(119);
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
			setState(122);
			match(K_SHOW);
			setState(123);
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
			setState(125);
			match(K_SHOW);
			setState(126);
			match(K_DATABASE);
			setState(127);
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

	public static class ShowTableStmtContext extends ParserRuleContext {
		public TerminalNode K_SHOW() { return getToken(TinySQLParser.K_SHOW, 0); }
		public TerminalNode K_TABLE() { return getToken(TinySQLParser.K_TABLE, 0); }
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public ShowTableStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_showTableStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterShowTableStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitShowTableStmt(this);
		}
	}

	public final ShowTableStmtContext showTableStmt() throws RecognitionException {
		ShowTableStmtContext _localctx = new ShowTableStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_showTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			match(K_SHOW);
			setState(130);
			match(K_TABLE);
			setState(131);
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
		enterRule(_localctx, 14, RULE_createDatabaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(K_CREATE);
			setState(134);
			match(K_DATABASE);
			setState(135);
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
		enterRule(_localctx, 16, RULE_createTableStmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(K_CREATE);
			setState(138);
			match(K_TABLE);
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(139);
				databaseName();
				setState(140);
				match(T__1);
				}
				break;
			}
			setState(144);
			tableName();
			{
			setState(145);
			match(T__2);
			setState(146);
			columnDefinition();
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(147);
					match(T__3);
					setState(148);
					columnDefinition();
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(154);
				match(T__3);
				setState(155);
				tableConstraint();
				}
			}

			setState(158);
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
		enterRule(_localctx, 18, RULE_columnDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			columnName();
			setState(161);
			typeName();
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_PRIMARY || _la==K_NOT) {
				{
				{
				setState(162);
				columnConstraint();
				}
				}
				setState(167);
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
		enterRule(_localctx, 20, RULE_tableConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(168);
			match(K_PRIMARY);
			setState(169);
			match(K_KEY);
			}
			setState(171);
			match(T__2);
			setState(172);
			indexedColumn();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(173);
				match(T__3);
				setState(174);
				indexedColumn();
				}
				}
				setState(179);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(180);
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
		enterRule(_localctx, 22, RULE_indexedColumn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			columnName();
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(183);
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
		enterRule(_localctx, 24, RULE_insertTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
			match(K_INSERT);
			setState(187);
			match(K_INTO);
			setState(188);
			tableName();
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(189);
				match(T__2);
				setState(190);
				columnName();
				setState(195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(191);
					match(T__3);
					setState(192);
					columnName();
					}
					}
					setState(197);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(198);
				match(T__4);
				}
			}

			{
			setState(202);
			match(K_VALUES);
			setState(203);
			match(T__2);
			setState(204);
			expression(0);
			setState(209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(205);
				match(T__3);
				setState(206);
				expression(0);
				}
				}
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(212);
			match(T__4);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(213);
				match(T__3);
				setState(214);
				match(T__2);
				setState(215);
				expression(0);
				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(216);
					match(T__3);
					setState(217);
					expression(0);
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(223);
				match(T__4);
				}
				}
				setState(229);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new ValueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(231);
				literalValue();
				}
				break;
			case 2:
				{
				_localctx = new TableColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(235);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(232);
					tableName();
					setState(233);
					match(T__1);
					}
					break;
				}
				setState(237);
				columnName();
				}
				break;
			case 3:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(238);
				unaryOperator();
				setState(239);
				expression(3);
				}
				break;
			case 4:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				match(T__2);
				setState(242);
				expression(0);
				setState(243);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
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
					setState(247);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(248);
					_la = _input.LA(1);
					if ( !(_la==T__5 || _la==T__6) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(249);
					expression(3);
					}
					} 
				}
				setState(254);
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
	public static class IsOrNotExpressionContext extends ConditionExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode K_IS() { return getToken(TinySQLParser.K_IS, 0); }
		public TerminalNode K_NOT() { return getToken(TinySQLParser.K_NOT, 0); }
		public IsOrNotExpressionContext(ConditionExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterIsOrNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitIsOrNotExpression(this);
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
	public static class IsNullExpressionContext extends ConditionExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode K_ISNULL() { return getToken(TinySQLParser.K_ISNULL, 0); }
		public IsNullExpressionContext(ConditionExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterIsNullExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitIsNullExpression(this);
		}
	}
	public static class IsNotNullExpressionContext extends ConditionExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode K_NOT() { return getToken(TinySQLParser.K_NOT, 0); }
		public TerminalNode K_NULL() { return getToken(TinySQLParser.K_NULL, 0); }
		public TerminalNode K_NOTNULL() { return getToken(TinySQLParser.K_NOTNULL, 0); }
		public IsNotNullExpressionContext(ConditionExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterIsNotNullExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitIsNotNullExpression(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_conditionExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				_localctx = new LessGreaterExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(256);
				expression(0);
				setState(257);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(258);
				expression(0);
				}
				break;
			case 2:
				{
				_localctx = new EqualExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(260);
				expression(0);
				setState(261);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(262);
				expression(0);
				}
				break;
			case 3:
				{
				_localctx = new ParenthesisConditionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(264);
				match(T__2);
				setState(265);
				conditionExpression(0);
				setState(266);
				match(T__4);
				}
				break;
			case 4:
				{
				_localctx = new IsNullExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				expression(0);
				setState(269);
				match(K_ISNULL);
				}
				break;
			case 5:
				{
				_localctx = new IsNotNullExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(271);
				expression(0);
				setState(275);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_NOT:
					{
					setState(272);
					match(K_NOT);
					setState(273);
					match(K_NULL);
					}
					break;
				case K_NOTNULL:
					{
					setState(274);
					match(K_NOTNULL);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 6:
				{
				_localctx = new IsOrNotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				expression(0);
				setState(278);
				match(K_IS);
				setState(280);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(279);
					match(K_NOT);
					}
					break;
				}
				setState(282);
				expression(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(292);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new AndExpressionContext(new ConditionExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionExpression);
						setState(286);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(287);
						match(K_AND);
						setState(288);
						conditionExpression(6);
						}
						break;
					case 2:
						{
						_localctx = new OrExpressionContext(new ConditionExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionExpression);
						setState(289);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(290);
						match(K_OR);
						setState(291);
						conditionExpression(5);
						}
						break;
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
		enterRule(_localctx, 30, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__15))) != 0)) ) {
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
		enterRule(_localctx, 32, RULE_literalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
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
		enterRule(_localctx, 34, RULE_selectTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(K_SELECT);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_DISTINCT || _la==K_ALL) {
				{
				setState(302);
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

			setState(305);
			resultColumn();
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(306);
				match(T__3);
				setState(307);
				resultColumn();
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_FROM) {
				{
				setState(313);
				match(K_FROM);
				setState(323);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
				case 1:
					{
					setState(314);
					tableName();
					setState(319);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(315);
						match(T__3);
						setState(316);
						tableName();
						}
						}
						setState(321);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(322);
					joinClause();
					}
					break;
				}
				}
			}

			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(327);
				match(K_WHERE);
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
		enterRule(_localctx, 36, RULE_resultColumn);
		try {
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(T__16);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(333);
				tableName();
				setState(334);
				match(T__1);
				setState(335);
				match(T__16);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(337);
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
		enterRule(_localctx, 38, RULE_joinClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			tableName();
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << K_JOIN) | (1L << K_NATURAL) | (1L << K_LEFT) | (1L << K_INNER))) != 0)) {
				{
				{
				setState(341);
				joinOperator();
				setState(342);
				tableName();
				setState(343);
				joinConstraint();
				}
				}
				setState(349);
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
		enterRule(_localctx, 40, RULE_joinConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ON) {
				{
				setState(350);
				match(K_ON);
				setState(351);
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
		enterRule(_localctx, 42, RULE_joinOperator);
		int _la;
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(354);
				match(T__3);
				}
				break;
			case K_JOIN:
			case K_NATURAL:
			case K_LEFT:
			case K_INNER:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(355);
					match(K_NATURAL);
					}
				}

				setState(363);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(358);
					match(K_LEFT);
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(359);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(362);
					match(K_INNER);
					}
					break;
				case K_JOIN:
					break;
				default:
					break;
				}
				setState(365);
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
		enterRule(_localctx, 44, RULE_updateTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(K_UPDATE);
			setState(369);
			tableName();
			setState(370);
			match(K_SET);
			setState(371);
			columnName();
			setState(372);
			match(T__11);
			setState(373);
			expression(0);
			setState(381);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(374);
				match(T__3);
				setState(375);
				columnName();
				setState(376);
				match(T__11);
				setState(377);
				expression(0);
				}
				}
				setState(383);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(384);
				match(K_WHERE);
				setState(385);
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
		enterRule(_localctx, 46, RULE_deleteTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388);
			match(K_DELETE);
			setState(389);
			match(K_FROM);
			setState(390);
			tableName();
			setState(391);
			match(K_WHERE);
			setState(392);
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
		enterRule(_localctx, 48, RULE_dropDatabaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(K_DROP);
			setState(395);
			match(K_DATABASE);
			setState(396);
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
		enterRule(_localctx, 50, RULE_dropTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			match(K_DROP);
			setState(399);
			match(K_TABLE);
			setState(400);
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
		enterRule(_localctx, 52, RULE_useDatabaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			match(K_USE);
			setState(403);
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
		enterRule(_localctx, 54, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			name();
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(406);
				match(T__2);
				setState(407);
				signedNumber();
				setState(408);
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
		enterRule(_localctx, 56, RULE_signedNumber);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
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
		enterRule(_localctx, 58, RULE_columnConstraint);
		int _la;
		try {
			setState(421);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_PRIMARY:
				enterOuterAlt(_localctx, 1);
				{
				setState(414);
				match(K_PRIMARY);
				setState(415);
				match(K_KEY);
				setState(417);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ASC || _la==K_DESC) {
					{
					setState(416);
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
				setState(419);
				match(K_NOT);
				setState(420);
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
		enterRule(_localctx, 60, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
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
		enterRule(_localctx, 62, RULE_databaseName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
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
		enterRule(_localctx, 64, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
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
		enterRule(_localctx, 66, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
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
		enterRule(_localctx, 68, RULE_anyName);
		try {
			setState(433);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(431);
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
			case K_IS:
			case K_ISNULL:
			case K_NOTNULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(432);
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
		public TerminalNode K_IS() { return getToken(TinySQLParser.K_IS, 0); }
		public TerminalNode K_ISNULL() { return getToken(TinySQLParser.K_ISNULL, 0); }
		public TerminalNode K_NOTNULL() { return getToken(TinySQLParser.K_NOTNULL, 0); }
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
		enterRule(_localctx, 70, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CREATE) | (1L << K_DATABASE) | (1L << K_TABLE) | (1L << K_DROP) | (1L << K_SELECT) | (1L << K_UPDATE) | (1L << K_DELETE) | (1L << K_INSERT) | (1L << K_PRIMARY) | (1L << K_KEY) | (1L << K_NOT) | (1L << K_NULL) | (1L << K_WHERE) | (1L << K_INTO) | (1L << K_FROM) | (1L << K_USE) | (1L << K_ASC) | (1L << K_DESC) | (1L << K_VALUES) | (1L << K_DATABASES) | (1L << K_SHOW) | (1L << K_LEFT) | (1L << K_INNER) | (1L << K_SET) | (1L << K_AND) | (1L << K_OR) | (1L << K_IS) | (1L << K_ISNULL) | (1L << K_NOTNULL))) != 0)) ) {
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
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 14:
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
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3=\u01b8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\7\2M\n\2\f\2\16\2P\13\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\4\7\4X\n\4\f\4\16\4[\13\4\3\4\3\4\6\4_\n\4\r\4\16\4`\3"+
		"\4\7\4d\n\4\f\4\16\4g\13\4\3\4\7\4j\n\4\f\4\16\4m\13\4\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5{\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\n\u0091\n\n\3\n"+
		"\3\n\3\n\3\n\3\n\7\n\u0098\n\n\f\n\16\n\u009b\13\n\3\n\3\n\5\n\u009f\n"+
		"\n\3\n\3\n\3\13\3\13\3\13\7\13\u00a6\n\13\f\13\16\13\u00a9\13\13\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\7\f\u00b2\n\f\f\f\16\f\u00b5\13\f\3\f\3\f\3\r\3"+
		"\r\5\r\u00bb\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00c4\n\16\f"+
		"\16\16\16\u00c7\13\16\3\16\3\16\5\16\u00cb\n\16\3\16\3\16\3\16\3\16\3"+
		"\16\7\16\u00d2\n\16\f\16\16\16\u00d5\13\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\7\16\u00dd\n\16\f\16\16\16\u00e0\13\16\3\16\3\16\7\16\u00e4\n\16\f"+
		"\16\16\16\u00e7\13\16\3\17\3\17\3\17\3\17\3\17\5\17\u00ee\n\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00f8\n\17\3\17\3\17\3\17\7\17"+
		"\u00fd\n\17\f\17\16\17\u0100\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u0116\n\20\3\20\3\20\3\20\5\20\u011b\n\20\3\20\3\20\5\20\u011f\n\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\7\20\u0127\n\20\f\20\16\20\u012a\13\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\5\23\u0132\n\23\3\23\3\23\3\23\7\23\u0137"+
		"\n\23\f\23\16\23\u013a\13\23\3\23\3\23\3\23\3\23\7\23\u0140\n\23\f\23"+
		"\16\23\u0143\13\23\3\23\5\23\u0146\n\23\5\23\u0148\n\23\3\23\3\23\5\23"+
		"\u014c\n\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u0155\n\24\3\25\3"+
		"\25\3\25\3\25\3\25\7\25\u015c\n\25\f\25\16\25\u015f\13\25\3\26\3\26\5"+
		"\26\u0163\n\26\3\27\3\27\5\27\u0167\n\27\3\27\3\27\5\27\u016b\n\27\3\27"+
		"\5\27\u016e\n\27\3\27\5\27\u0171\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\7\30\u017e\n\30\f\30\16\30\u0181\13\30\3\30\3"+
		"\30\5\30\u0185\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\5\35\u019d"+
		"\n\35\3\36\3\36\3\37\3\37\3\37\5\37\u01a4\n\37\3\37\3\37\5\37\u01a8\n"+
		"\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\5$\u01b4\n$\3%\3%\3%\2\4\34\36&\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2"+
		"\n\3\2)*\3\2\b\t\3\2\n\r\3\2\16\21\4\2\b\t\22\22\5\2\24\24\30\30$$\3\2"+
		"\61\62\4\2\31-\64;\2\u01d3\2N\3\2\2\2\4S\3\2\2\2\6Y\3\2\2\2\bz\3\2\2\2"+
		"\n|\3\2\2\2\f\177\3\2\2\2\16\u0083\3\2\2\2\20\u0087\3\2\2\2\22\u008b\3"+
		"\2\2\2\24\u00a2\3\2\2\2\26\u00aa\3\2\2\2\30\u00b8\3\2\2\2\32\u00bc\3\2"+
		"\2\2\34\u00f7\3\2\2\2\36\u011e\3\2\2\2 \u012b\3\2\2\2\"\u012d\3\2\2\2"+
		"$\u012f\3\2\2\2&\u0154\3\2\2\2(\u0156\3\2\2\2*\u0162\3\2\2\2,\u0170\3"+
		"\2\2\2.\u0172\3\2\2\2\60\u0186\3\2\2\2\62\u018c\3\2\2\2\64\u0190\3\2\2"+
		"\2\66\u0194\3\2\2\28\u0197\3\2\2\2:\u019e\3\2\2\2<\u01a7\3\2\2\2>\u01a9"+
		"\3\2\2\2@\u01ab\3\2\2\2B\u01ad\3\2\2\2D\u01af\3\2\2\2F\u01b3\3\2\2\2H"+
		"\u01b5\3\2\2\2JM\5\6\4\2KM\5\4\3\2LJ\3\2\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2"+
		"\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2QR\7\2\2\3R\3\3\2\2\2ST\7=\2\2TU\b\3"+
		"\1\2U\5\3\2\2\2VX\7\3\2\2WV\3\2\2\2X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\\\3"+
		"\2\2\2[Y\3\2\2\2\\e\5\b\5\2]_\7\3\2\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a"+
		"\3\2\2\2ab\3\2\2\2bd\5\b\5\2c^\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f"+
		"k\3\2\2\2ge\3\2\2\2hj\7\3\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2"+
		"l\7\3\2\2\2mk\3\2\2\2n{\5\20\t\2o{\5\n\6\2p{\5\f\7\2q{\5\16\b\2r{\5\22"+
		"\n\2s{\5\32\16\2t{\5$\23\2u{\5.\30\2v{\5\60\31\2w{\5\62\32\2x{\5\64\33"+
		"\2y{\5\66\34\2zn\3\2\2\2zo\3\2\2\2zp\3\2\2\2zq\3\2\2\2zr\3\2\2\2zs\3\2"+
		"\2\2zt\3\2\2\2zu\3\2\2\2zv\3\2\2\2zw\3\2\2\2zx\3\2\2\2zy\3\2\2\2{\t\3"+
		"\2\2\2|}\7-\2\2}~\7,\2\2~\13\3\2\2\2\177\u0080\7-\2\2\u0080\u0081\7\32"+
		"\2\2\u0081\u0082\5@!\2\u0082\r\3\2\2\2\u0083\u0084\7-\2\2\u0084\u0085"+
		"\7\33\2\2\u0085\u0086\5B\"\2\u0086\17\3\2\2\2\u0087\u0088\7\31\2\2\u0088"+
		"\u0089\7\32\2\2\u0089\u008a\5@!\2\u008a\21\3\2\2\2\u008b\u008c\7\31\2"+
		"\2\u008c\u0090\7\33\2\2\u008d\u008e\5@!\2\u008e\u008f\7\4\2\2\u008f\u0091"+
		"\3\2\2\2\u0090\u008d\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092"+
		"\u0093\5B\"\2\u0093\u0094\7\5\2\2\u0094\u0099\5\24\13\2\u0095\u0096\7"+
		"\6\2\2\u0096\u0098\5\24\13\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009e\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009c\u009d\7\6\2\2\u009d\u009f\5\26\f\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\7\2\2\u00a1\23\3\2\2"+
		"\2\u00a2\u00a3\5D#\2\u00a3\u00a7\58\35\2\u00a4\u00a6\5<\37\2\u00a5\u00a4"+
		"\3\2\2\2\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8"+
		"\25\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ab\7!\2\2\u00ab\u00ac\7\"\2\2"+
		"\u00ac\u00ad\3\2\2\2\u00ad\u00ae\7\5\2\2\u00ae\u00b3\5\30\r\2\u00af\u00b0"+
		"\7\6\2\2\u00b0\u00b2\5\30\r\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2"+
		"\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00b3"+
		"\3\2\2\2\u00b6\u00b7\7\7\2\2\u00b7\27\3\2\2\2\u00b8\u00ba\5D#\2\u00b9"+
		"\u00bb\t\2\2\2\u00ba\u00b9\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\31\3\2\2"+
		"\2\u00bc\u00bd\7 \2\2\u00bd\u00be\7&\2\2\u00be\u00ca\5B\"\2\u00bf\u00c0"+
		"\7\5\2\2\u00c0\u00c5\5D#\2\u00c1\u00c2\7\6\2\2\u00c2\u00c4\5D#\2\u00c3"+
		"\u00c1\3\2\2\2\u00c4\u00c7\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00c8\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c8\u00c9\7\7\2\2\u00c9"+
		"\u00cb\3\2\2\2\u00ca\u00bf\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00cd\7+\2\2\u00cd\u00ce\7\5\2\2\u00ce\u00d3\5\34\17\2\u00cf"+
		"\u00d0\7\6\2\2\u00d0\u00d2\5\34\17\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3"+
		"\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5"+
		"\u00d3\3\2\2\2\u00d6\u00e5\7\7\2\2\u00d7\u00d8\7\6\2\2\u00d8\u00d9\7\5"+
		"\2\2\u00d9\u00de\5\34\17\2\u00da\u00db\7\6\2\2\u00db\u00dd\5\34\17\2\u00dc"+
		"\u00da\3\2\2\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2"+
		"\2\2\u00df\u00e1\3\2\2\2\u00e0\u00de\3\2\2\2\u00e1\u00e2\7\7\2\2\u00e2"+
		"\u00e4\3\2\2\2\u00e3\u00d7\3\2\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2"+
		"\2\2\u00e5\u00e6\3\2\2\2\u00e6\33\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e8\u00e9"+
		"\b\17\1\2\u00e9\u00f8\5\"\22\2\u00ea\u00eb\5B\"\2\u00eb\u00ec\7\4\2\2"+
		"\u00ec\u00ee\3\2\2\2\u00ed\u00ea\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef\u00f8\5D#\2\u00f0\u00f1\5 \21\2\u00f1\u00f2\5\34\17\5\u00f2"+
		"\u00f8\3\2\2\2\u00f3\u00f4\7\5\2\2\u00f4\u00f5\5\34\17\2\u00f5\u00f6\7"+
		"\7\2\2\u00f6\u00f8\3\2\2\2\u00f7\u00e8\3\2\2\2\u00f7\u00ed\3\2\2\2\u00f7"+
		"\u00f0\3\2\2\2\u00f7\u00f3\3\2\2\2\u00f8\u00fe\3\2\2\2\u00f9\u00fa\f\4"+
		"\2\2\u00fa\u00fb\t\3\2\2\u00fb\u00fd\5\34\17\5\u00fc\u00f9\3\2\2\2\u00fd"+
		"\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\35\3\2\2"+
		"\2\u0100\u00fe\3\2\2\2\u0101\u0102\b\20\1\2\u0102\u0103\5\34\17\2\u0103"+
		"\u0104\t\4\2\2\u0104\u0105\5\34\17\2\u0105\u011f\3\2\2\2\u0106\u0107\5"+
		"\34\17\2\u0107\u0108\t\5\2\2\u0108\u0109\5\34\17\2\u0109\u011f\3\2\2\2"+
		"\u010a\u010b\7\5\2\2\u010b\u010c\5\36\20\2\u010c\u010d\7\7\2\2\u010d\u011f"+
		"\3\2\2\2\u010e\u010f\5\34\17\2\u010f\u0110\7:\2\2\u0110\u011f\3\2\2\2"+
		"\u0111\u0115\5\34\17\2\u0112\u0113\7#\2\2\u0113\u0116\7$\2\2\u0114\u0116"+
		"\7;\2\2\u0115\u0112\3\2\2\2\u0115\u0114\3\2\2\2\u0116\u011f\3\2\2\2\u0117"+
		"\u0118\5\34\17\2\u0118\u011a\79\2\2\u0119\u011b\7#\2\2\u011a\u0119\3\2"+
		"\2\2\u011a\u011b\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011d\5\34\17\2\u011d"+
		"\u011f\3\2\2\2\u011e\u0101\3\2\2\2\u011e\u0106\3\2\2\2\u011e\u010a\3\2"+
		"\2\2\u011e\u010e\3\2\2\2\u011e\u0111\3\2\2\2\u011e\u0117\3\2\2\2\u011f"+
		"\u0128\3\2\2\2\u0120\u0121\f\7\2\2\u0121\u0122\7\67\2\2\u0122\u0127\5"+
		"\36\20\b\u0123\u0124\f\6\2\2\u0124\u0125\78\2\2\u0125\u0127\5\36\20\7"+
		"\u0126\u0120\3\2\2\2\u0126\u0123\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126"+
		"\3\2\2\2\u0128\u0129\3\2\2\2\u0129\37\3\2\2\2\u012a\u0128\3\2\2\2\u012b"+
		"\u012c\t\6\2\2\u012c!\3\2\2\2\u012d\u012e\t\7\2\2\u012e#\3\2\2\2\u012f"+
		"\u0131\7\35\2\2\u0130\u0132\t\b\2\2\u0131\u0130\3\2\2\2\u0131\u0132\3"+
		"\2\2\2\u0132\u0133\3\2\2\2\u0133\u0138\5&\24\2\u0134\u0135\7\6\2\2\u0135"+
		"\u0137\5&\24\2\u0136\u0134\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2"+
		"\2\2\u0138\u0139\3\2\2\2\u0139\u0147\3\2\2\2\u013a\u0138\3\2\2\2\u013b"+
		"\u0145\7\'\2\2\u013c\u0141\5B\"\2\u013d\u013e\7\6\2\2\u013e\u0140\5B\""+
		"\2\u013f\u013d\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142"+
		"\3\2\2\2\u0142\u0146\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0146\5(\25\2\u0145"+
		"\u013c\3\2\2\2\u0145\u0144\3\2\2\2\u0146\u0148\3\2\2\2\u0147\u013b\3\2"+
		"\2\2\u0147\u0148\3\2\2\2\u0148\u014b\3\2\2\2\u0149\u014a\7%\2\2\u014a"+
		"\u014c\5\36\20\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c%\3\2\2"+
		"\2\u014d\u0155\3\2\2\2\u014e\u0155\7\23\2\2\u014f\u0150\5B\"\2\u0150\u0151"+
		"\7\4\2\2\u0151\u0152\7\23\2\2\u0152\u0155\3\2\2\2\u0153\u0155\5\34\17"+
		"\2\u0154\u014d\3\2\2\2\u0154\u014e\3\2\2\2\u0154\u014f\3\2\2\2\u0154\u0153"+
		"\3\2\2\2\u0155\'\3\2\2\2\u0156\u015d\5B\"\2\u0157\u0158\5,\27\2\u0158"+
		"\u0159\5B\"\2\u0159\u015a\5*\26\2\u015a\u015c\3\2\2\2\u015b\u0157\3\2"+
		"\2\2\u015c\u015f\3\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e"+
		")\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161\7.\2\2\u0161\u0163\5\36\20\2"+
		"\u0162\u0160\3\2\2\2\u0162\u0163\3\2\2\2\u0163+\3\2\2\2\u0164\u0171\7"+
		"\6\2\2\u0165\u0167\7\60\2\2\u0166\u0165\3\2\2\2\u0166\u0167\3\2\2\2\u0167"+
		"\u016d\3\2\2\2\u0168\u016a\7\64\2\2\u0169\u016b\7\63\2\2\u016a\u0169\3"+
		"\2\2\2\u016a\u016b\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016e\7\65\2\2\u016d"+
		"\u0168\3\2\2\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016e\u016f\3\2"+
		"\2\2\u016f\u0171\7/\2\2\u0170\u0164\3\2\2\2\u0170\u0166\3\2\2\2\u0171"+
		"-\3\2\2\2\u0172\u0173\7\36\2\2\u0173\u0174\5B\"\2\u0174\u0175\7\66\2\2"+
		"\u0175\u0176\5D#\2\u0176\u0177\7\16\2\2\u0177\u017f\5\34\17\2\u0178\u0179"+
		"\7\6\2\2\u0179\u017a\5D#\2\u017a\u017b\7\16\2\2\u017b\u017c\5\34\17\2"+
		"\u017c\u017e\3\2\2\2\u017d\u0178\3\2\2\2\u017e\u0181\3\2\2\2\u017f\u017d"+
		"\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0184\3\2\2\2\u0181\u017f\3\2\2\2\u0182"+
		"\u0183\7%\2\2\u0183\u0185\5\36\20\2\u0184\u0182\3\2\2\2\u0184\u0185\3"+
		"\2\2\2\u0185/\3\2\2\2\u0186\u0187\7\37\2\2\u0187\u0188\7\'\2\2\u0188\u0189"+
		"\5B\"\2\u0189\u018a\7%\2\2\u018a\u018b\5\36\20\2\u018b\61\3\2\2\2\u018c"+
		"\u018d\7\34\2\2\u018d\u018e\7\32\2\2\u018e\u018f\5@!\2\u018f\63\3\2\2"+
		"\2\u0190\u0191\7\34\2\2\u0191\u0192\7\33\2\2\u0192\u0193\5B\"\2\u0193"+
		"\65\3\2\2\2\u0194\u0195\7(\2\2\u0195\u0196\5@!\2\u0196\67\3\2\2\2\u0197"+
		"\u019c\5> \2\u0198\u0199\7\5\2\2\u0199\u019a\5:\36\2\u019a\u019b\7\7\2"+
		"\2\u019b\u019d\3\2\2\2\u019c\u0198\3\2\2\2\u019c\u019d\3\2\2\2\u019d9"+
		"\3\2\2\2\u019e\u019f\7\30\2\2\u019f;\3\2\2\2\u01a0\u01a1\7!\2\2\u01a1"+
		"\u01a3\7\"\2\2\u01a2\u01a4\t\2\2\2\u01a3\u01a2\3\2\2\2\u01a3\u01a4\3\2"+
		"\2\2\u01a4\u01a8\3\2\2\2\u01a5\u01a6\7#\2\2\u01a6\u01a8\7$\2\2\u01a7\u01a0"+
		"\3\2\2\2\u01a7\u01a5\3\2\2\2\u01a8=\3\2\2\2\u01a9\u01aa\5F$\2\u01aa?\3"+
		"\2\2\2\u01ab\u01ac\5F$\2\u01acA\3\2\2\2\u01ad\u01ae\5F$\2\u01aeC\3\2\2"+
		"\2\u01af\u01b0\5F$\2\u01b0E\3\2\2\2\u01b1\u01b4\7<\2\2\u01b2\u01b4\5H"+
		"%\2\u01b3\u01b1\3\2\2\2\u01b3\u01b2\3\2\2\2\u01b4G\3\2\2\2\u01b5\u01b6"+
		"\t\t\2\2\u01b6I\3\2\2\2/LNY`ekz\u0090\u0099\u009e\u00a7\u00b3\u00ba\u00c5"+
		"\u00ca\u00d3\u00de\u00e5\u00ed\u00f7\u00fe\u0115\u011a\u011e\u0126\u0128"+
		"\u0131\u0138\u0141\u0145\u0147\u014b\u0154\u015d\u0162\u0166\u016a\u016d"+
		"\u0170\u017f\u0184\u019c\u01a3\u01a7\u01b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}