package back_tracking.leet_code_46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  7/8/21 1:46 AM
 * @Desc :  leet code 46 : 全排列 ：leet code  46: 字节：43 次  全排列：https://leetcode-cn.com/problems/permutations/
 * 题解： https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 */
public class Permute2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] useed = new boolean[len];
        dfs(nums, len, 0, path, useed, result);

        return result;

    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] useed, List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 这是一个优化；
            if (useed[i]) {
                continue;
            }
            path.addLast(nums[i]);
            useed[i] = true;
            dfs(nums, len, depth + 1, path, useed, result);
            path.removeLast();
            useed[i] = false;

        }
    }


}
