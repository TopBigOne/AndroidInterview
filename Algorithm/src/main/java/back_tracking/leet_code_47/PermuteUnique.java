package back_tracking.leet_code_47;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  5/27/21 10:29 PM
 * @Desc : leet code 47: 全排列：https://leetcode-cn.com/problems/permutations-ii/solution/
 * <p>
 * 题解：https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class PermuteUnique {


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }
        // 排序（升序或者降序都可以）为了剪枝方便
        Arrays.sort(nums);

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, len, 0, used, path, result);
        return result;
    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i>0 是为了保证 nums[i-1] 有意义
            // used[i-1] 是因为 nums[i-1] 在回退的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, path, res);
            used[i] = false;
            path.removeLast();
        }
    }



}
