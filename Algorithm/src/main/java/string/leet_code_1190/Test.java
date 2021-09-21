package string.leet_code_1190;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/12 12:52
 * @Url : https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test {
   static String strs = "(u(love)i)";
    public static void main(String[] args) {

        test1();

    }

    private static void test1() {
        ReverseParentheses reverseParentheses = new ReverseParentheses();
        String result = reverseParentheses.reverseParentheses(strs);
        System.out.println(result);
    }
}
