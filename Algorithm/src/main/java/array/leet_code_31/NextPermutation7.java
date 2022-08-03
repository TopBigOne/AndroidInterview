package array.leet_code_31;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/8 21:16
 * @Desc :  https://leetcode.cn/problems/next-permutation/
 * <p>
 * 题解：https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 */
public class NextPermutation7 extends Base {
    public static void main(String[] args) {
        NextPermutation7 nextPermutation = new NextPermutation7();
        int[] nums = {1, 2, 3, 8, 5, 7, 6, 4};
        System.err.println("nums : " + Arrays.toString(nums));
        nextPermutation.nextPermutation(nums);

    }

    public void nextPermutation(int[] nums) {
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return;
        }
        int index = len - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }

        System.err.println("index: " + index);
        if (index >= 0) {
            int j = binarySearch(nums, index + 1, len - 1, nums[index]);
            System.err.println("j_Index: " + j + ", the need swap value is : " + nums[j]);
            swap(nums, index, j);

        }

        doPartReverse(nums, index + 1, len - 1);
    }

    /**
     * 在降序数组中找到第一个比target 大的数的下标
     *
     * @param nums   降序数组
     * @param l
     * @param r
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

    private void doPartReverse(int[] nums, int i, int j) {
        while (i < j) {

            swap(nums, i, j);
            i++;
            j--;
        }
    }


}
