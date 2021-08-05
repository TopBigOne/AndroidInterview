package array.leet_code_31;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/7 10:37
 * @Url : https://leetcode-cn.com/problems/next-permutation/
 * @Level :    medium
 * @Desc : 下一个全排列
 * @Counter :
 * @Answer :  *  * 高频题解： https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 */
public class NextPermutation4 extends Base {
    public static void main(String[] args) {
        int[] nums = {1, 5, 3, 8, 5, 6, 7};
        System.out.println("before : "+ Arrays.toString(nums));
        NextPermutation4 next = new NextPermutation4();
        next.nextPermutation(nums);
        System.out.println("end    : "+ Arrays.toString(nums));
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

        if (index >= 0) {
            int j = binarySearch(nums, index + 1, len - 1, nums[index]);
            swap(nums, index, j);
        }
        doPartReverse(nums, index + 1, len - 1);
    }

    private void doPartReverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] > target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }


}
