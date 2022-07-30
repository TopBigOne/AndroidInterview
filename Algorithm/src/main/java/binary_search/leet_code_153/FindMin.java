package binary_search.leet_code_153;

import binary_search.Base;

/**
 * @author : dev
 * @version : 153. 寻找旋转排序数组中的最小值
 * @Date :  2022/7/19 23:26
 * @Desc : https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/
 */
public class FindMin extends Base {
    public static void main(String[] args) {

        // int[] nums = generateArray(4, 5, 6, 7, 0, 1, 2);
        int[] nums = generateArray(6, 1, 2, 3, 4, 5);
        FindMin findMin = new FindMin();
        int result = findMin.findMin(nums);
        System.err.println("result :" + result);
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid index = " + mid);

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    public int findMin3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];


    }

    public int findMin4(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;

            }
        }
        return nums[left];
    }

    /**
     * 6 1 2 3 4 5
     *
     * @param nums
     * @return
     */
    public int findMin5(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

    // 456 7 123
    public int findMin6(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;


    }
}
