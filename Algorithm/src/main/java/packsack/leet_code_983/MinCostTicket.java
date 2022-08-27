package packsack.leet_code_983;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/25 02:59
 * @Desc :
 * <p>
 * 这个题解的思路，还是不错的；
 * 题解：https://www.bilibili.com/video/BV1st4y11736?spm_id_from=333.337.search-card.all.click&vd_source=48ebba24d97534cb7fc891ea4972fffa
 * <p>
 * <p>
 * <p>
 * * dp[i] 完成第天和之前的旅行，所花的最少费用
 * * base case : dp[0] = 0 : 完成第0天的旅行，所需的最少费用为0；
 * * induction rule:
 * * 如果当前遍历到这天不旅游，则： dp[i] = dp[i-1];
 * * 反之，这天能旅游，支付这天的费用有三种选择
 * * 1.dp[i-1]+costs[0]
 * * 2.dp[i-7]+costs[1]
 * * 3.dp[i-30]+costs[2]
 * <p>
 * 这个代码题解：https://leetcode.cn/problems/minimum-cost-for-tickets/solution/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/
 */
public class MinCostTicket {
    public int mincostTickets(int[] days, int[] costs) {
        int len = days.length;
        int minDay = days[0];
        int maxDay = days[len - 1];
        int[] dp = new int[maxDay + 31];
        // days 倒序遍历
        int index = len - 1;

        for (int currDay = maxDay; currDay >= minDay; currDay--) {
            if (currDay != days[index]) {
                dp[currDay] = dp[currDay - 1];
                continue;
            }
            int a = dp[currDay + 1] + costs[0];
            int b = dp[currDay + 7] + costs[1];
            int c = dp[currDay + 30] + costs[2];
            dp[currDay] = Math.min(a, Math.min(b, c));
            index--;

        }
        return dp[minDay];
    }
}
