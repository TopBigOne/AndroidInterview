package com.thread.comletable_future;


import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2023/7/27 23:49
 * @Desc :  test CompletableFuture;
 */
public class Demo_2 {
    static long start, end;

    public static void main(String[] args) {
       testOne();
    }


    private static void testOne() {
        start = System.currentTimeMillis();
        // task 1:
        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                return priceOfTM();
            }
        }).whenCompleteAsync(new BiConsumer<Double, Throwable>() {
            @Override
            public void accept(Double aDouble, Throwable throwable) {
                if(throwable!=null){
                    System.err.println("成功获取淘宝价格");
                }
            }
        });
        // task 2:
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                return priceOfTB();
            }
        });
        // task 3:
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                return priceOfJD();
            }
        });

        CompletableFuture.allOf(futureTM, futureTB, futureJD).join();

        CompletableFuture.supplyAsync(new Supplier<Double>() {
            @Override
            public Double get() {
                return priceOfTM();
            }
        }).thenApply(new Function<Double, String>() {
            @Override
            public String apply(Double aDouble) {
                return String.valueOf(aDouble);
            }
        }).thenAccept(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.err.println("finally s :" + s);
            }
        });

        end = System.currentTimeMillis();

        System.err.println("use completable future cost time id :  " + (end - start));

    }


    /**
     * 天猫的价格
     *
     * @return
     */
    private static double priceOfTM() {
        delay();
        return 1.00;
    }

    /**
     * 淘宝的价格
     *
     * @return
     */
    private static double priceOfTB() {
        delay();
        return 2.00;
    }

    /**
     * 京东的价格
     *
     * @return
     */
    private static double priceOfJD() {
        delay();
        return 3.00;
    }

    private static void delay() {
        int time = new Random().nextInt(500);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.err.printf("   delay() : After %s sleep!\n", time);
    }





}
