package com.jar.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

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
public class BIOClient {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8082);
                while (true) {
                    byte[] bytes = (new Date() + ": hello ，this is client.").getBytes();
                    socket.getOutputStream().write(bytes);
                    Thread.sleep(3000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        ) {
        }.start();
    }
}
