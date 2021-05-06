package array.leet_code_1480;

/**
 * @author : dev
 * @version :
 * @Date :  5/3/21 10:28 PM
 * @Desc : 一维数组的动态和
 * <p>
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/running-sum-of-1d-array/solution/ru-guo-mian-shi-yu-dao-zhe-ge-wen-ti-zhe-yi-dian-z/
 */
public class RunningSum {
    /**
     * 问清楚面试官，是否可以修改传来的 nums 数组
     * @param nums
     * @return
     */
    public int[] runningSum(final int[] nums) {
        int len = nums.length;
        int sum = 0;
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            sum = result[i] = sum + nums[i];
        }
        return result;

    }
}
