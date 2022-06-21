package dp.sub_sequence.leet_code_300;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/21 21:33
 * @Desc :最长递增子序列
 * https://leetcode.cn/problems/longest-increasing-subsequence/
 * <p>
 * https://leetcode.cn/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-dong-tai-gui-hua-2/
 */
public class LengthOfLIS7 {
    int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0;
            int r = res;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (tails[mid] < num) {
                    l = mid + 1;

                } else {
                    r = mid;
                }
            }

            tails[l] = num;
            if (res == l) {
                res++;
            }
        }
        return res;
    }

    int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0;
            int r = res;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (tails[mid] < num) {
                    // 不断的累加
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }

            tails[l] = num;
            if (res == l) {
                res++;
            }
        }
        return res;
    }

    int lengthOfLIS3(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0;
            int j = res;
            while (i < j) {
                int mid = (i + j) >>> 1;
                if (tails[mid] < num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (res == i) {
                res++;
            }
        }
        return res;

    }

    int lengthOfLIS4(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int l = 0;
            int r = res;
            while (l < r) {
                int mid = (l + r) >>> 1;
                if (tails[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            tails[l] = num;
            if (l == res) {
                res++;
            }
        }
        return res;

    }
}
