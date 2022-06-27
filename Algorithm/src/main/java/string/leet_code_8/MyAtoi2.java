package string.leet_code_8;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/27 11:46
 * @Desc :
 */
public class MyAtoi2 {
    public int myAtoi(String s) {
        // 1: base corner
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }


        // 2: remove all space
        s = s.trim();
        if ((len = s.length()) == 0) {
            return 0;
        }
        // 3:check p or n;
        int index = 0;
        int sign = 1;
        char firstChar = s.charAt(index);
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            sign = -1;
            index++;
        }
        int res = 0;
        while (index < len) {
            char currChar = s.charAt(index);
            //  不能转换成数字
            if (currChar < '0' || currChar > '9') {
                break;
            }
            // 检查越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && currChar - '0' > 7)) {
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

    public int myAtoi2(String s) {
        int len = 0;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        s = s.trim();
        if ((len = s.length()) == 0) {
            return 0;
        }
        int index = 0;
        char firstChar = s.charAt(index);
        int sign = 1;
        if (firstChar == '+') {
            index++;

        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }
        int res = 0;
        while (index < len) {
            char currChar = s.charAt(index);
            // check the char valuable
            if (currChar < '0' || currChar > '9') {
                break;
            }

            // check res scorp;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && currChar - '0' > 7)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && currChar - '0' > 8)) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (currChar - '0');
            index++;
        }

        return res;


    }
}
