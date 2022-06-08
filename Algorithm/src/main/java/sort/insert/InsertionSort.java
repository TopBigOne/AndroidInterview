package sort.insert;

import java.util.Arrays;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/7 16:29
 * @Url :
 * @Level :  medium
 * @Desc : 插入排序
 * @Counter :
 * @Answer :
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {3, 5, 8, 2, 4, 6};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertFive(nums, 0, nums.length);
        System.out.println("插入排序以后：" + Arrays.toString(nums));
    }


    /**
     * 插入排序
     *
     * @param nums
     * @param left
     * @param right
     */
    public void insertOne(int[] nums, int left, int right) {
        // 1: for loop
        for (int i = left; i < right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                // 进行前后交换
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public void insertTwo(int[] nums, int left, int right) {
        for (int i = 0; i < right; i++) {
            int temp = nums[i];
            int j = i;
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;

        }
    }

    public void insertThree(int[] nums, int left, int right) {
        for (int i = 0; i < right; i++) {
            int temp = nums[i];
            int j = i;
            // 开始内部循环
            while (j > left && nums[j - 1] > temp) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }

    }

    public void insertFour(int [] nums,int left,int right){
        for (int i = 0; i < right; i++) {
            int temp = nums[i];
            int j= i;
            while (j>0&&nums[j-1]>temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public void insertFive(int [] nums,int left,int right){
        for (int i = 0; i < right; i++) {
            int temp = nums[i];
            int j = i;
            // 后面的比前面的大
            while (j>0&&nums[j-1]>temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }
}
