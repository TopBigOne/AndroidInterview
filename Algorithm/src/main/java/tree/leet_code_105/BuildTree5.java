package tree.leet_code_105;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  7/7/21 1:55 AM
 * @Desc :  105 : 从前序和中序遍历 构造二叉树（https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/）
 *
 * 题解：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--22/
 */
public class BuildTree5 {
    int pre = 0;
    int in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildHelp(preorder, inorder, (long) Integer.MIN_VALUE + 1);
    }

    private TreeNode buildHelp(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildHelp(preorder, inorder, rootValue);
        root.right = buildHelp(preorder, inorder, stop);
        return root;
    }

    private TreeNode buildHelp2(int [] preorder,int [] inorder,int stop){
        if(pre==preorder.length){
            return null;
        }
        if(inorder[in] == stop){
            in++;
            return null;
        }
        int value = preorder[pre++];
        TreeNode root = new TreeNode(value);
        root.left = buildHelp2(preorder,inorder,value);
        root.right = buildHelp2(preorder,inorder,stop);
        return root;
    }
}
