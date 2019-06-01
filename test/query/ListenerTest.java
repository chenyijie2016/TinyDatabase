package query;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.misc.EqualityComparator;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Before;
import org.junit.Test;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class ListenerTest {
    private TinySQLParser parser;
    private TinySQLLexer lexer;
    private Listener listener;

    @Before
    public void setUp() {
        System.out.println("Start Test");


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
            assertEquals(2, listener.getStatementList().size());
            for (Statement statement : listener.getStatementList()) {
                System.out.println(statement);
            }
        } catch (IOException e) {
            return;
        }
    }
}