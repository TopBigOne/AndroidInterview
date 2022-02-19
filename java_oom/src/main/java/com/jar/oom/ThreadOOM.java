package com.jar.oom;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/3 02:35
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class ThreadOOM {
    /**
     * 不断的创建线程
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            System.out.println("======i " + i);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(Integer.MAX_VALUE);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
            i++;
        }
    }
}
