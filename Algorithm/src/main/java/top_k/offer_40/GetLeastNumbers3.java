package top_k.offer_40;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 15:37
 * @Desc :最小的k个数：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 */
public class GetLeastNumbers3 {

    public int[] getLeastNumbers(int[] arr, int k) {
        // 1: base coner
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> a - b);

        for (int i : arr) {
            if (maxHeap.size() < k) {
                maxHeap.add(i);
                continue;
            }
            if (i < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.add(i);
            }
        }
        return maxHeap.stream().mapToInt(a -> a).toArray();

    }
}
