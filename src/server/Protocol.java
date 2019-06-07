package server;

import query.Result;
import common.Triplet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class Protocol {
    public static byte[] resultToBytes(Result result) throws IOException {
        return resultToBytes(result, 0);
    }

    public static boolean isError(byte[] data) {
        return data[0] == 1;
    }

    public static byte[] resultToBytes(Result result, long time) throws IOException {
        // build table header
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        stream.write(0);
        stream.write(ByteBuffer.allocate(Long.BYTES).putLong(time).array());
        stream.write(result.getProtocolBytes());
        return stream.toByteArray();
    }

    public static byte[] errorToBytes(String message) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        stream.write(1);
        stream.write(ByteBuffer.allocate(Integer.BYTES).putInt(message.length()).array());
        stream.write(message.getBytes());
        return stream.toByteArray();
    }

    public static String getErrorMessage(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        byte flag = buffer.get();
        int length = buffer.getInt();
        byte[] message = new byte[length];
        buffer.get(message);
        return new String(message);

    }

    public static Triplet<String[], String[][], Long> fromBytes(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        byte flag = buffer.get();
        Long time = buffer.getLong();
        Integer columnSize = buffer.getInt();
        Integer rowSize = buffer.getInt();
        String[] columnNames = new String[columnSize];
        String[][] objs = new String[rowSize][];
        for (int i = 0; i < columnSize; i++) {
            byte[] name = new byte[buffer.getInt()];
            buffer.get(name);
            columnNames[i] = new String(name);
        }
        for (int i = 0; i < rowSize; i++) {
            objs[i] = new String[columnSize];
            for (int j = 0; j < columnSize; j++) {
                byte[] name = new byte[buffer.getInt()];
                buffer.get(name);
                objs[i][j] = new String(name);
            }
        }

        return new Triplet<String[], String[][], Long>(columnNames, objs, time);
    }
}
