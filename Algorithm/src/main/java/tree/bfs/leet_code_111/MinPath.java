package tree.bfs.leet_code_111;

import javax.swing.KeyStroke;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/24/21 5:54 PM
 * @Desc : 二叉树的最小深度
 * <p>
 * 题解：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/111-er-cha-shu-de-zui-xiao-shen-du-di-gui-die-dai-/
 */
public class MinPath {
    public int minDepth(TreeNode root) {
        return min(root);
    }

    private int min(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftMin = min(root.left);
        int rightMin = min(root.right);
        if (root.left == null && root.right != null) {
            return 1 + rightMin;
        }
        if (root.left != null && root.right == null) {
            return 1 + leftMin;
        }
        return Math.min(leftMin, rightMin) + 1;
    }

    private int min2(TreeNode root){
        if (root==null) {
            return 0;
        }
        int leftMin = min(root.left);
        int rightMin = min(root.right);
        if(root.left==null&&root.right!=null){
           return rightMin+1;
        }
        if(root.right==null&&root.left!=null){
            return leftMin+1;
        }
        return Math.min(leftMin,rightMin)+1;
    }

    private int min3(TreeNode node){
        if (node==null) {
            return 0;
        }
        int leftMin = min3(node.left);
        int rightMin = min3(node.right);
        if(node.left==null&&node.right!=null){
            return rightMin+1;
        }
        if(node.left!=null&&node.right==null){
            return leftMin+1;
        }

        return Math.min(leftMin,rightMin)+1;

    }
}
