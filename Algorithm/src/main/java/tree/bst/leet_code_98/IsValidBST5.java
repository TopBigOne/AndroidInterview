package tree.bst.leet_code_98;


import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 20:25
 * @Desc :
 */
public class IsValidBST5 {

    int pre = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return help(root);
    }

    private boolean help(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (help(root.left)) {
            return false;
        }

        if (pre > root.val) {
            return false;
        }
        pre = root.val;
        return help(root.right);
    }
}
