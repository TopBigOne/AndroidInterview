package array.leet_code_611;

import java.util.Arrays;

import dp.leet_code_120.MinimumTotal;
import jdk.nashorn.internal.objects.NativeNumber;

/**
 * @author : dev
 * @version :
 * @Date :  10/28/21 8:16 PM
 * @Desc :  https://leetcode-cn.com/problems/valid-triangle-number/
 * 有效的三角形个数
 */
public class TriangleNumber {
    /**
     * 1： 首先对数组排序
     * 2： 固定最短的两条边，二分查找最后一个小于两边之和的位置。可以求得固定两条边长之和满足条件的结果。枚举结束后，总和就是答案；
     * 3： 时间复杂度为 O(n^2logn)O(nlogn)。
     * 4： 二分查找
     *
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int s = nums[i] + nums[j];
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (nums[mid] < s) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }

                if (nums[r] < s) {
                    res += r - j;
                }
            }
        }
        return res;
    }

    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int s = nums[i] + nums[j];
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                if (nums[r] < s) {
                    res += r - j;
                }
            }
        }
        return res;
    }

    public int triangleNumber3(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int s = nums[i] + nums[j];
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                if (nums[r] < s) {
                    res += r - j;
                }
            }
        }
        return res;
    }

    public int triangleNumber4(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int s = nums[i] + nums[j];
                int l = j + 1;
                int r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }

                if (nums[r] < s) {
                    res += r - j;
                }

            }
        }
        return res;

    }

    public int triangleNumber5(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int res = 0;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                int s = nums[j] + nums[i];
                int l = j + 1;
                int r = length - 1;
                while (l < r) {
                    int mid = l + r + 1 >>> 1;
                    if (nums[mid] < s) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }

                if (nums[r] < s) {
                    res += r - j;
                }
            }
        }
        return res;

    }
}
