package n_sum.leet_code_259;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  6/19/21 8:03 PM
 * @Desc : leet code 较小三数之和： https://leetcode-cn.com/problems/3sum-smaller/
 * <p>
 * 题解：
 * <p>
 * 输入: nums = [-2,0,1,3], target = 2
 * 输出: 2
 * 解释: 因为一共有两个三元组满足累加和小于 2:
 *      [-2,0,1]
 * [-2,0,3]
 *
 * 题解：https://leetcode-cn.com/problems/3sum-smaller/solution/jiao-xiao-de-san-shu-zhi-he-by-leetcode/
 */
public class ThreeSumSmaller {
    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        // 1： 做一个排序
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int remainder = target - nums[i];
            sum += twoSumSmaller(nums, i + 1, remainder);
        }
        return sum;
    }

    /**
     * @param nums
     * @param startIndex
     * @param remainder  余数
     * @return
     */
    private int twoSumSmaller(int[] nums, int startIndex, int remainder) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < remainder) {
                // 有多少个小于 余数的 位数
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }

}
