package dp.leet_code_152;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/28 19:52
 * @Url : https://leetcode-cn.com/problems/maximum-product-subarray/submissions/
 * @Level :  medium
 * @Desc : 乘积最大子数组
 * @Counter :10
 * @Answer :
 */
public class MaxProduct {
    public static void main(String[] args) {
//        int[] nums = {2, 3, -2, 4};
        int[] nums = {-2, 3, -4};
        MaxProduct maxProduct = new MaxProduct();
        int result = maxProduct.maxProduct1(nums);
        System.out.println("result: " + result);
    }

    public int maxProduct1(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int iMax = 1;
        int iMin = 1;
        for (int i = 0; i < len; i++) {
            int curr = nums[i];
            if (curr < 0) {
                int temp = iMax;
                iMax = iMin;
                iMax = temp;
            }
            iMax = Math.max(curr * iMax, curr);
            iMin = Math.min(curr * iMin, curr);

            max = Math.max(iMax, max);
        }

        return max;
    }

    /**
     * 题解： https://leetcode-cn.com/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
     *
     * @param nums
     * @return
     */
    public int maxProduct2(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int iMax = 1;
        int iMin = 1;
        for (int i = 0; i < len; i++) {
            System.out.println("|------------------------------------|");
            int curr = nums[i];
            if (curr < 0) {
                int tmp = iMax;
                iMax = iMin;
                iMin = tmp;
            }

            iMax = Math.max(curr * iMax, curr);
            iMin = Math.min(curr * iMin, curr);

            String explain = "    当与" + curr + "相乘后，最大值：" + iMax + " ; 最小值：" + iMin;
            System.out.println(explain);

            max = Math.max(max, iMax);
        }
        return max;
    }
}
