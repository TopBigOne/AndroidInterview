package dp.rob.leet_code_198;

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
 * <p>
 * https://leetcode-cn.com/problems/house-robber/solution/dong-tai-gui-hua-jie-ti-si-bu-zou-xiang-jie-cjavap/
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

    public int rob3(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[length - 1];
    }

    /**
     * 将空间复杂度，由O(n) 优化到了O(1)
     *
     * @param nums
     * @return
     */
    public int rob4(int[] nums) {
        // preDay 表示：dp[k-2]
        int preDay = 0;
        // currDay 表示dp[k-1]
        int currDay = 0;
        //  每次循环，计算"偷到当前房子为止的最大金额"
        for (int num : nums) {
            // 循环开始：currDay 表示dp[k-1],preDay 表示：dp[k-2]
            int temp = Math.max(currDay, preDay + num);
            preDay = currDay;
            currDay = temp;
            // 循环结束时，curr 表示dp[k],pre 表示dp[k-1]
        }
        return currDay;
    }

    public int rob5(int[] nums) {
        int pre = 0;
        int cur = 0;
        for (int num : nums) {
            int temp = Math.max(cur, pre + num);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public int rob6(int[] nums) {
        // 当一家的金额
        int pre = 0;
        // 当前的金额
        int cur = 0;
        for (int num : nums) {
            // pre + num ：站在中间视角，算一下偷上一家和下一家加一起来，
            // 有没有现在偷的多......
            int temp = Math.max(cur, pre + num);
            pre = cur;
            cur = temp;
            System.out.println("pre : " + pre);
            System.out.println("cur : " + cur);
            System.out.println("------------------");
        }

        return cur;
    }

    public int rob67(int[] nums) {
        int pre = 0;
        int cur = 0;
        for (int num : nums) {
            int temp = Math.max(cur, pre + num);
            pre = cur;
            cur = temp;
        }

        return cur;

    }

    public int rob68(int[] nums) {
        int preValue = 0;
        int currValue = 0;
        for (int num : nums) {
            int temp = Math.max(currValue,preValue+num);
            preValue = currValue;
            currValue = temp;
        }

        return currValue;

    }


}
