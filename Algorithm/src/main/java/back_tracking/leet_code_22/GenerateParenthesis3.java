package back_tracking.leet_code_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/24 10:40
 * @Desc :
 */
public class GenerateParenthesis3 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, "", n, n);
        return result;

    }

    private void helper(List<String> result, String str, int leftCount, int rightCount) {
        if (leftCount == 0 && rightCount == 0) {
            result.add(str);
        }
        if (leftCount > 0) {
            helper(result, str + "(", leftCount - 1, rightCount);
        }
        if (rightCount > 0 && rightCount > leftCount) {
            helper(result, str + ")", leftCount, rightCount - 1);
        }
    }
}
