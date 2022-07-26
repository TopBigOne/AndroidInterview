package math.leet_code_172;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/19 21:29
 * @Desc :  172. 阶乘后的零 https://leetcode-cn.com/problems/factorial-trailing-zeroes/submissions/
 * <p>
 * 2*5 = 10;
 */
public class TrailingZero {
    public static void main(String[] args) {
        TrailingZero trailingZero = new TrailingZero();
        trailingZero.trailingZeroes(8);
    }

    public int trailingZeroes(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;
        }
        return result;
    }

    public int trailingZeroes2(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;

        }
        return result;
    }

    public int trailingZeros3(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;
        }
        return result;
    }

    public int trailingZeroes4(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;
        }
        return result;
    }

    public int trailingZeroes5(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;
        }
        return result;
    }

    public int trailingZeroes6(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;
        }
        return result;
    }

    /**
     * 阶乘以后，0的个数
     *
     * @param n
     * @return
     */
    public int trailingZeroes7(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;
        }
        return result;
    }

    public int trailingZeroes8(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;
        }
        return result;
    }
}
