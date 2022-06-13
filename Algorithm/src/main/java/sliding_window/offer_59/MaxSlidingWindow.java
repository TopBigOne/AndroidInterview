package sliding_window.offer_59;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/11 14:02
 * @Desc :
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.err.println(Arrays.toString(result));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        Window window = new Window();
        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            if (i < k - 1) {
                window.add(currValue);

                continue;
            }
            window.add(currValue);
            res.add(window.getMax());
            int delIndex = i - k + 1;
            window.pop(nums[delIndex]);
        }

        return res.stream().mapToInt(a -> a).toArray();

    }

    static class Window {
        public Deque<Integer> queue = new ArrayDeque<>();

        public void add(int val) {
            while (!queue.isEmpty() && queue.pollLast() < val) {
                queue.pollLast();
            }
            queue.offerLast(val);
        }

        public void pop(int val) {
            if (!queue.isEmpty() && queue.peekFirst() == val) {
                queue.pollFirst();
            }
        }


        public int getMax() {
            if (queue.isEmpty()) {
                return -1;
            }
            return queue.getFirst();
        }
    }


}
