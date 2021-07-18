package dp.packsack.leet_code_518;


import java.util.Arrays;

import stack.leet_code_726.CountOfAtoms;
import ten_sort.search.LeftBinarySearch;

/**
 * @author : dev
 * @version :
 * @Date :  1/29/21 11:03 PM
 * @Desc :leet code 518 零钱兑换：
 * https://leetcode-cn.com/problems/coin-change-2/solution/
 * 1: 并不是完全背包问题，
 *
 *
 * <p>
 * 题解：https://leetcode-cn.com/problems/coin-change-2/solution/dong-tai-gui-hua-wan-quan-bei-bao-wen-ti-by-liweiw/
 * 题解还是很长的；
 */
public class Change {
    public int change1(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {

            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public int change2(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        int coinFirstValue = coins[0];
        for (int i = coinFirstValue; i <= amount; i += coinFirstValue) {
            System.out.println("i : " + i);
            dp[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }


        return dp[amount];

    }

    public int change3(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        int coinFirstValue = coins[0];
        for (int i = coinFirstValue; i <= amount; i += coinFirstValue) {
            System.out.println("i:" + i);
            dp[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];
    }

    public int change4(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        int coinsFirstValue = coins[0];
        for (int i = coinsFirstValue; i <= amount; i += coinsFirstValue) {
            dp[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public int change5(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }

        }
        return dp[amount];


    }

    public int change6(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }

        for (int i = 1; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }



        return dp[amount];
    }


    public int change7(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;

            }
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        return dp[amount];

    }

    public int change8(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }
        for (int i = 1; i < length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public int change9(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins[0]; i < amount; i += coins[0]) {
            dp[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public int change10(int amount, int[] coins) {
        int len = coins.length;
        // base corner
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }
        System.out.println("init dp :"+ Arrays.toString(dp));

        for (int i = 1; i < len; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }

        System.out.println("dp:"+ Arrays.toString(dp));
        return dp[amount];


    }


}
