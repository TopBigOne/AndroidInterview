package back_tracking.leet_code_47;


import java.util.*;

/**
 * @author : dev
 * @version :
 * @Date :  2022/3/7 11:34
 * @Desc : leet code 47: 全排列：https://leetcode-cn.com/problems/permutations-ii/solution/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 *
 * <p>
 * 题解：https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class PermuteUnique2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int len;
        if (nums == null || (len = nums.length) == 0) {
            return result;
        }
        // 做一个排序。为了剪枝方便；
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, path, used, result);
        return result;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (depth == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            path.addLast(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, path, used, result);
            used[i] = false;
            path.removeLast();
        }
    }
}
