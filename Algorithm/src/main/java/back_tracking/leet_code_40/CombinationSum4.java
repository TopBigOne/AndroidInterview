package back_tracking.leet_code_40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/11 21:45
 * @Desc :
 */
public class CombinationSum4 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    private void dfs(int[] candidates, int len, int beigin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = beigin; i < len; i++) {

            int currValue = candidates[i];
            int rest = target - currValue;
            if (rest < 0) {
                break;
            }
            // 去重
            if (i > beigin && currValue == candidates[i - 1]) {
                continue;
            }
            path.addLast(currValue);
            dfs(candidates, len, i + 1, rest, path, res);
            path.removeLast();

        }

    }


}
