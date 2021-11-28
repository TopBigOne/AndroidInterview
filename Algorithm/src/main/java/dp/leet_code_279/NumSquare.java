package dp.leet_code_279;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/27 22:53
 * @Url :https://leetcode-cn.com/problems/perfect-squares/solution/
 * @Level :    medium
 * @Desc : 完全平方数
 * @Counter :
 * @Answer :  水姐：https://leetcode-cn.com/problems/perfect-squares/solution/gong-shui-san-xie-xiang-jie-wan-quan-bei-nqes/
 *
 * https://leetcode-cn.com/problems/perfect-squares/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--51/
 */
public class NumSquare {
    /**
     * @param n
     * @return
     */
    public int numSquares(int n) {
        int INF = 0x3f3f3f3f;
        List<Integer> list = new ArrayList<>();
        // 预处理出所有可能用到的【完全平方数】
        int t = 1;
        while (t * t <= n) {
            list.add(t * t);
            t++;
        }
        // f[i][j] 代表考虑前i个物品，凑出j所用到的最小元素个数
        int m = list.size();
        int[][] f = new int[m + 1][n + 1];
        // 当没有任何数时，除了f[0][0] 为0（花费0个数值凑出0），其他均为无效值
        Arrays.fill(f[0], INF);
        f[0][0] = 0;

        // 处理剩余情况
        for (int i = 1; i <= m; i++) {
            int x = list.get(i - 1);
            for (int j = 0; j <= n; j++) {
                // 对于不选第i个数的情况
                f[i][j] = f[i - 1][j];
                // 对于选k次第i 个数的情况
                for (int k = 1; k * x <= j; k++) {
                    // 能够选择k个x 的前提是剩余的数字 j-k*x 也能被凑出
                    if (f[i - 1][j - k * x] != INF) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - k * x] + k);
                    }
                }
            }
        }
        return f[m][n];
    }

    public int numSquares2(int n) {
        int[] dp = new int[n];
        for (int i = 1; i <= n; i++) {
            // 最坏的情况就是每次+1，比如：dp[3] = 1+1+1;
            dp[i] = i;
            // 枚举前一个状态
            for (int j = i; i - j * j >= 0; j++) {
                // 状态转移方程
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }

    public int numSquares3(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];

    }


}
