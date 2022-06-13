package math.offer_64;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/13 12:58
 * @Desc : 剑指 Offer 64. 求1+2+…+n ：https://leetcode.cn/problems/qiu-12n-lcof/
 *
 * 题解：https://leetcode.cn/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
 */
public class SumNums {

    int res;

    public int sumNums(int n) {
        boolean temp = n > 1 && sumNums(n - 1) > 0;
        res += n;

        return res;

    }
}
