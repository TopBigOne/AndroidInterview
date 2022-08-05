package dp.leet_code_152;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/5 11:21
 * @Desc :
 */
public class MaxProduct2 {

    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
        int[] nums = {-2, 3, -4};
        MaxProduct2 maxProduct = new MaxProduct2();
        int result = maxProduct.maxProduct(nums);
        System.out.println("result: " + result);
    }


    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            int currValue = nums[i];
            max = Math.max(Math.max(min * currValue, max * currValue), currValue);
            min = Math.min(Math.min(min * currValue, temp * currValue), currValue);
            res = Math.max(res, max);
        }
        return res;
    }

    public int maxProduct2(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            int currValue = nums[i];
            max = Math.max(Math.max(max * currValue, min * currValue), currValue);
            min = Math.min(Math.min(temp * currValue, min * currValue), currValue);
            res = Math.max(res, max);
        }

        return res;
    }


}
