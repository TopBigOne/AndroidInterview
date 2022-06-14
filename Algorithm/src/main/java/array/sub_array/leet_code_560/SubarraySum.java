package array.sub_array.leet_code_560;

/**
 * @author : dev
 * @version :
 * @Date :  11/4/21 9:28 PM
 * @Desc : leet code 560 : 和为 k 的 https://leetcode-cn.com/problems/subarray-sum-equals-k/
 *
 * 题解：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
 */
public class SubarraySum {
    /**
     * 前缀表
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        // 计算前缀和数组
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                // 区间和 [left..right]，注意下标偏移
                if (preSum[right + 1] - preSum[left] == k) {
                    count++;
                }
            }
        }
        return count;
    }


}
