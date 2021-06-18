package array.jump.leet_code_45;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/18 21:42
 * @Url : https://leetcode-cn.com/problems/jump-game-ii/
 * @Level :  medium
 * @Desc : 跳跃游戏2
 * @Counter : 12
 * @Answer : https://leetcode-cn.com/problems/jump-game-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-10/
 */
public class Jump {
    public int jump(int[] nums) {
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 找到能跳到最远的
            maxPosition = Math.max(maxPosition, nums[i] + i);
            // 遇到边界，就更新边界，并且步数加一
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
