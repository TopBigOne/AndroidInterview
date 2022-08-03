package binary_search.leet_code_34;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 12:23
 * @Desc :  leetcode 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange4 {

    public int[] searchRange(int[] nums, int target) {
        int left = searchLeft(nums, target);
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    private int searchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            int midValue = nums[mid];
            if (midValue < target) {
                left = mid + 1;
            } else if (midValue == target) {
                right = mid - 1;
            } else if (midValue > target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    private int searchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) >>> 1;
            int midValue = nums[mid];
            if (midValue == target) {
                left = mid + 1;
            } else if (midValue < target) {
                left = mid + 1;
            } else if (midValue > target) {
                right = mid - 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;


    }

}
