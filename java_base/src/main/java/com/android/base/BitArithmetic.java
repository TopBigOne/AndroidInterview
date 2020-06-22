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
        System.out.println("~5 :" + ~5);
        System.out.println("~1 :" + ~1);
        System.out.println("0^0 :" + (0^0));


    }
}
