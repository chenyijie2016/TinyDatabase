package query.statement;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.Test;
import query.Listener;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class UpdateTableStatementTest extends BaseTest {
    @Test
    public void TestUpdate() throws SQLExecuteException, SQLParseException, IOException {
        Listener listener = getListenerByTestFile("resources/update/update.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager).toString());
        }
    }

}