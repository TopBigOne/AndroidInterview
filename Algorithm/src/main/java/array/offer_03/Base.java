package array.offer_03;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/26 16:49
 * @Desc :
 */
public class Base {

    public  void swap(int [] nums,int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }
}
