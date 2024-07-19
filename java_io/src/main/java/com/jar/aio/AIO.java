package com.jar.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.CountDownLatch;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/19 18:39
 * @Desc : 异步IO ：异步IO的一个常见模型是使用回调（Callback）来处理操作完成的通知和结果。
 */
public class AIO {

    static String filePath = "/Users/dev/Documents/Android_work/AndroidInterview-master/java_io/src/main/java/com/jar/BufferDemo.java";

    public static void main(String[] args) {
        Path filePath = Paths.get("/Users/dev/Documents/Android_work/AndroidInterview-master/java_io/src/main/java/com/jar/BufferDemo.java");
        AsynchronousFileChannel fileChannel = null;
        try {
            fileChannel = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ);


            ByteBuffer buffer = ByteBuffer.allocate(1024);

            CountDownLatch latch = new CountDownLatch(1); // 创建一个CountDownLatch，初始值为1

            fileChannel.read(buffer, 0, null, new CompletionHandler<Integer, Void>() {
                @Override
                public void completed(Integer bytesRead, Void attachment) {
                    buffer.flip();
                    byte[] data = new byte[buffer.remaining()];
                    buffer.get(data);
                    String content = new String(data);
                    System.out.println("Read complete. Content: " + content);

                    // 处理读取的结果
                    processData(content);

                    buffer.clear(); // 清空缓冲区，为下一次读取做准备

                    latch.countDown(); // 完成读取后，减少CountDownLatch的计数
                }

                @Override
                public void failed(Throwable exc, Void attachment) {
                    System.out.println("Read failed: " + exc.getMessage());

                    latch.countDown(); // 读取失败时，也需要减少CountDownLatch的计数
                }
            });

            latch.await(); // 等待CountDownLatch的计数减为0，即异步操作完成

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(" ERROR  : " + e.getMessage());
        }

        // 继续执行其他操作...
    }

    private static void processData(String content) {
        // 处理读取的数据
        System.out.println("Processing data: " + content);
    }


}
