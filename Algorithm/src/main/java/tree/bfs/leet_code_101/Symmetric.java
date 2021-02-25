package tree.bfs.leet_code_101;

import java.util.Objects;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/18/21 11:21 PM
 * @Desc : 对称的二叉树 （https://leetcode-cn.com/problems/symmetric-tree/solution/）
 * Symmetric ：/si'metrik/ ： 对称性
 * 题解：https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
 */
public class Symmetric {
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
        if (!Objects.equals(left.val, right.val)) {
            return false;
        }
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    private boolean dfs2(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (!Objects.equals(left.val, right.val)) {
            return false;
        }

        // 左子树的左节点，和右子树的右节点，是否相等？
        // 左子树的右节点，和右子树的左节点，是否相等？
        return dfs2(left.left, right.right) && dfs2(left.right, right.left);
    }

    private boolean dfs3(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (!Objects.equals(left.val, right.val)) {
            return false;
        }

        return dfs3(left.left, right.right) && dfs3(left.right, right.left);
    }

}
