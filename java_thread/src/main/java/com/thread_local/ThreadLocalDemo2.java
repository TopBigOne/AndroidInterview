package com.thread_local;

import java.util.Random;

/**
 * @author : dev
 * @version :
 * @Date :  2022/10/5 06:40
 * @Desc :
 * https://www.youtube.com/watch?v=ad2li3MEv9o
 */
public class ThreadLocalDemo2 {
    static class House {
        int saleCount = 0;

        public synchronized void saleHouse() {
            ++saleCount;
        }

    }

    public static void main(String[] args) {
        House house = new House();
        for (int i = 1; i <= 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int size = new Random().nextInt(5) + 1;
                    System.err.println(size);

                    for (int j = 1; j <= size; j++) {
                        house.saleHouse();
                    }

                }
            }, "THREAD :" + i).start();


        }
        try {
            Thread.sleep(300);
            System.err.println("一共卖掉 ：" + house.saleCount + "套房子");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
