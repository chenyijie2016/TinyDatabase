// Generated from C:/Users/cyj/Desktop/TinyDatabase/src/main/java/query\TinySQL.g4 by ANTLR 4.7.2
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, IDENTIFIER=7, SINGLE_LINE_COMMENT=8, 
		MULTILINE_COMMENT=9, SPACES=10, NUMERIC_LITERAL=11, K_CREATE=12, K_DATABASE=13, 
		K_TABLE=14, K_DROP=15, K_SELECT=16, K_UPDATE=17, K_DELETE=18, K_INSERT=19, 
		K_PRIMARY=20, K_KEY=21, K_NOT=22, K_NULL=23, K_WHERE=24, K_INTO=25, K_FROM=26, 
		K_USE=27;
	public static final int
		RULE_entry = 0, RULE_sql_stmt_list = 1, RULE_sql_stmt = 2, RULE_create_database_stmt = 3, 
		RULE_create_table_stmt = 4, RULE_drop_database_stmt = 5, RULE_drop_table_stmt = 6, 
		RULE_use_database_stmt = 7, RULE_column_def = 8, RULE_table_constraint = 9, 
		RULE_type_name = 10, RULE_signed_number = 11, RULE_column_constraint = 12, 
		RULE_name = 13, RULE_database_name = 14, RULE_table_name = 15, RULE_table_or_index_name = 16, 
		RULE_column_name = 17, RULE_any_name = 18, RULE_keyword = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"entry", "sql_stmt_list", "sql_stmt", "create_database_stmt", "create_table_stmt", 
			"drop_database_stmt", "drop_table_stmt", "use_database_stmt", "column_def", 
			"table_constraint", "type_name", "signed_number", "column_constraint", 
			"name", "database_name", "table_name", "table_or_index_name", "column_name", 
			"any_name", "keyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'('", "','", "')'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "IDENTIFIER", "SINGLE_LINE_COMMENT", 
			"MULTILINE_COMMENT", "SPACES", "NUMERIC_LITERAL", "K_CREATE", "K_DATABASE", 
			"K_TABLE", "K_DROP", "K_SELECT", "K_UPDATE", "K_DELETE", "K_INSERT", 
			"K_PRIMARY", "K_KEY", "K_NOT", "K_NULL", "K_WHERE", "K_INTO", "K_FROM", 
			"K_USE"
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

	public static class EntryContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TinySQLParser.EOF, 0); }
		public List<Sql_stmt_listContext> sql_stmt_list() {
			return getRuleContexts(Sql_stmt_listContext.class);
		}
		public Sql_stmt_listContext sql_stmt_list(int i) {
			return getRuleContext(Sql_stmt_listContext.class,i);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << K_CREATE) | (1L << K_DROP) | (1L << K_USE))) != 0)) {
				{
				{
				setState(40);
				sql_stmt_list();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
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

	public static class Sql_stmt_listContext extends ParserRuleContext {
		public List<Sql_stmtContext> sql_stmt() {
			return getRuleContexts(Sql_stmtContext.class);
		}
		public Sql_stmtContext sql_stmt(int i) {
			return getRuleContext(Sql_stmtContext.class,i);
		}
		public Sql_stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterSql_stmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitSql_stmt_list(this);
		}
	}

	public final Sql_stmt_listContext sql_stmt_list() throws RecognitionException {
		Sql_stmt_listContext _localctx = new Sql_stmt_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sql_stmt_list);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(48);
				match(T__0);
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			sql_stmt();
			setState(63);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(56); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(55);
						match(T__0);
						}
						}
						setState(58); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==T__0 );
					setState(60);
					sql_stmt();
					}
					} 
				}
				setState(65);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(69);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(66);
					match(T__0);
					}
					} 
				}
				setState(71);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class Sql_stmtContext extends ParserRuleContext {
		public Create_database_stmtContext create_database_stmt() {
			return getRuleContext(Create_database_stmtContext.class,0);
		}
		public Create_table_stmtContext create_table_stmt() {
			return getRuleContext(Create_table_stmtContext.class,0);
		}
		public Drop_database_stmtContext drop_database_stmt() {
			return getRuleContext(Drop_database_stmtContext.class,0);
		}
		public Drop_table_stmtContext drop_table_stmt() {
			return getRuleContext(Drop_table_stmtContext.class,0);
		}
		public Use_database_stmtContext use_database_stmt() {
			return getRuleContext(Use_database_stmtContext.class,0);
		}
		public Sql_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterSql_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitSql_stmt(this);
		}
	}

	public final Sql_stmtContext sql_stmt() throws RecognitionException {
		Sql_stmtContext _localctx = new Sql_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql_stmt);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				create_database_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				create_table_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74);
				drop_database_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(75);
				drop_table_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				use_database_stmt();
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

	public static class Create_database_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(TinySQLParser.K_CREATE, 0); }
		public TerminalNode K_DATABASE() { return getToken(TinySQLParser.K_DATABASE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Create_database_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_database_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterCreate_database_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitCreate_database_stmt(this);
		}
	}

	public final Create_database_stmtContext create_database_stmt() throws RecognitionException {
		Create_database_stmtContext _localctx = new Create_database_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_create_database_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(K_CREATE);
			setState(80);
			match(K_DATABASE);
			setState(81);
			database_name();
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

	public static class Create_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_CREATE() { return getToken(TinySQLParser.K_CREATE, 0); }
		public TerminalNode K_TABLE() { return getToken(TinySQLParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public List<Column_defContext> column_def() {
			return getRuleContexts(Column_defContext.class);
		}
		public Column_defContext column_def(int i) {
			return getRuleContext(Column_defContext.class,i);
		}
		public List<Table_constraintContext> table_constraint() {
			return getRuleContexts(Table_constraintContext.class);
		}
		public Table_constraintContext table_constraint(int i) {
			return getRuleContext(Table_constraintContext.class,i);
		}
		public Create_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterCreate_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitCreate_table_stmt(this);
		}
	}

	public final Create_table_stmtContext create_table_stmt() throws RecognitionException {
		Create_table_stmtContext _localctx = new Create_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_create_table_stmt);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(K_CREATE);
			setState(84);
			match(K_TABLE);
			setState(85);
			table_name();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(86);
				match(T__1);
				setState(87);
				column_def();
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(88);
						match(T__2);
						setState(89);
						column_def();
						}
						} 
					}
					setState(94);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__2) {
					{
					{
					setState(95);
					match(T__2);
					setState(96);
					table_constraint();
					}
					}
					setState(101);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(102);
				match(T__3);
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

	public static class Drop_database_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(TinySQLParser.K_DROP, 0); }
		public TerminalNode K_DATABASE() { return getToken(TinySQLParser.K_DATABASE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Drop_database_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_database_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterDrop_database_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitDrop_database_stmt(this);
		}
	}

	public final Drop_database_stmtContext drop_database_stmt() throws RecognitionException {
		Drop_database_stmtContext _localctx = new Drop_database_stmtContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_drop_database_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(K_DROP);
			setState(107);
			match(K_DATABASE);
			setState(108);
			database_name();
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

	public static class Drop_table_stmtContext extends ParserRuleContext {
		public TerminalNode K_DROP() { return getToken(TinySQLParser.K_DROP, 0); }
		public TerminalNode K_TABLE() { return getToken(TinySQLParser.K_TABLE, 0); }
		public Table_nameContext table_name() {
			return getRuleContext(Table_nameContext.class,0);
		}
		public Drop_table_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterDrop_table_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitDrop_table_stmt(this);
		}
	}

	public final Drop_table_stmtContext drop_table_stmt() throws RecognitionException {
		Drop_table_stmtContext _localctx = new Drop_table_stmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_drop_table_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(K_DROP);
			setState(111);
			match(K_TABLE);
			setState(112);
			table_name();
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

	public static class Use_database_stmtContext extends ParserRuleContext {
		public TerminalNode K_USE() { return getToken(TinySQLParser.K_USE, 0); }
		public Database_nameContext database_name() {
			return getRuleContext(Database_nameContext.class,0);
		}
		public Use_database_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_database_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterUse_database_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitUse_database_stmt(this);
		}
	}

	public final Use_database_stmtContext use_database_stmt() throws RecognitionException {
		Use_database_stmtContext _localctx = new Use_database_stmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_use_database_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(K_USE);
			setState(115);
			database_name();
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

	public static class Column_defContext extends ParserRuleContext {
		public Column_nameContext column_name() {
			return getRuleContext(Column_nameContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public List<Column_constraintContext> column_constraint() {
			return getRuleContexts(Column_constraintContext.class);
		}
		public Column_constraintContext column_constraint(int i) {
			return getRuleContext(Column_constraintContext.class,i);
		}
		public Column_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterColumn_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitColumn_def(this);
		}
	}

	public final Column_defContext column_def() throws RecognitionException {
		Column_defContext _localctx = new Column_defContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_column_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			column_name();
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(118);
				type_name();
				}
				break;
			}
			setState(124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==K_PRIMARY || _la==K_NOT) {
				{
				{
				setState(121);
				column_constraint();
				}
				}
				setState(126);
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

	public static class Table_constraintContext extends ParserRuleContext {
		public List<Column_nameContext> column_name() {
			return getRuleContexts(Column_nameContext.class);
		}
		public Column_nameContext column_name(int i) {
			return getRuleContext(Column_nameContext.class,i);
		}
		public TerminalNode K_PRIMARY() { return getToken(TinySQLParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(TinySQLParser.K_KEY, 0); }
		public Table_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterTable_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitTable_constraint(this);
		}
	}

	public final Table_constraintContext table_constraint() throws RecognitionException {
		Table_constraintContext _localctx = new Table_constraintContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_table_constraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(127);
			match(K_PRIMARY);
			setState(128);
			match(K_KEY);
			}
			setState(130);
			match(T__1);
			setState(131);
			column_name();
			setState(136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(132);
				match(T__2);
				setState(133);
				column_name();
				}
				}
				setState(138);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(139);
			match(T__3);
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

	public static class Type_nameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type_name);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(142); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(141);
					name();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(144); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(146);
				match(T__1);
				setState(147);
				signed_number();
				setState(148);
				match(T__3);
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

	public static class Signed_numberContext extends ParserRuleContext {
		public TerminalNode NUMERIC_LITERAL() { return getToken(TinySQLParser.NUMERIC_LITERAL, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterSigned_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitSigned_number(this);
		}
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4 || _la==T__5) {
				{
				setState(152);
				_la = _input.LA(1);
				if ( !(_la==T__4 || _la==T__5) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(155);
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

	public static class Column_constraintContext extends ParserRuleContext {
		public TerminalNode K_PRIMARY() { return getToken(TinySQLParser.K_PRIMARY, 0); }
		public TerminalNode K_KEY() { return getToken(TinySQLParser.K_KEY, 0); }
		public TerminalNode K_NOT() { return getToken(TinySQLParser.K_NOT, 0); }
		public TerminalNode K_NULL() { return getToken(TinySQLParser.K_NULL, 0); }
		public Column_constraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterColumn_constraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitColumn_constraint(this);
		}
	}

	public final Column_constraintContext column_constraint() throws RecognitionException {
		Column_constraintContext _localctx = new Column_constraintContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_column_constraint);
		try {
			setState(161);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case K_PRIMARY:
				enterOuterAlt(_localctx, 1);
				{
				setState(157);
				match(K_PRIMARY);
				setState(158);
				match(K_KEY);
				}
				break;
			case K_NOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				match(K_NOT);
				setState(160);
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
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
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
		enterRule(_localctx, 26, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163);
			any_name();
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

	public static class Database_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Database_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_database_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterDatabase_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitDatabase_name(this);
		}
	}

	public final Database_nameContext database_name() throws RecognitionException {
		Database_nameContext _localctx = new Database_nameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_database_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			any_name();
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

	public static class Table_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterTable_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitTable_name(this);
		}
	}

	public final Table_nameContext table_name() throws RecognitionException {
		Table_nameContext _localctx = new Table_nameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_table_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			any_name();
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

	public static class Table_or_index_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Table_or_index_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_or_index_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterTable_or_index_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitTable_or_index_name(this);
		}
	}

	public final Table_or_index_nameContext table_or_index_name() throws RecognitionException {
		Table_or_index_nameContext _localctx = new Table_or_index_nameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_table_or_index_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			any_name();
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

	public static class Column_nameContext extends ParserRuleContext {
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Column_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterColumn_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitColumn_name(this);
		}
	}

	public final Column_nameContext column_name() throws RecognitionException {
		Column_nameContext _localctx = new Column_nameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_column_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			any_name();
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

	public static class Any_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TinySQLParser.IDENTIFIER, 0); }
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public Any_nameContext any_name() {
			return getRuleContext(Any_nameContext.class,0);
		}
		public Any_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_any_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).enterAny_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TinySQLListener ) ((TinySQLListener)listener).exitAny_name(this);
		}
	}

	public final Any_nameContext any_name() throws RecognitionException {
		Any_nameContext _localctx = new Any_nameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_any_name);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				keyword();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(175);
				match(T__1);
				setState(176);
				any_name();
				setState(177);
				match(T__3);
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
		enterRule(_localctx, 38, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << K_CREATE) | (1L << K_DATABASE) | (1L << K_TABLE) | (1L << K_DROP) | (1L << K_SELECT) | (1L << K_UPDATE) | (1L << K_DELETE) | (1L << K_INSERT) | (1L << K_PRIMARY) | (1L << K_KEY) | (1L << K_NOT) | (1L << K_NULL) | (1L << K_WHERE) | (1L << K_INTO) | (1L << K_FROM) | (1L << K_USE))) != 0)) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u00ba\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\7\2,\n\2\f\2\16\2/\13\2\3\2\3\2\3\3"+
		"\7\3\64\n\3\f\3\16\3\67\13\3\3\3\3\3\6\3;\n\3\r\3\16\3<\3\3\7\3@\n\3\f"+
		"\3\16\3C\13\3\3\3\7\3F\n\3\f\3\16\3I\13\3\3\4\3\4\3\4\3\4\3\4\5\4P\n\4"+
		"\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6]\n\6\f\6\16\6`\13\6\3"+
		"\6\3\6\7\6d\n\6\f\6\16\6g\13\6\3\6\3\6\5\6k\n\6\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\5\nz\n\n\3\n\7\n}\n\n\f\n\16\n\u0080\13"+
		"\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13\u0089\n\13\f\13\16\13\u008c"+
		"\13\13\3\13\3\13\3\f\6\f\u0091\n\f\r\f\16\f\u0092\3\f\3\f\3\f\3\f\5\f"+
		"\u0099\n\f\3\r\5\r\u009c\n\r\3\r\3\r\3\16\3\16\3\16\3\16\5\16\u00a4\n"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\5\24\u00b6\n\24\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(\2\4\3\2\7\b\3\2\16\35\2\u00ba\2-\3\2\2\2\4"+
		"\65\3\2\2\2\6O\3\2\2\2\bQ\3\2\2\2\nU\3\2\2\2\fl\3\2\2\2\16p\3\2\2\2\20"+
		"t\3\2\2\2\22w\3\2\2\2\24\u0081\3\2\2\2\26\u0090\3\2\2\2\30\u009b\3\2\2"+
		"\2\32\u00a3\3\2\2\2\34\u00a5\3\2\2\2\36\u00a7\3\2\2\2 \u00a9\3\2\2\2\""+
		"\u00ab\3\2\2\2$\u00ad\3\2\2\2&\u00b5\3\2\2\2(\u00b7\3\2\2\2*,\5\4\3\2"+
		"+*\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7"+
		"\2\2\3\61\3\3\2\2\2\62\64\7\3\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3"+
		"\2\2\2\65\66\3\2\2\2\668\3\2\2\2\67\65\3\2\2\28A\5\6\4\29;\7\3\2\2:9\3"+
		"\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=>\3\2\2\2>@\5\6\4\2?:\3\2\2\2@C\3"+
		"\2\2\2A?\3\2\2\2AB\3\2\2\2BG\3\2\2\2CA\3\2\2\2DF\7\3\2\2ED\3\2\2\2FI\3"+
		"\2\2\2GE\3\2\2\2GH\3\2\2\2H\5\3\2\2\2IG\3\2\2\2JP\5\b\5\2KP\5\n\6\2LP"+
		"\5\f\7\2MP\5\16\b\2NP\5\20\t\2OJ\3\2\2\2OK\3\2\2\2OL\3\2\2\2OM\3\2\2\2"+
		"ON\3\2\2\2P\7\3\2\2\2QR\7\16\2\2RS\7\17\2\2ST\5\36\20\2T\t\3\2\2\2UV\7"+
		"\16\2\2VW\7\20\2\2Wj\5 \21\2XY\7\4\2\2Y^\5\22\n\2Z[\7\5\2\2[]\5\22\n\2"+
		"\\Z\3\2\2\2]`\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_e\3\2\2\2`^\3\2\2\2ab\7\5\2"+
		"\2bd\5\24\13\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2"+
		"\2\2hi\7\6\2\2ik\3\2\2\2jX\3\2\2\2jk\3\2\2\2k\13\3\2\2\2lm\7\21\2\2mn"+
		"\7\17\2\2no\5\36\20\2o\r\3\2\2\2pq\7\21\2\2qr\7\20\2\2rs\5 \21\2s\17\3"+
		"\2\2\2tu\7\35\2\2uv\5\36\20\2v\21\3\2\2\2wy\5$\23\2xz\5\26\f\2yx\3\2\2"+
		"\2yz\3\2\2\2z~\3\2\2\2{}\5\32\16\2|{\3\2\2\2}\u0080\3\2\2\2~|\3\2\2\2"+
		"~\177\3\2\2\2\177\23\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7\26\2\2\u0082"+
		"\u0083\7\27\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\4\2\2\u0085\u008a\5"+
		"$\23\2\u0086\u0087\7\5\2\2\u0087\u0089\5$\23\2\u0088\u0086\3\2\2\2\u0089"+
		"\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2"+
		"\2\2\u008c\u008a\3\2\2\2\u008d\u008e\7\6\2\2\u008e\25\3\2\2\2\u008f\u0091"+
		"\5\34\17\2\u0090\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0090\3\2\2\2"+
		"\u0092\u0093\3\2\2\2\u0093\u0098\3\2\2\2\u0094\u0095\7\4\2\2\u0095\u0096"+
		"\5\30\r\2\u0096\u0097\7\6\2\2\u0097\u0099\3\2\2\2\u0098\u0094\3\2\2\2"+
		"\u0098\u0099\3\2\2\2\u0099\27\3\2\2\2\u009a\u009c\t\2\2\2\u009b\u009a"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7\r\2\2\u009e"+
		"\31\3\2\2\2\u009f\u00a0\7\26\2\2\u00a0\u00a4\7\27\2\2\u00a1\u00a2\7\30"+
		"\2\2\u00a2\u00a4\7\31\2\2\u00a3\u009f\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\33\3\2\2\2\u00a5\u00a6\5&\24\2\u00a6\35\3\2\2\2\u00a7\u00a8\5&\24\2\u00a8"+
		"\37\3\2\2\2\u00a9\u00aa\5&\24\2\u00aa!\3\2\2\2\u00ab\u00ac\5&\24\2\u00ac"+
		"#\3\2\2\2\u00ad\u00ae\5&\24\2\u00ae%\3\2\2\2\u00af\u00b6\7\t\2\2\u00b0"+
		"\u00b6\5(\25\2\u00b1\u00b2\7\4\2\2\u00b2\u00b3\5&\24\2\u00b3\u00b4\7\6"+
		"\2\2\u00b4\u00b6\3\2\2\2\u00b5\u00af\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b5"+
		"\u00b1\3\2\2\2\u00b6\'\3\2\2\2\u00b7\u00b8\t\3\2\2\u00b8)\3\2\2\2\23-"+
		"\65<AGO^ejy~\u008a\u0092\u0098\u009b\u00a3\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}