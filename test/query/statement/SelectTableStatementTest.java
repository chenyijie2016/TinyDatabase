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
    public void testSelectValid() throws IOException, SQLExecuteException, SQLParseException {
        Listener listener = getListenerByTestFile("testdata/select/select.txt");
        List<Statement> statementList = listener.getStatementList();
        for (Statement statement : statementList) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager).toString());
        }
    }

//    @Test(expected = SQLParseException.class)
//    public void testCreateNotValid1() throws IOException, SQLExecuteException, SQLParseException {
//        Listener listener = getListenerByTestFile("testdata/create/create_error1.txt");
//        List<Statement> statementList = listener.getStatementList();
//        for (Statement statement : statementList) {
//            if (statement.isValid()) {
//                statement.execute(schemaManager);
//            } else {
//                System.out.println(statement.getMessage());
//                throw new SQLParseException(statement.getMessage());
//            }
//        }
//        assertNotNull(schemaManager.getCurrentDataBase().getTableByName("employee"));
//    }
}