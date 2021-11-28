package tree.leet_code_437;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/28 22:19
 * @Url : https://leetcode-cn.com/problems/path-sum-iii/
 * @Level :    medium
 * @Desc : 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @Counter : 3
 * @Answer :https://leetcode-cn.com/problems/path-sum-iii/solution/qian-zhui-he-di-gui-hui-su-by-shi-huo-de-xia-tian/
 * <p>
 * 解法： 前缀和
 */
public class PathSum {

    public int pathSum(TreeNode root, int targetSum) {
        // key是前缀和，value 是大小为key的前缀和出现的次数
        Map<Integer, Integer> preFixSumSort = new HashMap<>();
        // 前缀和为0的一条路径
        preFixSumSort.put(0, 1);
        // 前缀和 的递归 回溯思路
        return recursionPathSum(root, preFixSumSort, targetSum, 0);
    }

    /**
     * 前缀和 的递归回溯思路
     * 从当前节点反推到根节点（反推比较好理解，正向其实也是有一条）有且仅有一条路径，因为这是一棵树
     * <p>
     * 如果此前有喝和为 currSum - target ,而当前的和又为currSum ,两者的差肯定为target 了；
     * 所以前缀和对于当前路径来说是唯一的，当前记录的前缀和，在回溯结束，回到本层时，去除，保证其不影响其他分支的结果
     *
     * @param node           树节点
     * @param preFixSumCount 前缀和map
     * @param target         目标值
     * @param currSum        当前路径和
     * @return 满足题意的题解
     */
    private int recursionPathSum(TreeNode node, Map<Integer, Integer> preFixSumCount, int target, int currSum) {
        if (node == null) {
            return 0;
        }
        // 2: 本层要做的事情
        int res = 0;
        // 当前路径上的和
        currSum += node.val;

        // ----- 核心代码--start
        // 看看root 当前节点这条路上是否存在节点前缀和 加 target 为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum - target ,
        // 而当前的和又为currSum ,两者的差就肯定为target了；
        // currSum - target 相当于找路劲的起点，起点的sum+target = currSum , 当前点到起点的距离就是target
        res += preFixSumCount.getOrDefault(currSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        preFixSumCount.put(currSum, preFixSumCount.getOrDefault(currSum, 0) + 1);
        // ----- 核心代码--end

        // 3. 进入下一层
        res += recursionPathSum(node.left, preFixSumCount, target, currSum);
        res += recursionPathSum(node.right, preFixSumCount, target, currSum);
        // 4. 回到本层，恢复状态，去除当前节点的前缀和数量
        preFixSumCount.put(currSum, preFixSumCount.get(currSum) - 1);


        return res;
    }



}
