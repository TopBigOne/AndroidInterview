package binary_search.leet_code_240;


import java.util.Arrays;

import binary_search.Base;

/**
 * @author :  dev
 * @version :
 * @Date :  6/20/21 11:25 PM
 * @Url : leetcode 240 搜索二维矩阵  https://leetcode-cn.com/problems/search-a-2d-matrix-ii/submissions/
 * @Level :  medium
 * @Desc : leetcode 240 搜索二维矩阵 ：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 * @Counter : 11
 * @Answer : https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 */

public class SearchMatrix  extends Base {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            System.out.println("ints:" + Arrays.toString(ints));
            int ints_0 = ints[0];
            System.out.println("ints_0 : " + ints_0);

            if (ints_0 > target) {
                break;
            }
            if (ints[ints.length - 1] < target) {
                continue;
            }
            int col = binarySearch(ints, target);
            if (col != -1) {
                return true;
            }
        }
        return false;
    }



    private int binarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

}
