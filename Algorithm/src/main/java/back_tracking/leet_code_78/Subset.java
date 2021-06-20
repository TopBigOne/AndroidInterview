package back_tracking.leet_code_78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  6/6/21 5:21 PM
 * @Desc : leet code 78: 子集：字节：15 次：https://leetcode-cn.com/problems/subsets/
 * <p>
 * 题解：
 * 1： weiwei：https://leetcode-cn.com/problems/subsets/solution/hui-su-python-dai-ma-by-liweiwei1419/
 */
public class Subset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Subset subset = new Subset();
        List<List<Integer>> result = subset.subsets(nums);
        System.out.println("result : " + result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        dfs(nums, 0, len, stack, res);
        return res;
    }

    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        dfs2(nums, 0, len, stack, res);
        return res;

    }

    private void dfs(int[] nums, int index, int len, Stack<Integer> stack, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
            // 递归的终止条件
            return;
        }
        // 当前数可选，也可不选
        stack.add(nums[index]);
        dfs(nums, index + 1, len, stack, res);

        stack.pop();

        // 不选，直接进入下一层
        dfs(nums, index + 1, len, stack, res);
    }

    private void dfs2(int[] nums, int index, int len, Deque<Integer> stack, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
            // 递归的终止条件
            return;
        }
        // 当前数可选，也可不选
        stack.add(nums[index]);// 添加了，别忘记 pop
        dfs2(nums, index + 1, len, stack, res);
        stack.pop();

        // 不选，直接进入下一层
        dfs2(nums, index + 1, len, stack, res);
    }

    private void dfs3(int[] nums, int index, int len, Stack<Integer> stack, List<List<Integer>> res) {
        if (len == index) {
            // 牛 b 不，stack，能直接变成 array；stack.toArray();
            res.add(new ArrayList<>(stack));
            return;
        }

        stack.add(nums[index]);
        dfs3(nums, index + 1, len, stack, res);
        stack.pop();

        // 不选，直接进入下一层；
        dfs3(nums, index + 1, len, stack, res);

    }


}
