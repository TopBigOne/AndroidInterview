package linked_list.offer_40;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/22 5:56 PM
 * @Desc :  最小的 k 个数 ： https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/solution/3chong-jie-fa-miao-sha-topkkuai-pai-dui-er-cha-sou/
 */
public class GetLeastNumbers2 {

    /**
     * 大根堆(前 K 小) /
     * 小根堆（前 K 大),Java中有现成的 PriorityQueue，实现起来最简单：O(NlogK)O(NlogK)
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        // 1: base coner
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int num : arr) {
            if (maxHeap.size() < k) {
                maxHeap.offer(num);
                continue;
            }
            if (num < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(num);
            }

        }
        // 返回堆中的元素

        List<Integer> list = new ArrayList<>(maxHeap);
        return list.stream().mapToInt(a -> a).toArray();

    }
}
