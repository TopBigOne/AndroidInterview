package com.thread.comletable_future;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2023/7/28 00:32
 * @Desc :
 */
public class Demo_3 {

    // task 1:
    static CompletableFuture<String> rice = CompletableFuture.supplyAsync(() -> {
        System.err.println("    task 1: 煮米饭");
        return "1:煮熟的米饭; ";
    });

    // task 2: 煮米饭的同时呢，我又做了牛奶
    static CompletableFuture<String> mike = CompletableFuture.supplyAsync(() -> {
        System.err.println("    task 2: 热牛奶");
        return "2: 加热的牛奶; ";
    });

    // task 3: 煮米饭的同时呢，我又做了牛奶
    static CompletableFuture<String> egg = CompletableFuture.supplyAsync(() -> {
        System.err.println("    task 3: 煮鸡蛋");
        return "3: 茶叶蛋; ";
    });

    private static void test_thenCombine() {
        System.err.println("test thenCombine()");
        // 合并操作
        rice.thenCombine(egg, new BiFunction<String, String, String>() {
            @Override
            public String apply(String m, String r) {
                return m + r;
            }
        }).thenAcceptBothAsync(mike, new BiConsumer<String, String>() {
            @Override
            public void accept(String m, String r) {
                System.err.println("我收获了早饭 3: " + m + "," + r);
            }
        });


        /*mike.thenAcceptBothAsync(rice, new BiConsumer<String, String>() {
            @Override
            public void accept(String m, String r) {
                System.out.println("我收获了早饭1 ：" + m + "," + r);

            }
        });*/


    }


    public static void main(String[] args) {
      //  test_thenCombine();
        divide();
        test_thenAcceptBothAsync();
    }

    private static void divide() {
        System.err.println("------------------------------------------------------------------------------");
    }

    private static void test_thenAcceptBothAsync() {
        System.err.println("test thenAcceptBothAsync()");
        rice.thenAcceptBothAsync(mike, new BiConsumer<String, String>() {
            @Override
            public void accept(String s1, String s2) {
                System.err.println("我收获了早饭 2: " + s1  + s2);
            }
        });
    }

}
