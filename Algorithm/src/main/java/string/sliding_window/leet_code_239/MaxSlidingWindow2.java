package string.sliding_window.leet_code_239;

import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  6/7/21 11:31 PM
 * @Desc : leetcode : 239 滑动窗口最大值,字节：9 次； hard:https://leetcode-cn.com/problems/sliding-window-maximum/submissions/
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 *
 * <p>
 * 是我的思维
 * 题解：https://leetcode-cn.com/problems/sliding-window-maximum/solution/dong-hua-yan-shi-dan-diao-dui-lie-239hua-hc5u/
 */
public class MaxSlidingWindow2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = 0;
        // 1: corner base
        if (nums == null || (length = nums.length) == 0 || length < k || k < 1) {
            return null;
        }
        // 2:双向队列，，保存当前窗口最大值数组的位置，保证队列中数组位置的数值，从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();
        // 3: 定义一个数组，承载结果
        int[] result = new int[length - k + 1];
        for (int i = 0; i < length; i++) {
            // 4： 保证从大到小，如果前面的数小，则一次弹出，直至满足结果
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 5：添加当前值所对应的下标
            queue.addLast(i);
            // 6：判断当前队列中，队首的值，是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 7：当窗口为 k 时，保存当前窗口最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int length;
        // 1: corner base;
        if (nums == null || (length = nums.length) == 0 || k < 1 || length < k) {
            return nums;
        }
        // 2: 双向队列，从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();
        // 3: 结果
        int[] result = new int[length - k + 1];
        for (int right = 0; right < length; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                result[left] = nums[queue.peekFirst()];
            }
        }

        return result;

    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int length;
        // 1: corner base;
        if (nums == null || (length = nums.length) == 0 || k < 1 || length < k) {
            return nums;
        }
        // 2: 双向队列，从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();
        // 3: 结果
        int[] result = new int[length - k + 1];
        for (int right = 0; right < length; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                result[left] = nums[queue.peekFirst()];
            }
        }


        return result;

    }

    public int[] maxSlidingWindow4(int[] nums, int k) {
        int length;
        // 1: corner base;
        if (nums == null || (length = nums.length) == 0 || k < 1 || length < k) {
            return nums;
        }
        // 2: 双向队列，从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();
        // 3: 结果
        int[] result = new int[length - k + 1];

        for (int right = 0; right < length; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);

            int left = right - k + 1;

            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            if (right + 1 >= k) {
                result[left] = nums[queue.peekFirst()];
            }

        }
        return result;

    }

    public int[] maxSlidingWindow5(int[] nums, int k) {
        int length;
        // 1: corner base;
        if (nums == null || (length = nums.length) == 0 || k < 1 || length < k) {
            return nums;
        }
        // 2: 双向队列，从大到小排列
        LinkedList<Integer> queue = new LinkedList<>();
        // 3: 结果
        int[] result = new int[length - k + 1];

        for (int right = 0; right < nums.length; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                result[left] = nums[queue.peekFirst()];
            }
        }


        return result;

    }


}
