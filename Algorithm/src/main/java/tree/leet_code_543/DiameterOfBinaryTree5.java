package tree.leet_code_543;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/4 23:39
 * @Desc :
 */
public class DiameterOfBinaryTree5 {

    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right);
        return Math.max(left, right) + 1;
    }

}
