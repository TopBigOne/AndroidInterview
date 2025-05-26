package back_tracking.leet_code_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 21:09
 * @Desc :
 * 题解：https://www.jiakaobo.com/leetcode/22.%20Generate%20Parentheses.html
 * <p>
 * 视频：https://www.youtube.com/watch?v=SwyEvjkUnPU
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

    /**
     * @param result     结果
     * @param curr       当前括号；
     * @param leftCount  左括号的数量，
     * @param rightCount 右括号的数量
     */
    private void helper(List<String> result, String curr, int leftCount, int rightCount) {
        System.out.println("curr : " + curr);
        if (leftCount == 0 && rightCount == 0) {
            System.out.println("start to add.");
            result.add(curr);
            return;
        }

        if (leftCount > 0) {
            helper(result, curr + "(", leftCount - 1, rightCount);
        }

        /*
         * 特殊判断： 有括号的数量，大于左边括号的数量才符合条件
         */
        if (rightCount > 0 && rightCount > leftCount) {
            helper(result, curr + ")", leftCount, rightCount - 1);
        }
    }


}
