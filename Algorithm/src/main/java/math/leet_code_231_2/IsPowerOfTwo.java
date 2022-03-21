package math.leet_code_231_2;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/22 21:55
 * @Url :https://leetcode-cn.com/problems/power-of-two/
 * @Level :  easy
 * @Desc : 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }
}
