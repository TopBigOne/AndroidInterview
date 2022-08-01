package tree.bst.leet_code_98;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 19:57
 * @Desc :
 */
public class IsValidBST3 {

    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }

    private boolean help(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.val >= root.val) {
            return false;
        }
        if (max != null && max.val <= root.val) {
            return false;
        }
        return help(root.left, min, root) && help(root.right, root, max);

    }

}
