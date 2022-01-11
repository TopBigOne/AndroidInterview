package string.leet_code_214;

/**
 * @author : dev
 * @version :
 * @Date :  12/30/21 8:23 PM
 * @Desc :
 * <p>
 * https://leetcode-cn.com/problems/shortest-palindrome/
 * <p>
 * 题解：https://leetcode-cn.com/problems/shortest-palindrome/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--44/
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        char[] c = s.toCharArray();
        while (j >= 0) {
            if (c[i] == c[j]) {
                i++;
            }
            j--;
        }
        //此时代表整个字符串是回文串
        if (i == s.length()) {
            return s;
        }
        //后缀
        String suffix = s.substring(i);
        //后缀倒置
        String reverse = new StringBuilder(suffix).reverse().toString();
        //递归 s[0,i),寻找开头开始的最长回文串，将其余部分加到开头和结尾
        return reverse + shortestPalindrome(s.substring(0, i)) + suffix;


    }
}
