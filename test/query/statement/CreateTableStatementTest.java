package query.statement;

import org.junit.Test;
import query.Listener;

import java.io.IOException;
import java.util.List;


import static org.junit.Assert.*;


public class CreateTableStatementTest extends BaseTest {

    @Test
    public void testCreate() throws IOException {
        Listener listener = getListenerByTestFile("testdata/create.txt");
        List<Statement> statementList = listener.getStatementList();
        for (Statement statement : statementList) {
            assertTrue(statement.isValid());
            statement.execute(schemaManager);
        }
        assertNotNull(schemaManager.getCurrentDataBase().getTableByName("employee"));
    }
}