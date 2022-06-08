package sort;

import java.util.Arrays;

/**
 * @author : Jakarta
 * @version :
 * @Date : 7/1/20 8:04 PM
 * @Desc :
 */
public class BaseOperation {
    protected static int[] arr = {2, 1, 6, 4, 5, 9, 0, 6};

    public static void printResult(int[] arr) {
        System.out.println("sort result:" + Arrays.toString(arr));
    }

    public static void printResult(String methodName, int[] arr) {
        System.out.println(methodName + Arrays.toString(arr));
    }


    /**
     * 交换数据
     * @param nums
     * @param index1
     * @param index2
     */
    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
