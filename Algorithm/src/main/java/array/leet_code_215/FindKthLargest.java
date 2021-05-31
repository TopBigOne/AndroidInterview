package array.leet_code_215;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  5/31/21 11:32 AM
 * @Desc : leetcode 215:  字节半年 30 次；数组中的第 k 个最大元素：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 * <p>
 * 伟伟：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 * <p>
 * ----------
 * 方法一： 暴力解法，注意数清楚排序后索引数多少？
 * 方法二： 减而治之，借助快速排序的子过程，parttion 操作
 * 注意：随机化 pivot 以免极端测试用例
 *
 * 方法三：堆。
 *  使用怼的好处，可以处理庞大的数据，即，数据不用一下子存到内存中，
 *  并且比较的操作可以交给堆内部完成，代码看起来封装性，代码看起来封装性更好，语义更清晰
 *  这里最合适的操作应该是 repalc. java 没有提供这个操作，因此最好先 poll(),再 offer();
 *
 *
 *
 * <p>
 */

public class FindKthLargest {
    /**
     * 借助系统 api
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
        return nums[len - k];

        // 1,2,2,3,3,4,5,5,6
    }
}
