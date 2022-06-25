package back_tracking.leet_code_10;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/25 16:57
 * @Desc :
 */
public class IsMatch7 {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        // '*' 匹配零个或多个前面的那一个元素
        char STAR = '*';
        // '.' 匹配任意单个字符
        char DOT = '.';

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            if (i > 0 && dp[0][i - 1] && p.charAt(i) == STAR) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char sChar = s.charAt(i);
                char pChar = p.charAt(j);
                if (sChar == pChar) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (pChar == DOT) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (pChar == STAR) {
                    char preChar = p.charAt(j - 1);
                    if (preChar != sChar && preChar != DOT) {
                        // p 的上一个位置
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] =
                                dp[i + 1][j] // dp[i][j-1]
                                        || dp[i + 1][j - 1] // dp[i][j-2]
                                        || dp[i][j + 1];//  dp[i-1][j]
                    }
                }
            }
        }

        return dp[m][n];
    }

    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char START = '*';
        char DOT = '.';

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            //  // '*' 匹配零个或多个,前面的那一个元素
            if (i > 0 && dp[0][i - 1] && p.charAt(i) == START) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char sChar = s.charAt(i);
                char pChar = p.charAt(j);

                if (sChar == pChar) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                // dot 能匹配任意字符
                if (pChar == DOT) {
                    dp[i + 1][j + 1] = dp[i][j];
                }


                // 匹配0个或者多个 ，前面的那个字符
                if (pChar == START) {
                    char preChar = p.charAt(j - 1);
                    if (preChar != sChar && preChar != DOT) {
                        // 跳过2个字符
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] =
                                dp[i + 1][j]
                                        || dp[i + 1][j - 1]
                                        || dp[i][j + 1];
                    }
                }
            }
        }

        return dp[m][n];

    }

    public boolean isMatch3(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char DOT = '.';
        char STAR = '*';

        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == STAR && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            char sChar = s.charAt(i);
            for (int j = 0; j < n; j++) {
                char pChar = p.charAt(j);

                if (sChar == pChar) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (pChar == DOT) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (pChar == STAR) {
                    char preChar = p.charAt(j - 1);
                    if (sChar != preChar && preChar != DOT) {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] =
                                dp[i + 1][j - 1] ||
                                        dp[i + 1][j] ||
                                        dp[i][j + 1];
                    }
                }
            }
        }
        return dp[m][n];


    }
}
