package top_k.offer_41;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 16:42
 * @Desc :
 */
public class MedianFinder2 {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> b - a);


    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            return;
        }
        minHeap.add(num);
        maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        return minHeap.peek();
    }

    public void addNum2(int num) {
        if (maxHeap.size() == minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            return;
        }
        minHeap.add(num);
        maxHeap.add(minHeap.poll());

    }

    public void addNum3(int num) {
        if(minHeap.size()==maxHeap.size()){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            return;
        }
        minHeap.add(num);
        maxHeap.add(minHeap.poll());


    }
}
