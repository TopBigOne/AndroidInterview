package tree.dfs.leet_code_104;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 19:40
 * @Desc :
 */
public class MaxDepthOfBinaryTree2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
