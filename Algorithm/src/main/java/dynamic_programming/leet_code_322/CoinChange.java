package dynamic_programming.leet_code_322;


import com.sun.org.apache.xerces.internal.impl.xpath.regex.REUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * @author : dev
 * @version :
 * @Date :  1/28/21 10:39 PM
 * @Desc :给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * --------https://leetcode-cn.com/problems/coin-change/solution/322-by-ikaruga/
 * -----: 题解：https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * <p>
 * 贪心 + dfs
 * 执行用时：4 ms, 在所有 Java 提交中击败了97.87%的用户
 * 内存消耗：35.9 MB, 在所有 Java 提交中击败了96.52%的用户
 */
public class CoinChange {
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        mincoin(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void mincoin(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            mincoin(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }

    //-----------------2---------------start
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        mincoin2(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void mincoin2(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        // 核心代码
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            mincoin2(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }

    //-----------------2---------------end

    //-----------------3---------------start
    public int coinChage3(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        minCoins3(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void minCoins3(int[] coins, int amount, int index, int count) {
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            minCoins3(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }

    //-----------------3---------------end

    //-----------------4---------------start
    public int coinChange4(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        minCoin4(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void minCoin4(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && i + count < res; i--) {
            minCoin4(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }

    //-----------------4---------------end
    //-----------------5---------------start
    public int coinChange5(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        minCoin5(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void minCoin5(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && count + i < res; i--) {
            minCoin5(coins, amount - (i * coins[index]), index - 1, count + 1);
        }
    }
    //-----------------5---------------end


    public int coinChange6(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        Arrays.sort(coins);
        minCoin6(coins, amount, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;

    }

    private void minCoin6(int[] coins, int amount, int index, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
            return;
        }
        if (index < 0) {
            return;
        }
        for (int i = amount / coins[index]; i >= 0 && count + i < res; i--) {
            minCoin6(coins, amount - (i * coins[index]), index - 1, count + i);
        }
    }


}
