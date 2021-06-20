package ten_sort.binary_search.leet_code_240;

/**
 * @author : dev
 * @version :
 * @Date :  6/20/21 11:25 PM
 * @Desc : leetcode 240 搜索二维矩阵 ： 字节 半年 11 次 ： https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 *
 *
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            if (ints[0] > target) {
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
