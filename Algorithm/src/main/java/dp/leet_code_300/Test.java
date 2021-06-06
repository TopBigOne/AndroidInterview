package dp.leet_code_300;

/**
 * @author : dev
 * @version :
 * @Date :  6/6/21 2:33 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int result = lengthOfLIS.lengthOfLIS4(nums);
        System.out.println("result : " + result);
    }
}
