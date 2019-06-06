package query.statement;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.Test;
import query.Listener;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class DeleteTableStatementTest extends BaseTest {
    @Test
    public void TestDelete() throws SQLExecuteException, SQLParseException, IOException {
        Listener listener = getListenerByTestFile("resources/delete/delete.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager).toString());
        }
    }

}