package array.leet_code_215;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/22 8:54 PM
 * @Desc :
 */
public class FindKthLargest8 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        FindKthLargest8 findKthLargest = new FindKthLargest8();
        int reuslt = findKthLargest.findKthLargest(nums, k);
        System.out.println("result : " + reuslt);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            Integer peek = minHeap.peek();
            if (peek < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        return minHeap.poll();
    }

}
