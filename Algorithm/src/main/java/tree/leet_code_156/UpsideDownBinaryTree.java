package tree.leet_code_156;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/9 20:24
 * @Url : https://leetcode-cn.com/problems/binary-tree-upside-down/submissions/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class UpsideDownBinaryTree {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode parent = null;
        TreeNode parentRight = null;
        while (root != null) {
            TreeNode rootLeft = root.left;
            root.left = parentRight;
            parentRight = root.right;
            root.right = parent;
            parent = root;
            root = rootLeft;
        }
        return parent;
    }


    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        TreeNode right = null;
        TreeNode parent = null;
        while (root != null) {
            TreeNode left = root.left;
            root.left = right;
            right = root.right;
            root.right = parent;
            parent = root;
            root = left;
        }
        return parent;
    }

    public TreeNode upsideDownBinaryTree3(TreeNode root) {
        TreeNode right = null;
        TreeNode parent = null;
        while (root != null) {
            TreeNode left = root.left;
            root.left = right;
            right = root.right;
            root.right = parent;

            parent = root;
            root = left;
        }
        return parent;
    }

    public TreeNode upsideDownBinaryTree4(TreeNode root) {
        TreeNode right = null;
        TreeNode parent = null;
        while (root != null) {
            TreeNode left = root.left;
            root.left = right;
            right = root.right;
            root.right = parent;
            parent = root;
            root = left;
        }
        return parent;


    }
}
