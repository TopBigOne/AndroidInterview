package math.leet_code_1141;

/**
 * @author : dev
 * @version :
 * @Date :  7/29/21 12:44 AM
 * @Desc : leet code 1411 : 给 给 N x 3 网格图涂色的方案数 https://leetcode-cn.com/problems/number-of-ways-to-paint-n-3-grid/
 * <p>
 * 题解：https://leetcode-cn.com/problems/number-of-ways-to-paint-n-3-grid/solution/shu-xue-jie-jue-fei-chang-kuai-le-by-lindsaywong/
 */
public class NumOfWays {
    private static final int mod = 1000000007;

    public int numOfWays(int n) {
        if (n == 0) {
            return 0;
        }
        // 题目要求
        int mod = 1000000007;
        // 每层可以涂色 ABAA 和 ABC 两类
        long ABA = 6;
        long ABC = 6;

        for (int i = 2; i <= n; i++) {
            // 本层的每个 ABA 类--> 下层演化为 3 个 ABA + 2ABA
            // 本层的每个 ABC 类--> 下层演化为 2 个 ABA+2 个 ABC
            ABC = 2 * (ABA + ABC) % mod;
            ABA = (ABA + ABC) % mod;
        }
        return (int) ((ABA + ABC) % mod);


    }


    public int numOfWays2(int n) {
        if (n == 0) {
            return 0;
        }
        //每层的涂色可以分成ABA和ABC两类
        long ABA = 6;
        long ABC = 6;
        for (int i = 2; i <= n; i++) {
            //本层的每个ABA类 -> 下层演化为3个ABA+2个ABC
            //本层的每个ABC类 -> 下层演化为2个ABA+2个ABC
            ABC = 2 * (ABA + ABC) % mod;
            ABA = (ABC + ABA) % mod;
        }
        return (int) ((ABA + ABC) % mod);
    }

    public int numOfWays3(int n) {
        if (n == 0) {
            return 0;
        }

        int mod = 1000000007;
        long aba = 6;
        long abc = 6;
        for (int i = 2; i <= n; i++) {
            abc = 2 * (aba + abc) % mod;
            aba = (aba + abc) % mod;
        }

        return (int) ((abc + aba) % mod);

    }

}
