package back_tracking.leet_code_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 21:09
 * @Desc :
 * 题解：https://www.jiakaobo.com/leetcode/22.%20Generate%20Parentheses.html
 */
public class GenerateParenthesis2 {
    public static void main(String[] args) {
        GenerateParenthesis2 generateParenthesis2 = new GenerateParenthesis2();
        List<String> result = generateParenthesis2.generateParenthesis(3);
        System.err.println("result : " + result);

    }


    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", n, n);
        return result;

    }

    private void helper(List<String> result, String curr, int left, int right) {
        System.out.println("curr : " + curr);
        if (left == 0 && right == 0) {
            System.out.println("start to add.");
            result.add(curr);
            return;
        }

        if (left > 0) {
            helper(result, curr + "(", left - 1, right);
        }

        if (right > 0 && right > left) {
            helper(result, curr + ")", left, right - 1);
        }
    }


}
