package tree.leet_code_572;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/26 04:51
 * @Desc :
 */
public class IsSubtree3 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        if (root == null) {
            return false;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot ==null) {
            return false;
        }
        if (root.val != subRoot.val) {
            return false;
        }


        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
    }
}
