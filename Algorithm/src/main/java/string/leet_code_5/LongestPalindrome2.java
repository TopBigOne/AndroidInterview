package string.leet_code_5;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/28 17:39
 * @Desc : 最长回文子串
 * <p>
 * 题解：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
 */
public class LongestPalindrome2 {
    public static void main(String[] args) {

    }

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
