package array.leet_code_215.test;

import array.leet_code_215.FindKthLargest;
import array.leet_code_215.base.BaseTest;

/**
 * @author : dev
 * @version :
 * @Date :  5/31/21 11:46 AM
 * @Desc :
 */
public class Test1 extends BaseTest {
    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int result = findKthLargest.findKthLargest(nums, k);
        printResult(result);

    }
}
