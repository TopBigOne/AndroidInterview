package com.thread.comletable_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/13 18:45
 * @Url :  https://www.cnblogs.com/xinde123/p/10928091.html
 * @Level :     hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Demo_1 {
    public static void main(String[] args) {
        submit();
        execute();
    }


    /**
     * submit 是有返回值的
     */
    private static void submit() {
        System.out.println("test submit: ");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    System.out.println("执行异步任务");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            submit.get();// 会阻塞
            System.out.println("异步任务执行完了");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }


    }

    /**
     * execute 没有返回值
     */
    private static void execute() {
        System.out.println("execute: ");
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 3; i++) {
                        System.out.println("执行异步任务不使用回调");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });



    }
}
