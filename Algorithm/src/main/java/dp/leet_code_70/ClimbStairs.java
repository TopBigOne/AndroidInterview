package dp.leet_code_70;

import ten_sort.select.SelectSort;

/**
 * @author : dev
 * @version :
 * @Date :  7/20/21 12:18 AM
 * @Desc :  https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * f(x) 表示 爬到第 x 级台阶的方案数，
 * 考虑到最后一步可能跨一级台阶，也可能跨 2 级台阶，所以可以列出如下公式
 * f(x) = f(x-1)+f(x-2)
 */
public class ClimbStairs {
    /**
     * 动态规划 解法
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int len = n + 1;
        int[] dp = new int[len+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 滚动数组 解法
     * -时间复杂度 O(n)
     * -空间复杂度 O(1)
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }

        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = first;

        }

        return second;


    }


}
