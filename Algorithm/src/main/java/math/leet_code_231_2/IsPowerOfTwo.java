package math.leet_code_231_2;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/22 21:55
 * @Url :https://leetcode-cn.com/problems/power-of-two/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/power-of-two/solution/power-of-two-er-jin-zhi-ji-jian-by-jyd/
 */
public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
