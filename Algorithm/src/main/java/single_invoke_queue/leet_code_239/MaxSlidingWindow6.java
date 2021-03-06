package single_invoke_queue.leet_code_239;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/29 17:39
 * @Url :   https://leetcode-cn.com/problems/sliding-window-maximum/submissions/
 * @Level :  easy  medium hard
 * @Desc : leetcode : 239 滑动窗口最大值,字节：9 次；
 * @Counter :
 * @Answer :
 */
public class MaxSlidingWindow6 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Window window = new Window();
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int currValue = nums[i];
            if (i < k - 1) {
                window.push(currValue);
                continue;
            }
            window.push(currValue);
            // 获取最大值
            res.add(window.getMax());
            // 弹出队列头部的值
            window.pop(nums[i - k + 1]);
        }
        return res.stream().mapToInt(v -> v).toArray();
    }


    private static class Window {
        // 这个队列，从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            // n 比最后一个值大，最后一个值就弹出
            while (!queue.isEmpty() && n > queue.getLast()) {
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
