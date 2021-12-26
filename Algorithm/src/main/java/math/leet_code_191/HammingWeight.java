package math.leet_code_191;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/22 22:05
 * @Url : https://leetcode-cn.com/problems/number-of-1-bits/
 * @Level :  easy
 * @Desc :  1的个数
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/number-of-1-bits/solution/fu-xue-ming-zhu-xiang-jie-wei-yun-suan-f-ci7i/
 */
public class HammingWeight {
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1);

            n >>>= 1;
        }
        return ans;
    }


    public int hammingWeight2(int n) {
        int ans = 0;
        while (n != 0) {
            // n & 1 消除二进制长串中，最后一个位置的1
            ans += (n & 1);
            n >>>= 1;
        }
        return ans;


    }
}
