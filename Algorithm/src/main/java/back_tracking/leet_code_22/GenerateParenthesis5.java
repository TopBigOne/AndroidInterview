package back_tracking.leet_code_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/26 02:24
 * @Desc :
 */
public class GenerateParenthesis5 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        help(result, "", n, n);
        return result;

    }

    /**
     * @param result  结果集
     * @param currStr 当前字符串
     * @param left    左括号 剩余的数量
     * @param right   右括号 剩余的数量
     */
    private void help(List<String> result, String currStr, int left, int right) {
        // case 1 ： 第一种有效的情况
        if (left == 0 && right == 0) {
            result.add(currStr);
            return;
        }


        // case 2: 第二种有效的情况
        if (left > 0) {
            help(result, currStr + "(", left - 1, right);
        }

        // case 3: 第三种有效的情况
        if (right > 0 && right > left) {
            help(result, currStr + ")", left, right - 1);
        }
    }
}
