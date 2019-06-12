package server;

import query.Result;
import common.Triplet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 负责客户端与服务端的通信与通信协议
 */
public class Protocol {
    public static final byte[] PACKET_END = {'e', 'n', 'd'};

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
        stream.write(PACKET_END);
        return stream.toByteArray();
    }

    public static byte[] errorToBytes(String message) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        stream.write(1);
        stream.write(ByteBuffer.allocate(Integer.BYTES).putInt(message.length()).array());
        stream.write(message.getBytes());
        stream.write(PACKET_END);
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

    public static boolean isEnd(byte[] data) {
        if (data.length < 3) {
            return false;
        }
        return data[data.length-3] == PACKET_END[0] && data[data.length-2] == PACKET_END[1] && data[data.length-1] == PACKET_END[2];
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
