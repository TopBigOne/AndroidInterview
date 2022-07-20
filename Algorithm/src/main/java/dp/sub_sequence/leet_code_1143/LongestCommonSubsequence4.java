package dp.sub_sequence.leet_code_1143;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 08:50
 * @Desc : 最长公共子序列
 */
public class LongestCommonSubsequence4 {
    public static void main(String[] args) {
        LongestCommonSubsequence4 longestCommonSubsequence = new LongestCommonSubsequence4();
        String text1 = "abcde", text2 = "ace";
        longestCommonSubsequence.longestCommonSubsequence(text1, text2);


    }

    public int longestCommonSubsequence(String text1, String text2) {
        StringBuilder sb = new StringBuilder();
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    sb.append(text1.charAt(i));

                    continue;
                }
                int one = dp[i - 1][j];
                int two = dp[i][j - 1];
                dp[i][j] = Math.max(one, two);
            }

        }
        return dp[m][n];

    }
}
