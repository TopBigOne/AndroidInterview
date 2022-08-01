package tree.leet_code_543;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 17:48
 * @Desc :  leetcode : 543 二叉树的直  https://leetcode.cn/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree4 {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return result;

    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        // 左边+ 右边就是直径
        result = Math.max(leftDepth + rightDepth, result);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
