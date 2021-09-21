package stack.single_invoke_stack.leet_code_321;


/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/21 18:38
 * @Url : 拼接最大数（https://leetcode-cn.com/problems/create-maximum-number/）
 * @Level :     hard
 * @Desc :  拼接最大数：给定长度分别为m和n的两个数组，其元素由0-9构成，表示两个自然数各位上的数字。
 * 现在从这两个数组中选出 k (k <= m + n)个数字拼接成一个新的数
 * ，要求从同一个数组中取出的数字保持其在原数组中的相对顺序。
 * <p>
 * 求满足该条件的最大数。结果返回一个表示该最大数的长度为k的数组
 * @Counter : 5
 * @Answer :  https://leetcode-cn.com/problems/create-maximum-number/solution/yi-zhao-chi-bian-li-kou-si-dao-ti-ma-ma-zai-ye-b-7/
 * <p>
 * 316. 去除重复字母（困难）
 * 321. 拼接最大数（困难）
 * 402. 移掉 K 位数字（中等）
 * 1081. 不同字符的最小子序列（中等）
 * 402. 移掉 K 位数字（中等）
 */
public class MaxNumber {

    /**
     * https://leetcode-cn.com/problems/create-maximum-number/solution/java-dan-diao-zhan-si-xiang-by-lil-q/
     *
     * @param num1
     * @param num2
     * @param k
     * @return
     */
    public int[] maxNumber(int[] num1, int[] num2, int k) {
        int[] res = new int[0];

        for (int i = 0; i <= k && i <= num1.length; i++) {
            if (k - i >= 0 && k - i <= num2.length) {
                // merge
                int[] tmp = merge(subMaxNumber(num1, i), subMaxNumber(num2, k - i));
                // 取最大值
                if (compare(tmp, 0, res, 0)) {
                    res = tmp;
                }
            }
        }
        return res;
    }

    public int[] subMaxNumber(int[] nums, int len) {
        int[] subNums = new int[len];
        int cur = 0;
        // rem 表示可以删除多少字符
        int rem = nums.length - len;
        for (int i = 0; i < nums.length; i++) {
            while (cur > 0 && subNums[cur - 1] < nums[i] && rem > 0) {
                cur--;
                rem--;
            }
            if (cur < len) {
                subNums[cur++] = nums[i];
            } else {
                // 避免超过边界而少删字符
                rem--;
            }
        }
        return subNums;
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int sumLen = len1 + len2;
        int[] res = new int[sumLen];
        int cur = 0;
        int p1 = 0;
        int p2 = 0;
        while (cur < sumLen) {
            if (compare(nums1, p1, nums2, p2)) {
                res[cur++] = nums1[p1++];
                continue;
            }
            res[cur++] = nums2[p2++];
        }

        return res;
    }

    public boolean compare(int[] nums1, int p1, int[] nums2, int p2) {
        if (p2 >= nums2.length) return true;
        if (p1 >= nums1.length) return false;

        if (nums1[p1] > nums2[p2]) return true;
        if (nums1[p1] < nums2[p2]) return false;
        return compare(nums1, p1 + 1, nums2, p2 + 1);
    }


}
