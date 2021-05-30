package back_tracking.leet_code_10;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 1:02 AM
 * @Desc :
 * <p>
 * 题解：https://leetcode-cn.com/problems/regular-expression-matching/solution/javahui-su-he-dong-tai-gui-hua-xiang-xi-dai-ma-zhu/
 */
public class IsMatch2 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 判断 s 和 p 的首字符是否匹配，主要先判断 s 不为空
        boolean isHeadMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // 如果p 的第一个元素的下一个元素是*
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 则分别对两种情况进行判断
            return isMatch(s, p.substring(2)) || (isHeadMatched && isMatch(s.substring(1), p));

        } else if (isHeadMatched) {
            // 如果 s 和 p 首字符相等
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }

    public boolean isMatch2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 1: 判断 s和 p 的首字符匹配， 主要先判断 s 不为空；
        boolean isHeadMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        // 如果 p 的第一个元素的下一个元素是*
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch2(s, p.substring(2)) || (isHeadMatched && isMatch2(s.substring(1), p));

        } else if (isHeadMatched) {
            // 如果 s 和 p 手字符相等
            return isMatch2(s.substring(1), p.substring(1));
        } else {
            return false;
        }


    }
}
