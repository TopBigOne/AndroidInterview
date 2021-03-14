package stack.single_invoke_stack.leet_code_32;

/**
 * @author : dev
 * @version :
 * @Date :  3/14/21 8:02 PM
 * @Desc :
 */
public class Test {

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        String rawStr = ")()())";

        int result = longestValidParentheses.longestValidParentheses(rawStr);
        System.out.println("result: "+result);


    }

}
