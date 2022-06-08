package string.leet_code_65;

/**
 * @author : dev
 * @version :
 * @Date :  11/13/21 9:44 PM
 * @Desc :   有效数字：https://leetcode-cn.com/problems/valid-number/
 * <p>
 * 题解：https://leetcode-cn.com/problems/valid-number/solution/gong-shui-san-xie-zi-fu-chuan-mo-ni-by-a-7cgc/
 */
public class IsNumber {

    public boolean isNumber(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int idx = -1;
        for (int i = 0; i < n; i++) {
            char currChar = cs[i];
            if (currChar == 'e' || currChar == 'E') {
                if (idx == -1) {
                    idx = i;
                } else {
                    return false;
                }
            }
        }

        boolean ans = true;
        if (idx != -1) {
            ans &= check(cs, 0, idx - 1, false);
            ans &= check(cs, idx + 1, n - 1, true);
        } else {
            ans &= check(cs, 0, n - 1, false);
        }
        return ans;
    }

    private boolean check(char[] cs, int start, int end, boolean mustInteger) {
        if (start > end) {
            return false;
        }
        if (cs[start] == '+' || cs[start] == '-') {
            start++;
        }
        boolean hasDot = false;
        boolean hasNum = false;
        for (int i = start; i <= end; i++) {
            char currChar = cs[i];
            if (currChar == '.') {
                if (mustInteger || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (currChar >= '0' && currChar <= '9') {
                hasNum = true;
            } else {
                return false;
            }


        }
        return hasNum;
    }

}
