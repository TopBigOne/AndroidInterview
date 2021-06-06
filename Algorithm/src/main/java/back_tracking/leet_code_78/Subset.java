package back_tracking.leet_code_78;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  6/6/21 5:21 PM
 * @Desc : leet code 78: 子集：字节：15 次：https://leetcode-cn.com/problems/subsets/
 *
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
}
