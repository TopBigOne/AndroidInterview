package ten_sort.quick_sort;

import java.util.Random;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/7 15:25
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class QuickSort_Base_2 {
    public static final int INSERTION_SORT_THRESHOLD = 7;
    public Random random = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        //  1: 快排 分左右
        quickSort(nums, 0, len - 1);
        return nums;
    }

    /**
     * @param nums
     * @param left
     * @param right
     */
    private void quickSort(int[] nums, int left, int right) {
        //  1: 小于区间的话，使用插入排序
        if (right - left <= INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }
        // 2: 做分割；
        int pIndex = partition(nums, left, right);
        // 3: 排序左边
        quickSort(nums, left, pIndex - 1);
        // 4: 排序右边
        quickSort(nums, pIndex + 1, right);
    }

    /**
     * 分割，并排序
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        // 1: 基准值
        int pivot = nums[left];
        int lt = left;
        // 循环不变量
        // all in [left+1,lt] < pivot;
        // all in [lt+1,   i] >=pivot;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return 0;
    }


    /**
     * 插入排序
     *
     * @param nums
     * @param left
     * @param right
     */
    public void insertionSort(int[] nums, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = nums[i];
            int j = i;
            while (j < left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    /**
     * 数组交换，老生长谈论的问题；
     *
     * @param nums
     * @param left
     * @param right
     */
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[right] = nums[left];
        nums[left] = temp;

    }

}
