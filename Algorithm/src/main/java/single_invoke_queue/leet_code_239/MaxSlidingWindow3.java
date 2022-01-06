package single_invoke_queue.leet_code_239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/1/3 20:11
 * @Desc :滑动窗口的最大值  ,单调队列
 * <p>
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * 原始解法
 */
public class MaxSlidingWindow3 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        MonotonicQueue window = new MonotonicQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                // 先填满，窗口的前k-1个
                window.push(nums[i]);
            } else {
                // 窗口向后滑动，加入新数字
                window.push(nums[i]);
                res.add(window.max());
                int deleteIndex = i - k + 1;
                window.pop(nums[deleteIndex]);
            }
        }

        return res.stream().mapToInt(value -> value).toArray();

    }


    static class MonotonicQueue {
        private LinkedList<Integer> q = new LinkedList<>();

        /**
         * 保证单调队列的 单调性
         *
         * @param n
         */
        public void push(int n) {
            //从后往前，不断的弹出
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }

            q.addLast(n);

        }

        public int max() {
            return q.getFirst();
        }

        /**
         * 移除n，这个元素
         *
         * @param n
         */
        public void pop(int n) {
            if (n == q.getFirst()) {
                q.pollFirst();
            }
        }

    }


}