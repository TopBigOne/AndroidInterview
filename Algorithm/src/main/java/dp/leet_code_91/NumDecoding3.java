package dp.leet_code_91;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/29 00:15
 * @Desc :
 */
public class NumDecoding3 {
    public int numDecodings(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= len; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                dp[i] = dp[i - 1];
            }
            if (second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }

        }
        return dp[len];

    }
}
