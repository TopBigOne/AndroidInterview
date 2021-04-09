package tree.leet_code_112;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/10/21 12:52 AM
 * @Desc :
 * <p>
 * 题解：https://leetcode-cn.com/problems/path-sum/solution/shu-ju-jie-gou-he-suan-fa-3chong-fang-sh-9zp1/
 * <p>
 * 我们从根节点到叶子节点的所有路径中，有没有和等于 sum 的。
 * 我们可以从根节点往下走，走的时候减去当前节点的值，一直到叶子节点，如果减到最后，值等于叶子节点的值，说明存在这样的结果，直接返回 true；
 * 否则，如果把所有节点都遍历完了，也不存在这样的结果，就返回 false
 * <p>
 * 解法：用递归；ps:这是我见过最好理解的递归了；
 */
public class HasPathSum2 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    public boolean hasPathSum3(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
        return hasPathSum3(root.left, sum - root.val) || hasPathSum3(root.right, sum - root.val);
    }


}
