package com.top.jar.chapter_001.t_07.z;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author : Jakarta
 * @version :
 * @Date : 2020-06-21 23:38
 * @Desc : 大佬是的实现方式，利用双端链表时间复杂度 O(N)
 */
public class ZMaxWindow {
    public static void main(String[] args) {
        int[] raw = {4, 3, 5, 4, 3, 3, 6, 7};
        int w = 3;
        int[] result = getMainWindow(raw, w);
        System.out.println("my_result :" + Arrays.toString(result));
        /*
         * 4, 3, 5, 4, 3, 3, 6, 7
         * 结果：
         * 4, 3, 5                  : 5
         *    3, 5, 4               : 5
         *       5, 4, 3            : 5
         *          4, 3, 3,        : 4
         *             3, 3, 6      : 6
         *                3, 6, 7   : 7
         * */
    }

    private static int[] getMainWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        int arrLength = arr.length;
        LinkedList<Integer> qmax = new LinkedList<>();

        int[] res = new int[arrLength - w + 1];
        int index = 0;
        for (int i = 0; i < arrLength; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }

            // 从尾部添加，以便能保持和数据一样的顺序：{4, 3, 5, 4, 3, 3, 6, 7}
            qmax.addLast(i);
            //判断当前队列头部的坐标是否已经过期
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            //将窗口最大值的下标存入 res 数组中
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

}
