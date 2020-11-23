package com.android.base.bit;

/**
 * @author : dev
 * @version :
 * @Date :  11/23/20 6:33 PM
 * @Desc : 给一个数，求奇偶. odd :奇数
 *   编译器会将对2的指数的取模操作，优化成位运算操作。
 */
public class IsOdd {

    public static void main(String[] args) {

//        boolean odd = isOdd(3);
        boolean odd = isOddTwo(3);
        System.out.println(odd);
    }

    public  static  boolean isOdd(int i) {
        boolean reuslt;
        // 取余运算
        if (i %2 == 1) {
            reuslt = false;
            System.out.println("是奇数");
        } else {
            reuslt = true;
            System.out.println("是偶数");
        }

        return reuslt;
    }

    /**
     * 使用位运算来做判断，奇数的最后一位是：1；
     * @param i
     * @return
     */
    public static boolean isOddTwo(int i) {
        return (i & 1) == 1;
    }
}
