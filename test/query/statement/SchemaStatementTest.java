package query.statement;

import database.DataBase;
import exception.SQLExecuteException;
import exception.SQLParseException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import query.Listener;
import schema.Schema;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class SchemaStatementTest extends BaseTest {
//    @BeforeClass
//    public static void before() throws  SQLExecuteException {
//        List<String> names = new LinkedList<>();
//        for (DataBase dataBase : schemaManager.schema().getDataBases()) {
//            names.add(dataBase.getName());
//        }
//        names.forEach(name-> {
//            try {
//                schemaManager.dropDataBaseByName(name);
//            } catch (SQLExecuteException e) {
//                e.printStackTrace();
//            }
//        });
//        schemaManager.schema().createDatabaseByName(Schema.DEFAULT_DATABASE_NAME);
//        schemaManager.switchDataBase(Schema.DEFAULT_DATABASE_NAME);
//    }
//
//    @AfterClass
//    public static void clean() throws  SQLExecuteException {
//        List<String> names = new LinkedList<>();
//        for (DataBase dataBase : schemaManager.schema().getDataBases()) {
//            names.add(dataBase.getName());
//        }
//        names.forEach(name-> {
//            try {
//                schemaManager.dropDataBaseByName(name);
//            } catch (SQLExecuteException e) {
//                e.printStackTrace();
//            }
//        });
//        schemaManager.schema().createDatabaseByName(Schema.DEFAULT_DATABASE_NAME);
//        schemaManager.switchDataBase(Schema.DEFAULT_DATABASE_NAME);
//    }

    @Test
    public void TestSchema() throws IOException, SQLExecuteException, SQLParseException {
        Listener listener = getListenerByTestFile("resources/schema/schema.sql");
        for (Statement statement : listener.getStatementList()) {
            assertTrue(statement.isValid());
            System.out.println(statement.execute(schemaManager));
        }
    }
}