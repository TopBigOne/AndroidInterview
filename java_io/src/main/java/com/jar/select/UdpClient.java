package com.jar.select;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Scanner;
import java.util.Set;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2024/7/23 15:06
 * @Desc : UDP 客户端 :https://www.cnblogs.com/robothy/p/14242971.html
 */
public class UdpClient {
    public static void main(String[] args) {
        UdpClient udpClient = new UdpClient();
        udpClient.startUdp();
    }

    public void startUdp() {

        Selector selector = null;                        // 获取选择器
        try {
            selector = Selector.open();

            DatagramChannel datagramChannel = DatagramChannel.open();   // 打开一个数据报通道
            datagramChannel.configureBlocking(false);                   // 配置通道为非阻塞模式
            datagramChannel.register(selector, SelectionKey.OP_WRITE);  // 将通道的写事件注册到选择器
            ByteBuffer buff = ByteBuffer.allocate(1024);                // 分配字节缓冲区
            Scanner scanner = new Scanner(System.in);                   // 创建扫描器，扫描控制台输入流
            InetSocketAddress server = new InetSocketAddress("localhost", 9090); // 本地IP
            while (selector.select() > 0) {                              // 有就绪事件
                Set<SelectionKey> keys = selector.selectedKeys();       // 获取选择键，即就绪的事件
                for (SelectionKey key : keys) {                           // 遍历选择键
                    if (key.isWritable()) {                               // 如果当前选择键是读就绪
                        String line;
                        if ("Bye".equals(line = scanner.nextLine())) { // 从控制台获取 1 行输入，并检查输入的是不是 Bye
                            System.exit(0);                 // 正常退出
                        }
                        buff.put(line.getBytes());          // 放入缓冲区
                        buff.flip();                        // 将缓冲区置为读状态
                        datagramChannel.send(buff, server); // 往 I/O 写数据
                        buff.compact();                     // 压缩缓冲区，保留没发送完的数据
                    }
                }
                keys.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
