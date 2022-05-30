package back_tracking.leet_code_10;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 2:02 AM
 * @Desc :
 */
public class IsMatch3 {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        // 1: 判断s 和 p 的字符是否匹配，ps:先判断 s 是否不为空；
        boolean isHeadMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 分两种情况进行判断
            return isMatch(s, p.substring(2)) || (isHeadMatched && isMatch(s.substring(1), p));
        }
        if (isHeadMatched) {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }
}
