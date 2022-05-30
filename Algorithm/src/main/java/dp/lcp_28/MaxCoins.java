package dp.lcp_28;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/23 16:11
 * @Desc :
 */
public class MaxCoins {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        // 创建一个辅助数组，并在首尾各添加1，方便处理边界情况
        int[] temp = new int[length + 2];
        temp[0] = 1;
        temp[length + 1] = 1;

        System.arraycopy(nums, 0, temp, 1, length);
        int[][] dp = new int[length + 2][length + 2];

        // len表示开区间长度
        for (int len = 3; len <= length + 2; len++) {
            // i:表示开区间左端点
            for (int i = 0; i <= length + 2 - len; i++) {
                int res = 0;
                // k:为开区间内的索引
                for (int k = i + 1; k < i + len - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];

                    res = Math.max(res, left + temp[i] * temp[k] * temp[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }
        return dp[0][length + 1];
    }

}
