package single_invoke_stack.leet_code_503;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/6/21 8:14 PM
 * @Desc : 下一个更大元素2（https://leetcode-cn.com/problems/next-greater-element-ii/）
 * 题解：https://leetcode-cn.com/problems/next-greater-element-ii/solution/dong-hua-jiang-jie-dan-diao-zhan-by-fuxu-4z2g/
 * <p>
 * https://leetcode-cn.com/problems/next-greater-element-ii/solution/cong-po-su-jie-fa-de-jiao-du-qu-li-jie-d-trht/
 */
public class NextGreaterElement {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < (n << 1); i++) {
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return res;
    }

    /**
     * 建立一个栈，来存储下标值，我们用max_index来记录最大元素第一次出现的下标。
     * 遍历数组，当前元素（nums[i]）大于nums[栈顶]，
     * 那么不断出栈（直到nums[栈顶]不小于当前元素nums[i]），
     * 出栈元素表示的数的下一个更大的元素即为当前遍历的元素(即：nums[pop()]=nums[i])。
     * 【这样每次出栈元素表示的数（nums[pop()]）总是递增的】
     * 遍历结束后，不在栈中的索引值，都找到了下一个最大的元素，栈肯定不空（至少包含最大元素的下标）。
     * 于是我们要将栈中剩下的数也要解决掉，栈中由顶至底所对应数组中的数是递增的，那么通过比较nums[max_index]和nums[栈顶]，
     * 可以将栈中非最大索引给解决掉。
     * 那么栈中剩下的就是最大元素的索引，它们表示的数的下一个更大元素不存在。
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements2(int[] nums) {
        int len = nums.length;
        if (len == 0) return new int[0];
        Stack<Integer> st_index = new Stack<>();
        int[] ans = new int[len];
        int max_index = 0;
        for (int i = 0; i < len; i++) {
            while (!st_index.isEmpty() && nums[st_index.peek()] < nums[i]) {
                ans[st_index.pop()] = nums[i];
            }
            st_index.push(i);
            if (nums[i] > nums[max_index]) max_index = i;
        }

        while (nums[max_index] > nums[st_index.peek()]) {
            int t = st_index.pop();
            for (int i = 0; i <= max_index; i++) {
                if (nums[i] > nums[t]) {
                    ans[t] = nums[i];
                    break;
                }
            }
        }
        while (!st_index.isEmpty()) ans[st_index.pop()] = -1;
        return ans;

    }

    public int[] nextGreaterElements3(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        if (len == 0) return ans;
        Stack<Integer> stIndex = new Stack<>();
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            while (!stIndex.isEmpty() && nums[stIndex.peek()] < nums[i]) {
                ans[stIndex.pop()] = nums[i];
            }
            stIndex.push(i);
            if (nums[i] > nums[maxIndex]) maxIndex = i;
        }

        while (nums[maxIndex] > nums[stIndex.peek()]) {
            int t = stIndex.pop();
            for (int i = 0; i <= maxIndex; i++) {
                if (nums[i] > nums[t]) {
                    ans[t] = nums[i];
                    break;
                }
            }
        }
        while (!stIndex.isEmpty()) ans[stIndex.pop()] = -1;
        return ans;
    }

    public int[] nextGreaterElements4(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Stack<Integer> indexStack = new Stack<>();
        int maxIndex = 0;
        for (int i = 0; i < len; i++) {
            while (!indexStack.isEmpty() && nums[indexStack.peek()] < nums[i]) {
                result[indexStack.pop()] = nums[i];
            }

            indexStack.push(i);
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }

        }

        while (nums[maxIndex] > nums[indexStack.peek()]) {
            int t = indexStack.pop();
            for (int i = 0; i <= maxIndex; i++) {
                if (nums[i] > nums[t]) {
                    result[t] = nums[i];
                    break;
                }
            }
        }
        while (!indexStack.isEmpty()) {
            result[indexStack.pop()] = -1;
        }
        return result;
    }


    public int[] nextGreaterElements5(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < len << 1; i++) {
            while (!d.isEmpty() && nums[i % len] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % len];
            }
            d.addLast(i % len);

        }
        return result;

    }

    public int[] nextGreaterElements6(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < len << 1; i++) {
            while (!d.isEmpty() && nums[i % len] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % len];
            }
            d.addLast(i % len);
        }
        return result;
    }

    public int[] nextGreaterElements7(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < len << 1; i++) {
            while (!d.isEmpty() && nums[i % len] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % len];
            }
            d.addLast(i % len);
        }
        return result;
    }

    public int[] nextGenerateElements8(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < len << 1; i++) {
            while (!d.isEmpty() && nums[i % len] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % len];
            }
            d.addLast(i % len);

        }
        return result;

    }

    public int[] nextGenerateElements9(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < len << 1; i++) {
            while (!d.isEmpty() && nums[i % len] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % len];
            }
            d.addLast(i % len);
        }

        return result;
    }

    public int[] nextGenerateElements10(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < length << 1; i++) {
            while (!d.isEmpty() && nums[i % length] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % length];
            }
            d.addLast(i % length);
        }
        return result;
    }

    public int[] nextGenerateElements11(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < length << 1; i++) {
            while (!d.isEmpty() && nums[i % length] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % length];
            }
            d.addLast(i % length);
        }

        return result;
    }

    public int[] nextGenerateElements12(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < length << 1; i++) {
            while (!d.isEmpty() && nums[i % length] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % length];
            }
            d.addLast(i % length);
        }
        return result;
    }

    public int[] nextGreaterElements13(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Deque<Integer> d = new ArrayDeque<>(16);
        for (int i = 0; i < length << 1; i++) {
            while (!d.isEmpty() && nums[i % length] > nums[d.peekLast()]) {
                int u = d.pollLast();
                result[u] = nums[i % length];
            }
            d.addLast(i % length);
        }
        return result;
    }

    public int[] nextGreaterElement14(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        Arrays.fill(result, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length << 1; i++) {
            while (!stack.isEmpty() && nums[i % length] > nums[stack.peekLast()]) {
                int u = stack.pollLast();
                result[u] = nums[i % length];
            }
            stack.addLast(i % length);
        }
        return result;
    }

    public int[] nextGreaterElement15(int[] nums) {
        int length = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[length];
        Arrays.fill(result, -1);
        for (int i = 0; i < length<<1; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i % length]) {
                int u = stack.pollLast();
                result[u] = nums[i % length];

            }
            stack.addLast(i % length);

        }
        return result;

    }


}
