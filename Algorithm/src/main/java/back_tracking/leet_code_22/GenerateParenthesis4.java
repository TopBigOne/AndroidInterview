package back_tracking.leet_code_22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/24 11:22
 * @Desc :
 */
public class GenerateParenthesis4 {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        help(result, "", n, n);
        return result;
    }

    private void help(List<String> result, String s, int l, int r) {
        if (l == 0 && r == 0) {
            result.add(s);
            return;
        }
        if (l > 0) {
            help(result, s + "(", l - 1, r);
        }
        if (r > 0 && r > l) {
            help(result, s + ")", l, r - 1);
        }
    }


}
