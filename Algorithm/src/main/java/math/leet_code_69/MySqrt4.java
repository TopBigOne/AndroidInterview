package math.leet_code_69;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/23 07:19
 * @Desc :
 * 题解：https://www.packetmania.net/2021/07/23/PGITVW-2-sqrt/
 */
public class MySqrt4 {
    public static void main(String[] args) {
        MySqrt4 mySqrt = new MySqrt4();
        double result = mySqrt.sqrtCount(8, 0.000001);
        System.err.println("result : " + result);
    }

    double sqrtCount(double x, double precision) {
        if (x < 0) {
            return -1;
        }

        double low = 1;
        double up = x;
        if (x > 0 && x < 1) {
            low = x;
            up = 1;
        }

        while (low <= up) {
            double mid = low + (up - low) / 2.0;
            if (Math.abs(mid * mid - x) <= precision)
                return mid;
            else if (mid * mid > x) {
                up = mid;
            } else if (mid * mid < x) {
                low = mid;
            }
        }
        return -1;
    }

}
