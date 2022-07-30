package binary_search.leet_code_154;

import binary_search.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/29 20:53
 * @Desc :  154. 寻找旋转排序数组中的最小值 II https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array-ii/solution/
 */
public class FindMin extends Base {
    public static void main(String[] args) {
        // 测试case 1
        int[] nums1 = generateArray(4, 4, 4, 4, 0, 1, 2, 3);
        int[] nums2 = generateArray(4, 4, 4, 4, 0, 2, 2, 2);
        // 证明 当 ： nums[right] = nums[mid]时，
        // 直接 right = mid，是不可行的；最小值，会直接被跳过；
        int[] nums3 = generateArray(4, 4, 0, 4, 4, 4, 4, 4);

        int[] nums4 = generateArray(4, 5, 6, 7, 8, 1, 2, 3);

        FindMin findMin = new FindMin();
        findMin.findMin3(nums4);

    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;

            } else {
                // nums[mid] == nums[right]
                right--;
            }
        }
        return nums[left];

    }

    /**
     * 45678  123
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public int findMin3(int[] nums) {
        // 4 5 6 7 8 1 2 3

        // 4 5 6 7 8  1 2 3   8 1 2 3   8 1
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }

    public int findMin4(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // 4 5 6 7 8  1 2 3
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid]>nums[right]){
                // 一步一步小心的向右边界推进
                left = mid+1;
            }else if(nums[mid]<nums[right]){
                // 根据二段性原则：
                // 这个时候，我们 要么在 左边的单调区域，要么在右边的单调区域；
                // 为什么不用mid-1,防止 漏掉 nums[mid] 区间数据,一步步的向左边界推进；
                right = mid;
            }else if (nums[mid]==nums[right]){
                right--;
            }

        }
        return nums[left];


    }
}
