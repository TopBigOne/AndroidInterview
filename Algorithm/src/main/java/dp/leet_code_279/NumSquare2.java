package dp.leet_code_279;

import java.util.HashMap;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/28 18:32
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/perfect-squares/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--51/
 */
public class NumSquare2 {

    public int numSquares(int n) {
        // 需要 memoization 技术，也就是把过程中的解利用 HashMap 全部保存起来即可。
        return numSquaresHelper(n, new HashMap<Integer, Integer>());
    }


    /**
     * n 减去1，然后求剩下的数分解成平方和所需的最小个数；
     * 这样做，会超时，但是，我们借鉴的是思想；
     *
     * @param n
     * @return
     */
    private int numSquaresHelper(int n) {
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresHelper(n - i * i) + 1);
        }
        return count;

    }

    private int numSquaresHelper(int n, HashMap<Integer, Integer> map) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            count = Math.min(count, numSquaresHelper(n - i * i, map) + 1);
        }
        map.put(n, count);

        return count;
    }
}
