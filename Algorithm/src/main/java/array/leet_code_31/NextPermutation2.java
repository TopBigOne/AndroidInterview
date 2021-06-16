package array.leet_code_31;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/14 17:51
 * @Url : https://leetcode-cn.com/problems/next-permutation/
 * @Level : easy medium hard
 * @Desc :下一个全排列
 * @Counter :
 * @Answer :
 */
public class NextPermutation2 {

    public void nextPermutation(int[] nums) {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        // 从后往前 查找 第一次出现nums[i]<nums[i+1] 的位置
        int i = length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // if i == -1 , nums 则整体逆序
        if (i >= 0) {
            // 此时，nums[i+1,length-1] 降序，查找其中 比大于nums[i]的最小的值，
            // 可以直接从后往前 逆向找
            // 因为有序，可以练习一下二分查找
            int j = binarySearch(nums, i + 1, length - 1, nums[i]);
            // 交换 i ，j；
            swap(nums, i, j);
        }
        // 此时num[i+1,length-1] 仍然降序，将其改为升序，只需要反转即可
        reverse(nums, i + 1, length - 1);
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >>> 1);
            int currValue = nums[mid];
            if (currValue == target) {
                return mid;
            } else if (currValue < target) {
                low = mid + 1;
            } else if (currValue > target) {
                high = mid - 1;
            }
        }
        return high;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 反转字符串，使用双指针
     *
     * @param nums
     * @param left
     * @param right
     */
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


}
