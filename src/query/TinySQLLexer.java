// Generated from query/TinySQL.g4 by ANTLR 4.7.2
package query;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TinySQLLexer extends Lexer {
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
		K_SET=52, IDENTIFIER=53, UNEXPECTED_CHAR=54;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"STRING_LITERAL", "SINGLE_LINE_COMMENT", "MULTILINE_COMMENT", "SPACES", 
			"NUMERIC_LITERAL", "K_CREATE", "K_DATABASE", "K_TABLE", "K_DROP", "K_SELECT", 
			"K_UPDATE", "K_DELETE", "K_INSERT", "K_PRIMARY", "K_KEY", "K_NOT", "K_NULL", 
			"K_WHERE", "K_INTO", "K_FROM", "K_USE", "K_ASC", "K_DESC", "K_VALUES", 
			"K_DATABASES", "K_SHOW", "K_ON", "K_JOIN", "K_NATURAL", "K_DISTINCT", 
			"K_ALL", "K_OUTER", "K_LEFT", "K_INNER", "K_SET", "IDENTIFIER", "UNEXPECTED_CHAR", 
			"DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", 
			"M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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
			"K_SET", "IDENTIFIER", "UNEXPECTED_CHAR"
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


	public TinySQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TinySQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\28\u01fd\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\3\2\3\2\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u00d1\n\23\f\23\16\23\u00d4"+
		"\13\23\3\23\3\23\3\24\3\24\3\24\3\24\7\24\u00dc\n\24\f\24\16\24\u00df"+
		"\13\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u00e7\n\25\f\25\16\25\u00ea"+
		"\13\25\3\25\3\25\3\25\5\25\u00ef\n\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\27\6\27\u00f8\n\27\r\27\16\27\u00f9\3\27\3\27\7\27\u00fe\n\27\f\27\16"+
		"\27\u0101\13\27\5\27\u0103\n\27\3\27\3\27\7\27\u0107\n\27\f\27\16\27\u010a"+
		"\13\27\5\27\u010c\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3"+
		"\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\""+
		"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3"+
		"+\3+\3+\3+\3+\3+\3+\3,\3,\3,\3,\3,\3-\3-\3-\3.\3.\3.\3.\3.\3/\3/\3/\3"+
		"/\3/\3/\3/\3/\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\60\3\61\3\61\3"+
		"\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\64\3"+
		"\64\3\64\3\64\3\64\3\64\3\65\3\65\3\65\3\65\3\66\3\66\7\66\u01c1\n\66"+
		"\f\66\16\66\u01c4\13\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3="+
		"\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I"+
		"\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3R\3R\3\u00e8\2S\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37="+
		" ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o\2"+
		"q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2\u008b"+
		"\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b\2\u009d"+
		"\2\u009f\2\u00a1\2\u00a3\2\3\2\"\3\2))\4\2\f\f\17\17\5\2\13\r\17\17\""+
		"\"\5\2C\\aac|\6\2\62;C\\aac|\3\2\62;\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4"+
		"\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOo"+
		"o\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2"+
		"XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u01ec\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y"+
		"\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2"+
		"\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2\2\3\u00a5\3\2\2\2\5\u00a7"+
		"\3\2\2\2\7\u00a9\3\2\2\2\t\u00ab\3\2\2\2\13\u00ad\3\2\2\2\r\u00af\3\2"+
		"\2\2\17\u00b1\3\2\2\2\21\u00b3\3\2\2\2\23\u00b5\3\2\2\2\25\u00b8\3\2\2"+
		"\2\27\u00ba\3\2\2\2\31\u00bd\3\2\2\2\33\u00bf\3\2\2\2\35\u00c2\3\2\2\2"+
		"\37\u00c5\3\2\2\2!\u00c8\3\2\2\2#\u00ca\3\2\2\2%\u00cc\3\2\2\2\'\u00d7"+
		"\3\2\2\2)\u00e2\3\2\2\2+\u00f2\3\2\2\2-\u010b\3\2\2\2/\u010d\3\2\2\2\61"+
		"\u0114\3\2\2\2\63\u011d\3\2\2\2\65\u0123\3\2\2\2\67\u0128\3\2\2\29\u012f"+
		"\3\2\2\2;\u0136\3\2\2\2=\u013d\3\2\2\2?\u0144\3\2\2\2A\u014c\3\2\2\2C"+
		"\u0150\3\2\2\2E\u0154\3\2\2\2G\u0159\3\2\2\2I\u015f\3\2\2\2K\u0164\3\2"+
		"\2\2M\u0169\3\2\2\2O\u016d\3\2\2\2Q\u0171\3\2\2\2S\u0176\3\2\2\2U\u017d"+
		"\3\2\2\2W\u0187\3\2\2\2Y\u018c\3\2\2\2[\u018f\3\2\2\2]\u0194\3\2\2\2_"+
		"\u019c\3\2\2\2a\u01a5\3\2\2\2c\u01a9\3\2\2\2e\u01af\3\2\2\2g\u01b4\3\2"+
		"\2\2i\u01ba\3\2\2\2k\u01be\3\2\2\2m\u01c5\3\2\2\2o\u01c7\3\2\2\2q\u01c9"+
		"\3\2\2\2s\u01cb\3\2\2\2u\u01cd\3\2\2\2w\u01cf\3\2\2\2y\u01d1\3\2\2\2{"+
		"\u01d3\3\2\2\2}\u01d5\3\2\2\2\177\u01d7\3\2\2\2\u0081\u01d9\3\2\2\2\u0083"+
		"\u01db\3\2\2\2\u0085\u01dd\3\2\2\2\u0087\u01df\3\2\2\2\u0089\u01e1\3\2"+
		"\2\2\u008b\u01e3\3\2\2\2\u008d\u01e5\3\2\2\2\u008f\u01e7\3\2\2\2\u0091"+
		"\u01e9\3\2\2\2\u0093\u01eb\3\2\2\2\u0095\u01ed\3\2\2\2\u0097\u01ef\3\2"+
		"\2\2\u0099\u01f1\3\2\2\2\u009b\u01f3\3\2\2\2\u009d\u01f5\3\2\2\2\u009f"+
		"\u01f7\3\2\2\2\u00a1\u01f9\3\2\2\2\u00a3\u01fb\3\2\2\2\u00a5\u00a6\7="+
		"\2\2\u00a6\4\3\2\2\2\u00a7\u00a8\7\60\2\2\u00a8\6\3\2\2\2\u00a9\u00aa"+
		"\7*\2\2\u00aa\b\3\2\2\2\u00ab\u00ac\7.\2\2\u00ac\n\3\2\2\2\u00ad\u00ae"+
		"\7+\2\2\u00ae\f\3\2\2\2\u00af\u00b0\7-\2\2\u00b0\16\3\2\2\2\u00b1\u00b2"+
		"\7/\2\2\u00b2\20\3\2\2\2\u00b3\u00b4\7>\2\2\u00b4\22\3\2\2\2\u00b5\u00b6"+
		"\7>\2\2\u00b6\u00b7\7?\2\2\u00b7\24\3\2\2\2\u00b8\u00b9\7@\2\2\u00b9\26"+
		"\3\2\2\2\u00ba\u00bb\7@\2\2\u00bb\u00bc\7?\2\2\u00bc\30\3\2\2\2\u00bd"+
		"\u00be\7?\2\2\u00be\32\3\2\2\2\u00bf\u00c0\7?\2\2\u00c0\u00c1\7?\2\2\u00c1"+
		"\34\3\2\2\2\u00c2\u00c3\7#\2\2\u00c3\u00c4\7?\2\2\u00c4\36\3\2\2\2\u00c5"+
		"\u00c6\7>\2\2\u00c6\u00c7\7@\2\2\u00c7 \3\2\2\2\u00c8\u00c9\7\u0080\2"+
		"\2\u00c9\"\3\2\2\2\u00ca\u00cb\7,\2\2\u00cb$\3\2\2\2\u00cc\u00d2\7)\2"+
		"\2\u00cd\u00d1\n\2\2\2\u00ce\u00cf\7)\2\2\u00cf\u00d1\7)\2\2\u00d0\u00cd"+
		"\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2"+
		"\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\7)"+
		"\2\2\u00d6&\3\2\2\2\u00d7\u00d8\7/\2\2\u00d8\u00d9\7/\2\2\u00d9\u00dd"+
		"\3\2\2\2\u00da\u00dc\n\3\2\2\u00db\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd"+
		"\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00e0\u00e1\b\24\2\2\u00e1(\3\2\2\2\u00e2\u00e3\7\61\2\2\u00e3\u00e4"+
		"\7,\2\2\u00e4\u00e8\3\2\2\2\u00e5\u00e7\13\2\2\2\u00e6\u00e5\3\2\2\2\u00e7"+
		"\u00ea\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9\u00ee\3\2"+
		"\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\7,\2\2\u00ec\u00ef\7\61\2\2\u00ed"+
		"\u00ef\7\2\2\3\u00ee\u00eb\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f1\b\25\2\2\u00f1*\3\2\2\2\u00f2\u00f3\t\4\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f5\b\26\2\2\u00f5,\3\2\2\2\u00f6\u00f8\5o8\2\u00f7\u00f6"+
		"\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u0102\3\2\2\2\u00fb\u00ff\7\60\2\2\u00fc\u00fe\5o8\2\u00fd\u00fc\3\2"+
		"\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100"+
		"\u0103\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u00fb\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u010c\3\2\2\2\u0104\u0108\7\60\2\2\u0105\u0107\5o8\2\u0106"+
		"\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u00f7\3\2\2\2\u010b"+
		"\u0104\3\2\2\2\u010c.\3\2\2\2\u010d\u010e\5u;\2\u010e\u010f\5\u0093J\2"+
		"\u010f\u0110\5y=\2\u0110\u0111\5q9\2\u0111\u0112\5\u0097L\2\u0112\u0113"+
		"\5y=\2\u0113\60\3\2\2\2\u0114\u0115\5w<\2\u0115\u0116\5q9\2\u0116\u0117"+
		"\5\u0097L\2\u0117\u0118\5q9\2\u0118\u0119\5s:\2\u0119\u011a\5q9\2\u011a"+
		"\u011b\5\u0095K\2\u011b\u011c\5y=\2\u011c\62\3\2\2\2\u011d\u011e\5\u0097"+
		"L\2\u011e\u011f\5q9\2\u011f\u0120\5s:\2\u0120\u0121\5\u0087D\2\u0121\u0122"+
		"\5y=\2\u0122\64\3\2\2\2\u0123\u0124\5w<\2\u0124\u0125\5\u0093J\2\u0125"+
		"\u0126\5\u008dG\2\u0126\u0127\5\u008fH\2\u0127\66\3\2\2\2\u0128\u0129"+
		"\5\u0095K\2\u0129\u012a\5y=\2\u012a\u012b\5\u0087D\2\u012b\u012c\5y=\2"+
		"\u012c\u012d\5u;\2\u012d\u012e\5\u0097L\2\u012e8\3\2\2\2\u012f\u0130\5"+
		"\u0099M\2\u0130\u0131\5\u008fH\2\u0131\u0132\5w<\2\u0132\u0133\5q9\2\u0133"+
		"\u0134\5\u0097L\2\u0134\u0135\5y=\2\u0135:\3\2\2\2\u0136\u0137\5w<\2\u0137"+
		"\u0138\5y=\2\u0138\u0139\5\u0087D\2\u0139\u013a\5y=\2\u013a\u013b\5\u0097"+
		"L\2\u013b\u013c\5y=\2\u013c<\3\2\2\2\u013d\u013e\5\u0081A\2\u013e\u013f"+
		"\5\u008bF\2\u013f\u0140\5\u0095K\2\u0140\u0141\5y=\2\u0141\u0142\5\u0093"+
		"J\2\u0142\u0143\5\u0097L\2\u0143>\3\2\2\2\u0144\u0145\5\u008fH\2\u0145"+
		"\u0146\5\u0093J\2\u0146\u0147\5\u0081A\2\u0147\u0148\5\u0089E\2\u0148"+
		"\u0149\5q9\2\u0149\u014a\5\u0093J\2\u014a\u014b\5\u00a1Q\2\u014b@\3\2"+
		"\2\2\u014c\u014d\5\u0085C\2\u014d\u014e\5y=\2\u014e\u014f\5\u00a1Q\2\u014f"+
		"B\3\2\2\2\u0150\u0151\5\u008bF\2\u0151\u0152\5\u008dG\2\u0152\u0153\5"+
		"\u0097L\2\u0153D\3\2\2\2\u0154\u0155\5\u008bF\2\u0155\u0156\5\u0099M\2"+
		"\u0156\u0157\5\u0087D\2\u0157\u0158\5\u0087D\2\u0158F\3\2\2\2\u0159\u015a"+
		"\5\u009dO\2\u015a\u015b\5\177@\2\u015b\u015c\5y=\2\u015c\u015d\5\u0093"+
		"J\2\u015d\u015e\5y=\2\u015eH\3\2\2\2\u015f\u0160\5\u0081A\2\u0160\u0161"+
		"\5\u008bF\2\u0161\u0162\5\u0097L\2\u0162\u0163\5\u008dG\2\u0163J\3\2\2"+
		"\2\u0164\u0165\5{>\2\u0165\u0166\5\u0093J\2\u0166\u0167\5\u008dG\2\u0167"+
		"\u0168\5\u0089E\2\u0168L\3\2\2\2\u0169\u016a\5\u0099M\2\u016a\u016b\5"+
		"\u0095K\2\u016b\u016c\5y=\2\u016cN\3\2\2\2\u016d\u016e\5q9\2\u016e\u016f"+
		"\5\u0095K\2\u016f\u0170\5u;\2\u0170P\3\2\2\2\u0171\u0172\5w<\2\u0172\u0173"+
		"\5y=\2\u0173\u0174\5\u0095K\2\u0174\u0175\5u;\2\u0175R\3\2\2\2\u0176\u0177"+
		"\5\u009bN\2\u0177\u0178\5q9\2\u0178\u0179\5\u0087D\2\u0179\u017a\5\u0099"+
		"M\2\u017a\u017b\5y=\2\u017b\u017c\5\u0095K\2\u017cT\3\2\2\2\u017d\u017e"+
		"\5w<\2\u017e\u017f\5q9\2\u017f\u0180\5\u0097L\2\u0180\u0181\5q9\2\u0181"+
		"\u0182\5s:\2\u0182\u0183\5q9\2\u0183\u0184\5\u0095K\2\u0184\u0185\5y="+
		"\2\u0185\u0186\5\u0095K\2\u0186V\3\2\2\2\u0187\u0188\5\u0095K\2\u0188"+
		"\u0189\5\177@\2\u0189\u018a\5\u008dG\2\u018a\u018b\5\u009dO\2\u018bX\3"+
		"\2\2\2\u018c\u018d\5\u008dG\2\u018d\u018e\5\u008bF\2\u018eZ\3\2\2\2\u018f"+
		"\u0190\5\u0083B\2\u0190\u0191\5\u008dG\2\u0191\u0192\5\u0081A\2\u0192"+
		"\u0193\5\u008bF\2\u0193\\\3\2\2\2\u0194\u0195\5\u008bF\2\u0195\u0196\5"+
		"q9\2\u0196\u0197\5\u0097L\2\u0197\u0198\5\u0099M\2\u0198\u0199\5\u0093"+
		"J\2\u0199\u019a\5q9\2\u019a\u019b\5\u0087D\2\u019b^\3\2\2\2\u019c\u019d"+
		"\5w<\2\u019d\u019e\5\u0081A\2\u019e\u019f\5\u0095K\2\u019f\u01a0\5\u0097"+
		"L\2\u01a0\u01a1\5\u0081A\2\u01a1\u01a2\5\u008bF\2\u01a2\u01a3\5u;\2\u01a3"+
		"\u01a4\5\u0097L\2\u01a4`\3\2\2\2\u01a5\u01a6\5q9\2\u01a6\u01a7\5\u0087"+
		"D\2\u01a7\u01a8\5\u0087D\2\u01a8b\3\2\2\2\u01a9\u01aa\5\u008dG\2\u01aa"+
		"\u01ab\5\u0099M\2\u01ab\u01ac\5\u0097L\2\u01ac\u01ad\5y=\2\u01ad\u01ae"+
		"\5\u0093J\2\u01aed\3\2\2\2\u01af\u01b0\5\u0087D\2\u01b0\u01b1\5y=\2\u01b1"+
		"\u01b2\5{>\2\u01b2\u01b3\5\u0097L\2\u01b3f\3\2\2\2\u01b4\u01b5\5\u0081"+
		"A\2\u01b5\u01b6\5\u008bF\2\u01b6\u01b7\5\u008bF\2\u01b7\u01b8\5y=\2\u01b8"+
		"\u01b9\5\u0093J\2\u01b9h\3\2\2\2\u01ba\u01bb\5\u0095K\2\u01bb\u01bc\5"+
		"y=\2\u01bc\u01bd\5\u0097L\2\u01bdj\3\2\2\2\u01be\u01c2\t\5\2\2\u01bf\u01c1"+
		"\t\6\2\2\u01c0\u01bf\3\2\2\2\u01c1\u01c4\3\2\2\2\u01c2\u01c0\3\2\2\2\u01c2"+
		"\u01c3\3\2\2\2\u01c3l\3\2\2\2\u01c4\u01c2\3\2\2\2\u01c5\u01c6\13\2\2\2"+
		"\u01c6n\3\2\2\2\u01c7\u01c8\t\7\2\2\u01c8p\3\2\2\2\u01c9\u01ca\t\b\2\2"+
		"\u01car\3\2\2\2\u01cb\u01cc\t\t\2\2\u01cct\3\2\2\2\u01cd\u01ce\t\n\2\2"+
		"\u01cev\3\2\2\2\u01cf\u01d0\t\13\2\2\u01d0x\3\2\2\2\u01d1\u01d2\t\f\2"+
		"\2\u01d2z\3\2\2\2\u01d3\u01d4\t\r\2\2\u01d4|\3\2\2\2\u01d5\u01d6\t\16"+
		"\2\2\u01d6~\3\2\2\2\u01d7\u01d8\t\17\2\2\u01d8\u0080\3\2\2\2\u01d9\u01da"+
		"\t\20\2\2\u01da\u0082\3\2\2\2\u01db\u01dc\t\21\2\2\u01dc\u0084\3\2\2\2"+
		"\u01dd\u01de\t\22\2\2\u01de\u0086\3\2\2\2\u01df\u01e0\t\23\2\2\u01e0\u0088"+
		"\3\2\2\2\u01e1\u01e2\t\24\2\2\u01e2\u008a\3\2\2\2\u01e3\u01e4\t\25\2\2"+
		"\u01e4\u008c\3\2\2\2\u01e5\u01e6\t\26\2\2\u01e6\u008e\3\2\2\2\u01e7\u01e8"+
		"\t\27\2\2\u01e8\u0090\3\2\2\2\u01e9\u01ea\t\30\2\2\u01ea\u0092\3\2\2\2"+
		"\u01eb\u01ec\t\31\2\2\u01ec\u0094\3\2\2\2\u01ed\u01ee\t\32\2\2\u01ee\u0096"+
		"\3\2\2\2\u01ef\u01f0\t\33\2\2\u01f0\u0098\3\2\2\2\u01f1\u01f2\t\34\2\2"+
		"\u01f2\u009a\3\2\2\2\u01f3\u01f4\t\35\2\2\u01f4\u009c\3\2\2\2\u01f5\u01f6"+
		"\t\36\2\2\u01f6\u009e\3\2\2\2\u01f7\u01f8\t\37\2\2\u01f8\u00a0\3\2\2\2"+
		"\u01f9\u01fa\t \2\2\u01fa\u00a2\3\2\2\2\u01fb\u01fc\t!\2\2\u01fc\u00a4"+
		"\3\2\2\2\16\2\u00d0\u00d2\u00dd\u00e8\u00ee\u00f9\u00ff\u0102\u0108\u010b"+
		"\u01c2\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}