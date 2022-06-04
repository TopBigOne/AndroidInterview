package array.offer_21;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/4 17:35
 * @Desc :
 */
public class Base {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
