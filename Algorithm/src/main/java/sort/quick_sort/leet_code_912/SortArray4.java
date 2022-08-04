package sort.quick_sort.leet_code_912;

import java.util.Random;

import sort.BaseOperation;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/4 13:36
 * @Desc :
 */
public class SortArray4 extends BaseOperation {

    int INSERT_SORT_THRESHOLD = 7;
    Random random = new Random();

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
            // 走在前面的值比较小
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
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private void insertSort2(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            swap(nums, i, j);
        }
    }

    private int partition2(int[] nums, int left, int right) {
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


}
