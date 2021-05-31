package array.leet_code_215.test;

import array.leet_code_215.FindKthLargest2;
import array.leet_code_215.base.BaseTest;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 16:18
 * @Url :
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test2 extends BaseTest {
    public static void main(String[] args) {
        FindKthLargest2 findKthLargest = new FindKthLargest2();
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest.findKthLarge(arr, k);
        System.out.println("---------------");
        System.out.println("result: " + result);
    }
}
