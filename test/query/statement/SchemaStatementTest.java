package query.statement;

import database.DataBase;
import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import query.Listener;

import java.io.IOException;

import static org.junit.Assert.*;

public class SchemaStatementTest extends BaseTest {
    @BeforeClass
    public static void before() throws IOException, SQLExecuteException {
        for (DataBase dataBase : schemaManager.schema().getDataBases()) {
            schemaManager.dropDataBaseByName(dataBase.getName());
        }
        schemaManager.schema().createDatabaseByName("test");
        schemaManager.switchDataBase("test");
    }

    @AfterClass
    public static void clean() throws IOException, SQLExecuteException {
        for (DataBase dataBase : schemaManager.schema().getDataBases()) {
            schemaManager.dropDataBaseByName(dataBase.getName());
        }
        schemaManager.schema().createDatabaseByName("test");
        schemaManager.switchDataBase("test");
    }

    @Test
    public void TestSchema() throws IOException, SQLExecuteException, SQLParseException {
        Listener listener = getListenerByTestFile("resources/schema/schema.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager));

        }
    }
}