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

}