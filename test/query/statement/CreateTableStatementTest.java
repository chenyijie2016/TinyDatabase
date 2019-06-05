package query.statement;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.Test;
import query.Listener;

import java.io.IOException;
import java.util.List;


import static org.junit.Assert.*;


public class CreateTableStatementTest extends BaseTest {

    @Test()
    public void testCreateValid() throws IOException, SQLExecuteException, SQLParseException {
        Listener listener = getListenerByTestFile("testdata/create/create.txt");
        List<Statement> statementList = listener.getStatementList();
        for (Statement statement : statementList) {
            assertTrue(statement.isValid());
            statement.execute(schemaManager);
        }
        assertNotNull(schemaManager.getCurrentDataBase().getTableByName("employee"));
    }

    @Test(expected = SQLParseException.class)
    public void testCreateNotValid1() throws IOException, SQLExecuteException, SQLParseException {
        Listener listener = getListenerByTestFile("testdata/create/create_error1.txt");
        List<Statement> statementList = listener.getStatementList();
        for (Statement statement : statementList) {
            if (statement.isValid()) {
                statement.execute(schemaManager);
            } else {
                System.out.println(statement.getMessage());
                throw new SQLParseException(statement.getMessage());
            }
        }
        assertNotNull(schemaManager.getCurrentDataBase().getTableByName("employee"));
    }
}