package back_tracking.leet_code_10;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 2:50 PM
 * * @Desc :  leetcode 10.字节 14 次： 正则表达式匹配 https://leetcode-cn.com/problems/regular-expression-matching/solution/
 */
public class IsMatch5 {

    public boolean isMatch(String s, String p) {
        // 1：判空
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 2： 判断首字符是否相等
        boolean isHeadMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (isHeadMatch && isMatch(s.substring(1), p));
        }

        if (isHeadMatch) {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }
}
