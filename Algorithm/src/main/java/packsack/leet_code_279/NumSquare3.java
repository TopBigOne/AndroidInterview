package packsack.leet_code_279;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/28 18:55
 * @Url : https://leetcode-cn.com/problems/perfect-squares/submissions/
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 * 题解：https://leetcode.cn/problems/perfect-squares/solution/gong-shui-san-xie-xiang-jie-wan-quan-bei-nqes/
 */
public class NumSquare3 {
    /**
     * 动态规划的解法
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }

    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }
}
