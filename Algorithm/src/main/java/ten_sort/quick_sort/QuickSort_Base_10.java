package ten_sort.quick_sort;

import java.util.Random;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/14 10:15
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class QuickSort_Base_10 extends BaseOperation {
    int insertion = 7;
    Random RANDOM = new Random();

    public void sortArray(int[] nums) {
        quickSort(nums, 0, nums.length);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left <= insertion) {
            insertSort(nums, left, right);
            return;
        }
        int pIndex = partion(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
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

    private int partion(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left) + left;
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
