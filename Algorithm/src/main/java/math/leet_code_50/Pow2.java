package math.leet_code_50;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/22 21:10
 * @Desc :
 */
public class Pow2 {

    public static void main(String[] args) {
        Pow2 pow = new Pow2();
        double result = pow.myPow(3, 7);
        System.out.println(result);
    }


    public double myPow(double x, int n) {
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
            b >>>= 1;
        }
        return res;
    }

    public double myPow2(double x, int n) {
        if (x == 0) {
            return x;
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
            b >>>= 1;
        }
        return res;

    }
}
