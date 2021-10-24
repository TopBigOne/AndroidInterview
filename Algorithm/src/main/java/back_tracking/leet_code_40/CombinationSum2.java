package back_tracking.leet_code_40;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/23 23:28
 * @Url : https://leetcode-cn.com/problems/combination-sum-ii/
 * @Level :  easy  medium hard
 * @Desc :  给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 注意：解集不能包含重复的组合。 
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }
        // 关键 step
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param len        冗余变量
     * @param begin      候选数组的begin位置开始搜索
     * @param target     表示剩余，这个值一开始等于target ，基于题目中说明的 所有数字，(包括目标数) 都熟正整数，这个条件
     * @param path       从根结点到叶子节点的路径
     * @param res        结果
     */
    private void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 当前的值
            int currValue = candidates[i];
            // 剩下的值
            int rest = target - currValue;
            // 大剪枝：减去candidates[i] 小于 0 ，减去后面的 candidates[i+1], candidates[i+2] 肯定也小于0，因此用break
            if (rest < 0) {
                break;
            }
            // 小减枝： 同一层相同数值的结点，从第2个开始，候选数更少，结果一定发生重复，因此跳过，用continue;
            if (i > begin && currValue == candidates[i - 1]) {
                continue;
            }
            path.addLast(currValue);
            //  调用语句1：
            System.out.println("递归之前 => " + path + ",剩余=" + rest);
            // 因为元素不可以用重复使用，这里递归传递下去的是i+1 ,而不是i
            dfs(candidates, len, i + 1, rest, path, res);
            path.removeLast();
            // 调用语句2：
            System.out.println("递归之后 =>" + path + ", 剩余 = " + rest);
        }
    }



}
