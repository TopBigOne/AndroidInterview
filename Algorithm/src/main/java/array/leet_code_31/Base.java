package array.leet_code_31;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/7/7 10:49
 * @Url :
 * @Level :
 * @Desc : 数组内交换数据
 * @Counter :
 * @Answer :
 */
public class Base {
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] =temp;
    }

}
