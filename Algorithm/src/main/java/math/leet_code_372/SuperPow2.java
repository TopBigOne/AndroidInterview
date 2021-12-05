package math.leet_code_372;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/5 23:39
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter : 3
 * @Answer :
 */
public class SuperPow2 {

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

    private int qpow2(int a, int b) {
        int ans = 1;
        a %= mod;
        while (b != 0) {
            //  奇数
            if ((b & 1) != 0) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
            b >>>= 1;
        }
        return ans;
    }

    private int grow3(int a, int b) {
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
