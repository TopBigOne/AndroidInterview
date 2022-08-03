package binary_search.leet_code_240;

import binary_search.Base;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 17:45
 * @Desc :
 */
public class SearchMatrix2  extends Base {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int numZero = ints[0];
            if (numZero > target) {
                break;
            }
            if (target > ints[ints.length - 1]) {
                continue;
            }
            int index = binarySearch(ints, target);
            if(index!=-1){
                return true;
            }
        }
        return false;


    }
}
