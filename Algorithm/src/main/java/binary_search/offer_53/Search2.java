package binary_search.offer_53;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/28 14:43
 * @Desc :
 * 题解：https://leetcode.cn/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/solution/gong-shui-san-xie-liang-chong-er-fen-ton-3epx/
 */
public class Search2 {
    public static void main(String[] args) {
        Search2 search = new Search2();
        int[] nums = {5, 7, 7, 8, 8, 8, 8, 8, 8, 8, 10};
        int result = search.search(nums, 8);
        System.out.println("result : " + result);
    }

    /**
     * 在一个排序数组中，从左往右寻找，找到这个数，第一次出现的下标！
     * @param nums
     * @param t
     * @return
     */
    public int search(int[] nums, int t) {
        int l = 0;
        int r = nums.length - 1;
        int result = 0;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        while (l <= nums.length - 1 && nums[l] == t) {
            result++;
            l++;
        }
        return result;
    }
}
