package interval.leet_code_495;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/10 05:40
 * @Desc :  495. 提莫攻击：  https://leetcode.cn/problems/teemo-attacking/
 * 视频题解：https://leetcode.cn/problems/teemo-attacking/solution/xiao-song-man-bu-fen-liang-chong-qing-ku-v292/
 * <p>
 * https://leetcode.cn/problems/teemo-attacking/solution/fu-xue-ming-zhu-tu-jie-suan-fa-lei-jia-s-g3st/
 */
public class FindPoisonedDuration {
    public static void main(String[] args) {
        int[] timeSeries = {1, 2, 3, 4, 5};
        int duration = 5;
        FindPoisonedDuration findPoisonedDuration = new FindPoisonedDuration();
        int result = findPoisonedDuration.findPoisonedDuration(timeSeries, duration);
        System.err.println("result : " + result);
    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int count = 0;
        // 当前被攻击的持续时间
        int currAttackInterval = timeSeries[0] + duration - 1;
        int len = timeSeries.length;

        for (int i = 1; i < len; i++) {
            // 没有覆盖，在中毒之后，才出现新的攻击
            if (timeSeries[i] > currAttackInterval) {
                count += duration;
                currAttackInterval = timeSeries[i] + duration - 1;
                continue;

            }
            // 在中毒时候，又被攻击了；
            // case 1: 更新被攻击的持续时间
            currAttackInterval = timeSeries[i] + duration - 1;
            // 去掉重置的中毒时间，然后做累加
            count += timeSeries[i] - timeSeries[i - 1];
        }
        // 因为我们统计的是上次「中毒」维持的时间，不要忘记最后一次中毒将维持 duration秒。所以在遍历结束的时候，结果需要加上 duration。
        // 是不是有点像 dp[i]？
        count += duration;
        return count;
    }


}
