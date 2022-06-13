package math.offer_14_2;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/11 19:52
 * @Desc : https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
 */
public class CuttingRope {
    public int cuttingRope(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        long res = 1;
        int mod = 1000000007;

        while (n > 4) {
            res *= 3;
            res = res % mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }
}
