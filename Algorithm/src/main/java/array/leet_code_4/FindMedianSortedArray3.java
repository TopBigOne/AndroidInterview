package array.leet_code_4;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/16 18:06
 * @Desc :
 */
public class FindMedianSortedArray3 {

    /**
     * 原始的解法
     *
     * @param nums1 正序（从小到大）数组
     * @param nums2 正序（从小到大）数组
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArray = mergeArray(nums1, nums2);
        // 偶数
        if ((mergeArray.length & 1) == 0) {
            int vOne = mergeArray[mergeArray.length >> 1];
            int vTwo = mergeArray[(mergeArray.length - 1) >> 1];
            return (vOne + vTwo) / 2.0;
        }

        return mergeArray[mergeArray.length >> 1];

    }


    /**
     * 合并数组
     *
     * @param nums1 正序（从小到大）数组
     * @param nums2 正序（从小到大）数组
     * @return
     */
    private int[] mergeArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m) {
            result[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }
        while (i < n) {
            result[k++] = nums1[i++];
        }
        while (j < m) {
            result[k++] = nums2[j++];
        }

        return result;
    }
}
