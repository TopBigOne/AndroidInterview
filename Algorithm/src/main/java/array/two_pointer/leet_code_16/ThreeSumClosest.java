package array.two_pointer.leet_code_16;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.swing.text.html.HTMLWriter;

import sun.security.provider.Sun;

/**
 * @author : dev
 * @version :
 * @Date :  9/28/21 7:03 PM
 * @Desc : 最接近的三数之和
 * <p>
 * https://leetcode-cn.com/problems/3sum-closest/
 * <p>
 * 字节：9；
 * <p>
 * 题解：https://leetcode-cn.com/problems/3sum-closest/solution/hua-jie-suan-fa-16-zui-jie-jin-de-san-shu-zhi-he-b/
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        // 1： do sort
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int start = i + 1;
            int end = len - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }

            }
        }
        return ans;

    }
}
