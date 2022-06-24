package dp.sub_sequence.leet_code_392;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/24 22:19
 * @Desc :  给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * https://leetcode.cn/problems/is-subsequence/
 * <p>
 * 题解：https://leetcode.cn/problems/is-subsequence/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-dpzi-knntf/
 */
public class IsSubsequence2 {

    public boolean isSubsequence(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        // dp[i][j]表示以下标i-1为结尾的字符串s和以下标j-1为结尾的字符串t 相同子序列的长度;

        int[][] dp = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {

                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 相当于t要删除元素，继续匹配
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        return dp[length1][length2] == length1;
    }

    public boolean isSubsequence2(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 删除t中的字符元素，继续匹配
                    dp[i][j] = dp[i][j - 1];
                }

            }
        }

        return dp[m][n] == m;


    }


}
