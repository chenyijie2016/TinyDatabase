package query.statement;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.After;
import org.junit.Before;
import query.ErrorListener;
import query.Listener;
import query.TinySQLLexer;
import query.TinySQLParser;
import schema.SchemaManager;

import java.io.IOException;

public class BaseTest {
    protected static SchemaManager schemaManager = SchemaManager.getNewSchemaManger();

    protected static Listener getListenerByTestFile(String filename) throws IOException, SQLParseException {
        CharStream in = CharStreams.fromFileName(filename);
        TinySQLLexer lexer = new TinySQLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TinySQLParser parser = new TinySQLParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ErrorListener());
        ParseTree tree;
        try {
            tree = parser.parse();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            throw new SQLParseException(e.getMessage());
        }
        Listener listener = new Listener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
        return listener;
    }

    @Before
    public void setUp() throws SQLExecuteException, IOException {
        schemaManager.getCurrentDataBase().dropAllTable();
    }

    @After
    public void cleanUp() throws SQLExecuteException, IOException {
        schemaManager.getCurrentDataBase().dropAllTable();
    }


}
