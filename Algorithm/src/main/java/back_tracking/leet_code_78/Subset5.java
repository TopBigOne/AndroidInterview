package back_tracking.leet_code_78;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 21:16
 * @Desc :
 */
public class Subset5 {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, res);

        return res;

    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        dfs(nums, len, depth + 1, path, res);
        path.addLast(nums[depth]);
        dfs(nums, len, depth + 1, path, res);
        path.removeLast();
    }

}
