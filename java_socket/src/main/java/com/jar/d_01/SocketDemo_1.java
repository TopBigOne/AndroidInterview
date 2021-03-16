package com.jar.d_01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;

/**
 * @author : dev
 * @version :
 * @Date :  3/16/21 5:46 PM
 * @Desc :
 */
public class SocketDemo_1 {

    public void test() {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            java.net.Socket socket = serverSocket.accept();
            Writer out;
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            writer.write(" 这是来自一段服务器的问候：hello world....");
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SocketDemo_1 socketDemo_1 = new SocketDemo_1();
        socketDemo_1.test();
    }

}
