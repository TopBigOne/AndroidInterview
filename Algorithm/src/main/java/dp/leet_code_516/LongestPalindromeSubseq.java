package dp.leet_code_516;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/25 23:29
 * @Url : https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * @Level :    medium
 * @Desc : 最长回文子序列
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 *
 *
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/longest-palindromic-subsequence/solution/dong-tai-gui-hua-si-yao-su-by-a380922457-3/
 * <p>
 * <p>
 * bb aa bb
 * bb a  bb
 * dp[i][j] 表示 第 i 个字符到 第 j 个字符之间最长的回文子序列长度
 * 1、当 s[i] == s[j] 时，考虑 i 和 j 中间序列的奇偶个数， dp[i][j] = dp[i+1][j-1] + 2
 * 对上述 dp[i][j] =  dp[i+1][j-1] + 2 的解释：
 * 当序列为 b aa b 时， i = 0, j = 3，则 dp[0][3] = dp[1][2] + 2 = 4
 * 当序列为 b a b 时，i = 0, j = 2，则 dp[0][2] = dp[1][1] + 2 = 3
 * 当序列为 b b 时， i = 0, j = 1，则 dp[0][1] = dp[1][0] = 0 + 2 = 2 (dp[1][0] 默认值为 0)
 * 该式子同时考虑到了奇偶
 * 2、当 s[i] != s[j] ，那么 dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1])
 * 对上述 dp[i][j] 式子的解释：
 * 假如序列为 d c b c c（index：0-4），s[0] != s[4] ，则 dp[0][4] = Math.max(dp[0][3],dp[1,4]) = Math.max(2,3) = 3
 * <p>
 * 注意：上述按我习惯分析是将 i 放在了 j 的前面，而按我写法习惯这里是将 i 放在了 j 的后面，即上面的 dp[i][j] 在这里应该是 dp[j][i]
 * 两层 for 循环，令 i 从 0 遍历到 len-1，而 j 为 i-1 递减到 0
 * 假如 i = 5，那么 j 的顺序为 4 3 2 1 0，在得到 dp[0][5] 过程中，dp[1][5]等值 就已经提前准备好了，有预先值
 * 一个字符单独作为一个回文子序列，即 dp[i][i] = 1
 */
public class LongestPalindromeSubseq {


    /**
     * 状态
     * f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
     * <p>
     * 转移方程
     * 如果 s 的第 i 个字符和第 j 个字符相同的话
     * <p>
     * f[i][j] = f[i + 1][j - 1] + 2
     * <p>
     * 如果 s 的第 i 个字符和第 j 个字符不同的话
     * <p>
     * f[i][j] = max(f[i + 1][j], f[i][j - 1])
     * <p>
     * 然后注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
     * <p>
     * 初始化
     * f[i][i] = 1 单个字符的最长回文序列是 1
     * <p>
     * 结果
     * f[0][n - 1]
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        // i 从最后一个字符开始往前遍历，
        // j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了。
        for (int i = n - 1; i >= 0; i--) {
            // 单个字符的最长回文序列是 1
            dp[i][i] = 1;
            ;
            for (int j = i + 1; j < n; j++) {
                // 如果 s 的第 i 个字符和第 j 个字符相同的话
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 如果 s 的第 i 个字符和第 j 个字符不同的话
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }

    public int longestPalindromeSubseq2(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public int longestPalindromeSubseq3(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    continue;
                }
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }

    public int longestPalindromeSubse3(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                    continue;
                }
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
            }
        }

        return dp[0][n - 1];

    }
}
