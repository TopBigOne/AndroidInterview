package math.appear_n_time.leet_code_136;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/6 14:32
 * @Desc :  136. 只出现一次的数字 https://leetcode-cn.com/problems/single-number/solution/
 */
public class SingleNumber3 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res^= nums[i];

        }
        return res;
    }
}
