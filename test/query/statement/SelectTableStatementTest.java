package query.statement;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.Test;
import query.Listener;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


public class SelectTableStatementTest extends BaseTest {

    @Test()
    public void testSelect() throws IOException, SQLExecuteException, SQLParseException {
        Listener listener = getListenerByTestFile("resources/select/select.txt");
        List<Statement> statementList = listener.getStatementList();
        for (Statement statement : statementList) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager).toString());
        }
    }
}