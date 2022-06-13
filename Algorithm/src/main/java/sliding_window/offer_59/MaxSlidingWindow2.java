package sliding_window.offer_59;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/11 14:56
 * @Desc :
 */
public class MaxSlidingWindow2 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Window window = new Window();
        List<Integer> res = new ArrayList<>();


        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (i < k - 1) {
                window.addLast(val);
                continue;
            }
            window.addLast(val);
            res.add(window.getMax());
            window.pop(nums[i - k + 1]);

        }
        return res.stream().mapToInt(a -> a).toArray();


    }

    static class Window {

        Deque<Integer> queue = new ArrayDeque<>();

        public void addLast(int val) {
            while (!queue.isEmpty() && queue.peekLast() < val) {
                queue.pollLast();
            }
            queue.addLast(val);
        }

        public int getMax() {
            if (queue.isEmpty()) {
                return -2;
            }
            return queue.peekFirst();
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
