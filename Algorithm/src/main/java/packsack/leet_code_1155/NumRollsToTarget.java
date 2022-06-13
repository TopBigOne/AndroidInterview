package packsack.leet_code_1155;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/6 00:09
 * @Url : https://leetcode-cn.com/problems/number-of-dice-rolls-with-target-sum/
 * @Level :    medium
 * @Desc : 掷骰子的N种方法 : 这里有d个一样的骰子，每个骰子上都有f个面，分别标号为1, 2, ..., f。
 * <p>
 * 我们约定：掷骰子的得到总点数为各骰子面朝上的数字的总和。
 * 如果需要掷出的总点数为target，请你计算出有多少种不同的组合情况（所有的组合情况总共有 f^d 种），模10^9 + 7后返回。
 * @Counter :
 * @Answer :
 */
public class NumRollsToTarget {
    // int mod = (int)1e9+7;
    public static void main(String[] args) {
    }

    /**
     * @param d      骰子个数
     * @param f      骰子面的数量
     * @param target 目标值
     * @return
     */
    public int numRollsToTarget(int d, int f, int target) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        // 枚举物品组（每个骰子）
        for (int i = 1; i <= d; i++) {
            // 枚举背包容量（所掷得的总点数）
            for (int j = 0; j <= target; j++) {
                // 枚举决策（当前骰子所掷得的点数）
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
        }
        return dp[d][target];
    }

    public int numRollsToTarget2(int d, int f, int target) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        // 枚举物品
        for (int i = 1; i <= d; i++) {
            // 枚举背包容量
            for (int j = 0; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
        }
        return dp[d][target];
    }

    public int numRollsToTarget3(int d, int f, int target) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        // 枚举物品
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
        }
        return dp[d][target];
    }

    public int numRollsToTarget4(int d, int f, int target) {
        int mod = (int) (1e9 + 7);
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j >= k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                    }
                }
            }
        }

        return dp[d][target];


    }


}
