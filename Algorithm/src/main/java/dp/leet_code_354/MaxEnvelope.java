package dp.leet_code_354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/15 22:50
 * @Url : https://leetcode-cn.com/problems/russian-doll-envelopes/
 * @Level : easy medium hard
 * @Desc : 俄罗斯套娃信封问题
 * @Counter : 13
 * @Answer : 题解：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/liang-ge-wei-du-de-zui-chang-di-zeng-zi-ctbmd/
 * 可以抽象成：
 * 题意：找出二维数组的一个排列，使得其中有最长的单调递增子序列（两个维度都递增）。
 * <p>
 * ------
 * 题解：https://leetcode-cn.com/problems/russian-doll-envelopes/solution/zui-chang-shang-sheng-zi-xu-lie-bian-xin-6s8d/
 */
public class MaxEnvelope {
    public int maxEnvelopes(int[][] es) {
        int n = es.length;
        if (n == 0) return n;
        // 因为我们在找第 i 件物品的前一件物品时，
        // 会对前面的 i - 1 件物品都遍历一遍，因此第二维（高度）排序与否都不影响
        Arrays.sort(es, Comparator.comparingInt(a -> a[0]));
        int[] f = new int[n]; // f(i) 为考虑前 i 个物品，并以第 i 个物品为结尾的最大值
        int ans = 1;
        for (int i = 0; i < n; i++) {
            // 对于每个 f[i] 都满足最小值为 1
            f[i] = 1;
            // 枚举第 i 件物品的前一件物品，
            for (int j = i - 1; j >= 0; j--) {
                // 只要有满足条件的前一件物品，我们就尝试使用 f[j] + 1 更新 f[i]
                if (check(es, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            // 在所有的 f[i] 中取 max 作为 ans
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    private boolean check(int[][] es, int mid, int i) {
        return es[mid][0] < es[i][0] && es[mid][1] < es[i][1];
    }

    public int maxEnvelopes2(int[][] es) {
        int length = es.length;
        if (length == 0) return length;
        // 因为我们在找第i件物品的前一件物品时，
        // 会对前面的i-1 件物品都遍历一遍，因此第二维（高度）是否排序，都不影响
        Arrays.sort(es, Comparator.comparingInt(value -> value[0]));

        // f(i)为考虑前i个物品，并以第i个物品为结尾的最大值
        int[] f = new int[length];
        int ans = 1;
        for (int i = 0; i < length; i++) {
            // 对于每个f[i]都满足最小值 为1；
            f[i] = 1;
            // 枚举第i件物品的前一件物品
            for (int j = i - 1; j >= 0; j--) {
                // 只要有满足条件的前一件物品，我们就尝试使用 f[j] + 1 更新f[i]
                if (check(es, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            // 在所有的f[i] 中取max 最大值作为f[i]
            ans = Math.max(ans, f[i]);

        }
        return ans;

    }

    public int maxEnvelopes3(int[][] es) {
        int length = es.length;
        if (length == 0) return length;
        // 1: 做排序
        Arrays.sort(es, Comparator.comparingInt(value -> value[0]));

        int[] f = new int[length];
        int ans = 1;
        for (int i = 0; i < length; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (check(es, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public int maxEnvelopes4(int[][] es) {
        int length = es.length;
        if (length == 0) {
            return length;
        }
        Arrays.sort(es, Comparator.comparingInt(value -> value[0]));

        int[] f = new int[length];
        int ans = 1;
        for (int i = 0; i < length; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (check(es, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public int maxEnvelopes5(int[][] es) {
        int length = es.length;
        if (length == 0) {
            return length;
        }
        Arrays.sort(es, Comparator.comparingInt(value -> value[0]));

        int[] f = new int[length];
        int ans = 1;
        for (int i = 0; i < length; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                // do a check
                if (check(es, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }

            ans = Math.max(f[i], ans);
        }
        return ans;
    }

    public int maxEnvelopes6(int[][] es) {
        int length = es.length;
        if (length == 0) {
            return length;
        }
        Arrays.sort(es, Comparator.comparingInt(a -> a[0]));
        int[] f = new int[length];
        int ans = 1;
        for (int i = 0; i < length; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                // do a check
                if (check(es, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public int maxEnvelopes7(int[][] es) {
        int length = es.length;
        if (length == 0) {
            return length;
        }
        Arrays.sort(es, Comparator.comparingInt(value -> value[0]));
        int[] f = new int[length];
        int ans = 1;
        for (int i = 0; i < length; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                // do check
                if (check(es, j, i)) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(f[i], ans);
        }
        return ans;
    }

    public int maxEnvelopes8(int[][] es) {
        int length = es.length;
        if (length == 0) {
            return length;
        }
        Arrays.sort(es, Comparator.comparingInt(value -> value[0]));
        int ans = 1;
        int[] f = new int[length];
        for (int i = 0; i < length; i++) {
            f[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                f[i] = Math.max(f[i], f[j] + 1);
            }
            ans = Math.max(f[i], ans);
        }
        return ans;
    }


}
