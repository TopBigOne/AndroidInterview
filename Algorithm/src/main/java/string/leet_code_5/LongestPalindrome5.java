package string.leet_code_5;

/**
 * @author : dev
 * @version :
 * @Date :  7/15/21 12:08 AM
 * @Desc :
 */
public class LongestPalindrome5 {
    public String longestPalindrome(String str) {
        int len;
        if (str == null || (len = str.length()) == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(str, len, i, i);
            int len2 = expandAroundCenter(str, len, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }
        return str.substring(start, end + 1);
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
