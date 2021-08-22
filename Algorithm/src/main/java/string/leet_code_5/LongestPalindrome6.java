package string.leet_code_5;

import javax.print.attribute.standard.Media;

/**
 * @author : dev
 * @version :
 * @Date :  8/22/21 1:44 PM
 * @Desc : 最长回文串   (字节，37次)最长回文子串(https://leetcode-cn.com/problems/longest-palindromic-substring/)
 */
public class LongestPalindrome6 {
    /**
     * 解法 4: 扩展中心
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    private int expandAroundCenter(String s, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;

    }


}
