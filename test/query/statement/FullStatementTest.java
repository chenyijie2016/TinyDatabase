package query.statement;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.Test;
import query.Listener;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class FullStatementTest extends BaseTest {
    @Test
    public void TestPrimary() throws SQLExecuteException, SQLParseException, IOException {
        Listener listener = getListenerByTestFile("resources/full/primaryKey.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager));
        }
    }

    @Test
    public void TestFull() throws SQLExecuteException, SQLParseException, IOException {
        Listener listener = getListenerByTestFile("resources/full/full.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager).toString());
        }
    }

    @Test
    public void TestFull2() throws SQLExecuteException, SQLParseException, IOException {
        Listener listener = getListenerByTestFile("resources/full/full2.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager).toString());
        }
    }
}