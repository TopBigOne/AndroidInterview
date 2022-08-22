package math.leet_code_50;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/28 21:28
 * @Url : https://leetcode-cn.com/problems/powx-n/
 * @Level : easy medium hard
 * @Desc : leetcode 50 : 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x的n次方）。
 * @Counter : 5
 * @Answer :
 */
public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        double result = pow.myPow2(81, 1);
        System.out.println(result);
    }

    /**
     * https://leetcode-cn.com/problems/powx-n/solution/qing-xi-jian-dan-de-dan-han-shu-di-gui-wu-lei-xing/
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        if (n == -1) {
            return 1 / x;
        }
        double half = myPow(x, n >> 2);
        double rest = myPow(x, n % 2);

        return rest * half * half;
    }

    public double myPow2(double x, int n) {
        System.out.println("x:" + x + " , n :" + n);
        if (n == Integer.MIN_VALUE) {
            return x == 1 || x == -1 ? 1 : 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return myPow2(1 / x, -n);
        }
        if (n % 2 == 0) {
            return myPow2(x * x, n / 2);
        } else {
            return myPow2(x, n - 1) * x;
        }
    }

    public double myPow3(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return x == 1 || x == -1 ? 1 : 0;
        }

        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            // 你还记得吗： 负负得正
            return myPow3(1 / x, -n);
        }
        // 如果n 是偶数,用位运算，判断奇偶.
        return ((n & 1) != 1) ? myPow3(x * x, n / 2) : myPow3(x, n - 1) * x;
    }


}
