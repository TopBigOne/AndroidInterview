package linked_list.offer_40;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/22 4:30 PM
 * @Desc :
 */
public class BaseFunc {

    /**
     * 数组交换值
     *
     * @param nums
     * @param index1
     * @param index2
     */
    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
