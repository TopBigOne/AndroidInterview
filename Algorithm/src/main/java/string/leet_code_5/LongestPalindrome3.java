package string.leet_code_5;

/**
 * @author : dev
 * @version :  (字节，37次)最长回文子串(https://leetcode-cn.com/problems/longest-palindromic-substring/)
 * @Date :  7/12/21 12:59 AM
 * @Desc :
 */
public class LongestPalindrome3 {
    public String longestPalindrome(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(s, len, i, i);
            int len2 = expandAroundCenter(s, len, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public String longestPalindrome2(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(s, len, i, i);
            int len2 = expandAroundCenter(s, len, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    private int expandAroundCenter(String s, int len, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }
        return r - l - 1;
    }

}
