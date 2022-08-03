package binary_search.leet_code_33;

import binary_search.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/30 17:54
 * @Desc : 33 搜索旋转排序数组：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
 */
public class Search7 extends Base {
    public static void main(String[] args) {
        int[] nusm = generateArray(4, 5, 6, 7, 0, 1, 2);
        Search7 search = new Search7();
        search.search(nusm, 0);

    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (target == nums[mid]) {
                return mid;
            }
            // nums = [4,5,6,7,0,1,2], target = 0
            // case 1: target 和 nums[0]同在一个区间，注意 "=="
            if (target >= nums[0] == nums[mid] >= nums[0]) {
                // 当target在同一区间的时候，我们就可以使用传统二分查找了；
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (target >= nums[0]) {
                // 目标值在左区间，所以right 往左边走；
                right = mid - 1;
            } else if (target < nums[0]) {
                // 目标值在右区间，所以left 往右边走；
                left = mid + 1;
            }

        }
        // check 一下结果
        if (left == right && nums[left] == target) {
            return left;
        }
        return -1;

    }
}
