package stack.leet_code_7;

/**
 * @author : dev
 * @version :
 * @Date :  3/14/21 9:58 PM
 * @Desc :   整数 反转：https://leetcode.cn/problems/reverse-integer/solution/
 * <p>
 * 题解：https://leetcode.cn/problems/reverse-integer/solution/hua-jie-suan-fa-7-zheng-shu-fan-zhuan-by-guanpengc/
 */
public class ReverseInt {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 取余操作
            int pop = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            res = res * 10 + pop;
            //每次减少一个数量级（10）
            x /= 10;

        }
        return res;

    }

    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {

            int carry = x % 10;
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && carry > 7)) {
                return 0;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && carry < -8)) {
                return 0;
            }
            res = res * 10 + carry;
            x /= 10;
        }
        return res;


    }


}
