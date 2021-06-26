package sliding_window.leet_code_718;

/**
 * @author : dev
 * @version :
 * @Date :  6/21/21 10:01 PM
 * * @Desc : leetcode 718 :  字节 9 次： 最长无重复子数组：https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * <p>
 * <p>
 * 题解： 滑动窗口
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/wu-li-jie-fa-by-stg-2/
 */
public class FindLength {

    /**
     * 好算法，我一点没有理解；
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        return A.length < B.length ? findMax(A, B) : findMax(B, A);
    }

    private int findMax(int[] A, int[] B) {
        int max = 0;
        int an = A.length;
        int bn = B.length;
        for (int len = 0; len < an; len++) {
            max = Math.max(max, maxLen(A, 0, B, bn - len, len));
        }

        for (int j = bn - an; j >= 0; j--) {
            max = Math.max(max, maxLen(A, 0, B, j, an));
        }

        for (int i = 1; i < an; i++) {
            max = Math.max(max, maxLen(A, i, B, 0, an - i));
        }

        return max;
    }

    private int maxLen(int[] a, int i, int[] b, int j, int len) {
        int count = 0;
        int max = 0;
        for (int k = 0; k < len; k++) {
            if (a[i + k] == b[j + k]) {
                count++;
                continue;
            }
            if (count > 0) {
                max = Math.max(max, count);
            }
        }

        return count > 0 ? Math.max(max, count) : max;
    }
}
