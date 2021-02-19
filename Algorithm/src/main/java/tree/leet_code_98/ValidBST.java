package tree.leet_code_98;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/19/21 6:19 PM
 * @Desc : 验证二叉搜索树（https://leetcode-cn.com/problems/validate-binary-search-tree/）
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.val >= root.val) {
            return false;
        }
        if (max != null && max.val <= root.val) {
            return false;
        }
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);

    }


    private boolean isValidBST2(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.val >= root.val) {
            return false;
        }

        if (max != null && max.val <= root.val) {
            return false;
        }

        return isValidBST2(root.left, min, root) && isValidBST2(root.right, root, max);
    }

    public boolean isValidBST3(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && min.val >= root.val) {
            return false;
        }
        if (max != null && max.val <= root.val) {
            return false;
        }
        return isValidBST3(root.left, min, root) && isValidBST3(root.right, root, max);
    }


}
