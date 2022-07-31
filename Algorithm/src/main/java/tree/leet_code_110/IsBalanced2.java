package tree.leet_code_110;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 17:53
 * @Desc : 110. 平衡二叉树 ：  https://leetcode.cn/problems/balanced-binary-tree/
 */
public class IsBalanced2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
