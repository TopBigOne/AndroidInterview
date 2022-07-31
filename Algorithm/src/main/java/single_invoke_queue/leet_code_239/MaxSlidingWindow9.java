package single_invoke_queue.leet_code_239;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 12:25
 * @Desc :
 */
public class MaxSlidingWindow9 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        List<Integer> res = new ArrayList<>();
        Window window = new Window();
        for (int i = 0; i < nums.length; i++) {
            int currVal = nums[i];
            if (i < k - 1) {

                window.push(currVal);
                continue;
            }
            window.push(currVal);
            res.add(window.getMax());

            window.pop(nums[i - k + 1]);
        }
        return res.stream().mapToInt(v -> v).toArray();


    }

    static class Window {
        Deque<Integer> queue = new ArrayDeque<>();

        public void push(int val) {
            while (!queue.isEmpty() && queue.peekLast() < val) {
                queue.pollLast();
            }
            queue.offerLast(val);
        }

        public int getMax() {
            if (queue.isEmpty()) {
                return Integer.MIN_VALUE;
            }
            return queue.getFirst();
        }

        public void pop(int val) {
            if (queue.isEmpty()) {
                return;
            }
            if (queue.peekFirst() == val) {
                queue.pollFirst();
            }
        }
    }
}
