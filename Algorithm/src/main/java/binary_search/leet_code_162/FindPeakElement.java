package binary_search.leet_code_162;

/**
 * @author : dev
 * @version :
 * @Date :  6/27/21 11:54 PM
 * @Desc :leetcode 162 无序数组 找峰值：字节：4 次：  https://leetcode-cn.com/problems/find-peak-element/
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }
}
