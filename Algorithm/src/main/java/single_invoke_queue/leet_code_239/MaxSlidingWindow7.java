package single_invoke_queue.leet_code_239;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * @author :  dev
 * @version :
 * @Date :   2022/3/31 13:40
 * @Url :   https://leetcode-cn.com/problems/sliding-window-maximum/submissions/
 * @Level :  easy  medium hard
 * @Desc : leetcode : 239 滑动窗口最大值,字节：9 次；
 * @Counter :
 * @Answer :
 */
public class MaxSlidingWindow7 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 5,3,6,8,4,2,7    ; k = 2; length = 7
        // 53 36 68 84 42 27  l =6
        // 536 368 684 842 427     7-4+1
        List<Integer> res = new ArrayList<>();
        Window window = new Window();
        for (int i = 0; i < nums.length; i++) {
            int currValue = nums[i];
            if (i < k - 1) { // k-1 = 2
                window.push(currValue);
                continue;
            }
            window.push(currValue);
            res.add(window.getMax());
            window.pop(nums[i - k + 1]);
        }
        return res.stream().mapToInt(a -> a).toArray();
    }


    static class Window {
        Deque<Integer> queue = new LinkedList<>();

        public void push(int n) {
            while (!queue.isEmpty() && n > queue.getLast()) {
                queue.pollLast();
            }
            // 从尾部添加
            queue.addLast(n);

        }

        public int getMax() {
            return queue.getFirst();
        }

        public void pop(int n) {
            if (!queue.isEmpty() && queue.getFirst() == n) {
                queue.pollFirst();
            }
        }
    }
}
