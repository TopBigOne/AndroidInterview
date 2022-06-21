package dp.sub_sequence.leet_code_72;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/21 15:39
 * @Desc :
 */
public class MinDistance5 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {

                // 字符相等，什么都不用做；
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    continue;
                }

                int delete = dp[i - 1][j] + 1;

                int replace = dp[i - 1][j - 1] + 1;

                int insert = dp[i][j - 1] + 1;

                dp[i][j] = Math.min(insert, Math.min(replace, delete));

            }

        }
        return dp[len1][len2];
    }
}
