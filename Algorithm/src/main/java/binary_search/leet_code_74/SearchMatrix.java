package binary_search.leet_code_74;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/23 23:20
 * @Desc :
 */
public class SearchMatrix {


    public static void main(String[] args) {

        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60},

        };
        int target = 13;
        SearchMatrix searchMatrix = new SearchMatrix();
        boolean result = searchMatrix.searchMatrix(matrix, target);
        System.err.println("result : " + result);

    }

    /**
     * [ [1,3,5,7],
     * [10,11,16,20],
     * [23,30,34,60]
     * ]
     * 13
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {

            int len = ints.length;

            if (ints[0] == target || ints[len - 1] == target) {
                return true;
            }
            if (ints[len - 1] < target) {
                continue;
            }
            if (isFind(ints, target)) {
                return true;
            }

        }
        return false;

    }

    private boolean isFind(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


}
