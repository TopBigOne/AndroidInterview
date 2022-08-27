package top_k.offer_41;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/27 15:08
 * @Desc :
 */
public class MedianFinder3 {


    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() == maxHeap.size() + 1) {
            maxHeap.add(minHeap.poll());
        }
    }


    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return maxHeap.peek();
    }


}
