package math.appear_n_time.leet_code_136;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 19:01
 * @Desc : https://leetcode.cn/problems/single-number/
 *
 * 和leetcode 56 题有点类似
 *
 *
 */
public class SingleNumber2 {
    /**
     * 使用位运算
     * https://leetcode.cn/problems/single-number/solution/cou-yi-pian-ti-jie-hua-shuo-ti-jie-hen-hao-wan-by-/
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int num : nums) {
            res = res ^ num;
        }
        return res;

    }
}
