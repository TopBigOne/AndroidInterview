package math.offer_16;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/12 11:17
 * @Desc :数值的整数次方 :https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/jian-dan-li-jie-kuai-su-mi-by-ollieq-rl74/
 */
public class MyPow {

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double result = myPow.myPow(5, 3);
        System.err.println("result : " + result);
    }

    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }

        long b = n;
        double res = 1.0;
        // 转正
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }

        while (b > 0) {
            // 判断最后一位是否为1。
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;

    }

    public double myPow2(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;

        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;

    }

    public double myPow3(double x, int n) {
        if (x == 0) {
            return 0;
        }

        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;


    }
}
