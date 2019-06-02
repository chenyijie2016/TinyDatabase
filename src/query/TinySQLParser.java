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
		K_SET=52, UNEXPECTED_CHAR=53, IDENTIFIER=54;
	public static final int
		RULE_parse = 0, RULE_error = 1, RULE_sqlStatementList = 2, RULE_sqlStatement = 3, 
		RULE_showDatabasesStmt = 4, RULE_showDatabaseTablesStmt = 5, RULE_createDatabaseStmt = 6, 
		RULE_createTableStmt = 7, RULE_columnDefinition = 8, RULE_tableConstraint = 9, 
		RULE_indexedColumn = 10, RULE_insertTableStmt = 11, RULE_expression = 12, 
		RULE_unaryOperator = 13, RULE_literalValue = 14, RULE_selectTableStmt = 15, 
		RULE_resultColumn = 16, RULE_joinClause = 17, RULE_joinConstraint = 18, 
		RULE_joinOperator = 19, RULE_updateTableStmt = 20, RULE_deleteTableStmt = 21, 
		RULE_dropDatabaseStmt = 22, RULE_dropTableStmt = 23, RULE_useDatabaseStmt = 24, 
		RULE_typeName = 25, RULE_signedNumber = 26, RULE_columnConstraint = 27, 
		RULE_name = 28, RULE_databaseName = 29, RULE_tableName = 30, RULE_columnName = 31, 
		RULE_anyName = 32, RULE_keyword = 33;
	private static String[] makeRuleNames() {
		return new String[] {
			"parse", "error", "sqlStatementList", "sqlStatement", "showDatabasesStmt", 
			"showDatabaseTablesStmt", "createDatabaseStmt", "createTableStmt", "columnDefinition", 
			"tableConstraint", "indexedColumn", "insertTableStmt", "expression", 
			"unaryOperator", "literalValue", "selectTableStmt", "resultColumn", "joinClause", 
			"joinConstraint", "joinOperator", "updateTableStmt", "deleteTableStmt", 
			"dropDatabaseStmt", "dropTableStmt", "useDatabaseStmt", "typeName", "signedNumber", 
			"columnConstraint", "name", "databaseName", "tableName", "columnName", 
			"anyName", "keyword"
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
			"K_SET", "UNEXPECTED_CHAR", "IDENTIFIER"
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
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << K_CREATE) | (1L << K_DROP) | (1L << K_SELECT) | (1L << K_UPDATE) | (1L << K_DELETE) | (1L << K_INSERT) | (1L << K_USE) | (1L << K_SHOW) | (1L << UNEXPECTED_CHAR))) != 0)) {
				{
				setState(70);
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
					setState(68);
					sqlStatementList();
					}
					break;
				case UNEXPECTED_CHAR:
					{
					setState(69);
					error();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
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
			setState(77);
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
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(80);
				match(T__0);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			sqlStatement();
			setState(95);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(87);
						match(T__0);
						}
						}
						setState(90); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__0 );
					setState(92);
					sqlStatement();
					}
					} 
				}
				setState(97);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(98);
					match(T__0);
					}
					} 
				}
				setState(103);
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
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				createDatabaseStmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				showDatabasesStmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				showDatabaseTablesStmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				createTableStmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				insertTableStmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				selectTableStmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(110);
				updateTableStmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(111);
				deleteTableStmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(112);
				dropDatabaseStmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(113);
				dropTableStmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(114);
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
			setState(117);
			match(K_SHOW);
			setState(118);
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
			setState(120);
			match(K_SHOW);
			setState(121);
			match(K_DATABASE);
			setState(122);
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
			setState(124);
			match(K_CREATE);
			setState(125);
			match(K_DATABASE);
			setState(126);
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
			setState(128);
			match(K_CREATE);
			setState(129);
			match(K_TABLE);
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(130);
				databaseName();
				setState(131);
				match(T__1);
				}
				break;
			}
			setState(135);
			tableName();
			{
			setState(136);
			match(T__2);
			setState(137);
			columnDefinition();
			setState(142);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(138);
					match(T__3);
					setState(139);
					columnDefinition();
					}
					} 
				}
				setState(144);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(145);
				match(T__3);
				setState(146);
				tableConstraint();
				}
			}

			setState(149);
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
			setState(151);
			columnName();
			setState(152);
			typeName();
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_PRIMARY || _la==K_NOT) {
				{
				{
				setState(153);
				columnConstraint();
				}
				}
				setState(158);
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
			setState(159);
			match(K_PRIMARY);
			setState(160);
			match(K_KEY);
			}
			setState(162);
			match(T__2);
			setState(163);
			indexedColumn();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(164);
				match(T__3);
				setState(165);
				indexedColumn();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(171);
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
			setState(173);
			columnName();
			setState(175);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ASC || _la==K_DESC) {
				{
				setState(174);
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
			setState(177);
			match(K_INSERT);
			setState(178);
			match(K_INTO);
			setState(179);
			tableName();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(180);
				match(T__2);
				setState(181);
				columnName();
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(182);
					match(T__3);
					setState(183);
					columnName();
					}
					}
					setState(188);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(189);
				match(T__4);
				}
			}

			{
			setState(193);
			match(K_VALUES);
			setState(194);
			match(T__2);
			setState(195);
			expression(0);
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(196);
				match(T__3);
				setState(197);
				expression(0);
				}
				}
				setState(202);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(203);
			match(T__4);
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(204);
				match(T__3);
				setState(205);
				match(T__2);
				setState(206);
				expression(0);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(207);
					match(T__3);
					setState(208);
					expression(0);
					}
					}
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(214);
				match(T__4);
				}
				}
				setState(220);
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
	public static class LessZGreaterExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LessZGreaterExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterLessZGreaterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitLessZGreaterExpression(this);
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
	public static class EuqalExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EuqalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterEuqalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitEuqalExpression(this);
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
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				{
				_localctx = new ValueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(222);
				literalValue();
				}
				break;
			case 2:
				{
				_localctx = new TableColumnExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(223);
					tableName();
					setState(224);
					match(T__1);
					}
					break;
				}
				setState(228);
				columnName();
				}
				break;
			case 3:
				{
				_localctx = new UnaryExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				unaryOperator();
				setState(230);
				expression(5);
				}
				break;
			case 4:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(T__2);
				setState(233);
				expression(0);
				setState(234);
				match(T__4);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(249);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(247);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new AddSubExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(239);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(240);
						expression(5);
						}
						break;
					case 2:
						{
						_localctx = new LessZGreaterExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(241);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(242);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(243);
						expression(4);
						}
						break;
					case 3:
						{
						_localctx = new EuqalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(245);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(246);
						expression(3);
						}
						break;
					}
					} 
				}
				setState(251);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		enterRule(_localctx, 26, RULE_unaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
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
		enterRule(_localctx, 28, RULE_literalValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 30, RULE_selectTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(K_SELECT);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_DISTINCT || _la==K_ALL) {
				{
				setState(257);
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

			setState(260);
			resultColumn();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(261);
				match(T__3);
				setState(262);
				resultColumn();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_FROM) {
				{
				setState(268);
				match(K_FROM);
				setState(278);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
				case 1:
					{
					setState(269);
					tableName();
					setState(274);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__3) {
						{
						{
						setState(270);
						match(T__3);
						setState(271);
						tableName();
						}
						}
						setState(276);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				case 2:
					{
					setState(277);
					joinClause();
					}
					break;
				}
				}
			}

			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(282);
				match(K_WHERE);
				setState(283);
				expression(0);
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
		enterRule(_localctx, 32, RULE_resultColumn);
		try {
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(287);
				match(T__16);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(288);
				tableName();
				setState(289);
				match(T__1);
				setState(290);
				match(T__16);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(292);
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
		enterRule(_localctx, 34, RULE_joinClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(295);
			tableName();
			setState(302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << K_JOIN) | (1L << K_NATURAL) | (1L << K_LEFT) | (1L << K_INNER))) != 0)) {
				{
				{
				setState(296);
				joinOperator();
				setState(297);
				tableName();
				setState(298);
				joinConstraint();
				}
				}
				setState(304);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 36, RULE_joinConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_ON) {
				{
				setState(305);
				match(K_ON);
				setState(306);
				expression(0);
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
		enterRule(_localctx, 38, RULE_joinOperator);
		int _la;
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(309);
				match(T__3);
				}
				break;
			case K_JOIN:
			case K_NATURAL:
			case K_LEFT:
			case K_INNER:
				enterOuterAlt(_localctx, 2);
				{
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_NATURAL) {
					{
					setState(310);
					match(K_NATURAL);
					}
				}

				setState(318);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case K_LEFT:
					{
					setState(313);
					match(K_LEFT);
					setState(315);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==K_OUTER) {
						{
						setState(314);
						match(K_OUTER);
						}
					}

					}
					break;
				case K_INNER:
					{
					setState(317);
					match(K_INNER);
					}
					break;
				case K_JOIN:
					break;
				default:
					break;
				}
				setState(320);
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
		enterRule(_localctx, 40, RULE_updateTableStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			match(K_UPDATE);
			setState(324);
			tableName();
			setState(325);
			match(K_SET);
			setState(326);
			columnName();
			setState(327);
			match(T__11);
			setState(328);
			expression(0);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(329);
				match(T__3);
				setState(330);
				columnName();
				setState(331);
				match(T__11);
				setState(332);
				expression(0);
				}
				}
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(341);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==K_WHERE) {
				{
				setState(339);
				match(K_WHERE);
				setState(340);
				expression(0);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
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
		enterRule(_localctx, 42, RULE_deleteTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343);
			match(K_DELETE);
			setState(344);
			match(K_FROM);
			setState(345);
			tableName();
			setState(346);
			match(K_WHERE);
			setState(347);
			expression(0);
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
		enterRule(_localctx, 44, RULE_dropDatabaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(K_DROP);
			setState(350);
			match(K_DATABASE);
			setState(351);
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
		enterRule(_localctx, 46, RULE_dropTableStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			match(K_DROP);
			setState(354);
			match(K_TABLE);
			setState(355);
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
		enterRule(_localctx, 48, RULE_useDatabaseStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			match(K_USE);
			setState(358);
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
		enterRule(_localctx, 50, RULE_typeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			name();
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(361);
				match(T__2);
				setState(362);
				signedNumber();
				setState(363);
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
		enterRule(_localctx, 52, RULE_signedNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5 || _la==T__6) {
				{
				setState(367);
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

			setState(370);
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
		enterRule(_localctx, 54, RULE_columnConstraint);
		int _la;
		try {
			setState(379);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_PRIMARY:
				enterOuterAlt(_localctx, 1);
				{
				setState(372);
				match(K_PRIMARY);
				setState(373);
				match(K_KEY);
				setState(375);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==K_ASC || _la==K_DESC) {
					{
					setState(374);
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
				setState(377);
				match(K_NOT);
				setState(378);
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
		enterRule(_localctx, 56, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
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
		enterRule(_localctx, 58, RULE_databaseName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
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
		enterRule(_localctx, 60, RULE_tableName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
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
		enterRule(_localctx, 62, RULE_columnName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
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
		enterRule(_localctx, 64, RULE_anyName);
		try {
			setState(391);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(389);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
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
		enterRule(_localctx, 66, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CREATE) | (1L << K_DATABASE) | (1L << K_TABLE) | (1L << K_DROP) | (1L << K_SELECT) | (1L << K_UPDATE) | (1L << K_DELETE) | (1L << K_INSERT) | (1L << K_PRIMARY) | (1L << K_KEY) | (1L << K_NOT) | (1L << K_NULL) | (1L << K_WHERE) | (1L << K_INTO) | (1L << K_FROM) | (1L << K_USE) | (1L << K_ASC) | (1L << K_DESC) | (1L << K_VALUES) | (1L << K_DATABASES) | (1L << K_SHOW) | (1L << K_LEFT) | (1L << K_INNER) | (1L << K_SET))) != 0)) ) {
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
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u018e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\7\2I\n\2\f\2\16\2L\13\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\4\7\4T\n\4\f\4\16\4W\13\4\3\4\3\4\6\4[\n\4\r\4\16\4\\\3\4\7\4`\n\4"+
		"\f\4\16\4c\13\4\3\4\7\4f\n\4\f\4\16\4i\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\5\5v\n\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\5\t\u0088\n\t\3\t\3\t\3\t\3\t\3\t\7\t\u008f\n\t"+
		"\f\t\16\t\u0092\13\t\3\t\3\t\5\t\u0096\n\t\3\t\3\t\3\n\3\n\3\n\7\n\u009d"+
		"\n\n\f\n\16\n\u00a0\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u00a9"+
		"\n\13\f\13\16\13\u00ac\13\13\3\13\3\13\3\f\3\f\5\f\u00b2\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\7\r\u00bb\n\r\f\r\16\r\u00be\13\r\3\r\3\r\5\r\u00c2"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c9\n\r\f\r\16\r\u00cc\13\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\7\r\u00d4\n\r\f\r\16\r\u00d7\13\r\3\r\3\r\7\r\u00db\n\r\f"+
		"\r\16\r\u00de\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u00e5\n\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00ef\n\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u00fa\n\16\f\16\16\16\u00fd\13\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\5\21\u0105\n\21\3\21\3\21\3\21\7\21\u010a\n\21\f"+
		"\21\16\21\u010d\13\21\3\21\3\21\3\21\3\21\7\21\u0113\n\21\f\21\16\21\u0116"+
		"\13\21\3\21\5\21\u0119\n\21\5\21\u011b\n\21\3\21\3\21\5\21\u011f\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u0128\n\22\3\23\3\23\3\23\3\23"+
		"\3\23\7\23\u012f\n\23\f\23\16\23\u0132\13\23\3\24\3\24\5\24\u0136\n\24"+
		"\3\25\3\25\5\25\u013a\n\25\3\25\3\25\5\25\u013e\n\25\3\25\5\25\u0141\n"+
		"\25\3\25\5\25\u0144\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\7\26\u0151\n\26\f\26\16\26\u0154\13\26\3\26\3\26\5\26\u0158"+
		"\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5\33\u0170\n\33\3\34\5\34"+
		"\u0173\n\34\3\34\3\34\3\35\3\35\3\35\5\35\u017a\n\35\3\35\3\35\5\35\u017e"+
		"\n\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\5\"\u018a\n\"\3#\3#\3#\2"+
		"\3\32$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<"+
		">@BD\2\n\3\2)*\3\2\b\t\3\2\n\r\3\2\16\21\5\2\b\t\22\22##\5\2\24\24\30"+
		"\30$$\3\2\61\62\4\2\31-\64\66\2\u01a4\2J\3\2\2\2\4O\3\2\2\2\6U\3\2\2\2"+
		"\bu\3\2\2\2\nw\3\2\2\2\fz\3\2\2\2\16~\3\2\2\2\20\u0082\3\2\2\2\22\u0099"+
		"\3\2\2\2\24\u00a1\3\2\2\2\26\u00af\3\2\2\2\30\u00b3\3\2\2\2\32\u00ee\3"+
		"\2\2\2\34\u00fe\3\2\2\2\36\u0100\3\2\2\2 \u0102\3\2\2\2\"\u0127\3\2\2"+
		"\2$\u0129\3\2\2\2&\u0135\3\2\2\2(\u0143\3\2\2\2*\u0145\3\2\2\2,\u0159"+
		"\3\2\2\2.\u015f\3\2\2\2\60\u0163\3\2\2\2\62\u0167\3\2\2\2\64\u016a\3\2"+
		"\2\2\66\u0172\3\2\2\28\u017d\3\2\2\2:\u017f\3\2\2\2<\u0181\3\2\2\2>\u0183"+
		"\3\2\2\2@\u0185\3\2\2\2B\u0189\3\2\2\2D\u018b\3\2\2\2FI\5\6\4\2GI\5\4"+
		"\3\2HF\3\2\2\2HG\3\2\2\2IL\3\2\2\2JH\3\2\2\2JK\3\2\2\2KM\3\2\2\2LJ\3\2"+
		"\2\2MN\7\2\2\3N\3\3\2\2\2OP\7\67\2\2PQ\b\3\1\2Q\5\3\2\2\2RT\7\3\2\2SR"+
		"\3\2\2\2TW\3\2\2\2US\3\2\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2Xa\5\b\5\2Y"+
		"[\7\3\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]^\3\2\2\2^`\5\b\5"+
		"\2_Z\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3\2\2\2bg\3\2\2\2ca\3\2\2\2df\7\3\2"+
		"\2ed\3\2\2\2fi\3\2\2\2ge\3\2\2\2gh\3\2\2\2h\7\3\2\2\2ig\3\2\2\2jv\5\16"+
		"\b\2kv\5\n\6\2lv\5\f\7\2mv\5\20\t\2nv\5\30\r\2ov\5 \21\2pv\5*\26\2qv\5"+
		",\27\2rv\5.\30\2sv\5\60\31\2tv\5\62\32\2uj\3\2\2\2uk\3\2\2\2ul\3\2\2\2"+
		"um\3\2\2\2un\3\2\2\2uo\3\2\2\2up\3\2\2\2uq\3\2\2\2ur\3\2\2\2us\3\2\2\2"+
		"ut\3\2\2\2v\t\3\2\2\2wx\7-\2\2xy\7,\2\2y\13\3\2\2\2z{\7-\2\2{|\7\32\2"+
		"\2|}\5<\37\2}\r\3\2\2\2~\177\7\31\2\2\177\u0080\7\32\2\2\u0080\u0081\5"+
		"<\37\2\u0081\17\3\2\2\2\u0082\u0083\7\31\2\2\u0083\u0087\7\33\2\2\u0084"+
		"\u0085\5<\37\2\u0085\u0086\7\4\2\2\u0086\u0088\3\2\2\2\u0087\u0084\3\2"+
		"\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008a\5> \2\u008a\u008b"+
		"\7\5\2\2\u008b\u0090\5\22\n\2\u008c\u008d\7\6\2\2\u008d\u008f\5\22\n\2"+
		"\u008e\u008c\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0095\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\7\6\2\2\u0094"+
		"\u0096\5\24\13\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3"+
		"\2\2\2\u0097\u0098\7\7\2\2\u0098\21\3\2\2\2\u0099\u009a\5@!\2\u009a\u009e"+
		"\5\64\33\2\u009b\u009d\58\35\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2"+
		"\u009e\u009c\3\2\2\2\u009e\u009f\3\2\2\2\u009f\23\3\2\2\2\u00a0\u009e"+
		"\3\2\2\2\u00a1\u00a2\7!\2\2\u00a2\u00a3\7\"\2\2\u00a3\u00a4\3\2\2\2\u00a4"+
		"\u00a5\7\5\2\2\u00a5\u00aa\5\26\f\2\u00a6\u00a7\7\6\2\2\u00a7\u00a9\5"+
		"\26\f\2\u00a8\u00a6\3\2\2\2\u00a9\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00ae\7\7"+
		"\2\2\u00ae\25\3\2\2\2\u00af\u00b1\5@!\2\u00b0\u00b2\t\2\2\2\u00b1\u00b0"+
		"\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\27\3\2\2\2\u00b3\u00b4\7 \2\2\u00b4"+
		"\u00b5\7&\2\2\u00b5\u00c1\5> \2\u00b6\u00b7\7\5\2\2\u00b7\u00bc\5@!\2"+
		"\u00b8\u00b9\7\6\2\2\u00b9\u00bb\5@!\2\u00ba\u00b8\3\2\2\2\u00bb\u00be"+
		"\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be"+
		"\u00bc\3\2\2\2\u00bf\u00c0\7\7\2\2\u00c0\u00c2\3\2\2\2\u00c1\u00b6\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\7+\2\2\u00c4"+
		"\u00c5\7\5\2\2\u00c5\u00ca\5\32\16\2\u00c6\u00c7\7\6\2\2\u00c7\u00c9\5"+
		"\32\16\2\u00c8\u00c6\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00dc\7\7"+
		"\2\2\u00ce\u00cf\7\6\2\2\u00cf\u00d0\7\5\2\2\u00d0\u00d5\5\32\16\2\u00d1"+
		"\u00d2\7\6\2\2\u00d2\u00d4\5\32\16\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7\3"+
		"\2\2\2\u00d5\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7"+
		"\u00d5\3\2\2\2\u00d8\u00d9\7\7\2\2\u00d9\u00db\3\2\2\2\u00da\u00ce\3\2"+
		"\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd"+
		"\31\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e0\b\16\1\2\u00e0\u00ef\5\36"+
		"\20\2\u00e1\u00e2\5> \2\u00e2\u00e3\7\4\2\2\u00e3\u00e5\3\2\2\2\u00e4"+
		"\u00e1\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00ef\5@"+
		"!\2\u00e7\u00e8\5\34\17\2\u00e8\u00e9\5\32\16\7\u00e9\u00ef\3\2\2\2\u00ea"+
		"\u00eb\7\5\2\2\u00eb\u00ec\5\32\16\2\u00ec\u00ed\7\7\2\2\u00ed\u00ef\3"+
		"\2\2\2\u00ee\u00df\3\2\2\2\u00ee\u00e4\3\2\2\2\u00ee\u00e7\3\2\2\2\u00ee"+
		"\u00ea\3\2\2\2\u00ef\u00fb\3\2\2\2\u00f0\u00f1\f\6\2\2\u00f1\u00f2\t\3"+
		"\2\2\u00f2\u00fa\5\32\16\7\u00f3\u00f4\f\5\2\2\u00f4\u00f5\t\4\2\2\u00f5"+
		"\u00fa\5\32\16\6\u00f6\u00f7\f\4\2\2\u00f7\u00f8\t\5\2\2\u00f8\u00fa\5"+
		"\32\16\5\u00f9\u00f0\3\2\2\2\u00f9\u00f3\3\2\2\2\u00f9\u00f6\3\2\2\2\u00fa"+
		"\u00fd\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\33\3\2\2"+
		"\2\u00fd\u00fb\3\2\2\2\u00fe\u00ff\t\6\2\2\u00ff\35\3\2\2\2\u0100\u0101"+
		"\t\7\2\2\u0101\37\3\2\2\2\u0102\u0104\7\35\2\2\u0103\u0105\t\b\2\2\u0104"+
		"\u0103\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u010b\5\""+
		"\22\2\u0107\u0108\7\6\2\2\u0108\u010a\5\"\22\2\u0109\u0107\3\2\2\2\u010a"+
		"\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u011a\3\2"+
		"\2\2\u010d\u010b\3\2\2\2\u010e\u0118\7\'\2\2\u010f\u0114\5> \2\u0110\u0111"+
		"\7\6\2\2\u0111\u0113\5> \2\u0112\u0110\3\2\2\2\u0113\u0116\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0119\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0117\u0119\5$\23\2\u0118\u010f\3\2\2\2\u0118\u0117\3\2\2\2\u0119"+
		"\u011b\3\2\2\2\u011a\u010e\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011e\3\2"+
		"\2\2\u011c\u011d\7%\2\2\u011d\u011f\5\32\16\2\u011e\u011c\3\2\2\2\u011e"+
		"\u011f\3\2\2\2\u011f!\3\2\2\2\u0120\u0128\3\2\2\2\u0121\u0128\7\23\2\2"+
		"\u0122\u0123\5> \2\u0123\u0124\7\4\2\2\u0124\u0125\7\23\2\2\u0125\u0128"+
		"\3\2\2\2\u0126\u0128\5\32\16\2\u0127\u0120\3\2\2\2\u0127\u0121\3\2\2\2"+
		"\u0127\u0122\3\2\2\2\u0127\u0126\3\2\2\2\u0128#\3\2\2\2\u0129\u0130\5"+
		"> \2\u012a\u012b\5(\25\2\u012b\u012c\5> \2\u012c\u012d\5&\24\2\u012d\u012f"+
		"\3\2\2\2\u012e\u012a\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131%\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\7.\2\2\u0134"+
		"\u0136\5\32\16\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136\'\3\2\2"+
		"\2\u0137\u0144\7\6\2\2\u0138\u013a\7\60\2\2\u0139\u0138\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u0140\3\2\2\2\u013b\u013d\7\64\2\2\u013c\u013e\7"+
		"\63\2\2\u013d\u013c\3\2\2\2\u013d\u013e\3\2\2\2\u013e\u0141\3\2\2\2\u013f"+
		"\u0141\7\65\2\2\u0140\u013b\3\2\2\2\u0140\u013f\3\2\2\2\u0140\u0141\3"+
		"\2\2\2\u0141\u0142\3\2\2\2\u0142\u0144\7/\2\2\u0143\u0137\3\2\2\2\u0143"+
		"\u0139\3\2\2\2\u0144)\3\2\2\2\u0145\u0146\7\36\2\2\u0146\u0147\5> \2\u0147"+
		"\u0148\7\66\2\2\u0148\u0149\5@!\2\u0149\u014a\7\16\2\2\u014a\u0152\5\32"+
		"\16\2\u014b\u014c\7\6\2\2\u014c\u014d\5@!\2\u014d\u014e\7\16\2\2\u014e"+
		"\u014f\5\32\16\2\u014f\u0151\3\2\2\2\u0150\u014b\3\2\2\2\u0151\u0154\3"+
		"\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0157\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0155\u0156\7%\2\2\u0156\u0158\5\32\16\2\u0157\u0155\3"+
		"\2\2\2\u0157\u0158\3\2\2\2\u0158+\3\2\2\2\u0159\u015a\7\37\2\2\u015a\u015b"+
		"\7\'\2\2\u015b\u015c\5> \2\u015c\u015d\7%\2\2\u015d\u015e\5\32\16\2\u015e"+
		"-\3\2\2\2\u015f\u0160\7\34\2\2\u0160\u0161\7\32\2\2\u0161\u0162\5<\37"+
		"\2\u0162/\3\2\2\2\u0163\u0164\7\34\2\2\u0164\u0165\7\33\2\2\u0165\u0166"+
		"\5> \2\u0166\61\3\2\2\2\u0167\u0168\7(\2\2\u0168\u0169\5<\37\2\u0169\63"+
		"\3\2\2\2\u016a\u016f\5:\36\2\u016b\u016c\7\5\2\2\u016c\u016d\5\66\34\2"+
		"\u016d\u016e\7\7\2\2\u016e\u0170\3\2\2\2\u016f\u016b\3\2\2\2\u016f\u0170"+
		"\3\2\2\2\u0170\65\3\2\2\2\u0171\u0173\t\3\2\2\u0172\u0171\3\2\2\2\u0172"+
		"\u0173\3\2\2\2\u0173\u0174\3\2\2\2\u0174\u0175\7\30\2\2\u0175\67\3\2\2"+
		"\2\u0176\u0177\7!\2\2\u0177\u0179\7\"\2\2\u0178\u017a\t\2\2\2\u0179\u0178"+
		"\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017e\3\2\2\2\u017b\u017c\7#\2\2\u017c"+
		"\u017e\7$\2\2\u017d\u0176\3\2\2\2\u017d\u017b\3\2\2\2\u017e9\3\2\2\2\u017f"+
		"\u0180\5B\"\2\u0180;\3\2\2\2\u0181\u0182\5B\"\2\u0182=\3\2\2\2\u0183\u0184"+
		"\5B\"\2\u0184?\3\2\2\2\u0185\u0186\5B\"\2\u0186A\3\2\2\2\u0187\u018a\7"+
		"8\2\2\u0188\u018a\5D#\2\u0189\u0187\3\2\2\2\u0189\u0188\3\2\2\2\u018a"+
		"C\3\2\2\2\u018b\u018c\t\t\2\2\u018cE\3\2\2\2,HJU\\agu\u0087\u0090\u0095"+
		"\u009e\u00aa\u00b1\u00bc\u00c1\u00ca\u00d5\u00dc\u00e4\u00ee\u00f9\u00fb"+
		"\u0104\u010b\u0114\u0118\u011a\u011e\u0127\u0130\u0135\u0139\u013d\u0140"+
		"\u0143\u0152\u0157\u016f\u0172\u0179\u017d\u0189";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}