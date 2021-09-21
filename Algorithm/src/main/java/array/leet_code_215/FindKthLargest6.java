package array.leet_code_215;


import array.leet_code_215.base.BaseFun;

/**
 * @author : dev
 * @version :
 * @Date :  7/1/21 12:17 AM
 * @Desc :
 */
public class FindKthLargest6 extends BaseFun {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // 转换一下，第 k 大元素的索引是 len - k;
        int target = len - k;
        while (true) {
            //  这是一个排序操作，
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
        int len = nums.length;
        int target = len - k;
        int left = 0;
        int right = len - 1;
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


    public int findKthLargest3(int[] nums, int k) {
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int target = length - 1;
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
                left = index - 1;
                continue;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            int currValue = nums[i];
            if (currValue < pivot) {
                // 小于 pivot 的元素被交换到了前面
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
            int currValue = nums[i];
            if (currValue < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, left);
        return j;
    }


    private int partition3(int[] nums, int left, int right) {
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
