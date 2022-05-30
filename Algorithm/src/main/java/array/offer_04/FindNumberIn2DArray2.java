package array.offer_04;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/27 15:51
 * @Desc :
 */
public class FindNumberIn2DArray2 {


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null||matrix.length==0) {
            return false;
        }
        if (matrix[0].length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            int length = ints.length;

            if (ints[0] > target) {
                return false;
            }
            if (ints[length - 1] < target) {
                continue;
            }
            if (getIndex(ints, target) != -1) {
                return true;
            }


        }
        return false;

    }

    private int getIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int currValue = nums[mid];
            if (currValue < target) {
                left = mid + 1;

            } else if (currValue > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


}
