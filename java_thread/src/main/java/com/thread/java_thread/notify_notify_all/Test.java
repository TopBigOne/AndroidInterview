package com.thread.java_thread.notify_notify_all;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 8:45 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> cache = new ArrayList<>();
        new Thread(new Producer(cache),"P1").start();
        new Thread(new Customer(cache),"C1").start();
    }
}
