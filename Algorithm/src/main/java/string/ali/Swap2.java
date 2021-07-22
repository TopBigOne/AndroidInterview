package string.ali;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/15 13:59
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 * <p>
 * 就像leet code 全排列：https://leetcode-cn.com/problems/next-permutation/
 */
public class Swap2 {
    public void nextPermutation(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return;
        }
        int index = len - 2;
        // 1:找到突然变小的那个点
        while (index >= 0 && nums[index] > nums[index + 1]) {
            index--;
        }
        // 2:做交换
        if (index >= 0) {
            int j = binarySearch(nums, index + 1, len - 1, nums[index]);
            swap(nums, index, j);
        }
        // 3: 对剩下的部分做一个反转
        doPartReverse(nums, index + 1, len - 1);
    }

    /**
     * 二分查找，有点不一样的是：这个数组是降序的，从大到小，和我们以前写的 二分查找不一样哦，，
     * 以前的二分查找，是一个升序的数组；这点，需要自己好好的体会哦
     *
     * @param nums
     * @param low
     * @param high
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int curValue = nums[mid];
            if (curValue > target) {
                high = mid + 1;
            } else {
                low = mid - 1;
            }
        }
        return high;
    }

    /**
     * 反转数组的一部分
     *
     * @param nums
     * @param left
     * @param right
     */
    public void doPartReverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    /**
     * 交换
     *
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
