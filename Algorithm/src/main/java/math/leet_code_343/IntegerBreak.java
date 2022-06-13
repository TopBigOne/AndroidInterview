package math.leet_code_343;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/11 18:37
 * @Desc : 整数拆分 : 是面积最大 https://leetcode.cn/problems/integer-break/
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        // 余数
        int b = n % 3;

        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }
        return (int) Math.pow(3, a) * 2;
    }

    public int integerBreak2(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) Math.pow(3, a - 1) * 4;
        }

        return (int) (Math.pow(3, a) * 2);

    }

    public int integerBreak3(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int a = n / 3;
        int b = n % 3;

        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            // n = 10
            // 3*3*4
            return (int) Math.pow(3, a - 1) * 4;
        }
        // n = 11
        // 3*3*2
        return (int) Math.pow(3, a) * 2;

    }

}
