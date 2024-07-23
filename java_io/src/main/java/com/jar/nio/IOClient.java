package com.jar.nio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/7 14:34
 * @Url :
 * @Level :  easy
 * @Desc : BIO
 * @Counter :
 * @Answer :
 */
public class IOClient {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Socket socket = new Socket("127.0.0.1", 8082);
                    int index = 0;
                    while (true) {
                        System.err.println("    @@@ client start connection....");
                        byte[] bytes = (index + " : 世佳").getBytes();
                        socket.getOutputStream().write(bytes);
                        index++;
                        Thread.sleep(3000);

                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        ) {
        }.start();
    }
}
