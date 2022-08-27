package math.leet_code_384;

import java.util.Random;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/27 12:25
 * @Desc :
 */
public class Solution3 {

    public int[] nums;
    public Random random;

    public Solution3(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

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
        int len = nums.length - 1;
        for (int end = len; end >= 0; end--) {
            int randomIndex = random.nextInt(end + 1);
            swap(clone, randomIndex, end);
        }
        return clone;
    }


}
