package com.jar.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/23 15:08
 * @Desc :
 */
public class TcpClient {

    public static void main(String[] args) {
        TcpClient tcpClient = new TcpClient();
        tcpClient.startTcp();
    }

    public void startTcp() {
        System.out.println("startTcp......");
        Selector selector = null;
        try {
            selector = Selector.open();
            SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9090));
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_WRITE);

            Scanner scanner = new Scanner(System.in);
            String line;
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (selector.select() > 0) {
                Set<SelectionKey> keys = selector.selectedKeys();
                for (SelectionKey key : keys) {
                    if (key.isWritable()) {
                        if ("Bye".equals((line = scanner.nextLine()))) {
                            socketChannel.shutdownOutput();
                            socketChannel.close();
                            break;
                        }
                        buf.put(line.getBytes());
                        buf.flip();
                        socketChannel.write(buf);
                        buf.compact();
                    }
                }
                keys.clear();
                if (!socketChannel.isOpen()) break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
