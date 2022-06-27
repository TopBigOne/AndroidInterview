package string.leet_code_5;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/27 00:10
 * @Desc :
 */
public class LongestPalindrome11 {

    public static void main(String[] args) {
        String s = "babad";

        LongestPalindrome11 longestPalindrome = new LongestPalindrome11();
        String result = longestPalindrome.longestPalindrome(s);
        System.err.println("result : " + result);
    }

    public String longestPalindrome(String s) {

        int len = 0;
        if (s == null || (len = s.length()) < 2) {
            return s;
        }
        int[] res = new int[2];
        int maxLen = 0;
        for (int i = 0; i < len; i++) {

            int[] odd = centerSpread(s, i, i);
            int[] even = centerSpread(s, i, i + 1);
            int[] max = odd[1] > even[1] ? odd : even;
            if (max[1] > maxLen) {
                maxLen = max[1];
                res = max;
            }
            System.out.println("res status : " + Arrays.toString(res));
        }

        return s.substring(res[0], res[0] + res[1]);


    }

    /**
     * @param s
     * @param i
     * @param j
     * @return index 0 : the start index; index 1: the  Palindrome length;
     */
    private int[] centerSpread(String s, int i, int j) {
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                // i ： 往左边走
                // j :  往右边走
                // 这样的话，才能不断的扩大回文
                i--;
                j++;
            } else {
                // 只要发现了不相等，就直接中断循环
                break;
            }
        }

        return new int[]{i + 1, j - i - 1};
    }
}
