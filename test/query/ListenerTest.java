package query;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import query.statement.InsertTableStatement;
import query.statement.SchemaStatement;
import query.statement.Statement;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class ListenerTest {
    private TinySQLParser parser;
    private TinySQLLexer lexer;
    private Listener listener;




    @Before
    public void setUp() {

    }

    private void prepareEnv(CharStream in) {
        lexer = new TinySQLLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new TinySQLParser(tokens);
        ParseTree tree = parser.parse();
        listener = new Listener();
        ParseTreeWalker.DEFAULT.walk(listener, tree);
    }

    @Test
    public void parseSQL() {
        try {
            CharStream in = CharStreams.fromFileName("testdata/sql1.txt");
            prepareEnv(in);
            List<Statement> statementList = listener.getStatementList();
//            assertEquals(2, statementList.size());
            assertTrue(statementList.get(1) instanceof SchemaStatement);
        } catch (IOException e) {
            return;
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void testInsert() {
        try {
            CharStream in = CharStreams.fromFileName("testdata/insert.txt");
            prepareEnv(in);
            List<Statement> statementList = listener.getStatementList();
            assertEquals(3, statementList.size());
            assertTrue(statementList.get(1) instanceof InsertTableStatement);
            assertTrue(statementList.get(0).isValid());
            assertTrue(statementList.get(1).isValid());
            assertFalse(statementList.get(2).isValid());

        } catch (IOException e) {

        }
    }
}