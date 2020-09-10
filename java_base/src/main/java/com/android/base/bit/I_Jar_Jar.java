package com.android.base.bit;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/8/20 10:09 AM
 * @Desc : i++ 和++i 的区别
 */
public class I_Jar_Jar {
    public static void main(String[] args) {
        testOne();
        testTwo();
        testThree();
        testFour();
    }

    public static void testOne() {
        int i = 1;
        i = i++;
        System.out.println("i : " + i);

    }

    public static void testTwo() {
        int i = 1;
        i = ++i;
        System.out.println("i :" + i);

    }

    public static void testThree() {
        int i = 1;
        int a = ++i;
        System.out.println("a :" + a);

    }

    public static void testFour() {
        int i = 1;
        int a = ++i;
        System.out.println("a :" + a);
    }

}
