package dp.leet_code_1449;

/**
 * @author : dev
 * @version :
 * @Date :  2/8/21 11:05 PM
 * @Desc :
 * https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
 * <p>
 * 给你一个整数数组 cost 和一个整数 target 。请你返回满足如下规则可以得到的 最大 整数：
 * <p>
 * 给当前结果添加一个数位（i + 1）的成本为 cost[i] （cost 数组下标从 0 开始）。
 * 总成本必须恰好等于 target 。
 * 添加的数位中没有数字 0 。
 * 由于答案可能会很大，请你以字符串形式返回。
 * <p>
 * 如果按照上述要求无法得到任何整数，请你返回 "0" 。
 * <p>
 * 示例 1：
 * 输入：cost = [4,3,2,5,6,7,2,5,5], target = 9
 * 输出："7772"
 * 解释：添加数位 '7' 的成本为 2 ，添加数位 '2' 的成本为 3 。所以 "7772" 的代价为 2*3+ 3*1 = 9 。 "977" 也是满足要求的数字，但 "7772" 是较大的数字。
 * 数字    成本
 * 1  ->   4
 * 2  ->   3
 * 3  ->   2
 * 4  ->   5
 * 5  ->   6
 * 6  ->   7
 * 7  ->   2
 * 8  ->   5
 * 9  ->   5
 * <p>
 * https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/solution/xiang-xi-jiang-jie-wan-quan-bei-bao-zhuang-tai-de-/
 */

public class LargestNumber {
    private String maxStr(String lhs, String rhs) {
        if (lhs.length() > rhs.length()) {
            return lhs;
        } else if (rhs.length() > lhs.length()) {
            return rhs;
        } else if (rhs.length() == lhs.length()) {
            return lhs;
        } else {
            return rhs;
        }
    }

    public String largestNumber(int[] c, int target) {
        int[] cost = new int[9 + 5];
        String[][] dp = new String[9 + 5][5000 + 5];
        int length = c.length;
        System.arraycopy(c, 0, cost, 1, length);

        for (int j = 0; j <= target; j++) {
            dp[0][j] = "#";
        }
        dp[0][0] = "";

        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= target; j++) {
                String a, b = "";
                a = dp[i - 1][j];
                if (j - cost[i] >= 0 &&
                        !"#".equals(dp[i][j - cost[i]])) {
                    b = i + dp[i][j - cost[j]];
                }
                dp[i][j] = maxStr(a, b);

            }

        }
        if ("#".equals(dp[9][target])) {
            return "0";
        }

        return dp[9][target];


    }


}
