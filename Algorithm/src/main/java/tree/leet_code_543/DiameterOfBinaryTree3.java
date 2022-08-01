package tree.leet_code_543;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 17:44
 * @Desc : 543. 二叉树的直径:https://leetcode.cn/problems/diameter-of-binary-tree/
 */
public class DiameterOfBinaryTree3 {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        result = Math.max(result, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
