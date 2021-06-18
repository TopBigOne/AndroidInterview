package array.jump.leet_code_55;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/17 21:40
 * @Url : https://leetcode-cn.com/problems/jump-game/
 * @Level :  medium
 * @Desc : 跳跃游戏
 * @Counter : 15
 * @Answer : https://leetcode-cn.com/problems/jump-game/solution/55-by-ikaruga/
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
    }

    public boolean canJump(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return false;
        }
        int k = 0;
        for (int i = 0; i <= k; i++) {
            int temp = i + nums[i];
            // 更新更远距离
            k = Math.max(k, temp);
            // 如果最远距离已经大于或者等于一个元素的下标，则说明能跳过去，退出，减少循环
            if (k >= length - 1) {
                return true;
            }
        }
        // 最远距离k不再改变，且没有尾部元素
        return false;
    }


}
