package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Server implements Runnable {
    private Socket socket;

    Server(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("server is running!");
        System.out.println(System.getProperty("user.dir"));
        ServerSocket socket = new ServerSocket(3306);
        System.out.println("Server start on port" + 3306);
        while (true) {
            Socket sock = socket.accept();
            new Thread(new Server(sock));
        }

    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            char[] buffer = new char[2048];
            in.read(buffer);
            String sqlStatementListString = new String(buffer);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
