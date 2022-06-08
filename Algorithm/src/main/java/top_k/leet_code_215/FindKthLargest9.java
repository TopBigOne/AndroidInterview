package top_k.leet_code_215;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 15:15
 * @Desc :
 * <p>
 * 题解：https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
public class FindKthLargest9 {
    public static void main(String[] args) {
        FindKthLargest9 findKthLargest = new FindKthLargest9();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int result = findKthLargest.findKthLargest(nums, k);
        System.err.println(result);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            minHeap.add(num);
        }
        while (--k > 0) {
            minHeap.poll();
        }

        return minHeap.peek();

    }

}
