package sliding_window.leet_code_209;

/**
 * @author : dev
 * @version :
 * @Date :  7/27/21 12:49 AM
 * @Desc :
 * <p>
 * 题解：https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-hua-d-kb06/
 * <p>
 * <p>
 * <p>
 * 数组力扣题目总结
 * 按照如下顺序刷力扣上的题目，相信会帮你快速掌握各类数组题目。以下每道题目在力扣题解区都有「代码随想录」的题解。
 * <p>
 * 数组过于简单，但你该了解这些！
 * 704.二分查找
 * 27.移除元素.md
 * 977.有序数组的平方
 * 209.长度最小的子数组
 * 59.螺旋矩阵II
 * 数组总结篇
 */
public class MinSubArrayLen2 {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int length = nums.length;
        for (int right = 0; right < length; right++) {
            sum += nums[right];
            while (sum >= s) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }




}
