package sort.quick_sort.leet_code_912;

import java.util.Random;

import sort.BaseOperation;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/4 14:24
 * @Desc :
 */
public class SortArray5 extends BaseOperation {
    Random random = new Random();
    int INSERT_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left <= INSERT_SORT_THRESHOLD) {
            insertSort(nums, left, right);
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j = i;
            int temp = nums[i];
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }


}
