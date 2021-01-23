package com.jar;

import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap map = new HashMap();
        test(6);

    }

    private static void test(int type) {
        switch (type) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("异常");
                return;
        }
        System.out.println(" 其他逻辑.....");
    }
}