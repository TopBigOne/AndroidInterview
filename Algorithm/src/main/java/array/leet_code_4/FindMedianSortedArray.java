package array.leet_code_4;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/20 10:19
 * @Desc : 寻找两个正序数组的中位数
 * <p>
 * 题解：https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2/
 * <p>
 * https://blog.csdn.net/chen_xinjia/article/details/69258706
 *
 *
 *
 * 视频：https://www.youtube.com/watch?v=do7ibYtv5nk&t=193s
 */
public class FindMedianSortedArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            // 保证 m<=n
            return findMedianSortedArrays(B, A);
        }
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) >> 1;
            int j = ((m + n + 1) >> 1) - i;
            // i 需要增大
            if (j != 0 && i != m && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
                // i 需要减小
                iMax = i - 1;
            } else {
                // 达到要求，并且将边界条件列出来 单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                // 奇数的话不需要考虑右半部分
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;

    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) {
            // 保证 m <= n
            return findMedianSortedArrays(B, A);
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            // i 需要增大
            if (j != 0 && i != m && B[j - 1] > A[i]) {
                iMin = i + 1;
            } else if (i != 0 && j != n && A[i - 1] > B[j]) {
                // i 需要减小
                iMax = i - 1;
            } else {
                // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                // 奇数的话不需要考虑右半部分
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                } else if (j == n) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }
                //如果是偶数的话返回结果
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {// 确保N1是短的部分。
            return findMedianSortedArrays3(nums2, nums1);
        }

        if (n1 == 0) {
            return ((double) nums2[(n2 - 1) / 2] + (double) nums2[n2 / 2]) / 2;
        }
        int len = n1 + n2;
        int cutL = 0, cutR = n1;
        int cut1 = n1 >> 1;
        int cut2;

        while (cut1 <= n1) {
            cut1 = ((cutR - cutL) >> 1) + cutL;
            cut2 = (len >> 1) - cut1;
            double l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            double r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];
            if (l1 > r2)
                cutR = cut1 - 1;
            else if (l2 > r1)
                cutL = cut1 + 1;
            else {// Otherwise, that's the right cut.
                if (len % 2 == 0) {// 偶数个数的时候
                    l1 = Math.max(l1, l2);
                    r1 = Math.min(r1, r2);
                    return (l1 + r1) / 2;
                }
                // 奇数
                r1 = Math.min(r1, r2);
                return r1;
            }
        }
        return -1;

    }

    public double findMedianSortedArrays4(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays4(nums2, nums1);
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
            if (l1 > r2) {
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
                // 奇数
                r1 = Math.min(r1, r2);
                return r1;
            }
        }
        return -1;
    }

    public double findMedianSortedArrays5(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if (n1 > n2) {
            return findMedianSortedArrays5(nums2, nums1);
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
            if (l1 > r2) {
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
