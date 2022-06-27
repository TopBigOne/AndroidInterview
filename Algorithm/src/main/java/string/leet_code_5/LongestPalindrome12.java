package string.leet_code_5;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/27 10:20
 * @Desc : (字节，37次。)最长回文子串(https://leetcode-cn.com/problems/longest-palindromic-substring/)
 */
public class LongestPalindrome12 {

    public String longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
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

        }
        return s.substring(res[0], res[0] + res[1]);
    }

    private int[] centerSpread(String s, int start, int end) {
        while (start >= 0 && end < s.length()) {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        }

        return new int[]{start + 1, end - start - 1};
    }


}
