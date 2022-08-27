package string.leet_code_8;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/24 04:10
 * @Desc :
 */
public class MyAtoi4 {
    public int myAtoi(String str) {
        int len;
        if (str == null || (len = str.length()) == 0) {
            return 0;

        }
        str = str.trim();
        if ((len = str.length()) == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        int res = 0;
        while (index < len) {
            char currChar = str.charAt(index);
            if (currChar > '9' || currChar < '0') {
                break;
            }
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > 8)) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign * (currChar - '0');
            index++;

        }
        return res;

    }
}
