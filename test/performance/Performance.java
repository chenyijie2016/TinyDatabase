package performance;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.Before;
import org.junit.Test;
import query.Listener;
import query.statement.BaseTest;
import query.statement.Statement;

import java.io.*;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class Performance extends BaseTest {
    @Before
    public void prepareData() throws IOException {
        Random r = new Random();
        BufferedWriter out = new BufferedWriter(new FileWriter("performance.sql"));
        out.write("create table test( id int, name string(20), salary double, age long, primary key(id));\n");
        for (int i = 0; i < 10000; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append("insert into test values(").append(i).append(",").append("'asdasd'").append(",")
                    .append(r.nextDouble() * 1000).append(",").append(r.nextLong()).append(");\n");
            out.write(builder.toString());
        }
        out.flush();
        out.close();

    }

    @Test
    public void test() throws SQLExecuteException, SQLParseException, IOException {
        Listener listener = getListenerByTestFile("performance.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            statement.execute(schemaManager);
        }
    }
}
