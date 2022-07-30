package binary_search.leet_code_852;

import binary_search.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/30 14:16
 * @Desc : 852. 山脉数组的峰顶索引 :  https://leetcode.cn/problems/peak-index-in-a-mountain-array/
 * <p>
 * https://leetcode.cn/problems/peak-index-in-a-mountain-array/solution/man-hua-suan-fa-er-fen-cha-zhao-yi-shou-shi-jie-ju/
 */
public class PeakIndexInMountainArray extends Base {
    public static void main(String[] args) {
        PeakIndexInMountainArray peakIndexInMountainArray = new PeakIndexInMountainArray();
        int[] nums = generateArray(0, 6, 7, 8, 9, 10, 5, 2);
        int index = peakIndexInMountainArray.peakIndexInMountainArray(nums);
        System.err.println("index : " + index);
        // 0, 6, 7, 8, 9, 10, 5, 2
        // 8, 9, 10, 5, 2
       //  10, 5, 2
        // 10, 5
        // 10,
    }

    public int peakIndexInMountainArray(int[] nums) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;
        while (l <= r) {
            int mid = (l + r) >>> 1;

            int midValue = nums[mid];


            if (nums[mid + 1] > midValue) {
                l = mid + 1;
                continue;
            }
            if (nums[mid - 1] > nums[mid]) {
                r = mid - 1;
                continue;
            }
            return mid;
        }

        return 0;


    }
}
