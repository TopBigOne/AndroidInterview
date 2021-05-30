package back_tracking.leet_code_10;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 2:11 AM
 * @Desc :
 */
public class IsMatch4 {
    public boolean isMatch(String s, String p) {
        // 1: 判空
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //2 : 判断 s 和 p 的首个字符是否能匹配上，注意：对 s 是否判断为空；
        boolean isHeadMatch = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '*');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 2-1;
            return isMatch(s, p.substring(2)) || (isHeadMatch && isMatch(s.substring(1), p));
        }

        // 3:
        if (isHeadMatch) {
            return isMatch(s.substring(1), p.substring(1));
        }
        return false;
    }
}
