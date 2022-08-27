package top_k.leet_code_215;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/29 22:11
 * @Desc :
 */
public class FindKthLargest10 {
    public static void main(String[] args) {
        FindKthLargest10 findKthLargest = new FindKthLargest10();
        // 3,2,1,5,6,4
        // int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        // int k = 4;
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthLargest.findKthLargest(nums, k);
        System.err.println("result : " + result);
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
                continue;
            }

            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        return minHeap.peek();
    }
}
