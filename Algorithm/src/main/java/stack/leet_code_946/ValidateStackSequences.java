package stack.leet_code_946;

import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/4 23:04
 * @Desc : 946： https://leetcode-cn.com/problems/validate-stack-sequences/
 * 题解：https://leetcode-cn.com/problems/validate-stack-sequences/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-23/
 * <p>
 * 示例：
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 说白了，就是给你一个数组，通过push 和 pop 两个操作，pop出来的值，依次放到数组里，和数组 popped 一样；
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int j : pushed) {
            stack.push(j);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }

        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences3(int[] pushed, int[] popped) {
        if (pushed.length != popped.length) {
            return false;
        }
        int index = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }

        return stack.isEmpty();
    }



}
