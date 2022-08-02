package back_tracking.leet_code_39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 16:58
 * @Desc :
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        int[] candicates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = combinationSum.combinationSum(candicates, target);
        System.out.println("result : " + result);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, len, 0, path, target, res);
        return res;
    }

    private void dfs(int[] candidates, int len, int begin, Deque<Integer> path, int target, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = begin; j < len; j++) {
            int currValue = candidates[j];
            path.addLast(currValue);
            dfs(candidates, len, j, path, target - currValue, res);
            path.removeLast();
        }

    }
}
