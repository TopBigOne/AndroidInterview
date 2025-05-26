package math.leet_code_1004;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/10/27 20:44
 * @Url : https://leetcode.cn/problems/max-consecutive-ones-iii/description/
 * @Level :  easy
 * @Desc : 给定一个二进制数组 nums 和一个整数 k，如果可以翻转最多 k 个 0 ，则返回 数组中连续 1 的最大个数 。
 * @Counter :
 * @Answer :https://leetcode.cn/problems/max-consecutive-ones-iii/solutions/609055/fen-xiang-hua-dong-chuang-kou-mo-ban-mia-f76z/?orderBy=most_votes
 * <p>
 * 输入：nums = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：[1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * --------
 * 重点：题意转换。把「最多可以把 K 个 0 变成 1，求仅包含 1 的最长子数组的长度」
 * 转换为 「找出一个最长的子数组，该子数组内最多允许有 K 个 0 」。
 */
public class LongestOnes {
    public int longestOnes(int[] nums, int k) {
        int length = nums.length;
        int res = 0;
        int left = 0, right = 0;

        int zeros = 0;
        while (right < length) {
            if (nums[right] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[left++] == 0)
                    zeros--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;

    }

    public int longestOnes2(int[] nums, int k) {
        int length = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        while (right < length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left++] == 0) {
                    zeros--;

                }
            }
            res = Math.max(res, right - left + 1);
            right++;

        }
        return res;


    }
}
