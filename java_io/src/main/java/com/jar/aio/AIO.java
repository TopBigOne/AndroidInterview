package com.jar.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/19 18:39
 * @Desc : 异步IO ：异步IO的一个常见模型是使用回调（Callback）来处理操作完成的通知和结果。
 */
public class AIO {

    public static String javaFilePath = "/Users/dev/Documents/Android_work/AndroidInterview-master/java_io/src/main/java/com/jar/aio/AIO.java";

    public static void main(String[] args) {
        startReadFullFile();

    }


    public static void startReadFullFile() {
        Path filePath = Paths.get(javaFilePath);
        AsynchronousFileChannel fileChannel = null;
        try {
            fileChannel = AsynchronousFileChannel.open(filePath, StandardOpenOption.READ);


            long fileSize = fileChannel.size();
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);

            CountDownLatch latch = new CountDownLatch(1);
            List<ByteBuffer> bufferList = new ArrayList<>();

            AsynchronousFileChannel finalFileChannel = fileChannel;
            fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer bytesRead, ByteBuffer attachment) {
                    if (bytesRead > 0) {
                        attachment.flip();
                        ByteBuffer copyBuffer = ByteBuffer.allocate(attachment.remaining());
                        copyBuffer.put(attachment);
                        bufferList.add(copyBuffer);
                        attachment.clear();

                        long newPosition = bytesRead + attachment.position();
                        finalFileChannel.read(attachment, newPosition, attachment, this);
                    } else {
                        latch.countDown();
                    }
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    exc.printStackTrace();
                    latch.countDown();
                }
            });

            latch.await();

            byte[] mergedData = mergeBuffers(bufferList);

            // 将字节数组转换为字符串或进行其他处理
            String content = new String(mergedData);
            System.out.println(content);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    private static byte[] mergeBuffers(List<ByteBuffer> bufferList) {
        int totalBytes = bufferList.stream().mapToInt(ByteBuffer::remaining).sum();
        byte[] mergedData = new byte[totalBytes];

        int offset = 0;
        for (ByteBuffer buffer : bufferList) {
            int length = buffer.remaining();
            buffer.get(mergedData, offset, length);
            offset += length;
        }

        return mergedData;
    }
}



