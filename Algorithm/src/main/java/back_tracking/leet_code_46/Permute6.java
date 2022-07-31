package back_tracking.leet_code_46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 22:01
 * @Desc :
 */
public class Permute6 {
    public static void main(String[] args) {
        Permute6 permute = new Permute6();

        int[] nums = {1, 2, 3};
        List<List<Integer>> result = permute.permute(nums);
        System.out.println("result :"+result);

    }

    /**
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, len, 0, used, path, res);

        return res;

    }

    private void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, len, depth + 1, used, path, res);
            used[i] = false;
            path.removeLast();
        }


    }


}
