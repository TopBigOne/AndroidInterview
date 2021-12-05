package single_invoke_stack.leet_code_456;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/21 22:17
 * @Desc : 132 模式 （https://leetcode-cn.com/problems/132-pattern/） 和503类似
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 * 视频：https://www.bilibili.com/video/BV1SZ4y1x74J?from=search&seid=532580104179757539
 */
public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[length];
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[length];
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;

    }

    public boolean find132pattern3(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int[] min = new int[length];
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        for (int j = length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }

        }

        return false;
    }

    public boolean find132patttern4(int[] nums) {
        int length = nums.length;
        if (length < 3) {
            return false;
        }
        int[] min = new int[length];
        Stack<Integer> stack = new Stack<>();
        min[0] = nums[0];
        for (int i = 1; i < length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int j = length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }


}
