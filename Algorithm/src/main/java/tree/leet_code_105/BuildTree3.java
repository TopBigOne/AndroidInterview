package tree.leet_code_105;

import sun.reflect.generics.tree.ReturnType;
import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  3/19/21 1:46 AM
 * @Desc : 字节
 */
public class BuildTree3 {
    int pre, in;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelpTree(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }


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

    private TreeNode buildHelpTree2(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildHelpTree2(preorder, inorder, rootValue);
        root.right = buildHelpTree2(preorder, inorder, stop);
        return root;
    }

    private TreeNode buildHelpTree3(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildHelpTree3(preorder, inorder, rootValue);
        root.right = buildHelpTree3(preorder, inorder, stop);
        return root;
    }


}
