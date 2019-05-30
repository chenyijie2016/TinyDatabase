// Generated from C:/Users/cyj/Desktop/TinyDatabase/src/main/java/query\TinySQL.g4 by ANTLR 4.7.2
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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, IDENTIFIER=7, SINGLE_LINE_COMMENT=8, 
		MULTILINE_COMMENT=9, SPACES=10, NUMERIC_LITERAL=11, K_CREATE=12, K_DATABASE=13, 
		K_TABLE=14, K_DROP=15, K_SELECT=16, K_UPDATE=17, K_DELETE=18, K_INSERT=19, 
		K_PRIMARY=20, K_KEY=21, K_NOT=22, K_NULL=23, K_WHERE=24, K_INTO=25, K_FROM=26, 
		K_USE=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "IDENTIFIER", "SINGLE_LINE_COMMENT", 
			"MULTILINE_COMMENT", "SPACES", "NUMERIC_LITERAL", "K_CREATE", "K_DATABASE", 
			"K_TABLE", "K_DROP", "K_SELECT", "K_UPDATE", "K_DELETE", "K_INSERT", 
			"K_PRIMARY", "K_KEY", "K_NOT", "K_NULL", "K_WHERE", "K_INTO", "K_FROM", 
			"K_USE", "DIGIT", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
			"Z"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u016c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\7\b\u0080\n\b\f\b\16\b\u0083\13\b\3\b\3"+
		"\b\3\b\3\b\3\b\7\b\u008a\n\b\f\b\16\b\u008d\13\b\3\b\3\b\3\b\7\b\u0092"+
		"\n\b\f\b\16\b\u0095\13\b\3\b\3\b\3\b\7\b\u009a\n\b\f\b\16\b\u009d\13\b"+
		"\5\b\u009f\n\b\3\t\3\t\3\t\3\t\7\t\u00a5\n\t\f\t\16\t\u00a8\13\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\7\n\u00b0\n\n\f\n\16\n\u00b3\13\n\3\n\3\n\3\n\5\n\u00b8"+
		"\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\6\f\u00c1\n\f\r\f\16\f\u00c2\3\f"+
		"\3\f\7\f\u00c7\n\f\f\f\16\f\u00ca\13\f\5\f\u00cc\n\f\3\f\3\f\7\f\u00d0"+
		"\n\f\f\f\16\f\u00d3\13\f\5\f\u00d5\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\""+
		"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3"+
		".\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65"+
		"\3\66\3\66\3\67\3\67\3\u00b1\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31"+
		"\61\32\63\33\65\34\67\359\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2"+
		"W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2\3\2$\3\2$$\3\2bb\3\2__\5\2C\\aac"+
		"|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\r\17\17\"\"\3\2\62;\4\2CCcc\4\2"+
		"DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4"+
		"\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUu"+
		"u\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0161\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\3o\3\2\2\2\5q\3\2"+
		"\2\2\7s\3\2\2\2\tu\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17\u009e\3\2\2\2\21"+
		"\u00a0\3\2\2\2\23\u00ab\3\2\2\2\25\u00bb\3\2\2\2\27\u00d4\3\2\2\2\31\u00d6"+
		"\3\2\2\2\33\u00dd\3\2\2\2\35\u00e6\3\2\2\2\37\u00ec\3\2\2\2!\u00f1\3\2"+
		"\2\2#\u00f8\3\2\2\2%\u00ff\3\2\2\2\'\u0106\3\2\2\2)\u010d\3\2\2\2+\u0115"+
		"\3\2\2\2-\u0119\3\2\2\2/\u011d\3\2\2\2\61\u0122\3\2\2\2\63\u0128\3\2\2"+
		"\2\65\u012d\3\2\2\2\67\u0132\3\2\2\29\u0136\3\2\2\2;\u0138\3\2\2\2=\u013a"+
		"\3\2\2\2?\u013c\3\2\2\2A\u013e\3\2\2\2C\u0140\3\2\2\2E\u0142\3\2\2\2G"+
		"\u0144\3\2\2\2I\u0146\3\2\2\2K\u0148\3\2\2\2M\u014a\3\2\2\2O\u014c\3\2"+
		"\2\2Q\u014e\3\2\2\2S\u0150\3\2\2\2U\u0152\3\2\2\2W\u0154\3\2\2\2Y\u0156"+
		"\3\2\2\2[\u0158\3\2\2\2]\u015a\3\2\2\2_\u015c\3\2\2\2a\u015e\3\2\2\2c"+
		"\u0160\3\2\2\2e\u0162\3\2\2\2g\u0164\3\2\2\2i\u0166\3\2\2\2k\u0168\3\2"+
		"\2\2m\u016a\3\2\2\2op\7=\2\2p\4\3\2\2\2qr\7*\2\2r\6\3\2\2\2st\7.\2\2t"+
		"\b\3\2\2\2uv\7+\2\2v\n\3\2\2\2wx\7-\2\2x\f\3\2\2\2yz\7/\2\2z\16\3\2\2"+
		"\2{\u0081\7$\2\2|\u0080\n\2\2\2}~\7$\2\2~\u0080\7$\2\2\177|\3\2\2\2\177"+
		"}\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082"+
		"\u0084\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u009f\7$\2\2\u0085\u008b\7b\2"+
		"\2\u0086\u008a\n\3\2\2\u0087\u0088\7b\2\2\u0088\u008a\7b\2\2\u0089\u0086"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b"+
		"\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u009f\7b"+
		"\2\2\u008f\u0093\7]\2\2\u0090\u0092\n\4\2\2\u0091\u0090\3\2\2\2\u0092"+
		"\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0096\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0096\u009f\7_\2\2\u0097\u009b\t\5\2\2\u0098"+
		"\u009a\t\6\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e"+
		"{\3\2\2\2\u009e\u0085\3\2\2\2\u009e\u008f\3\2\2\2\u009e\u0097\3\2\2\2"+
		"\u009f\20\3\2\2\2\u00a0\u00a1\7/\2\2\u00a1\u00a2\7/\2\2\u00a2\u00a6\3"+
		"\2\2\2\u00a3\u00a5\n\7\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a6\3\2"+
		"\2\2\u00a9\u00aa\b\t\2\2\u00aa\22\3\2\2\2\u00ab\u00ac\7\61\2\2\u00ac\u00ad"+
		"\7,\2\2\u00ad\u00b1\3\2\2\2\u00ae\u00b0\13\2\2\2\u00af\u00ae\3\2\2\2\u00b0"+
		"\u00b3\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b7\3\2"+
		"\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7,\2\2\u00b5\u00b8\7\61\2\2\u00b6"+
		"\u00b8\7\2\2\3\u00b7\u00b4\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9\u00ba\b\n\2\2\u00ba\24\3\2\2\2\u00bb\u00bc\t\b\2\2\u00bc\u00bd"+
		"\3\2\2\2\u00bd\u00be\b\13\2\2\u00be\26\3\2\2\2\u00bf\u00c1\59\35\2\u00c0"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2"+
		"\2\2\u00c3\u00cb\3\2\2\2\u00c4\u00c8\7\60\2\2\u00c5\u00c7\59\35\2\u00c6"+
		"\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2"+
		"\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00c4\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\u00d5\3\2\2\2\u00cd\u00d1\7\60\2\2\u00ce\u00d0\5"+
		"9\35\2\u00cf\u00ce\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00c0\3\2"+
		"\2\2\u00d4\u00cd\3\2\2\2\u00d5\30\3\2\2\2\u00d6\u00d7\5? \2\u00d7\u00d8"+
		"\5]/\2\u00d8\u00d9\5C\"\2\u00d9\u00da\5;\36\2\u00da\u00db\5a\61\2\u00db"+
		"\u00dc\5C\"\2\u00dc\32\3\2\2\2\u00dd\u00de\5A!\2\u00de\u00df\5;\36\2\u00df"+
		"\u00e0\5a\61\2\u00e0\u00e1\5;\36\2\u00e1\u00e2\5=\37\2\u00e2\u00e3\5;"+
		"\36\2\u00e3\u00e4\5_\60\2\u00e4\u00e5\5C\"\2\u00e5\34\3\2\2\2\u00e6\u00e7"+
		"\5a\61\2\u00e7\u00e8\5;\36\2\u00e8\u00e9\5=\37\2\u00e9\u00ea\5Q)\2\u00ea"+
		"\u00eb\5C\"\2\u00eb\36\3\2\2\2\u00ec\u00ed\5A!\2\u00ed\u00ee\5]/\2\u00ee"+
		"\u00ef\5W,\2\u00ef\u00f0\5Y-\2\u00f0 \3\2\2\2\u00f1\u00f2\5_\60\2\u00f2"+
		"\u00f3\5C\"\2\u00f3\u00f4\5Q)\2\u00f4\u00f5\5C\"\2\u00f5\u00f6\5? \2\u00f6"+
		"\u00f7\5a\61\2\u00f7\"\3\2\2\2\u00f8\u00f9\5c\62\2\u00f9\u00fa\5Y-\2\u00fa"+
		"\u00fb\5A!\2\u00fb\u00fc\5;\36\2\u00fc\u00fd\5a\61\2\u00fd\u00fe\5C\""+
		"\2\u00fe$\3\2\2\2\u00ff\u0100\5A!\2\u0100\u0101\5C\"\2\u0101\u0102\5Q"+
		")\2\u0102\u0103\5C\"\2\u0103\u0104\5a\61\2\u0104\u0105\5C\"\2\u0105&\3"+
		"\2\2\2\u0106\u0107\5K&\2\u0107\u0108\5U+\2\u0108\u0109\5_\60\2\u0109\u010a"+
		"\5C\"\2\u010a\u010b\5]/\2\u010b\u010c\5a\61\2\u010c(\3\2\2\2\u010d\u010e"+
		"\5Y-\2\u010e\u010f\5]/\2\u010f\u0110\5K&\2\u0110\u0111\5S*\2\u0111\u0112"+
		"\5;\36\2\u0112\u0113\5]/\2\u0113\u0114\5k\66\2\u0114*\3\2\2\2\u0115\u0116"+
		"\5O(\2\u0116\u0117\5C\"\2\u0117\u0118\5k\66\2\u0118,\3\2\2\2\u0119\u011a"+
		"\5U+\2\u011a\u011b\5W,\2\u011b\u011c\5a\61\2\u011c.\3\2\2\2\u011d\u011e"+
		"\5U+\2\u011e\u011f\5c\62\2\u011f\u0120\5Q)\2\u0120\u0121\5Q)\2\u0121\60"+
		"\3\2\2\2\u0122\u0123\5g\64\2\u0123\u0124\5I%\2\u0124\u0125\5C\"\2\u0125"+
		"\u0126\5]/\2\u0126\u0127\5C\"\2\u0127\62\3\2\2\2\u0128\u0129\5K&\2\u0129"+
		"\u012a\5U+\2\u012a\u012b\5a\61\2\u012b\u012c\5W,\2\u012c\64\3\2\2\2\u012d"+
		"\u012e\5E#\2\u012e\u012f\5]/\2\u012f\u0130\5W,\2\u0130\u0131\5S*\2\u0131"+
		"\66\3\2\2\2\u0132\u0133\5c\62\2\u0133\u0134\5_\60\2\u0134\u0135\5C\"\2"+
		"\u01358\3\2\2\2\u0136\u0137\t\t\2\2\u0137:\3\2\2\2\u0138\u0139\t\n\2\2"+
		"\u0139<\3\2\2\2\u013a\u013b\t\13\2\2\u013b>\3\2\2\2\u013c\u013d\t\f\2"+
		"\2\u013d@\3\2\2\2\u013e\u013f\t\r\2\2\u013fB\3\2\2\2\u0140\u0141\t\16"+
		"\2\2\u0141D\3\2\2\2\u0142\u0143\t\17\2\2\u0143F\3\2\2\2\u0144\u0145\t"+
		"\20\2\2\u0145H\3\2\2\2\u0146\u0147\t\21\2\2\u0147J\3\2\2\2\u0148\u0149"+
		"\t\22\2\2\u0149L\3\2\2\2\u014a\u014b\t\23\2\2\u014bN\3\2\2\2\u014c\u014d"+
		"\t\24\2\2\u014dP\3\2\2\2\u014e\u014f\t\25\2\2\u014fR\3\2\2\2\u0150\u0151"+
		"\t\26\2\2\u0151T\3\2\2\2\u0152\u0153\t\27\2\2\u0153V\3\2\2\2\u0154\u0155"+
		"\t\30\2\2\u0155X\3\2\2\2\u0156\u0157\t\31\2\2\u0157Z\3\2\2\2\u0158\u0159"+
		"\t\32\2\2\u0159\\\3\2\2\2\u015a\u015b\t\33\2\2\u015b^\3\2\2\2\u015c\u015d"+
		"\t\34\2\2\u015d`\3\2\2\2\u015e\u015f\t\35\2\2\u015fb\3\2\2\2\u0160\u0161"+
		"\t\36\2\2\u0161d\3\2\2\2\u0162\u0163\t\37\2\2\u0163f\3\2\2\2\u0164\u0165"+
		"\t \2\2\u0165h\3\2\2\2\u0166\u0167\t!\2\2\u0167j\3\2\2\2\u0168\u0169\t"+
		"\"\2\2\u0169l\3\2\2\2\u016a\u016b\t#\2\2\u016bn\3\2\2\2\22\2\177\u0081"+
		"\u0089\u008b\u0093\u009b\u009e\u00a6\u00b1\u00b7\u00c2\u00c8\u00cb\u00d1"+
		"\u00d4\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}