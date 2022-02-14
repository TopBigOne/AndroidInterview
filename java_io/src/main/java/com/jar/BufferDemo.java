package com.jar;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author : dev
 * @version :
 * @Date :  2022/2/8 10:04
 * @Desc :
 */
public class BufferDemo {
    public static void main(String[] args) {
        BufferDemo bufferDemo = new BufferDemo();
        bufferDemo.readFile();
    }

    public void readFile() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/dev/Documents/Android_work/AndroidInterview-master/java_io/src/main/java/com/jar/nio/IOClient.java", "rw");
            FileChannel channel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int bytesRead = channel.read(byteBuffer);
            while (bytesRead != -1) {
                // 写模式切换到读模式
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    byte charContent = byteBuffer.get();
                    System.out.println("charContent : " + charContent);
                }
                byteBuffer.clear();
                bytesRead = channel.read(byteBuffer);
            }
            randomAccessFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
