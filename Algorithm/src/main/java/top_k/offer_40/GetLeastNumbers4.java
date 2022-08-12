package top_k.offer_40;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/12 18:36
 * @Desc :
 */
public class GetLeastNumbers4 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr == null || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.add(num);
                continue;
            }
            if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(num);
            }
        }

        return maxHeap.stream().mapToInt(a -> a).toArray();

    }
}
