package tree.leet_code_112;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 16:30
 * @Desc :
 */
public class HasPathSum3 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int val = targetSum - root.val;
        if (root.left == null && root.right == null && val == 0) {
            return true;
        }

        return hasPathSum(root.left, val) || hasPathSum(root.right, val);


    }
}
