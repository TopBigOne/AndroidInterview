package top_k.offer_41;

import java.util.PriorityQueue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/8 16:13
 * @Desc : 数据流中的中位数
 * <p>
 * <p>
 * 题解：https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof/solution/dai-tu-xiang-jie-jian-zhi-offer-41-shu-j-y3d6/
 */
public class MedianFinder {

    // 大顶堆存储较小一半的值
    PriorityQueue<Integer> maxHeap;
    // 小顶堆存储较大一般的值
    PriorityQueue<Integer> minHeap;


    /**
     * 大顶堆的每个节点的值大于等于左右孩子节点的值: 堆顶为最大值。
     * 小顶堆的每个节点的值小于等于左右孩子节点的值: 堆顶为最小值。
     */
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((x, y) -> (y - x));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // 长度为奇数时先放入小顶堆,重新排序后在插入到大顶堆
        if (maxHeap.size() != minHeap.size()) {
            minHeap.add(num);
            int minValue = minHeap.poll();
            maxHeap.add(minValue);
        } else {
            // 长度为偶数时先放入大顶堆,重新排序后在插入到小顶堆
            maxHeap.add(num);
            int maxValue = maxHeap.poll();
            minHeap.add(maxValue);
        }
    }

    public double findMedian() {
        if (maxHeap.size() != minHeap.size()) {
            return minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }


    }
}
