package com.android.java_thread.pool;

import com.android.java_thread.DaemonThreadFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/13/20 1:35 AM
 * @Desc : 线程池 里面一个 thread 异常了，会怎么样？
 */
public class Executors {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new LinkedBlockingDeque<>(100),
                new DaemonThreadFactory("Jakarta"), new ThreadPoolExecutor.AbortPolicy());


        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                sayHi("execute");
            }
        });
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                sayHi("execute");
            }
        });

    }


    public static void sayHi(String name) {
        String printStr = " threadName :" + Thread.currentThread().getName();
        System.out.println(printStr);
        throw new RuntimeException(printStr + "异常了....");


    }


}
