package tree.leet_code_105;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 15:37
 * @Desc :
 */
public class BuildTree7 {
    int preIndex = 0;
    int inorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        long stop = Integer.MAX_VALUE + 1;
        return help(preorder, inorder, stop);

    }

    private TreeNode help(int[] preorder, int[] inorder, long stop) {
        if (preIndex == preorder.length) {
            return null;
        }
        if (inorder[inorderIndex] == stop) {
            inorderIndex++;
            return null;
        }
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = help(preorder, inorder, rootValue);
        root.right = help(preorder, inorder, stop);
        return root;

    }

    private TreeNode help2(int[] preorder, int[] inorder, long stop) {
        if (preIndex == preorder.length) {
            return null;
        }
        if (inorder[inorderIndex] == stop) {
            inorderIndex++;
            return null;
        }
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);
        root.left = help2(preorder, inorder, rootValue);
        root.right = help2(preorder, inorder, stop);

        return root;
    }
}
