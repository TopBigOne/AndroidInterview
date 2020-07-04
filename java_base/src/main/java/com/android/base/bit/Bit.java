package com.android.base.bit;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/1/20 8:52 PM
 * @Desc : 深入了解为运算
 */
public class Bit {
    public static void main(String[] args) {
        int LG_READERS = 7;
        System.out.println("LG_READERS to binary: " + Integer.toBinaryString(LG_READERS));
        long RUNIT = 1L;
        // 1左移 7位，
        // 128，64，32，16，8，4，2，1
        long WBIT = 1L << LG_READERS;
        System.out.println("WBIT to binary: " + Long.toBinaryString(WBIT));
        System.out.println("1<<7:" + (1 << 7));

        // 左移一位：就是乘以 2；=256
        long ORIGIN = WBIT << 1;
        System.out.println("ORIGIN ；" + ORIGIN);
        // WBIT = 128，减1= 127
        long RBITS = WBIT - 1L;
        System.out.println("RBITS ：" + RBITS);

        long state = ORIGIN;
        long s, next;

        System.out.println(" RBITS to binary: " + Long.toBinaryString(RBITS));
        System.out.println(" again RBITS ：" + RBITS);
        long SBITS = ~RBITS;
        System.out.println(" SBITS to binary: " + Long.toBinaryString(SBITS));


        long newValue = s = state;
        System.out.println("newVlaue:" + newValue + "newValue to binary:" + Long.toBinaryString(newValue));

        long result = ((newValue & WBIT) == 0L) ? (s & SBITS) : 0L;


        System.out.println("result:" + result);

        System.out.println("~1 :" + (~1));

        testFei();
        testRightOffset();

    }

    /**
     * 测试非运算
     * 1. 所有正整数的按位取反是其本身+1的负数
     * 2. 所有负整数的按位取反是其本身+1的绝对值
     * 3. 零的按位取反是 -1（0在数学界既不是正数也不是负数）
     */
    private static void testFei() {
        System.out.println("\n");
        int result = 4;
        //result:-5
        System.out.println("~" + result + ": " + (~result));
        int b = -2;
        System.out.println("~ " + b + ": " + (~b));
        System.out.println("\n");
    }


    /**
     * 只有正数在右移一位和对 2 取模，结果是一样的。
     * 负数是不行的。
     */
    private static void testRightOffset() {
        int a = 8;
        int b = -8;
        int c = 1;
        int d = -1;
        System.out.println("8>>>1  :" + (a >>> 1));
        System.out.println("-8>>>1 :" + (b >>> 1));
        System.out.println("-1<<2  :" + (d << 2));
        System.out.println("1<<2   :" + (c << 2));

    }


}
