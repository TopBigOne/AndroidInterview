package math.leet_code_372;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/5 23:28
 * @Url :https://leetcode-cn.com/problems/super-pow/
 * @Level :  easy  medium hard
 * @Desc : 你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/super-pow/solution/gong-shui-san-xie-di-gui-kuai-su-mi-ying-yx1j/
 */
public class SuperPow {
    int mod = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }
    private int dfs(int a, int[] b, int u) {
        if (u == -1) {
            return 1;
        }
        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % mod;
    }

    private int qpow(int a, int b) {
        int ans = 1;
        a %= mod;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = ans * a % mod;
            }

            a = a * a % mod;
            b >>>= 1;
        }
        return ans;

    }
}
