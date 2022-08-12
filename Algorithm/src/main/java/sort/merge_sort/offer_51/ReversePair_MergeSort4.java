package sort.merge_sort.offer_51;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/12 14:45
 * @Desc :
 */
public class ReversePair_MergeSort4 {

    public int reversePairs(int[] nums) {
        int length = nums.length;
        int[] copy = new int[length];
        System.arraycopy(nums, 0, copy, 0, length);
        int[] helpArray = new int[length];
        return reversePairs(copy, 0, length - 1, helpArray);
    }

    private int reversePairs(int[] nums, int left, int right, int[] helpArray) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int leftCount = reversePairs(nums, left, mid, helpArray);
        int rightCount = reversePairs(nums, mid + 1, right, helpArray);
        int crossCount = mergeAndCount(nums, left, right, mid, helpArray);
        return leftCount + rightCount + crossCount;
    }

    private int mergeAndCount(int[] nums, int left, int right, int mid, int[] helpArray) {
        if (right - left + 1 >= 0) {
            System.arraycopy(nums, left, helpArray, left, right - left + 1);
        }
        int i = left;
        int j = mid + 1;
        int count = 0;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = helpArray[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = helpArray[i];
                i++;
            } else if (helpArray[i] <= helpArray[j]) {
                nums[k] = helpArray[i];
                i++;
            } else {
                nums[k] = helpArray[j];
                j++;
                count += (mid - i + 1);
            }
        }

        return count;
    }


}
