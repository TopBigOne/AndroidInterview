package array.sub_array.leet_code_53;

/**
 * @author : dev
 * @version :
 * @Date :  5/31/21 10:32 AM
 * @Desc :  https://leetcode-cn.com/problems/maximum-subarray/
 * <p>
 * 另类题解，从动态规划角度
 * https://leetcode-cn.com/problems/maximum-subarray/solution/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn/
 */
public class MaximumSubArray2 {
    /**
     * 时间复杂度为 O(n)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum =0;
        for (int num : nums) {
            // sum 大于 0，最结果有增益的效果，则在 sum 上累加；
            if (sum > 0) {
                sum += num;
            } else {
                // sum 小于或者等于 0，sum 对结果无增益效果，
                // 需要舍弃，则 sum 直接被替换成当前遍历的数字；
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public int maxSubArray2(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            // sum 大于 0 ，可直接累加
            if (sum > 0) {
                sum += num;
            } else {
                // 小于或者等于 0；丢弃原有的 sum 值，并直接用 num 值替代
                sum = num;
            }

            // 3: 做一下结果比较，取最大值
            res = Math.max(res,sum);
        }

        return res;
    }
}
