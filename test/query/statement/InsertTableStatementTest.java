package query.statement;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.Test;
import query.Listener;

import java.io.IOException;

import static org.junit.Assert.*;

public class InsertTableStatementTest extends BaseTest {
    @Test
    public void TestInsert() throws SQLExecuteException, SQLParseException, IOException {
        Listener listener = getListenerByTestFile("resources/insert/insert.sql");
        for (Statement statement : listener.getStatementList()) {
            if (statement.isValid()) {
                statement.execute(schemaManager);
            }
        }
    }

    @Test
    public void TestNull() throws SQLParseException, IOException, SQLExecuteException {
        Listener listener = getListenerByTestFile("resources/insert/insert_withnull.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager));

        }
    }

    @Test
    public void TestNullError() throws SQLParseException, IOException, SQLExecuteException {
        Listener listener = getListenerByTestFile("resources/insert/insert_null_error.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            boolean ok = true;
            try {
                System.out.println(statement.execute(schemaManager));
            }
            catch (SQLExecuteException e) {
                System.out.println("Error! " + e.getMessage());
                ok = false;
            }
//            assertFalse(ok);
        }
    }
}