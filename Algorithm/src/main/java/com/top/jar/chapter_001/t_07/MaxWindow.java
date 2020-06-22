package com.top.jar.chapter_001.t_07;

import java.util.Arrays;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-20 23:53
 * @Desc :生成窗口最大值数组,(自己的写法。)
 */
public class MaxWindow {
    public static void main(String[] args) {
        int[] raw = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int[] result = getMainWindow(raw, w);
        System.out.println("result:" + Arrays.toString(result));
    }

    private static int[] getMainWindow(int[] raw, int w) {
        int n = raw.length;
        int subArrayCount = n - w + 1;
        int[] result = new int[subArrayCount];
        for (int i = 0; i < subArrayCount; i++) {
            // 数组截取
            int[] subArr = Arrays.copyOfRange(raw, i, i + w);
            System.out.println("subArr:" + Arrays.toString(subArr));
            // 数组排序（从小到大）
            Arrays.sort(subArr);
            System.out.println("subArr after sort:" + Arrays.toString(subArr));
            // 取数组中最大的那一个值，并赋值给 result[];
            result[i] = subArr[w - 1];
        }

        return result;
    }

}
