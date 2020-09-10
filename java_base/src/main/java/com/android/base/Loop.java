package com.android.base;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-21 11:05
 * @Desc : 测试 for 循环-静态查找；
 */
public class Loop {
    public static void main(String[] args) {
        int[] raw = {2, 4, 23, 7, 3, 6, 42, 45, 9, 0,};
        System.out.println("raw length:" + raw.length);
        int target = 42;
        int index = staticSearch(raw, 42);
        System.out.println("result: target is in :" + index);
    }

    private static int staticSearch(int[] raw, int key) {
        int i;
        for (i = raw.length - 1; raw[i] != key; i--) ;
        return i;
    }

}
