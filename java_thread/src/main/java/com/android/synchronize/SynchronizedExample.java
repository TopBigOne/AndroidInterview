package com.android.synchronize;

/**
 * @author : dev
 * @version :
 * @Date :  2022/2/2 19:08
 * @Desc :
 */
public class SynchronizedExample {
    int a = 0;
    boolean flag = false;

    public synchronized void writer() {
        a = 1;
        flag = true;
    }

    public synchronized void reader() {
        if (flag) {
            int i = a;
        }
    }
}
