package array.leet_code_31;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/14 17:51
 * @Url : https://leetcode-cn.com/problems/next-permutation/
 * @Level :  medium
 * @Desc :下一个全排列
 * @Counter :
 * @Answer :
 */
public class NextPermutation2 {
    public void nextPermutation(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) return;
        // 1: 从后往前查找第一次出现 nums[i] < nums[i+1] 的位置
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = binarySearch(nums, i + 1, length - 1, nums[i]);
            swap(nums, i, j);
        }
        // 3:此时 nums[i+1, length-1] 仍然降序，将其改为升序，只需要反转即可。
        doSegmentReverse(nums, i + 1, length - 1);
    }

    /**
     * nums[left, right] 逆序，查找其中 > target 的 最大下标
     */
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

    private void doSegmentReverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


}
