package array.leet_code_4;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/21 03:57
 * @Desc :https://leetcode.cn/problems/median-of-two-sorted-arrays/
 */
public class FindMedianSortedArray4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenA = nums1.length;
        int lenB = nums2.length;
        if (lenA > lenB) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (lenA == 0) {
            double one = (double) nums2[(lenB >> 1)];
            double two = (double) nums2[((lenB - 1) >> 1)];
            return (one + two) / 2;
        }
        int len = lenA + lenB;
        int A_startK = 0;
        int A_endK = lenA;


        int cutA;
        int cutB;
        while (A_startK <= A_endK) {
            // nums1 数组左边贡献的值的下标,其实就是一个中点值
            cutA = (A_startK + A_endK) >> 1;
            // nums1 数组贡献了以后，剩下的由B数组贡献值的下标
            cutB = (len + 1) / 2 - cutA;

            // nums1 数组左边贡献的值
            double l1 = cutA == 0 ? Integer.MIN_VALUE : nums1[cutA - 1];
            // nums2 数组左边贡献的值
            double l2 = cutB == 0 ? Integer.MIN_VALUE : nums2[cutB - 1];

            double r1 = cutA == lenA ? Integer.MAX_VALUE : nums1[cutA];
            double r2 = cutB == lenB ? Integer.MAX_VALUE : nums2[cutB];
            // 开始做比较

            if (l1 > r2) {
                // case 1: 不符合条件
                // 就是右指针-1；
                A_endK = cutA - 1;

            } else if (l2 > r1) {

                // case 2: 不符合条件
                // 左指针+1；
                A_startK = cutA + 1;

            } else {
                // case 3 : 符合条件
                // l1<=r2 && l2<=r1

                if (len % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2;
                }
                return Math.max(l1, l2);
            }


        }
        return -1;

    }
}
