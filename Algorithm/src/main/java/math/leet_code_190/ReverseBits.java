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

        // 0000 0010 1001 0100 0001 1110 1001 1100
        // 0011 1001 0111 1000 0010 1001 0100 0000

    }

    public int reverseBits2(int n) {
        int res = 0;
        int count = 32;
        while (count-- > 0) {
            res <<= 1;
            res += (n & 1);
            n >>>= 1;
        }
        return res;
    }

    public int reverseBits3(int n) {
        int res = 0;
        int count = 32;
        //  题意说了：32位
        while (count-- > 0) {
            // 左移一位，给末尾腾出一个bit位  00001<<1 ===> 0010
            res <<= 1;
            // 末尾做累加操作
            res+= (n&1);
            // 右移一位
            n>>>=1;
        }
        return res;

    }
}
