package com.jar.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/7 14:39
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class IOServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8082);
            new Thread(() -> {
                try {
                    System.out.println("server 已经开始运行，并等待连接...");
                    // 获取新的连接
                    Socket socket = serverSocket.accept();
                    // 每一个新的连接，都需要创建线程，负责读取数据
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            int len;
                            try {
                                byte[] data = new byte[1024];
                                InputStream inputStream = socket.getInputStream();
                                while ((len = inputStream.read(data)) != -1) {
                                    System.out.println(new String(data, 0, len));
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }) {
                    }.start();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }) {
            }.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
