package dp.leet_code_115;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/21 17:54
 * @Url : https://leetcode-cn.com/problems/distinct-subsequences/
 * @Level :   hard
 * @Desc :  给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * <p>
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE"是"ABCDE"的一个子序列，而"AEC"不是）
 * <p>
 * 题目数据保证答案符合 32 位带符号整数范围。
 * @Answer :
 * <p>
 * https://leetcode-cn.com/problems/distinct-subsequences/solution/bu-tong-de-zi-xu-lie-by-leetcode-solutio-urw3/
 */
public class NumDistinct {
    public static void main(String[] args) {
        String s = "rabbbit";
        String t = "rabbit";
        NumDistinct numDistinct = new NumDistinct();
        int result = numDistinct.numDistinct(s, t);
        System.out.println(result);

    }

    public int numDistinct(String s, String t) {
        int n = t.length();
        int m = s.length();
        if (m < n) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[n][m];
    }

    /**
     * 3 中有多少子序列和t 是一样的
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistnict2(String s, String t) {
        int n = t.length();
        int m = s.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;

        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {

                if (t.charAt(i - 1) == s.charAt(j - 1)) {

                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j - 1];
            }

        }
        return dp[n][m];

    }

    public int numDistnict3(String s, String t) {
        int n = t.length();
        int m = s.length();

        if (m < n) {
            return 0;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;

        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[n][m];
    }

    public int numDistinct4(String s, String t) {
        int n = t.length();
        int m = s.length();
        if (m < n) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j - 1];

            }
        }
        return dp[n][m];

    }

    public int numDistinct5(String s, String t) {
        int n = t.length();
        int m = s.length();
        if (m < n) {
            return 0;
        }

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j - 1];

            }

        }

        return dp[n][m];

    }

    public int numDistinct6(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) return 0;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    continue;
                }
                dp[i][j] = dp[i][j - 1];
            }
        }

        return dp[n][m];


    }


}
