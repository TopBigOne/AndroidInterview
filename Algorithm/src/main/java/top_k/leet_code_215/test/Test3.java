package top_k.leet_code_215.test;

import top_k.leet_code_215.FindKthLargest3;
import top_k.leet_code_215.base.BaseTest;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 17:39
 * @Url :
 * @Level : easy medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Test3 extends BaseTest {
    public static void main(String[] args) {
        FindKthLargest3 findKthLargest = new FindKthLargest3();
        int result = findKthLargest.findKthLargest(nums, k);
        printResult(result);
    }

}
