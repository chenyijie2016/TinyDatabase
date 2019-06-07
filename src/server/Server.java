package server;

import exception.SQLExecuteException;
import exception.SQLParseException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import query.*;
import query.statement.Statement;
import schema.SchemaManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable {
    private Socket socket;
    private static int id = 0;
    private int clientId;
    private SchemaManager schemaManager;

    Server(Socket socket, int clientId) {
        this.socket = socket;
        this.clientId = clientId;
        schemaManager = SchemaManager.getNewSchemaManger();
    }

    public static void main(String[] args) throws IOException {

        System.out.println("server is running!");
        System.out.println(System.getProperty("user.dir"));
        ServerSocket socket = new ServerSocket(3306);
        System.out.println("Server start on port: " + 3306);
        while (true) {
            Socket sock = socket.accept();
            System.out.println("Receive client connect");
            new Thread(new Server(sock, id++)).start();
        }

    }

    @Override
    public void run() {
        try {
            System.out.println("Start Serving for Client " + clientId);
            InputStream inputStream = socket.getInputStream();
            while (true) {
                if (inputStream.available() > 0) {
                    char[] buffer = new char[inputStream.available()];
                    System.out.print("Receive SQL from client " + clientId + " :");
                    InputStreamReader reader = new InputStreamReader(inputStream);
                    reader.read(buffer);
                    String sqlStatementListString = new String(buffer);
                    System.out.println("Executing SQL:" + sqlStatementListString + " " + sqlStatementListString.length());
                    try {
                        CharStream in = CharStreams.fromString(sqlStatementListString);
                        TinySQLLexer lexer = new TinySQLLexer(in);
                        CommonTokenStream tokens = new CommonTokenStream(lexer);
                        TinySQLParser parser = new TinySQLParser(tokens);
                        parser.removeErrorListeners();
                        parser.addErrorListener(new ErrorListener());
                        ParseTree tree;
                        try {
                            tree = parser.parse();
                        } catch (RuntimeException e) {
                            throw new SQLParseException(e.getMessage());
                        }
                        System.out.println("parse finished");
                        Listener listener = new Listener();
                        ParseTreeWalker.DEFAULT.walk(listener, tree);
                        for (Statement statement : listener.getStatementList()) {
                            if (!statement.isValid()) {
                                throw new SQLParseException(statement.getMessage());
                            }
                        }
                        System.out.println("start executing");
                        long startTime = System.currentTimeMillis();
                        Result result = null;
                        for (Statement statement : listener.getStatementList()) {
                            result = statement.execute(schemaManager);
                        }
                        long endTime = System.currentTimeMillis();
                        System.out.println(result);
                        byte[] response = Protocol.resultToBytes(result, endTime - startTime);
                        socket.getOutputStream().write(response);
                    } catch (SQLParseException | SQLExecuteException | NullPointerException e) {
                        e.printStackTrace();
                        byte[] response = Protocol.errorToBytes(e.getMessage());
                        socket.getOutputStream().write(response);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }
}
