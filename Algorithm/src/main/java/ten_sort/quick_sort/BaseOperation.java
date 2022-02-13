package ten_sort.quick_sort;

/**
 * @author : dev
 * @version :
 * @Date :  2/13/22 1:46 AM
 * @Desc :
 */
public class BaseOperation {

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
