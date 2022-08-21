package dp.back_to_origin;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/21 16:07
 * @Desc :   圆环回原点: https://www.nowcoder.com/questionTerminal/16409dd00ab24a408ddd0c46e49ddcf8?answerType=1&f=discussion
 * 圆环上有 10 个点，编号 0~9 。从 0 出发，每次可以顺时针或逆时针走一格，请问一共走且仅走 n 步回到原点的方法有多少种。
 * <p>
 * 由于答案可能会非常大，所以请对答案对  取模
 * <p>
 * ----
 * <p>
 * 0-12共13个数构成一个环，从0出发，每次走1步，走n步回到0共有多少种走法（2020.09 字节跳动-广告-后端）[1]
 * 0-8组成一个圆环，从0出发，每次可以逆时针和顺时针走，走n步能回到0有多少种情况（2020.09 字节跳动-people-后端）[2]
 * 0~9的环，从0出发，N步后能否走回0。（2020.07 字节跳动-电商-后端）[3]
 * 圆环回原点问题 (2020.08 字节跳动-飞书-后端)[4]
 */
public class BackToOrigin {

    public int backToOrigin(int n) {
        int[][] dp = new int[n + 1][10];
        dp[0][0] = 1;
        int mod = 1000000007;
        int k = 10;  //圆环上有10个点，编号为[0,9]

        //dp[i][j] = dp[i-1][j-1] (i-1步走到j左边的方法数) + dp[i-1][j+1](i-1步走到j右边的方法数）
        //
        //注意： 上边为了方便理解，没有处理j-1和j+1的越界问题，在下边代码中体现
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + k) % k] + dp[i - 1][(j + 1) % k];
                dp[i][j] %= mod;
            }
        }
        return dp[n][0];
    }

    public int backToOrigi2n(int n) {
        int[][] dp = new int[n + 1][10];
        dp[0][0] = 1;
        int mod = 1000000007;
        int k = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + k) % 10] + dp[i - 1][(j + 1) % k];
                dp[i][j] %= mod;

            }
        }
        return dp[n][0];
    }
}
