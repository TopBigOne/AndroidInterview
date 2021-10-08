package stack.single_invoke_stack.leet_code_1673;

import java.util.Stack;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/26 23:09
 * @Url :  https://leetcode-cn.com/problems/find-the-most-competitive-subsequence/
 * @Level :    medium
 * @Desc : 给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/find-the-most-competitive-subsequence/solution/java-dan-diao-zhan-by-thedesalizes/
 */
public class MostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 当前元素比队尾元素小，将队尾元素出栈
            // 此处需要另外判断数组剩余长度够不够填满栈，不然最后答案长度可能会小于k
            int currNum = nums[i];
            while (currNum < stack.peek() && k - stack.size() + 1 < len - i) {
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.add(currNum);
            }
        }
        int[] ret = new int[k];
        while (k > 0) {
            ret[--k] = stack.pop();
        }
        return ret;
    }

    public int[] mostCompetitive2(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int currNum = nums[i];
            while (currNum < stack.peek() && k - stack.size() + 1 < len - i) {
                stack.pop();
            }
            if (stack.size() < k + 1) {
                stack.add(currNum);
            }
        }

        int[] ret = new int[k];
        while (k > 0) {
            ret[--k] = stack.pop();
        }
        return ret;
    }
}


