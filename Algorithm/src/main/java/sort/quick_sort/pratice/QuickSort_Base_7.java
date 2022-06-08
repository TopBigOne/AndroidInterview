package sort.quick_sort.pratice;

import java.util.Random;
import sort.BaseOperation;
/**
 * @author : dev
 * @version :
 * @Date :  2/13/22 3:33 PM
 * @Desc :
 */
public class QuickSort_Base_7 extends BaseOperation {
    int inserttion = 7;
    Random RANDOM = new Random();

    public int[] sortArray(int[] nums) {

        int length = nums.length;
        quickSort(nums, 0, length - 1);
        return nums;

    }

    private void quickSort(int[] nums, int left, int right) {
        if (right - left <= inserttion) {
            inserttionSort(nums, left, right);
            return;
        }
        int pIndex = parttion(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex+1, right);
    }

    private int parttion(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
                ;
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private void inserttionSort(int[] nums, int left, int right) {
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


}
