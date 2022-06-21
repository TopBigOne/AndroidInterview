package dp.sub_sequence.leet_code_674;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/22 23:12
 * @Url : https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 * @Level :  easy
 * @Desc : 最长连续递增 子序列
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/solution/hua-jie-suan-fa-674-zui-chang-lian-xu-di-zeng-xu-l/
 */
public class FindLengthOfLCIS {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        int count = 1;
        int res = 1;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(count, res);
        }
        return res;
    }

    public int findLengthOfLCIS2(int[] nums) {
        int len = nums.length;
        int count = 1;
        int res = 1;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                // 只要发现了不相等，就回归为0；
                count = 1;
            }
            res = Math.max(res, count);

        }
        return res;

    }

    public int findLengthOfLCIS3(int[] nums) {
        int len = nums.length;
        int count = 1;
        int res = 1;
        for (int i = 0; i < len - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                count++;
            } else {
                count = 1;
            }
            res = Math.max(res, count);

        }
        return res;

    }
}
