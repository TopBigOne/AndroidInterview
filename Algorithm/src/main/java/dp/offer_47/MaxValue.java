package dp.offer_47;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/31 17:55
 * @Desc : 礼物的最大值：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/
 * 基础的dp 题，
 * 状态转移方程：
 * f(i, j) = max{f(i - 1, j), f(i, j - 1)} + grid[i][j]
 * 题解：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/solution/shu-ju-jie-gou-he-suan-fa-dong-tai-gui-h-569o/
 */
public class MaxValue {


    /**
     * 优化以后的方法
     *
     * @param grid
     * @return
     */
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int currValue = grid[i - 1][j - 1];
                dp[j] = Math.max(dp[j], dp[j - 1]) + currValue;
            }
        }
        return dp[n];


    }
}
