package dp.linear.classic.leet_code_53;

/**
 * @author : dev
 * @version :
 * @Date :  1/26/21 12:28 AM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
//        int[] raws = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] raws = {1};
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int result = maximumSubArray.maxSubArray9(raws);
        System.out.println("result: " + result);
    }
}
