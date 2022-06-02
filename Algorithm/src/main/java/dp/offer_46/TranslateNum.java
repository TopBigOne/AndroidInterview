package dp.offer_46;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/1 18:14
 * @Desc :把数字翻译成字符串：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 */
public class TranslateNum {
    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();

        int num = 12258;
        System.out.println("use num : " + num);
        int result = translateNum.translateNum(num);
        System.err.println("result  : " + result);
    }

    public int translateNum(int num) {

        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            // 如果 第 i−1 位和第 i 位组成的数字在 10 到 25 之间，可以把这两位连起来翻译
            // 最后两位字符出城的数字
            char preChar = s.charAt(i - 2);
            char currChar = s.charAt(i - 1);
            // System.out.println("combination string : " + (preChar + currChar));
            //  第 i−1 位和第 i 位组成的数字
            int currNum = (preChar - '0') * 10 + currChar - '0';
            // 因为 小写字母只有 26个
            if (currNum > 9 && currNum < 26) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                // 不符合条件
                dp[i] = dp[i - 1];
            }
            System.out.println("dp status : " + Arrays.toString(dp));
        }

        return dp[len ];
    }

    public int translateNum2(int num) {
        /*
         *  1,2,2,5,8
         *  12,2,5,8
         *  1,22,5,8
         *  1,2,25,8
         *  1,2,2,58
         *
         *
         * */

        String s = String.valueOf(num);
        int len = s.length();
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String temp = s.substring(i - 2, i);
            System.out.println("temp : " + temp);
            // 0-25 之间
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
            System.out.println("dp status : " + Arrays.toString(dp));

        }

        return dp[len];
    }
}
