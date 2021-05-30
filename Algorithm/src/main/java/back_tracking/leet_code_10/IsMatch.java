package back_tracking.leet_code_10;

/**
 * @author : dev
 * @version :
 * @Date :  5/29/21 10:56 PM
 * @Desc :  leetcode 10.字节 14 次： 正则表达式匹配 https://leetcode-cn.com/problems/regular-expression-matching/solution/
 * <p>
 * 题解：https://leetcode-cn.com/problems/regular-expression-matching/solution/javahui-su-he-dong-tai-gui-hua-xiang-xi-dai-ma-zhu/
 */
public class IsMatch {

    public boolean isMatch(String s, String p) {
        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if (p.isEmpty()) return s.isEmpty();
        //判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {//如果p的第一个元素的下一个元素是*
            //则分别对两种情况进行判断
            return isMatch(s, p.substring(2)) ||
                    (headMatched && isMatch(s.substring(1), p));


        } else if (headMatched) {//否则，如果s和p的首字符相等
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }

    public boolean isMath2(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean headMatched = !s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        // 如果 p 的第一个元素的下一个元素是*
        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 分别对两种情况进行判断
            return isMath2(s, p.substring(2)) || (headMatched && isMath2(s.substring(1), p));
        } else if (headMatched) {
            return isMath2(s.substring(1), p.substring(1));
        } else {
            return false;
        }

    }


}
