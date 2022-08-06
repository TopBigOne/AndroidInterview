package sliding_window.leet_code_209;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/6 15:14
 * @Desc : 和为sum，最短数组的长度
 */
public class MinSubArrayLen3 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;
        int result = Integer.MAX_VALUE;

        while (right < len) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }
}
