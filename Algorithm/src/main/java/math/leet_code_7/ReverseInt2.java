package math.leet_code_7;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/11 22:26
 * @Desc :
 */
public class ReverseInt2 {
    public static void main(String[] args) {
        ReverseInt2 reverseInt = new ReverseInt2();
        int result = reverseInt.reverse(123);
        System.err.println("result : " + result);

    }

    // x = 123
    public int reverse(int x) {
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
