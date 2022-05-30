package array.leet_code_136;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 19:01
 * @Desc : https://leetcode.cn/problems/single-number/
 */
public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int num : nums) {
            res = res ^ num;
        }
        return res;

    }
}
