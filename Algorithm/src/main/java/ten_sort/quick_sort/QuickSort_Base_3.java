package ten_sort.quick_sort;

import java.util.Random;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/7 17:24
 * @Url : https://leetcode-cn.com/problems/sort-an-array/solution/
 * @Level :  medium
 * @Desc :
 * @Counter :
 * @Answer : 题解：https://leetcode-cn.com/problems/sort-an-array/solution/fu-xi-ji-chu-pai-xu-suan-fa-java-by-liweiwei1419/
 */
public class QuickSort_Base_3 {
    int INSERT_SORT_THRESHOLD = 7;
    Random random = new Random();
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        quickSort(nums, 0, len - 1);
        return nums;
    }
    private void quickSort(int[] nums, int left, int right) {
        // 1: 符合做插入排序
        if ((right - left) <= INSERT_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        int pIndex = partition(nums, left, right);
        quickSort(nums, left, pIndex - 1);
        quickSort(nums, pIndex + 1, right);

    }
    /**
     * 插入排序 for + while 循环
     *
     * @param nums
     * @param left
     * @param right
     */
    private void insertionSort(int[] nums, int left, int right) {
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

    /**
     * 做分割，也做排序；
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randomIndex);
        // 基准值
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

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
