package com.android.java_thread.synchronize;

/**
 * @author : dev
 * @version :
 * @Date :  5/6/21 11:05 AM
 * @Desc :
 */
public class Demo_01 {
    private final Object lock = new Object();

    public void test() {
        synchronized (lock) {


            // do sth....
        }
    }
}
