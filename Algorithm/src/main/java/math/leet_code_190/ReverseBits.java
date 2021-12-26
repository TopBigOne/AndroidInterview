package math.leet_code_190;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/23 21:23
 * @Url : https://leetcode-cn.com/problems/reverse-bits/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/reverse-bits/solution/yi-ti-san-jie-dui-cheng-wei-zhu-wei-fen-ub1hi/
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int ans = 0;
        int cnt = 32;
        while (cnt-- > 0) {
            ans <<= 1;
            ans += (n & 1);
            n >>= 1;
        }
        return ans;



    }
}
