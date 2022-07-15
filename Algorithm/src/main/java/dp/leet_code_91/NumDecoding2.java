package dp.leet_code_91;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/15 12:43
 * @Desc :
 * <p>
 * 题解：https://leetcode.cn/problems/decode-ways/solution/c-wo-ren-wei-hen-jian-dan-zhi-guan-de-jie-fa-by-pr/
 */
public class NumDecoding2 {

    public static void main(String[] args) {
        NumDecoding2 numDecoding = new NumDecoding2();
        String str = "22665896";
        System.err.println("raw str    : " + str);
        int result = numDecoding.numDecodings(str);
        System.err.println("result : " + result);
    }


    public int numDecodings(String s) {
        int len;
        if (s == null || (len = s.length()) == 0 || s.charAt(0) == '0') {
            return 0;

        }
        int pre = 1;
        int curr = 1;
        for (int i = 1; i < len; i++) {
            int currChar = s.charAt(i);
            int preChar = s.charAt(i - 1);

            // case 1:
            if (currChar == '0') {
                curr = 0;
            }

            // case 2:
            // preChar 是 '1'，'2'的话，currChar<'6'
            // preChar+currChar 的组合才能是 [10,26]
            if (preChar == '1' || preChar == '2' && currChar <= '6') {
                curr = curr + pre;
                pre = curr - pre;
                continue;
            }

            // case 3: skip
            pre = curr;

        }
        return curr;


    }

    public int numDecodings2(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        // dp[-1] dp[0] = 1;
        int pre = 1;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = curr;
            char currChar = s.charAt(i);
            char preChar = s.charAt(i - 1);

            if (currChar == '0') {
                if (preChar == '1' || preChar == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
                continue;
            }

            if (preChar == '1' || preChar == '2' && currChar >= '1' && currChar <= '6') {
                curr += pre;
            }

            pre = temp;


        }
        return curr;

    }

    public int numDecodings3(String s) {
        int len;
        if (s == null || (len = s.length()) == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1;
        int curr = 1;
        for (int i = 1; i < len; i++) {
            char currChar = s.charAt(i);
            char preChar = s.charAt(i - 1);
            if (currChar == '0') {
                curr = 0;
            }
            if (preChar == '1' || preChar == '2' && currChar <= '6') {
                curr += pre;
                pre = curr - pre;
                continue;
            }
            pre = curr;

        }
        return curr;

    }

    public int numDecodings4(String s) {
        int len;
        if (s == null || (len = s.length()) == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int pre = 1;
        int curr = 1;
        for (int i = 1; i < len; i++) {
            int currChar = s.charAt(i);
            int preChar = s.charAt(i - 1);
            if (currChar == '0') {
                curr = 0;
            }
            if (preChar == '0' || pre == '1' && currChar <= '6') {
                curr += pre;
                pre = curr - pre;
                continue;

            }
            pre = curr;

        }
        return curr;


    }
}
