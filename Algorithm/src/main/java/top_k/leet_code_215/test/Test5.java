package top_k.leet_code_215.test;

import top_k.leet_code_215.FindKthLargest5;
import top_k.leet_code_215.base.BaseTest;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/5/31 21:15
 * @Url : https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * @Level : easy medium hard
 * @Desc :测试使用优先级队列
 * @Counter :
 * @Answer :
 */
public class Test5 extends BaseTest {
    public static void main(String[] args) {
        FindKthLargest5 findKthLargest = new FindKthLargest5();
        int result = findKthLargest.findKthLargest(nums, k);
        printResult(result);

    }

}
