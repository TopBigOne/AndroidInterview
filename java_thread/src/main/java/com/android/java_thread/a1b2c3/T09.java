package com.android.java_thread.a1b2c3;

/**
 * @author : dev
 * @version :
 * @Date :  2/7/21 5:17 PM
 * @Desc :
 */
public class T09 {

    public static void main(String[] args) {

        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();
        final   boolean[] b1 = {true};
        final  boolean[] b2 = {false};

        new Thread(() -> {
            while (true){
            for (int i = 0; i < aI.length; i += 2) {
                    while (b1[0]) {
                        System.out.print(aI[i]);
                        b2[0] = true;
                        b1[0] = false;
                    }
                }
            }
        }, "t1").start();


        new Thread(() -> {
            while (true){
                for (int i = 0; i < aC.length; i += 2) {
                    while (true){
                        while (b2[0]) {
                            System.out.print(aC[i]);
                            b2[0] = false;
                            b1[0] = true;
                        }
                    }
                }
            }

        }, "t2").start();


    }
}
