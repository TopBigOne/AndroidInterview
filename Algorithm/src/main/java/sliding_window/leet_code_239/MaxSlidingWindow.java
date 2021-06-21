package sliding_window.leet_code_239;

import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  5/23/21 4:12 PM
 * @Desc : leetcode : 239 滑动窗口最大值,字节：9 次； hard:https://leetcode-cn.com/problems/sliding-window-maximum/submissions/
 * <p>
 * 是我的思维
 * 题解：https://leetcode-cn.com/problems/sliding-window-maximum/solution/dong-hua-yan-shi-dan-diao-dui-lie-239hua-hc5u/
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length;
        if (nums == null || (length = nums.length) == 0 || length < k || k < 1) {
            return null;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        // 结果数组
        int[] result = new int[nums.length - k + 1];
        // 遍历nums数组
        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[queue.peek()];
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k < 1 || len < k) {
            return null;
        }
        // 窗口个数
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            // 存储元素下标
            queue.addLast(right);
            // 计算窗口左侧边界
            int left = right - k + 1;
            // 当队首元素的下标小于滑动窗口左侧边界 left 时；
            // 表示队首元素已经不在滑动窗口内，因此将其从队首移除
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            // 由于数组下标是从 0 开始，因此窗口右边界 right+1 大于 等于 窗口大小 k 时
            // 意味着窗口形成，此时，队首元素就是该窗口内的最大值
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }

        }

        return res;

    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        // corner base;
        int len;
        if (nums == null || (len = nums.length) == 0 || k < 1 || len < k) {
            return null;
        }
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] >= queue.peekLast()) {
                queue.removeLast();
            }
            // 存储元素的下标
            queue.addLast(right);

            // 计算窗口左边界
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }

        }
        return res;

    }

    public int[] maxSlidingWindow4(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k < 1 || len < k) {
            return null;
        }
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            // store index in queue;
            queue.addLast(right);
            // calcute the left base bounder of window
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow5(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k < 1 || len < k) {
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[len - k + 1];
        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            // store index to queue
            queue.addLast(right);

            // calcute the left bounder of window;
            int left = right - k + 1;

            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }

        return res;
    }

    public int[] maxSlidingWindow6(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k < 1 || len < k) {
            return null;
        }
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }

        }
        return res;
    }

    public int[] maxSlidingWindow7(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || k < 1 || len < k) {
            return null;
        }
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);
            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }
            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    public int[] maxSlidingWindow8(int[] nums, int k) {
        int len;
        if (nums == null || (len = nums.length) == 0 || len < k || k < 1) {
            return null;
        }
        int[] res = new int[len - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        for (int right = 0; right < len; right++) {
            while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                queue.removeLast();
            }
            queue.addLast(right);

            int left = right - k + 1;
            if (queue.peekFirst() < left) {
                queue.removeFirst();
            }

            if (right + 1 >= k) {
                res[left] = nums[queue.peekFirst()];
            }
        }

        return res;

    }

}
