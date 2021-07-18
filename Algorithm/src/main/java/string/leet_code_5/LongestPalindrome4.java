package string.leet_code_5;

/**
 * @author : dev
 * @version :
 * @Date :  7/13/21 1:07 AM
 * @Desc : 最长回文串
 * 题解：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
 */
public class LongestPalindrome4 {
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
                start = i - ((maxLen - 1) >> 1);
                end = i + (maxLen >> 1);
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int len, int left, int right) {
        int l = left;
        int r = right;
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }
}
