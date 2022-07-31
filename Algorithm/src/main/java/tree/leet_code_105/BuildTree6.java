package tree.leet_code_105;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 15:30
 * @Desc :  105 : 从前序和中序遍历 构造二叉树（https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/）
 */
public class BuildTree6 {

    int pre = 0;
    int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        long stop = Integer.MAX_VALUE + 1L;
        return help(preorder, inorder, stop);

    }

    private TreeNode help(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = help(preorder, inorder, rootValue);
        root.right = help(preorder, inorder, stop);
        return root;
    }

}
