package palindrome.leet_code_09;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 5:15 PM
 * @Desc : leetcode 09: 回文数；字节 8 次：https://leetcode-cn.com/problems/palindrome-number/
 * 快慢指针；
 */
public class IsPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String newStr = String.valueOf(x);
        int start = 0;
        int end = newStr.length() - 1;
        while (start < end) {
            if (newStr.charAt(start) != newStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

}
