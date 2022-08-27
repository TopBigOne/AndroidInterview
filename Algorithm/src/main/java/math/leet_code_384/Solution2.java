package math.leet_code_384;

import java.util.Random;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/27 12:13
 * @Desc :
 */
public class Solution2 {
    public Solution2(int[] nums) {
        this.nums = nums;
        this.random = new Random();

    }

    private int[] nums;
    private final Random random;

    public int[] reset() {
        return nums;
    }

    private void swap(int[] clone, int randomIndex, int end) {
        int temp = clone[randomIndex];
        clone[randomIndex] = clone[end];
        clone[end] = temp;
    }

    public int[] shuffle() {
        int[] clone = nums.clone();
        int len = clone.length;
        for (int end = len - 1; end >= 0; end--) {
            int randomIndex = random.nextInt(end + 1);
            swap(clone, randomIndex, end);
        }
        return clone;

    }
}
