package back_tracking.leet_code_10;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/23 18:28
 * @Desc :
 * <p>
 * 题解：https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
 */
public class IsMatch6 {

    /**
     * "aab", ".*"
     * "ab",".*"
     * "aab" , "c*a*b"
     * --> "aab" , "c*aab"
     * '*' 可以把c给消掉
     * ----------------
     *
     * <p>
     * boolean dp[i][j]的含义是 s[0-i] 与p[0-j] 是否匹配？
     * dp[0][0] = true;
     * 1. if p.charAt(j) == s.charAt(i) ===>dp[i][j] = dp[i-1] [j-1];
     * 2. if p.charAt(j) == '.' ===> do[i][j] = dp[i-1][j-1];
     * 3. if p.charAt(j) == '*'
     * ******** here are two sub conditions:
     * *********** 1: if p.charAt(j-1) != .charAt(i) : dp[i][j] = dp[i][j-2] // int this case ,a* only counts as empty;
     * *********** 2: if the p.charAt(j-1) == s.charAt(i) or p.charAt(j-1) == '.';
     * ***************** dp[i][j] = dp[i][j-1] // in this case ,a* counts as single a;
     * ***************** dp[i][j] = dp[i][j-2] // in this case ,a* counts as empty;
     * ***************** dp[i][j] = dp[i-1][j] // in this case ,a* counts as single multiple a;
     * <p>
     * .  : 匹配任意单一字符；
     * *  : 匹配0个或者多个前面已经记录的字符；
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;

        for (int i = 0; i < pLength; i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j < pLength; j++) {
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        }

        return dp[sLength][pLength];

    }


    public boolean isMatch2(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;

        for (int i = 0; i < pLength; i++) {
            if (i > 0 && p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < sLength; i++) {
            char sChar = s.charAt(i);
            for (int j = 0; j < pLength; j++) {
                char pChar = p.charAt(j);

                // case 1: 字符一样
                if (pChar == sChar) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                //  case 2: p char 是 '.'  ，'.' 能匹配单一任意字符；
                if (pChar == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                // case 3: pchar 是 *
                if (pChar == '*') {


                    // j =     * 的位置
                    // "baab","bc*aab"
                    // 把"c*" 删除以后，我们需要看b的状态[j-1]
                    // dp[i][j] = dp[i][j-2]
                    // case 3-1:
                    char lastPChat = p.charAt(j - 1);
                    // sChar 是'a',index = 0 处的'a';
                    //
                    if (lastPChat != sChar && lastPChat != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        //
                        dp[i + 1][j + 1] = dp[i + 1][j]  //  "aa","a*"
                                || dp[i + 1][j - 1]      //
                                || dp[i][j + 1];        //  "aaaaaa","a*"
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }

    public boolean isMatch3(String s, String p) {
        // corner base
        if (s == null || p == null) {
            return false;
        }
        char star = '*';
        char dot = '.';
        int sLength = s.length();
        int pLength = p.length();

        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;

        for (int j = 0; j < pLength; j++) {
            if (j > 0 && p.charAt(j) == star && dp[0][j - 1]) {
                dp[0][j+1] = true;
            }
        }

        for (int i = 0; i < sLength; i++) {
            for (int j = 0; j < pLength; j++) {
                char sChar = s.charAt(i);
                char pChar = p.charAt(j);

                // case 1: 字符相等
                if (sChar == pChar) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                // case 2: 是点
                if (pChar == dot) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                // case 3: 字符相等
                if (pChar == star && j > 0) {
                    char lastPChar = p.charAt(j - 1);

                    if (lastPChar != sChar && lastPChar != dot) {
                        // /in this case, a* only counts as empty
                        // p 的上一个位置
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];

                    } else {
                        dp[i + 1][j + 1] =
                                dp[i + 1][j] // p 中上一个字符
                                        || dp[i + 1][j - 1] // p 中，上2个字符
                                        || dp[i][j + 1]; // s 中上一个字符

                    }
                }

            }
        }
        return dp[sLength][pLength];

    }
}
