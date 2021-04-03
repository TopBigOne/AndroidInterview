package stack.leet_code_1021;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/2 21:18
 * @Desc :
 * 最牛x 的解法： https://leetcode-cn.com/problems/remove-outermost-parentheses/solution/jian-ji-de-java-shi-xian-by-huaouo/
 */
public class RemoveOuterParentheses2 {

    public String removeOuterParentheses(String s) {
        char leftBracket = '(';
        char rightBracket = ')';
        StringBuilder sb = new StringBuilder();
        int level = 0;

        for (char c : s.toCharArray()) {

            if (c == rightBracket) {
                --level;
            }

            if (level >= 1) {
                sb.append(c);
            }

            if (c == leftBracket) {
                ++level;
            }

        }
        return sb.toString();

    }


}
