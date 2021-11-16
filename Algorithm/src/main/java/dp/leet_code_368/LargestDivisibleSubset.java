package dp.leet_code_368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/14 21:38
 * @Url : https://leetcode-cn.com/problems/largest-divisible-subset/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 * 题解：https://leetcode-cn.com/problems/largest-divisible-subset/solution/shu-ju-jie-gou-he-suan-fa-dong-tai-gui-h-59wq/
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // 1: 先对数组排序
        Arrays.sort(nums);
        int length = nums.length;
        int[] dp = new int[length];
        int[] prev = new int[length];
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        // 记录最大整除子集的长度
        int max = 1;
        // 记录最整除子集中最后一个元素的位置
        int maxIndex = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                // 这里大括号我们改为求余
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    // 说明nums[i] 可以放到nums[j] 后面构成一个更长的整数子集,
                    // 也就[...,...,...,nums[j],nums[i]]，
                    // 注意dp[i] 记录的整除子集中，
                    // nums[i] 一定是数组的最后一个元素，我们用prev[i]来记录
                    // 这个子集中，nums[i] 前一个元素的位置，也就是num[j]的位置
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // 如果找到更大的子集，就记录最大的即可
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }

        // 把找到的最大整除子集加到list中，prev 和类似链表，每一个都记录前一个位置
        List<Integer> res = new ArrayList<>();
        while (maxIndex != -1) {
            res.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }
        return res;


    }
}
