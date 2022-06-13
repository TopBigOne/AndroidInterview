package top_k.leet_code_414;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/9 15:28
 * @Desc : https://leetcode.cn/problems/third-maximum-number/
 */
public class ThirdMax {
    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        //  int[] nums = {2, 1};
        int[] nums = {1, 1, 2};
        // int[] nums = {1, 3, 2, 2};

        int result = thirdMax.thirdMax(nums);
        System.err.println("result : " + result);

    }

    public int thirdMax(int[] nums) {
        int k = 3;
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {
            if (heap.contains(num)) {
                continue;
            }
            if (heap.size() < k) {
                heap.add(num);
                continue;
            }
            if (num > heap.peek()) {
                heap.poll();
                heap.add(num);
            }
        }

        if (heap.size() < k) {
            while (heap.size() != 1) {
                heap.poll();
            }
            return heap.peek();

        }

        return heap.peek();
    }
}
