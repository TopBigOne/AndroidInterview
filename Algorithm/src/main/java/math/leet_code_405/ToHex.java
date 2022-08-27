package math.leet_code_405;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 00:04
 * @Desc :
 *
 * 题解：https://leetcode.cn/problems/convert-a-number-to-hexadecimal/solution/gong-shui-san-xie-yi-ti-shuang-jie-jin-z-d93o/
 */
public class ToHex {
    public String toHex(int num) {
        if (num == 0){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int u = num & 15;
            char c = (char) (u + '0');
            if (u >= 10) c = (char) (u - 10 + 'a');
            sb.append(c);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

}
