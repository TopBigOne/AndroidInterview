package ten_sort.quick_sort;

import java.util.Random;

import array.leet_code_88.TestIndex;

/**
 * @author : dev
 * @version :
 * @Date :  2/13/22 6:00 PM
 * @Desc : 快排
 */
public class QuickSort_Base_8 extends BaseOperation {
    int inserttionSort = 7;
    Random RANDDOM = new Random();

    public void sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);

    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left <= inserttionSort) {
            insertSort(nums, left, right);
            return;
        }

        int pIndex = parttion(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    private int parttion(int[] nums, int left, int right) {
        int randIndex = RANDDOM.nextInt(right - left) + left;
        swap(nums, left, randIndex);
        int lt = left;
        int pivot = nums[left];
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
