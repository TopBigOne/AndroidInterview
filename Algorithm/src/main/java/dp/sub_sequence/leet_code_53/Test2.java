package dp.sub_sequence.leet_code_53;

/**
 * @author : dev
 * @version :
 * @Date :  5/31/21 10:41 AM
 * @Desc :
 */
public class Test2 {
    public static void main(String[] args) {
        int[] arr = {-1, -4, 1, 6, -4};
        MaximumSubArray2 maximumSubArray2 = new MaximumSubArray2();
        int result = maximumSubArray2.maxSubArray(arr);
        System.out.println("result : " + result);


    }
}
