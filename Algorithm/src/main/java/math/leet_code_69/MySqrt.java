package math.leet_code_69;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 7:45 PM
 * @Desc :leetcode： 69； x 的平方根字 ；节半年24 次 https://leetcode-cn.com/problems/sqrtx/
 * <p>
 * 牛顿迭代法 : 题解：https://leetcode-cn.com/problems/sqrtx/solution/niu-dun-die-dai-fa-by-loafer/
 * 牛顿迭代法
 */
public class MySqrt {
    int s;

    public int mySqrt(int x) {
        s = x;
        if (x == 0) return 0;
        return ((int) (sqrts(x)));
    }

    public double sqrts(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        }
        return sqrts(res);

    }

}
