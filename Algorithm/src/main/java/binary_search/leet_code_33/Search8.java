package binary_search.leet_code_33;

import packsack.leet_code_139.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 13:51
 * @Desc : 33 搜索旋转排序数组：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/submissions/
 */
public class Search8 extends Base {

    /**
     * 4, 5, 6, 7, 0, 1, 2
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[0] == target >= nums[0]) {
                if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

                continue;
            }
            if (target >= nums[0]) {
                right = mid - 1;
                continue;

            }
            if (target <= nums[0]) {
                left = mid + 1;
            }
        }
        if (left == right && nums[left] == target) {
            return left;
        }
        return -1;


    }
}
