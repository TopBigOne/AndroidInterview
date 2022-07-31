package back_tracking.leet_code_78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 21:03
 * @Desc :
 */
public class Subset4 {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (len == 0) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, result);
        return result;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> result) {
        if (len == depth) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 不选择
        dfs(nums, len, depth + 1, path, result);

        // 选择
        path.addLast(nums[depth]);
        dfs(nums, len, depth + 1, path, result);
        path.removeLast();
    }
}
