package com.thread.synchronize;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/8 15:57
 * @Desc : synchronized 的使用方式
 */
public class Demo_1 {
    private final Object object = new Object();

    public void test() {

        //用在代码块上
        synchronized (this) {
            // do sth
        }
    }

    public void test2() {
        // 用在对象上
        synchronized (object) {
            //  do sth
        }
    }

    public synchronized void test3() {
        // do sth
    }

    public static void test4() {
        synchronized (Demo_1.class) {
            // do sth
        }
    }



}
