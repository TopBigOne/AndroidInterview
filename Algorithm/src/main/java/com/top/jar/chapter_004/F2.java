package com.top.jar.chapter_004;

/**
 * @author : dev
 * @version :
 * @Date :  1/10/21 5:50 PM
 * @Desc : 裴波那楔数列，可以从左到右依次求出每一项的值，那么通过顺序计算出，求到第 N 项 即可！
 */
public class F2 {
    public static void main(String[] args) {
        F2 f2 = new F2();
        int fibResult = f2.f5(5);
        System.out.println("fibResult " + fibResult);
    }

    public int f2(int n) {
        if (n < 1) {
            return 0;

        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int res = 1;
        int pre = 1;
        int tmp;
        for (int i = 0; i < n; i++) {
            tmp = res;
            res += pre;
            pre = tmp;
        }
        return res;
    }

    public int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int res = 1, pre = 1;
        int temp;
        for (int i = 0; i < n; i++) {
            temp = res;
            res += res + pre;
            pre = temp;
        }
        return res;
    }

    public int f4(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int temp;

        for (int i = 0; i < n; i++) {
            temp = res;
            res += pre;
            pre = temp;

            System.out.println("res: " + res);

        }


        return res;
    }

    public int f5(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int temp;
        int res = 1;
        int pre = 1;
        for (int i = 0; i < n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }

        return res;
    }


}
