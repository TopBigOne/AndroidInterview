package dp.sub_sequence.leet_code_673;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/22 00:15
 * @Url :  https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 * @Level :    medium
 * @Desc :  给定一个未排序的整数数组，找到最长递增子序列的个数。
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * @Counter :
 * @Answer : 三叶姐：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/gong-shui-san-xie-lis-de-fang-an-shu-wen-obuz/
 * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dp673-9txt/
 */
public class FindNumberOfLIS {

    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return length;
        }
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        int[] count = new int[length];
        Arrays.fill(count, 1);

        int maxCount = 0;
        for (int i = 1; i < length; i++) {
            int rightValue = nums[i];
            for (int j = 0; j < i; j++) {
                int leftValue = nums[j];

                if (rightValue > leftValue) {

                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];

                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
                if (dp[i] > maxCount) {
                    maxCount = dp[i];
                }
            }
        }

        int result = 0;
        for (int i = 0; i < length; i++) {
            if (maxCount == dp[i]) {
                result += count[i];
            }
        }
        return result;

    }
}
