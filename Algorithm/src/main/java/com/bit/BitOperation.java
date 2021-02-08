package com.bit;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-16 14:32
 * @Desc : 位运算
 */
public class BitOperation {
    public static void main(String[] args) {
        while (true) {
            int low = 2;
            int high = 10;
            int reslut = low + ((high - low) >> 1);
            System.out.println("result :" + reslut);
           // return;
        }
    }
}
