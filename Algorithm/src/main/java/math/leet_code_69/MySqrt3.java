package math.leet_code_69;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/23 06:58
 * @Desc :
 */
public class MySqrt3 {

    public static void main(String[] args) {
        MySqrt3 mySqrt = new MySqrt3();
        double result = mySqrt.sqrt(8);
        System.err.println("result : " + result);
    }

    public double mySqrt(double x) {
        double n = 1e-6;
        double left = 1;
        double right = x / 2;
        // 开始查找
        while (left <= right) {
            double mid = (left + right) / 2;
            if (x / mid < mid) {
                right = mid - n;
            } else {
                left = mid + n;
            }
        }
        return right;
    }

    public  double sqrt(int target) {
        double n = 1e-2;
        double l = 0, r = target / 2;
        while (l <= r) {
            double mid = (l + r) / 2;
            if (target / mid < mid) {
                r = mid - n;
            } else {
                l = mid + n;
            }
        }
        return r;
    }


}
