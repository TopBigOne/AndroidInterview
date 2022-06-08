package top_k.leet_code_215;

import top_k.leet_code_215.base.BaseFun;

/**
 * @author : dev
 * @version :
 * @Date :  8/22/21 10:30 PM
 * @Desc : 数组中第 K 个最大元素
 */
public class FindKthLargest7 extends BaseFun {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int target = length - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            }
            if (index < target) {
                left = index + 1;
                continue;
            }
            if (index > target) {
                right = index - 1;
                continue;
            }
        }
    }

    public int findKthLargest2(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int target = length - k;
        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            }
            if (index < target) {
                left = index + 1;
                continue;
            }
            if (index > target) {
                right = index - 1;
                continue;
            }
        }
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            int currValue = nums[i];
            if (currValue < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    public int partition2(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            int currValue = nums[i];
            if (currValue < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }

    public int partition3(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            int currValue = nums[i];
            if (currValue < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;

    }


}
