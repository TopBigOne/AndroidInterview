package array.offer_53_2;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/26 17:46
 * @Desc :https://leetcode.cn/problems/que-shi-de-shu-zi-lcof/solution/jian-zhi-offer-53-ii-0n-1zhong-que-shi-d-idr6/
 */
public class MissingNumber {
    public static void main(String[] args) {
        // n = 3;
        int[] nums = {0, 1};
        MissingNumber missingNumber = new MissingNumber();
        int result = missingNumber.missingNumber(nums);
        System.out.println("result : " + result);
    }

    public int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 如果相等说明 left 到 mid 中间肯定不少元素 所以往右边二分查找
            if (nums[mid] == mid) left = mid + 1;
            else right = mid - 1;
        }
        return left;

    }
}
