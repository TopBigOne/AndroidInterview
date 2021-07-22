package com.android.base.exception;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/26 21:00
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class TT {
    public static void main(String[] args) {

        try {
            try {
                throw (new B("hh"));
            } catch (B e) {
                System.out.println(2);
            }


        } finally {
            System.out.println(4);
        }

    }

    static class A extends Exception {
        public A(String message) {
            super(message);
        }

    }

    static class B extends Exception {
        public B(String message) {
            super(message);
        }
    }


}
