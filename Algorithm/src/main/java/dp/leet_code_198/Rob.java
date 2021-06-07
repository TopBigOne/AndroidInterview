package dp.leet_code_198;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/7 20:26
 * @Url : https://leetcode-cn.com/problems/house-robber/
 * @Level : easy medium hard
 * @Desc : leetcode 198: 打家劫舍
 * @Counter : 30
 * @Answer :
 * 1: 甜姨：https://leetcode-cn.com/problems/house-robber/solution/liang-ge-yue-0ji-chu-cong-an-mo-shi-zhuan-xing-zi-/
 */
public class Rob {

    public static void main(String[] args) {
        Rob rob = new Rob();
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int result = rob.rob(nums);

        System.out.println("result : " + result);
    }

    public int rob(int[] nums) {
        int len = nums.length;
        // base corner
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        // 当前结果，由上一个结果决定的；
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[len - 1];

    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return len;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            // 状态转移方程
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public  int rob3(int [] nums){
        int length = nums.length;
        if (length==0) {
            return 0;
        }
        if (length==1) {
            return nums[0];
        }
        int [] dp =new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<length;i++){
            dp[i] =  Math.max(nums[i]+dp[i-2],dp[i-1]);
        }

        return  dp[length-1];
    }

}
