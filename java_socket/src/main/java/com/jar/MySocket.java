package com.jar;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author : dev
 * @version :
 * @Date :  1/7/22 10:04 AM
 * @Desc :
 */
public class MySocket {
    public void tesOne(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
            }
            System.out.println("result: " + sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
