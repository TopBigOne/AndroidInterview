package com.jar.jvm;


/**
 * @author : dev
 * @version :
 * @Date :  2/7/21 8:31 PM
 * @Desc : 指令重排序
 */
public class CommandResort {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                reSort();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static void reSort() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                a = 1; //操作1
                x = b; //操作2
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                b = 1; //操作3
                y = a;  //操作4
            }
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        if (x == 0 && y == 0) {
            System.out.println("(" + x + "," + y + ")");
        }
        x = 0;
        y = 0;
        a = 0;
        b = 0;
    }

}
