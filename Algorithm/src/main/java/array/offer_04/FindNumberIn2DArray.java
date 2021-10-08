package array.offer_04;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/2 18:47
 * @Url :https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * @Level :    medium
 * @Desc : 二维数组的查找:在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * @Counter : 11
 * @Answer :
 * <p>
 * 本题与：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 样哦
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // base corner.
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;
        int col = matrix[0].length;
        // 遍历matrix 得到每一行
        for (int[] rowInts : matrix) {
            // 第一行，一个数字，就比target大的话，那就返回false
            if (rowInts[0] > target) {
                return false;
            }
            // 如果每行的最后一个数大于这一行的话，那就需要遍历下一行
            if (rowInts[col - 1] < target) {
                continue;
            }
            if (getIndex(rowInts, target) != -1) {
                return true;
            }

        }
        return false;
    }

    private int getIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) >> 1;
            int value = nums[mid];
            if (value == target) {
                return mid;
            } else if (value < target) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return -1;

    }
}
