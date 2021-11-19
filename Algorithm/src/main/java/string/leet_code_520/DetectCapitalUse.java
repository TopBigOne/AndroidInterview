package string.leet_code_520;

/**
 * @author : dev
 * @version :
 * @Date :  11/13/21 8:56 PM
 * @Desc :  检测大写字母： https://leetcode-cn.com/problems/detect-capital/
 * <p>
 * 题解：https://leetcode-cn.com/problems/detect-capital/solution/gong-shui-san-xie-jian-dan-zi-fu-chuan-m-rpor/
 */
public class DetectCapitalUse {
    public boolean detecttCaptalUse(String word) {
        int length = word.length();
        int cnt = 0;
        for (int i = 0; i < length; i++) {
            if (Character.isUpperCase((word.charAt(i)))) {
                cnt++;
            }
        }

        return cnt == length || // 全是大写
                cnt == 0 || // 全是小写
                (cnt == 1 && Character.isUpperCase(word.charAt(0)));// 只有字符串第一个位置是大写字符
    }
}
