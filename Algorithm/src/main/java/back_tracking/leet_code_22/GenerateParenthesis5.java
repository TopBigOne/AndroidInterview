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

    private void help(List<String> result, String currStr, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(currStr);
            return;
        }
        if (left > 0) {
            help(result, currStr + "(", left - 1, right);
        }
        if (right > 0 && right > left) {
            help(result, currStr + ")", left, right - 1);
        }
    }
}
