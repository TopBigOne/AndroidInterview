package string.offer_67;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/13 17:59
 * @Desc :
 */
public class StrToInt {
    public static void main(String[] args) {
        // String s = "-91283472332";
        // String s = "42";
        //  String s = "4193 with words";
        //  String s = "-";
        //String s = "+1";
        // String s = "    0000000000000   ";
        //   String s = "  -0k4";

        String s = "20000000000000000000";
        //
        System.out.println(" s         : " + s);
        System.out.println(" MAX_VALUE : " + Integer.MAX_VALUE);
        System.out.println(" MIN_VALUE : " + Integer.MIN_VALUE);
        StrToInt strToInt = new StrToInt();
        int result = strToInt.strToInt(s);

        System.err.println("result : " + result);
    }


    public int strToInt(String str) {
        str = str.trim();//去掉前后的空格
        //如果为空，直接返回0
        if (str.length() == 0)
            return 0;
        int index = 0;//遍历字符串中字符的位置
        int res = 0;//最终结果
        int sign = 1;//符号，1是正数，-1是负数，默认为正数
        int length = str.length();
        //判断符号
        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index++) == '+' ? 1 : -1;
        }

        for (; index < length; ++index) {
            //取出字符串中字符，然后转化为数字
            int digit = str.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9) {
                break;
            }
            //越界处理
            if (res > Integer.MAX_VALUE / 10 ||
                    (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                res = res * 10 + digit;
            }
        }

        return sign * res;

    }


}