package top_k.leet_code_703;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 18:25
 * @Desc :数据流中的第 K 大元素
 */
public class KthLargest {
    public static void main(String[] args) {

        int k = 2;
        int[] nums = {0};
        KthLargest kthLargest = new KthLargest(k, nums);
        // [[2,[0]],[-1],[1],[-2],[-4],[3]]
        int result = kthLargest.add(-1); // -3
        System.err.println("result :" + result);

        result = kthLargest.add(1); // -2
        System.err.println("result :" + result);

        result = kthLargest.add(-2); //
        System.err.println("result :" + result);
        result = kthLargest.add(-4);
        System.err.println("result :" + result);
        result = kthLargest.add(3);
        System.err.println("result :" + result);

        // [,-1,0,0,0,1]

    }

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k = 0;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            if (minHeap.size() < k) {
                minHeap.add(num);
                continue;
            }

            if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(num);
            }

        }
    }

    public int add(int val) {
        // case 1:
        if (minHeap.isEmpty()) {
            minHeap.add(val);
            return minHeap.peek();
        }

        // case 2:
        if (minHeap.size() < k) {
            minHeap.add(val);
            return minHeap.peek();
        }

        // case 3:
        if (val > minHeap.peek() && minHeap.size() >= k) {
            minHeap.poll();
            minHeap.add(val);
        }
        return minHeap.peek();

    }


}
