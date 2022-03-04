package ten_sort.quick_sort;

import com.sun.deploy.panel.ITreeNode;

import org.omg.CORBA.INTERNAL;

import java.util.Random;

/**
 * @author : dev
 * @version :
 * @Date :  2022/3/1 15:19
 * @Desc :
 */
public class QuickSort_Base_12 extends BaseOperation {
    public static final int INSERTION_SORT_THRESHOLD = 7;
    public Random RANDOM = new Random();

    public void sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int left, int right) {
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertSort(nums, left, right);
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, right, pIndex + 1);
    }

    public void insertSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int j = i;
            int temp = nums[i];
            while (j > left && nums[j - 1] > temp) {
                nums[j - 1] = nums[j];
                j--;
            }
            nums[j] = temp;
        }
    }

    public int partition(int[] nums, int left, int right) {
        int randomIndex = RANDOM.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int lt = left;
        for (int i = left + 1; i < right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;

    }


}
