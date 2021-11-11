package back_tracking.leet_code_216;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/7 23:22
 * @Url : https://leetcode-cn.com/problems/combination-sum-iii/
 * @Level :    medium
 * @Desc : 组合总和 III ： 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/combination-sum-iii/solution/hui-su-jian-zhi-by-liweiwei1419/
 */
public class CombinationSum3 {

    /**
     * 先画出递归树，帮助分析；
     * 代码实现，即使用 深度优先遍历，搜索 所有 可能的解（因为是遍历，所以可以得到所有的解）；
     * 注意 状态重置（恢复现场，以免出错）和 剪枝（避免不必要的搜索消耗时间），这一步没有技巧，根据一些特殊用例， 画图帮助分析，看清剪枝和结算的条件 。
     *
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        // 一开始做一些特殊判断
        if (k <= 0 || n <= 0 || k > n) {
            return res;
        }
        // 寻找n的上限：[9,8,...,(9-k+1) ],他们的和为(19 - k)*k/2
        // 比上限还大，就不用搜索了。
        if (n > (19 - k) * k / 2) {
            return res;
        }

        // 根据官方对 Stack 的使用建议，这里将Deque对象当做stack使用
        Deque<Integer> path = new ArrayDeque<>();
        dfs(k, n, 1, path, res);
        return res;
    }

    /**
     * @param k       剩下要找k个数
     * @param residue 剩余多少
     * @param start   下一轮搜索的起始元素是多少
     * @param path    深度优先遍历的路径参数（状态变量）
     * @param res     保存结果集的列表
     */
    private void dfs(int k, int residue, int start, Deque<Integer> path, List<List<Integer>> res) {
        if (10 - start < k) {
            return;
        }
        if (k == 0) {
            if (residue == 0) {
                res.add(new ArrayList<>(path));
                return;
            }
        }

        // 枚举起点值[....,7,8,9]
        // 找3个数，起点最多到 7 ；
        // 找2个数，起点最多到8 ；
        // 规律是：起点上界 +k = 10 ,故起点上界 = 10 -k;
        for (int i = start; i <= 10 - k; i++) {
            // 减枝
            if (residue - i < 0) {
                break;
            }

            path.addLast(i);
            dfs(k - 1, residue - i, i + 1, path, res);
            path.removeLast();
        }
    }


}
