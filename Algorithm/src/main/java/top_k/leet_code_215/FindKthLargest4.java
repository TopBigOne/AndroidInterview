package top_k.leet_code_215;

import top_k.leet_code_215.base.BaseFun;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 18:34
 * @Url :
 * @Level :  medium
 * @Desc : leetcode 215:  字节半年 30 次；数组中的第 k 个最大元素：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Counter :
 * @Answer :
 */
public class FindKthLargest4 extends BaseFun {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = nums.length - 1;
        int target = len - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 切分
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            int currValue = nums[i];
            if (currValue > pivot) {
                j++;

                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    private int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > pivot) {
                j++;
                // 前后交换
                swap(nums, j, i);
            }

        }
        swap(nums, j, left);
        return j;

    }
}
