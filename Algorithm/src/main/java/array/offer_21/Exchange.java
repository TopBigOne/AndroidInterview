package array.offer_21;


import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/4 17:33
 * @Desc :
 */
public class Exchange extends Base {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Exchange exchange = new Exchange();

        int[] result = exchange.exchange(nums);
        System.err.println("result : " + Arrays.toString(result));

    }

    public int[] exchange(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            int val = nums[fast];
            if ((val & 1) == 1) {

                swap(nums, slow, fast);
                System.err.println(" 交换状态 : " + Arrays.toString(nums));
                slow++;
            }
            fast++;
        }
        return nums;
    }

    /**
     * @param nums
     * @return
     */
    public int[] exchange2(int[] nums) {
        int len = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < len) {
            int currValue = nums[fast];
            if ((currValue & 1) == 1) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
        return nums;


    }


}
