package tan_xin.leet_code_376;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/11/16 23:26
 * @Url : https://leetcode.cn/problems/wiggle-subsequence/solutions/?orderBy=most_votes
 * @Level :    medium
 * @Desc :  摆动序列：
 * @Counter :
 * @Answer : 动态规划的解法
 * 题解：https://www.youtube.com/watch?v=eOVP7fudeNg
 *
 */
public class WiggleMaxLength2 {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        int[] down = new int[length];
        int[] up = new int[length];
        down[0] = 1;
        up[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int preValue = nums[i - 1];
            int currValue = nums[i];

            // case 1:
            if (currValue > preValue) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
                continue;
            }
            // case 2:
            if (currValue < preValue) {
                down[i] = up[i - 1] + 1;
                up[i] = up[i - 1];
                continue;
            }
            // case 3:
            if (currValue == preValue) {
                down[i] = down[i - 1];
                up[i] = up[i - 1];
            }

        }
        return Math.max(down[length - 1], up[length - 1]);


    }
}
