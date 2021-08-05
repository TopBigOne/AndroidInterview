package array.leet_code_4;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/8/3 11:27
 * @Url :
 * @Level :     hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class FindMedianSortedArray2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        if (n1 == 0) {
            return ((double) nums2[(n2 - 1) >> 1] + (double) nums2[n2 >> 1]) / 2;
        }
        int len = n1 + n2;
        int cutL = 0;
        int cutR = n1;
        int cut1 = n1 >> 1;
        int cut2;
        while (cut1 <= n1) {
            cut1 = ((cutR - cutL) >> 1) + cutL;
            cut2 = (len >> 1) - cut1;
            double l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];

            double r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 > l2) {
                cutR = cut1 - 1;
            } else if (l2 > r1) {
                cutL = cut1 + 1;
            } else {
                // 偶数
                if ((len & 1) == 0) {
                    l1 = Math.max(l1, l2);
                    r1 = Math.min(r1, r2);
                    return (l1 + r1) / 2;
                }
                r1 = Math.min(r1, r2);
                return r1;
            }
        }

        return -1;

    }
}
