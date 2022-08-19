package back_tracking.leet_code_40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/19 11:37
 * @Desc :
 * * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * * 输出:
 * * [
 * * [1,1,6],
 * * [1,2,5],
 * * [1,7],
 * * [2,6]
 * * ]
 */
public class CombinationSum6 {
    public static void main(String[] args) {
        CombinationSum6 combinationSum = new CombinationSum6();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> result = combinationSum.combinationSum2(nums, 8);
        System.err.println(result);

    }


    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len;
        if (candidates == null || (len = candidates.length) == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();

        dfs(candidates, len, 0, target, path, res);

        return res;

    }

    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            int reset = target - candidates[i];
            // base case
            if (reset < 0) {
                break;
            }
            if (begin < i) {
                System.out.println("begin : " + begin);
                System.out.println("i     : " + i);
                System.out.println("-----------------|");
            }

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (begin < i && candidates[i - 1] == candidates[i]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, i + 1, reset, path, res);
            path.removeLast();
        }
    }

}
