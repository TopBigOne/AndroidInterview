package tree.offer_28;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/29 17:51
 * @Desc : 对称二叉树：https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 */
public class IsSymmetric {
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


        // 广亚，你再好好理解一下，什么是镜像
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    private boolean dfs2(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return dfs2(left.left, right.right) && dfs2(left.right, right.left);

    }
}
