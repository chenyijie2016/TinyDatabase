package query.statement;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.AfterClass;
import query.Listener;
import query.TinySQLLexer;
import query.TinySQLParser;
import schema.Schema;
import schema.SchemaManager;

import java.io.IOException;

public class BaseTest {
    protected static SchemaManager schemaManager = SchemaManager.getNewSchemaManger();

    protected static Listener getListenerByTestFile(String filename) throws IOException {
        CharStream in = CharStreams.fromFileName(filename);
        TinySQLLexer lexer = new TinySQLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TinySQLParser parser = new TinySQLParser(tokens);
        ParseTree tree = parser.parse();
        Listener listener = new Listener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
        return listener;
    }

    @AfterClass
    public static void cleanUp() throws IOException {
        schemaManager.getCurrentDataBase().dropAll();
    }
}
