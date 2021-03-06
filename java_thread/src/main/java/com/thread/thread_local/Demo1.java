package com.thread.thread_local;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/3 01:13
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :  https://juejin.cn/post/6982121384533032991
 */
public class Demo1 {
    public static void main(String[] args) {
        try {
            test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class LocalVariable {
        //总共有5M
        private byte[] locla = new byte[1024 * 1024 * 5];
    }

    // (1)创建了一个核心线程数和最大线程数为 6 的线程池，这个保证了线程池里面随时都有 6 个线程在运行
    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(6, 6, 1, TimeUnit.MINUTES,
            new LinkedBlockingQueue<>());
    // (2)创建了一个 ThreadLocal 的变量，泛型参数为 LocalVariable，LocalVariable 内部是一个 Long 数组
    static ThreadLocal<LocalVariable> localVariable = new ThreadLocal<>();


    public   static void test() throws InterruptedException {
        // (3)向线程池里面放入 50 个任务
        for (int i = 0; i < 50; ++i) {
            poolExecutor.execute(() -> {
                // (4) 往threadLocal变量设置值
                LocalVariable localVariable = new LocalVariable();
                // 会覆盖
                Demo1.localVariable.set(localVariable);
                // (5) 手动清理ThreadLocal
                System.out.println("thread name end：" + Thread.currentThread().getName() + ", value:"+ Demo1.localVariable.get());
//                    ThreadLocalOutOfMemoryTest.localVariable.remove();

            });

            Thread.sleep(1000);
        }

        // (6)是否让key失效，都不影响。只要持有的线程存在，都无法回收。
        //ThreadLocalOutOfMemoryTest.localVariable = null;
        System.out.println("pool execute over");


    }
}
