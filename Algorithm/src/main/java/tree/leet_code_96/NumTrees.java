package tree.leet_code_96;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/12 20:24
 * @Desc :字节7次：不同的二叉搜索树（https://leetcode-cn.com/problems/unique-binary-search-trees/）
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class NumTrees {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }

        return dp[n];
    }

    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - 1];
            }
        }
        return dp[n];
    }


}
