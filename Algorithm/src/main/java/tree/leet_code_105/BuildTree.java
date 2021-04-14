package tree.leet_code_105;


import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  3/19/21 12:40 AM
 * @Desc : 105 : 从前序和中序遍历 构造二叉树（https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/）
 * 题解
 * 还可以看一下，leetcode 上 offer 07（https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/）
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class BuildTree {
    private int pre, in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        // 到达末尾返回
        if (pre == preorder.length) {
            return null;
        }
        // 到达停止点，返回 null
        // 当前停止点已经用了，in 后移
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper(preorder, inorder, rootVal);
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }

    private TreeNode buildTreeHelper2(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTreeHelper2(preorder, inorder, rootVal);
        root.right = buildTreeHelper2(preorder, inorder, stop);
        return root;

    }

    private TreeNode buildTreeHelper3(int[] preorder, int[] inorder, int stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        // 前序遍历的第一个元素就是root 节点
        int rootvalue = preorder[pre++];


        TreeNode root = new TreeNode(rootvalue);
        root.left = buildTreeHelper3(preorder, inorder, rootvalue);
        root.right = buildTreeHelper3(preorder, inorder, stop);
        return root;
    }

    private TreeNode buildTreeHelper4(int[] preorder, int[] inorder, int stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTreeHelper4(preorder, inorder, rootValue);
        root.right = buildTreeHelper4(preorder, inorder, stop);
        return root;

    }

    private TreeNode buildTreeHelp5(int []preorder,int [] inorder,int stop){
        if (pre==preorder.length) {
            return null;
        }
        if (inorder[in]==stop) {
            in++;
            return null;
        }
        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);

        root.left = buildTreeHelp5(preorder,inorder,rootValue);
        root.right = buildTreeHelp5(preorder,inorder, stop);
        return root;

    }



}
