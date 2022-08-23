package sort.merge_sort.offer_51;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/23 10:25
 * @Desc :  offer51:数组中的逆序对，字节半年 10 次  https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
 */
public class ReversePair_MergeSort7 {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        int[] help = new int[len];
        System.arraycopy(nums, 0, copy, 0, len);

        return reversePairs(copy, 0, len - 1, help);


    }

    private int reversePairs(int[] copy, int left, int right, int[] help) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(copy, left, mid, help);
        int rightCount = reversePairs(copy, mid + 1, right, help);
        int crossCount = mergeAndCalculate(copy, left, mid, right, help);
        return leftCount + rightCount + crossCount;
    }

    private int mergeAndCalculate(int[] nums, int left, int mid, int right, int[] help) {
        if (right - left + 1 >= 0) {
            System.arraycopy(nums, left, help, left, right - left + 1);
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {

            if (i == mid + 1) {
                nums[k] = help[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = help[i];
                i++;
            } else if (help[i] <= help[j]) {
                nums[k] = help[i];
                i++;
            } else if (help[i] > help[j]) {
                nums[k] = help[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }


}
