package tree.leet_code_124;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 05:42
 * @Desc :
 */
public class MaxPathSum4 {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        max = Math.max(max, root.val + leftMax + rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
