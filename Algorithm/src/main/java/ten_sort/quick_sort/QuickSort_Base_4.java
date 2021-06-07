package ten_sort.quick_sort;

import java.util.Random;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/7 18:02
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class QuickSort_Base_4 {
    int INSERTION_SORT_THRESHOLD = 7;
    Random random = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        // 小于或者等于插入排序的边界
        if ((right - left) <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);
    }

    public void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <=right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    private int partition(int[] nums, int left, int right) {
        // 1: 随机下标
        int randomIndex = random.nextInt(right - left + 1) + left;
        // 2: 做交换
        swap(nums, left, randomIndex);

        // 3: 获取基准值
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

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

}
