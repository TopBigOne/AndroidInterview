package com.android.base;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-22 10:27
 * @Desc : 位运算
 * & : 0&0=0,1&0=0,0&0=0,1&1=1;
 * | : 0|0=0,1|0=1,0|1=1,1|1=1;
 * ~ : ~0 = 1,~1 = 0;
 * ^ : 0^0 = 0,1^1= 0,1^0 = 1,0^1 = 1;
 */


public class BitArithmetic {
    public static void main(String[] args) {
        int a = 5 & 3;
        System.out.println("5 & 3:" + a);
        /*
        * 01-1
        * 10-2
        * 11-3
        * 100-4
        * 0000 0101-5  ---取反-->1111 1010--->2
        * 所有正整数的按位取反是其 本身+1的 负数
        * 所有负整数的按位取反是其 本身+1的绝对值
        * 零的按位取反是 -1
        * */
        System.out.println("~5 :" + ~5);
        System.out.println("~1 :" + ~1);
        System.out.println("~0 :" + ~0);
        System.out.println("0^0 :" + (0^0));
    }
}
