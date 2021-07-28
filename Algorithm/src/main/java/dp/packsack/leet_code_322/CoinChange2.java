package dp.packsack.leet_code_322;

import java.util.Arrays;

import jdk.nashorn.internal.ir.IfNode;

/**
 * @author : dev
 * @version :
 * @Date :  7/24/21 4:25 PM
 * @Desc :  https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 */
public class CoinChange2 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange2 coinChange = new CoinChange2();
        int result = coinChange.coinChage(coins, amount);
        System.out.println("result : " + result);
    }

    public int coinChage(int[] coins, int amount) {
        // 给 0 占位
        int[] dp = new int[amount + 1];

        // 注意：因为要比较的是最小值，这个
        Arrays.fill(dp, amount + 1);
        System.out.println("dp:" + Arrays.toString(dp));
        System.out.println("|-----------------------------|");

        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int dynamic = i - coin;
                if (dynamic >= 0 && dp[dynamic] != amount + 1) {
                    System.out.println("i : " + i + " , " + "dynamic: " + dynamic);
                    dp[i] = Math.min(dp[i], 1 + dp[dynamic]);
                    // System.out.println("  凑成" + i + "元，使用面值为 " + coin + " 硬币最少需要的硬币 ：" + dp[i]);
                }
            }
            System.out.println("|-----------------------------|");
        }
        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }

        return dp[amount];
    }

    public int coinChage2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                int dynamic = i - coin;
                if (dynamic < 0) continue;

                if (dp[dynamic] != amount + 1) {
                    dp[i] = Math.min(dp[i], dp[dynamic] + 1);
                }
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }

        return dp[amount];

    }
}
