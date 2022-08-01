package tree.leet_code_101;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 16:38
 * @Desc : 101. 对称二叉树 ：https://leetcode.cn/problems/symmetric-tree/
 */
public class Symmetric3 {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }


}
