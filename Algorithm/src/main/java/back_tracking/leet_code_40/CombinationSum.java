package back_tracking.leet_code_40;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/24 20:59
 * @Url :
 * @Level :    medium
 * @Desc : 组合总和2
 * @Counter :
 * @Answer :
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) return res;
        //  do a sort ---core operation
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
            // 当前的值
            int currVale = candidates[i];
            // 剩下的值
            int rest = target - currVale;
            // 大减枝
            if (rest < 0) {
                break;
            }
            // 小减法：同一层相同数值的结点，从第2个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && currVale == candidates[i - 1]) {
                continue;
            }
            path.addLast(currVale);
            dfs(candidates, len, i + 1, rest, path, res);
            path.removeLast();

        }
    }
}
