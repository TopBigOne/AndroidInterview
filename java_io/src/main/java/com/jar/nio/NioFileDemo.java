package com.jar.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/22 14:22
 * @Desc : read an
 */


public class NioFileDemo {

    public static final String tempFilePath = "/Users/dev/Documents/Android_work/AndroidInterview-master/java_io/src/doc/paicoding.txt";

    public static void main(String[] args) {

        NioFileDemo nioFileDemo = new NioFileDemo();
        nioFileDemo.writeFile();
        nioFileDemo.readFile();


    }

    public void writeFile() {
        Path path = Paths.get(tempFilePath);
        FileChannel fileChannel = null;
        try {
            fileChannel = FileChannel.open(path, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
            ByteBuffer buffer = StandardCharsets.UTF_8.encode("在家看看NIO，不是罪过吧");
            while (buffer.hasRemaining()) {
                fileChannel.write(buffer);
            }

            System.out.println("    写文件完成.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileChannel != null) {

                try {
                    fileChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }




    public void readFile() {
        Path path = Paths.get("/Users/dev/Documents/Android_work/AndroidInterview-master/java_io/src/main/java/com/jar/nio/IOClient.java");
        FileChannel fileChannel =null;
        try {
             fileChannel = FileChannel.open(path,StandardOpenOption.READ);
             ByteBuffer buffer = ByteBuffer.allocate(1024);
             int bytesRead = fileChannel.read(buffer);
             while (bytesRead!=-1){
                 buffer.flip();
                 System.out.println("读取的内容: " + StandardCharsets.UTF_8.decode(buffer));
                 buffer.clear();
                 bytesRead = fileChannel.read(buffer);
             }

            fileChannel.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
