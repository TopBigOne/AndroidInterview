package sort.quick_sort.pratice;

import java.util.Random;
import sort.BaseOperation;
/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/21 17:52
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class QuickSort_Base_11 extends BaseOperation {
    int insertion = 7;
    Random RANDOM = new Random();

    public void sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
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

    private int partion2(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left) + left;
        swap(nums, left, randomIndex);
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


}
