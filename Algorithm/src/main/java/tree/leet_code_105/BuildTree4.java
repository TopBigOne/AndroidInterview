package tree.leet_code_105;


import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  3/23/21 12:22 AM
 *
 * @Desc : 字节半年考了 21 次；
 */
public class BuildTree4 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelpTree(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }

    int pre, in;

    private TreeNode buildHelpTree(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildHelpTree(preorder, inorder, rootValue);
        root.right = buildHelpTree(preorder, inorder, stop);
        return root;
    }


}
