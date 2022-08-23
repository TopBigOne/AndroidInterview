package binary_search.leet_code_74;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/21 00:43
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class SearchMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length;
        for (int[] ints : matrix) {
            // 基本没有这个数
            if (ints[0] > target) {
                break;
            }
            if (ints[col - 1] < target) {
                continue;
            }
            if (getIndex(ints, target) != -1) {
                return true;
            }
        }
        return false;

    }

    private int getIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low<=high){
            int mid = (low+high)>>1;
            int currVale = nums[mid];
            if(currVale==target){
                return mid;
            }else if(currVale<target){
                low=mid+1;
            }else if(currVale>target){
                high = mid-1;
            }
        }
        return -1;
    }
}
