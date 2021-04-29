package array.leet_code_88;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/28 21:17
 * @Desc :
 */
public class Merge2 {

    /**
     * 含有返回值的数组合并
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     * @return
     */
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] mergedArray = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;while (i < m && j < n) {
            mergedArray[k++] = (nums1[i] < nums2[j]) ? nums1[i++] : nums2[j++];
        }
        while (i < m) {
            mergedArray[k++] = nums1[i++];
        }
        while (j < n) {
            mergedArray[k++] = nums2[j++];
        }

        return mergedArray;

    }

    public static void main(String[] args) {
        Merge2 merge2 = new Merge2();

        int[] nums1 = {1, 2, 3};
        int m = nums1.length;
        int[] nums2 = {2, 5, 6};
        int n = nums2.length;

        int[] result = merge2.merge(nums1, m, nums2, n);
        System.out.println("result: "+ Arrays.toString(result));

    }
}
