package math.leet_code_384;

import java.util.Random;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/26 22:47
 * @Desc :   leetcode: 384. 打乱数组 ： https://leetcode.cn/problems/shuffle-an-array/
 */
public class Solution {
    int[] nums;
    private final Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        int[] clone = nums.clone();
        for (int end = nums.length - 1; end >= 0; end--) {
            int randIndex = random.nextInt(end + 1);
            swap(clone, randIndex, end);
        }
        return clone;
    }

    private void swap(int[] clone, int randIndex, int end) {
        int temp = clone[randIndex];
        clone[randIndex] = clone[end];
        clone[end] = temp;
    }
}
