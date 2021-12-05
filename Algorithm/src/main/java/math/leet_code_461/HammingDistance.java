package math.leet_code_461;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/3 22:43
 * @Url :
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : 题解：https://leetcode-cn.com/problems/hamming-distance/solution/gong-shui-san-xie-tong-ji-liang-shu-er-j-987a/
 */
public class HammingDistance {
    /**
     * 一行代码的解法
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 树状数组，low bit可以快速求得x 二进制表示中 最低位1表示的值,
     * 因此我们可以先将x和y进行异或，再统计异或结果中1的个数；
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance2(int x, int y) {
        int ans = 0;
        for (int i = x ^ y; i > 0; i -= lowBit(i)) {
            ans++;
        }
        return ans;
    }

    int lowBit(int x) {

        return x & -x;
    }

    /***
     * 右移统计：
     * 每次统计当前x和y的最后一位，统计完则将x和y右移一位。
     * 当x和y 的最高一位1 都被统计过之后，循环结束
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance3(int x, int y) {
        int ans = 0;
        while ((x | y) != 0) {
            int a = x & 1;
            int b = y & 1;
            ans += a ^ b;
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }

    /**
     * 逐位比较
     * 本身不改变x和y，每次取不同的偏移位进行比较，不同则加1；
     * 循环固定取满32；
     * int 有32 位
     *
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance4(int x, int y) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int a = (x >> i) & 1;
            int b = (y >> i) & 1;
            ans += a ^ b;
        }
        return ans;


    }

}
