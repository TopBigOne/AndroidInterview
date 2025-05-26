package sliding_window.leet_code_413;

/**
 * @author : 周广亚
 * @version :
 * @Date :  2022/11/12 22:31
 * @Desc : 413. 等差数列划分
 * <p>
 * https://leetcode.cn/problems/arithmetic-slices/description/
 * <p>
 * 题解：https://leetcode.cn/problems/arithmetic-slices/solutions/927325/hua-dong-chuang-kou-dong-tai-gui-hua-jav-3vpp/?orderBy=most_votes
 */
public class NumberOfArithmeticSlice {
    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        int len = nums.length;
        if (len < 3) {
            return res;
        }

        int preDiff = nums[1] - nums[0];
        int coreLength = 2;
        for (int i = 2; i < len; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff == preDiff) {
                coreLength++;
                continue;
            }
            // 累加加过
            res += (coreLength - 1) * (coreLength - 2) / 2;
            // 重置L 和preDiff;
            coreLength = 2;
            preDiff = diff;
        }
        res += (coreLength - 1) * (coreLength - 2) / 2;
        return res;

    }
}
