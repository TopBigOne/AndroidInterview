* NIO有三大核心部分：Channel(通道)、Buffer(缓冲区)、Selector(选择器)。Selector可以选择一个通道Channel，通道和Buffer缓冲区交互，客户端和Buffer缓冲区交互。
* BIO基于字节流和字符流进行操作，而NIO基于Channel(通道)和Buffer(缓冲区)进行操作， 数据总是从通道读取到缓冲区中，或者从缓冲区写入通道中。
* Selector(选择器) 用于监听多个通道的事件(比如连接请求、数据到达等)，因此使用单个线程就可以监听到多个客户端通道。
---
## Channel通道
### 简介
1. NIO channel 通道类似于流，但是有区别：

(1) 通道可以同时读或者写，而流只能读或者只能写

(2)通道可以实现异步读写数据

(3)通道可以从缓冲区读数据，也可以写数据到缓冲区

### Channel 在NIO中是一个接口，下面有很多子接口和主要实现。主要实现有：

* FileChannel 注意用于文件的数据读写，
* DatagramChannel 用于UDP的数据读写，
* ServerSocketChannel SocketChannel 用于TCP的数据读写。

## ByteBuffer

* allocate(int capacity)：静态方法，分配一个指定容量的新字节缓冲区。
* clear()：清空缓冲区，将位置设置为 0，限制设置为容量，用于准备写入数据。
* flip()：将缓冲区从写模式切换为读模式，将限制设置为当前位置，将位置重置为 0，用于准备读取数据。
* rewind()：将位置设置为 0，保持限制不变，用于重读缓冲区中的数据。
* compact()：将缓冲区中未读取的数据复制到缓冲区的开始位置，将位置设置为复制后的位置，限制设置为容量，用于继续写入数据。
* put(byte b)：将一个字节写入缓冲区的当前位置，位置递增。
* put(byte[] src)：将字节数组写入缓冲区的当前位置，位置递增。
* put(ByteBuffer src)：将另一个字节缓冲区的内容写入当前缓冲区，位置递增。
* get()：从缓冲区的当前位置读取一个字节，位置递增。
* get(byte[] dst)：从缓冲区的当前位置读取字节到指定的字节数组，位置递增。
* get(ByteBuffer dst)：从缓冲区的当前位置读取字节到另一个字节缓冲区，位置递增。
* remaining()：返回当前位置与限制之间的字节数量。
* hasRemaining()：检查是否还有未读取的字节。
* mark()：在当前位置设置一个标记。
* reset()：将位置重置为之前设置的标记位置。
* markSupported()：检查缓冲区是否支持标记和重置操作。

# 小结
* BIO（Blocking I/O）：采用阻塞式 I/O 模型，线程在执行 I/O 操作时被阻塞，无法处理其他任务，适用于连接数较少且稳定的场景。

* NIO（New I/O 或 Non-blocking I/O）：使用非阻塞 I/O 模型，线程在等待 I/O 时可执行其他任务，通过 Selector 监控多个 Channel 上的事件，提高性能和可伸缩性，适用于高并发场景。

* AIO（Asynchronous I/O）：采用异步 I/O 模型，线程发起 I/O 请求后立即返回，当 I/O 操作完成时通过回调函数通知线程，进一步提高了并发处理能力，适用于高吞吐量场景。
  * 用CompletionHandler 回调接收事件完成；



## 参考
[NIO简介以及三大组件(Buffer\Channel\Selector)基本使用 ](https://www.cnblogs.com/qlqwjy/p/14433524.html)
[一文彻底解释清楚Java 中的NIO、BIO和AIO](https://javabetter.cn/nio/BIONIOAIO.html)
[异步文件通道 AsynchronousFileChannel](https://www.cnblogs.com/czwbig/p/10056131.html)
[How can AsynchronousFileChannel read large file?](https://stackoverflow.com/questions/19532020/how-can-asynchronousfilechannel-read-large-file)
[Java NIO 选择器 Selector](https://www.cnblogs.com/robothy/p/14242971.html)



