package back_tracking.leet_code_40;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/24 22:12
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len;
        if ((len = candidates.length) == 0) {
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    /**
     * @param candidates 数据
     * @param len        数组长度
     * @param begin      开始遍历的下标
     * @param target     要匹配的目标值
     * @param path       符合结果的路径
     * @param res        结果
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            int currValue = candidates[i];
            int rest = target - currValue;
            if (rest < 0) {
                break;
            }
            if (i > begin && currValue == candidates[i - 1]) {
                continue;
            }
            path.addLast(currValue);
            dfs(candidates, len, i + 1, rest, path, res);
            path.removeLast();

        }
    }
}
