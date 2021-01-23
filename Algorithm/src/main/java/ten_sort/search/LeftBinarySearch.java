package ten_sort.search;

import java.lang.annotation.Target;

/**
 * @author : dev
 * @version :
 * @Date :  1/21/21 6:11 PM
 * @Desc : 二分法左侧边界 搜索；
 * <p>
 * 比如说给你有序数组 nums = [1,2,2,2,3] ，
 * target 为 2，此算法返回的索 引是 2，没错。
 * 但是如果我想得到 target 的左侧边界，即索引 1，或者我 想得到 target 的右侧边界，即索引 3，这样的话此算法是无法处理的。
 */
public class LeftBinarySearch {

    public static void main(String[] args) {
        LeftBinarySearch leftBinarySearch = new LeftBinarySearch();
        int[] nums = {1, 2, 2, 2, 3};

        int result = leftBinarySearch.leftBound2(nums, 2);
        System.out.println("result : " + result);

    }

    public int left_bound(int[] nums, int target) {
        int lenght = nums.length;
        if (lenght == 0) {
            return -1;
        }
        int left = 0;
        // 注意
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                //找到 target时不要立即返回，而是缩小「搜索区间」的上界right ，
                //在区间 [left, mid) 中继续搜索，即不断向左收缩，达到锁定左侧边界的目的。
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;

            }
        }

        return left;
    }

    public int leftBound2(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int right = length;
        int left = 0;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (target == nums[mid]) {
                right = mid;
            } else if (nums[mid] < target) {
                // 指针右移
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 在左边
                right = mid - 1;
            }
        }
        // 再优化一下：
        return nums[left] == target ? left : -1;
    }
}
