package com.thread_local;

import java.util.Random;

/**
 * @author : dev
 * @version :
 * @Date :  2022/10/5 06:40
 * @Desc :
 * https://www.youtube.com/watch?v=ad2li3MEv9o
 * https://www.youtube.com/watch?v=dymtsbH9fg8
 */
public class ThreadLocalDemo3 {
    static class House {
        int saleCount = 0;

        public void saleHouse() {
            ++saleCount;
        }

        ThreadLocal<Integer> saleVolume = ThreadLocal.withInitial(() -> 0);

        public void saleVolumeByThreadLocal() {
            saleVolume.set(saleVolume.get() + 1);
        }
    }

    public static void main(String[] args) {
        House house = new House();
        for (int i = 1; i <= 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int size = new Random().nextInt(5) + 1;
                    try {
                        for (int j = 1; j <= size; j++) {
                            house.saleHouse();
                            house.saleVolumeByThreadLocal();
                        }
                        System.err.println(Thread.currentThread().getName() + "---> 卖出 " + house.saleVolume.get() + " 套房子");
                    } finally {
                        // 防止内存泄露，一定要 执行一下remove() 函数；
                        house.saleVolume.remove();
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
