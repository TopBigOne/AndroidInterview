package dynamic_programming.leet_code_879;

/**
 * @author : dev
 * @version :
 * @Date :  2/6/21 12:11 AM
 * @Desc : https://leetcode-cn.com/problems/profitable-schemes/solution/leetcode-01bei-bao-zong-jie-by-pedantic-einstein/
 * <p>
 * 01背包题目总结
 * 分为最优解和最优解和两种类型。
 * <p>
 * 最优解：
 * 416分割等和子集
 * 474一和零
 * 1049最后一块石头的重量 II
 * <p>
 * 最优解和：
 * 377组合总和 Ⅳ
 * [494目标和
 * 879盈利计划
 * <p>
 * 最优解一般模板为dp[i][j]=max(dp[i-1][j],dp[i-1][j-w[i]]+v[i])，
 * 空间压缩后为dp[j]=max(dp[j],dp[j-w[i]]+v[i])。
 * v[i]与边界的设置，根据题目要求进行更改。
 * <p>
 * <p>
 * <p>
 * 题解：https://leetcode-cn.com/problems/profitable-schemes/solution/bei-bao-wen-ti-zhi-ying-li-ji-hua-by-a-fei-8/
 */
public class Solution {
    /**
     * @param G      工人数量
     * @param P
     * @param group
     * @param profit
     * @return
     */
    public int profitableSchemes1(int G, int P, int[] group, int[] profit) {
        int mod = 1_000_000_007;
        int N = profit.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = G; j >= g; j--) {
                for (int k = P; k >= 0; k--) {
                    int nk = Math.max(k - p, 0);
                    dp[j][k] = (dp[j][k] + dp[j - g][nk]) % mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (sum + dp[i][P]) % mod;
        }
        return sum;
    }

    public int profitableSchemes2(int G, int P, int[] group, int[] profit) {
        int mod = 1000_000_007;
        int N = profit.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= N; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = G; j >= g; j--) {
                for (int k = P; k >= 0; k--) {
                    int nk = Math.max(k - p, 0);
                    dp[j][k] = (dp[j][k] + dp[j - g][nk]) % mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (sum + dp[i][P]) % mod;

        }
        return sum;
    }

    public int profitableSchemes3(int G, int P, int[] group, int[] profit) {
        int mod = 1000_000_007;
        int length = group.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = G; j >= g; j--) {
                for (int k = P; k >= 0; k--) {
                    int nk = Math.max(k - p, 0);
                    dp[j][k] = (dp[j][k] + dp[j - g][nk]) % mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (sum + dp[i][P]) % mod;
        }

        return sum;
    }

    public int profitableSchemes4(int G, int P, int[] group, int[] profit) {
        int mod = 1000_000_007;
        int length = group.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = G; j >= g; j--) {
                for (int k = P; k >= 0; k--) {
                    int nk = Math.max(k - p, 0);
                    dp[j][k] = (dp[j][k] + dp[j - g][nk]) % mod;
                }
            }

        }
        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (sum + dp[i][P]) % mod;
        }
        return sum;

    }

    public int profitableSchemes5(int G, int P, int[] group, int[] profit) {
        int mod = 1000_000_007;
        int length = group.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = G; j >= g; j--) {
                for (int k = P; k >= 0; k--) {
                    int nk = Math.max(k - p, 0);
                    dp[j][k] = (dp[j][k] + dp[j - g][nk]) % mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (sum + dp[i][P]) % mod;
        }
        return sum;
    }

    public int profitableSchemes6(int G, int P, int[] group, int[] profit) {
        int mod = 1000_000_007;
        int length = group.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = G; j >= g; j--) {
                for (int k = P; k >= 0; k--) {
                    int nk = Math.max(k - p, 0);
                    dp[j][k] = (dp[j][k] + dp[j - g][nk]) % mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (sum + dp[i][P]) % mod;
        }

        return sum;

    }

    public int profitableSchemes7(int G, int P, int[] group, int[] profit) {
        int mod = 1000_000_007;
        int length = group.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];

            for (int j = G; j >= g; j--) {
                for (int k = P; k >= 0; k--) {
                    int nk = Math.max(k - p, 0);
                    dp[j][k] = (dp[j][k] + dp[j - g][nk]) % mod;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (sum + dp[i][P]) % mod;
        }

        return sum;
    }

    public int profitableSchemes8(int G, int P, int[] group, int[] profit) {
        int mod = 1000_000_007;
        int length = group.length;
        int[][] dp = new int[G + 1][P + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            for (int j = G; j >= g; j--) {
                for (int k = P; k >= 0; k--) {
                    int nk = Math.max(k - p, 0);
                    dp[j][k] = (dp[j][k] + dp[j - g][nk]) % mod;
                }
            }

        }

        int sum = 0;
        for (int i = 0; i <= G; i++) {
            sum = (dp[i][P] + sum) % mod;
        }
        return sum;


    }


}
