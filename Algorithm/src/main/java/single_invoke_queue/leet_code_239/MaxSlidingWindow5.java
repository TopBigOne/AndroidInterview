package single_invoke_queue.leet_code_239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import sun.awt.geom.AreaOp;

/**
 * @author : dev
 * @version :
 * @Date :  2022/1/3 22:51
 * @Desc :
 */
public class MaxSlidingWindow5 {
    int[] maxSlidingWindow(int[] nums, int k) {
        Window window = new Window();
        List<Integer> res = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int currValue = nums[i];
            if (i < k - 1) {
                window.push(currValue);
                continue;
            }
            window.push(currValue);
            res.add(window.getMax());
            window.pop(nums[i - k + 1]);

        }
        return res.stream().mapToInt(v -> v).toArray();

    }


    static class Window {
        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }


        public int getMax() {
            return queue.getFirst();
        }

        public void pop(int n) {
            if (n == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }
}
