package dp.recursive.leet_code_70;

/**
 * @author : dev
 * @version :
 * @Date :  2/1/21 11:10 PM
 * @Desc : 递推类型的 dp
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbStair {
    public int climbStair1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        int length = dp.length;
        for (int i = 2; i < length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
    public int climbStair2(int n) {
        int length = n + 1;
        int[] dp = new int[length];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < length; i++) {
            // 假如：爬 5 个台阶，每次爬一个台阶，或者爬 2 个台阶；
            //- 如果爬1个台阶，那就就剩下 4 个台阶要爬；
            //- 如果爬2个台阶，那就就剩下 3 个台阶要爬；
            //- 于是：爬 5 个台阶的方式数目= 爬 4 级台阶的方式数目+爬 3 级台阶的方式数目
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
