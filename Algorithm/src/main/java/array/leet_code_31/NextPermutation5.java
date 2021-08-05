package array.leet_code_31;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/15 15:15
 * @Url :下一个排列：（https://leetcode-cn.com/problems/next-permutation/）
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 * * 题解：
 * * 一姐：https://www.youtube.com/watch?v=IbcQOdtmvpA
 * * 高频题解： https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 */
public class NextPermutation5 extends Base {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index = len - 2;
        while (index >= 0 && nums[index] >= nums[index + 1]) {
            index--;
        }
        if (index >= 0) {
            int j = binarySearch(nums, index + 1, len - 1, nums[index]);
            swap(nums, index, j);
        }
        doPartReverse(nums, index + 1, len - 1);
    }

    private void doPartReverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }

    private int binarySearch(int[] nums, int l, int r, int target) {

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > target) {
                l = mid + 1;

            } else {
                r = mid - 1;
            }
        }

        return r;
    }


}
