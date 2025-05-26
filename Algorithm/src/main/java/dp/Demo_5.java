package dp;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/11/22 22:57
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */ 
public class Demo_5 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 1, 7, 8, 3};
        Demo_5 demo_5 = new Demo_5();
        int result = demo_5.calculateMaxSub(nums);
        System.err.println("result :" + result );

    }

    public int calculateMaxSub(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        int result = 0;
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            result = Math.max(result, dp[i]);

        }
        return result;
    }
}
