package dp.leet_code_91;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/15 11:39
 * @Desc : 解码方法 : https://leetcode.cn/problems/decode-ways/
 * <p>
 * <p>
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 * <p>
 * -------
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 */
public class NumDecoding {
    public static void main(String[] args) {
        NumDecoding numDecoding = new NumDecoding();
        String str = "22665896";
        System.err.println("str    : " + str);
        int result = numDecoding.numDecodings(str);
        System.err.println("result : " + result);
    }

    /**
     * 空间复杂度 是 O(n)
     *
     * @param s
     * @return
     */
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
            System.err.println("first  : " + first);
            System.err.println("second : " + second);
            System.err.println("-------------------------|");
            // 处理[1,9]字符的：A-->I
            if (first >= 1 && first <= 9) {
                dp[i] = dp[i - 1];
            }
            //处理[10,26]字符的:I-->Z
            if (second >= 10 && second <= 26) {
                // 有可能dp[i]已经发生了改变；
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[len];

    }

    public int numDecodings2(String s) {
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
                dp[i] = dp[i] + dp[i - 2];
            }

        }

        return dp[len];


    }

    public int numDecodings3(String s) {
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
                dp[i] = dp[i] + dp[i - 2];
            }

        }
        return dp[len];


    }
}
