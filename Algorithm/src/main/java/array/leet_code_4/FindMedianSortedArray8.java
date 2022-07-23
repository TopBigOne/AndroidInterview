package array.leet_code_4;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/21 23:49
 * @Desc :
 */
public class FindMedianSortedArray8 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (len1 == 0) {
            double one = nums2[len2 >>> 1];
            double two = nums2[(len2 - 1) >>> 1];
            return (one + two) / 2;
        }
        int len = len1 + len2;
        int cutA;
        int cutB;
        int start = 0;
        int end = len1;
        while (start <= end) {
            cutA = (start + end) >>> 1;
            cutB = (len + 1) / 2 - cutA;

            double l1 = cutA == 0 ? Integer.MIN_VALUE : nums1[cutA - 1];
            double l2 = cutB == 0 ? Integer.MIN_VALUE : nums2[cutB - 1];

            double r1 = cutA == len1 ? Integer.MAX_VALUE : nums1[cutA];
            double r2 = cutB == len2 ? Integer.MAX_VALUE : nums2[cutB];
            if (l1 > r2) {
                end = cutA - 1;
            } else if (l2 > r1) {
                start = cutA + 1;
            } else {
                if ((len & 1) == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                return Math.max(l1, l2);
            }
        }
        return -1;

    }
}
