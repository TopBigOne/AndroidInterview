package string.leet_code_8;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/13 14:48
 * @Desc :
 * <p>
 * 题解：https://leetcode.cn/problems/string-to-integer-atoi/solution/jin-liang-bu-shi-yong-ku-han-shu-nai-xin-diao-shi-/
 */
public class MyAtoi3 {
    public static void main(String[] args) {
        String s = "+-12";
        MyAtoi3 myAtoi3 = new MyAtoi3();
        int result = myAtoi3.myAtoi(s);
        System.err.println("result : " + result);
    }

    public int myAtoi(String str) {
        int len;
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        if (str == null || (len = str.length()) == 0) {
            return 0;
        }
        // 1、去除前导空格
        str = str.trim();

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if ((len = str.length()) == 0) {
            return 0;
        }

        char[] charArray = str.toCharArray();
        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        int index = 0;
        char firstChar = str.charAt(index);
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 4、将后续出现的数字字符进行转换
        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = str.charAt(index);
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;

    }


}
