package array.leet_code_41;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/15 21:26
 * @Url :https://www.youtube.com/watch?v=jfb72FfxWKU
 * @Level :    hard
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 * https://www.youtube.com/watch?v=jfb72FfxWKU
 * <p>
 * nums[nums[i]-1]!=nums[i]
 */
public class FirstMissingPositive2 {
    public int firstMissingPositive(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 1;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);

            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }

        }

        return len + 1;


    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
