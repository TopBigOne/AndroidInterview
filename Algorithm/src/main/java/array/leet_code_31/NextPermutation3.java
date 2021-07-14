package array.leet_code_31;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/6 20:37
 * @Url : https://leetcode-cn.com/problems/next-permutation/
 * @Level :    medium
 * @Desc : 下一个全排列
 * @Counter :
 * @Answer :
 */
public class NextPermutation3 {
    public void nextPermutation(int[] nums) {
        int length;
        // base corner
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int index = length - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        if (index >= 0) {
            int j = binarySearch(nums, index + 1, length - 1, nums[index]);
            // 3: 交换 nums[index] 和nums[j]
            swap(nums, index, j);
        }
        // 4 此时，nums[index+1,length-1],仍然是降序，反转一下，改成升序
        doSegmentReverse(nums, index + 1, length - 1);
    }
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    /**
     * 对数组nums,从i到end的位置，做一个升序
     *
     * @param nums
     * @param i
     * @param end
     */
    private void doSegmentReverse(int[] nums, int i, int end) {
        while (i < end) {
            swap(nums, i++, end--);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] =temp;
    }





}
