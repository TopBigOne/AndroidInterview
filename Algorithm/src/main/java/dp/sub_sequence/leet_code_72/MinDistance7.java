package dp.sub_sequence.leet_code_72;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/26 03:03
 * @Desc :
 */
public class MinDistance7 {
    public static void main(String[] args) {
        MinDistance7 minDistance = new MinDistance7();
        minDistance.minDistance("","a");

    }
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }
                int delete = dp[i - 1][j] + 1;
                int replace = dp[i - 1][j - 1] + 1;
                int insert = dp[i][j - 1] + 1;
                dp[i][j] = Math.min(delete, Math.min(replace, insert));
            }
        }
        return dp[m][n];
    }
}
