package tree.leet_code_110;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 17:58
 * @Desc :
 */
public class IsBalanced3 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1
                && isBalanced(root.right) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
