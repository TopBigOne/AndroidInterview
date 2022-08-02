package tree.leet_code_226;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 19:11
 * @Desc :
 */
public class InvertTree3 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;


    }
}
