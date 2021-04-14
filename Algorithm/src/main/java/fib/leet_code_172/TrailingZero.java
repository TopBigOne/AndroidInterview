package fib.leet_code_172;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/19 21:29
 * @Desc : https://leetcode-cn.com/problems/factorial-trailing-zeroes/submissions/
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

    public int trailingZeros6a(int n) {
        int result = 0;
        int div = 5;
        while (div <= n) {
            result += n / div;
            div *= 5;
        }
        return result;
    }
}
