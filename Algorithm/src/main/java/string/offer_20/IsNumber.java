package string.offer_20;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/7 20:34
 * @Desc : 剑指 Offer 20. 表示数值的字符串 ：https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 题解：https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/solution/by-gong-zhu-zi-zhu-3xvr/
 */
public class IsNumber {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // 去掉首尾部空格
        s = s.trim();

        // 是否出现数字
        boolean numFlag = false;
        // 是否出现小数点
        boolean dotFlag = false;

        boolean eFlag = false;

        for (int i = 0; i < s.length(); i++) {

            // 判定为数字，则标记numFlag
            char currChar = s.charAt(i);

            if (currChar >= '0' && currChar <= '9') {
                numFlag = true;

                // 小数点只可以出现再e之前，且只能出现一次.num  num.num num.都是被允许的
            } else if (currChar == '.' && !dotFlag && !eFlag) {
                dotFlag = true;
                // 判定为e，需要没出现过e，并且出过数字了
            } else if ((currChar == 'e' || currChar == 'E') && !eFlag && numFlag) {
                eFlag = true;

                //避免e以后没有出现数字
                numFlag = false;
                //判定为+-符号，只能出现在第一位或者紧接e后面
            } else if ((currChar == '+' || currChar == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {

                //其他情况，都是非法的
            } else {
                return false;
            }
        }

        //是否出现了数字
        return numFlag;
    }


}
