package array.sub_array.leet_code_560;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/10 20:46
 * @Desc :
 */
public class SubarraySum3 {

    /**
     * 最原始的前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len; i++) {
            int preFixSum = 0;
            for (int j = i; j < len; j++) {
                preFixSum += nums[j];
                if (preFixSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
