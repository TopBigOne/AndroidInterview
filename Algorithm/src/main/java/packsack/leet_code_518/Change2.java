package packsack.leet_code_518;

/**
 * @author : dev
 * @version :
 * @Date :  7/17/21 6:51 PM
 * @Desc :
 * https://leetcode-cn.com/problems/coin-change-2/solution/
 * 这个题解，还是比较符合我自己的理解；
 * 定义：f[i][j]  为考虑前 i 个钱币凑成总和为 j 的方案数
 * https://leetcode-cn.com/problems/coin-change-2/solution/gong-shui-san-xie-xiang-jie-wan-quan-bei-6hxv/
 */
public class Change2 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        Change2 change = new Change2();
        int result = change.change(amount, coins);
        System.out.println("result : " + result);
    }

    /**
     * 完全背包（朴素解法）
     * f[i][j]: 前 i 件物品，凑成综合为 j 的方案数量
     * <p>
     * 时间复杂度 o(len*amount*amount)
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int len = coins.length;
        int[][] f = new int[len + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int currCoinValue = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                // 注意：j 此时是变的；
                // case 1 :i-1 的意思是不使用 当前i
                f[i][j] = f[i - 1][j];
                for (int k = 1; k * currCoinValue <= j; k++) {
                    f[i][j] = f[i][j] + f[i - 1][j - k * currCoinValue];
                }
            }
        }
        return f[len][amount];
    }

    public int change2(int amount, int[] coins) {
        int len = coins.length;
        int[][] f = new int[len + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int currCoinValue = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                // 转移一下
                f[i][j] = f[i - 1][j];
                for (int k = 1; k * currCoinValue <= j; k++) {
                    f[i][j] += f[i - 1][j - k * currCoinValue];
                }
            }
        }
        return f[len][amount];
    }

    public int change3(int amount, int[] coins) {
        int len = coins.length;
        int[][] f = new int[len + 1][amount + 1];
        f[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int currCoinValue = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                f[i][j] = f[i - 1][j];
                for (int k = 1; k * currCoinValue <= j; k++) {
                    f[i][j] += f[i - 1][j - k * currCoinValue];
                }
            }
        }
        return f[len][amount];
    }

    public int change4(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int currValue = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * currValue <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * currValue];
                }
            }
        }
        return dp[len][amount];
    }

    public int change5(int amount, int[] coins) {
        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            int currValue = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                //
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * currValue <= j; k++) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - coins[i - 1] * k];
                }
            }

        }
        return dp[len][amount];
    }
    //----------------以下是优化版本--------------------------------------------------------------


    /**
     * 1：在二维解法的基础上，直接取消【物品维度】
     * 2：确保【容量维度】的遍历顺序为【从小到大】（适用于【完全背包】）
     * 3：将形如 f[i-1][j-k*value] 的式子，更替为 f[j-val] ，同时解决【数组越界】问题，（将物品维度的遍历修改为 val 开始）
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change6(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                dp[j] += dp[j - val];
            }
        }
        return dp[amount];
    }

    public int chage7(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                dp[j] += dp[j - val];
            }
        }
        return dp[amount];
    }

    public int change7(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                dp[j] += dp[j - val];
            }
        }
        return dp[amount];
    }


    public int change8(int amount, int[] coins) {
        int len = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= len; i++) {
            int value = coins[i - 1];
            for (int j = value; j <= amount; j++) {
                dp[j] += dp[j - coins[i - 1]];
            }

        }
        return dp[amount];
    }
}
