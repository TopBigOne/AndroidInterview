package array.leet_code_1480;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  5/3/21 10:47 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        RunningSum runningSum = new RunningSum();
        int[] result = runningSum.runningSum(nums);
        System.out.println("result: "+Arrays.toString(result));


    }
}
