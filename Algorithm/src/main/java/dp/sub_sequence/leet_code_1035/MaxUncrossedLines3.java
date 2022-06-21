package dp.sub_sequence.leet_code_1035;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/22 00:03
 * @Desc :
 */
public class MaxUncrossedLines3 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= m; ++i) {
            int last = dp[0];

            for (int j = 1; j <= n; ++j) {
                // dp[j]计算过会被覆盖，这里先把他存储起来
                int temp = dp[j];
                //下面是递推公式
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = last + 1;
                } else{
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                last = temp;
            }
        }
        return dp[n];
    }


}
