package string.leet_code_8;

/**
 * @author : dev
 * @version :
 * @Date :  2021/5/26 16:10
 * @Desc : leet code 8： 字符串转换整数：https://leetcode-cn.com/problems/string-to-integer-atoi/
 * <p>
 * 题解：https://leetcode-cn.com/problems/string-to-integer-atoi/solution/jin-liang-bu-shi-yong-ku-han-shu-nai-xin-diao-shi-/
 */
public class MyAtoi {
    public int myAtoi(String str) {
        int len = str.length();
        // str.charAt(i) 方法回去检查下标的合法性，一般先转换成字符数组
        char[] charArray = str.toCharArray();

        // 1、去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }

        // 2、如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }

        // 3、如果出现符号字符，仅第 1 个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
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
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 ||
                    (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }

    public int myAtoi2(String str) {
        int len = str.length();
        char[] charArray = str.toCharArray();

        // 去除前导空格
        int index = 0;
        while (index < len && charArray[index] == ' ') {
            index++;
        }
        // 2: 如果已经遍历完成，（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }
        // 3: 如果出现符号字符，仅第1个有效，并记录正负
        int sign = 1;
        char firstChar = charArray[index];
        if (firstChar == '+') {
            index++;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }
        // 4: 将后续出现的数字字符进行转换
        // 不能使用long 类型。这是题目说的；
        int res = 0;
        while (index < len) {
            char currChar = charArray[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }
            int tempMax = Integer.MAX_VALUE / 10;
            int tempMin = Integer.MIN_VALUE / 10;
            int tempChar = currChar - '0';
            if (res > tempMax ||
                    (res == tempMax && tempChar > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < tempMin ||
                    (res == tempMin && tempChar > -(Integer.MIN_VALUE % 10))
            ) {

                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * tempChar;
            index++;


        }
        return res;

    }


}
