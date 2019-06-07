package client;

import org.apache.commons.cli.*;

import common.Triplet;
import server.Protocol;


import javax.swing.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;


class Client extends JFrame implements ActionListener {

    private int port = 3306;
    private String host = "localhost";
    private static JMenuBar menuBar = new JMenuBar();
    private static JMenu fileMenu = new JMenu("file");
    private static JMenuItem importSql = new JMenuItem("import");
    private static JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    private static JPanel contentPanel = new JPanel();
    private static JMenuItem connectServer = new JMenuItem("connect");
    private static JPanel bodyPanel = new JPanel();
    private static JScrollPane tablePanel = new JScrollPane();
    private static JButton clearButton = new JButton("clear");
    private static JButton executeButton = new JButton("execute SQL");
    private static JTable resultTable;
    private static JTextArea sqlStatementsInput = new JTextArea();
    private static JLabel message = new JLabel("message");
    private Socket socket = null;
    private ReceiveWorker receiveWorker;

    private Client(String host, int port) {
        this.host = host;
        this.port = port;
        resultTable = new JTable();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setTitle("TinyDatabase Client");
        setLayout(new BorderLayout());

        // Menu Bar
        menuBar.add(fileMenu);
        connectServer.setActionCommand("connect");
        importSql.setActionCommand("import");
        fileMenu.add(connectServer);
        fileMenu.add(importSql);
        connectServer.addActionListener(this);
        importSql.addActionListener(this);

        message.setText("Not connected to the server");
        message.setForeground(Color.RED);
        add(menuBar, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);

        contentPanel.setLayout(new BorderLayout());
        contentPanel.add(buttonPanel, BorderLayout.NORTH);
        contentPanel.add(bodyPanel, BorderLayout.CENTER);
        contentPanel.add(message, BorderLayout.SOUTH);
        clearButton.setActionCommand("clear");
        executeButton.setActionCommand("execute");
        clearButton.addActionListener(this);
        executeButton.addActionListener(this);
        buttonPanel.add(clearButton);
        buttonPanel.add(executeButton);

        GridLayout gridLayout = new GridLayout(2, 1, 10, 10);
        bodyPanel.setLayout(gridLayout);
        bodyPanel.add(new JScrollPane(sqlStatementsInput));
        bodyPanel.add(tablePanel);
        tablePanel.add(resultTable);


    }

    public static void main(String[] args) {
        Options options = new Options();
        Option portOption = new Option("p", "port", true, "port");
        portOption.setRequired(false);

        options.addOption(portOption);
        Option hostOption = new Option("h", "host", true, "hostname");
        hostOption.setRequired(false);
        options.addOption(hostOption);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("java -jar TinyDatabaseClient.jar", options);
            System.exit(1);
        }
        int port = cmd.getOptionValue("port") == null ? 3306 : Integer.parseInt(cmd.getOptionValue("port"));
        String host = cmd.getOptionValue("host") == null ? "localhost" : cmd.getOptionValue("host");
        Client client = new Client(host, port);
        client.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "clear":
                System.out.println(sqlStatementsInput.getText());
                sqlStatementsInput.setText("");
                break;
            case "execute":
                if (socket == null) {
                    message.setText("Not connected!");
                    message.setForeground(Color.BLUE);
                    return;
                }

                System.out.println(sqlStatementsInput.getText());
                new SendWorker(socket);
                break;
            case "connect":
                if (socket != null) {
                    int dialogResult = JOptionPane.showConfirmDialog(null, "It seems you have connected to a server, CLOSE and reconnect?", "Warning", JOptionPane.YES_NO_OPTION);
                    if (dialogResult == JOptionPane.YES_OPTION) {
                        connect();
                    }
                } else {
                    connect();
                }

                break;
            case "import":
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fileChooser.showDialog(new JLabel(), "选择");
                File file = fileChooser.getSelectedFile();
                try {
                    FileInputStream inputStream = new FileInputStream(file);
                    String sql = new String(inputStream.readAllBytes());
                    sqlStatementsInput.setText(sql);
                } catch (IOException err) {
                    message.setForeground(Color.RED);
                    message.setText("Error when import file");
                }
                break;
        }
    }

    private void connect() {
        try {
            socket = new Socket(host, port);
            message.setText("Connect Success!");
            message.setForeground(Color.GREEN);
            receiveWorker = new ReceiveWorker(socket);

        } catch (IOException e) {
            e.printStackTrace();
            message.setText("Connect Failed!");
        }
    }

    private class SendWorker extends Thread {
        Socket socket;

        SendWorker(Socket socket) {
            this.socket = socket;
            start();
        }

        @Override
        public void run() {
            try {
                socket.getOutputStream().write(sqlStatementsInput.getText().getBytes());
            } catch (IOException e) {
                message.setText("Write failed");
            }
        }
    }

    private class ReceiveWorker extends Thread {
        Socket socket;

        ReceiveWorker(Socket socket) {
            this.socket = socket;
            start();
        }

        @Override
        public void run() {
            System.out.println("Start receive worker");
            while (true) {
                if (socket.isClosed()) {
                    return;
                }
                try {
                    if (socket.getInputStream().available() > 0) {

                        byte[] data = new byte[socket.getInputStream().available()];
                        socket.getInputStream().read(data);
                        if (Protocol.isError(data)) {
                            String errMessage = Protocol.getErrorMessage(data);
                            System.out.println("error:" + errMessage);
                            message.setText(errMessage);
                            message.setForeground(Color.RED);
                        } else {
                            Triplet<String[], String[][], Long> result = Protocol.fromBytes(data);
                            Long time = result.getThird();
                            message.setText("Time Cost: " + time + "ms");
                            message.setForeground(Color.BLACK);
                            bodyPanel.remove(1);
                            resultTable = new JTable(result.getSecond(), result.getFirst());
                            bodyPanel.add(new JScrollPane(resultTable));
                            revalidate();
                        }
                    }
                } catch (IOException e) {
                    message.setText("Receive Thead Error");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

