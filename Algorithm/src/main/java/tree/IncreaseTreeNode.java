package tree;

import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/21 8:58 PM
 * @Desc : 如何即将二叉树的节点都加一；
 */
public class IncreaseTreeNode {
    public static void main(String[] args) {
        IncreaseTreeNode increaseTreeNode = new IncreaseTreeNode();

        Integer[] raw = {2, 1, 4, 3, 5, 73};
        TreeNode root = TreeNodeFactory.build(raw);

        XYLog.d(root);
        increaseTreeNode.plusOne(root);
        XYLog.d(root);
    }

    void plusOne(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val += 1;

        plusOne(root.left);
        plusOne(root.right);


    }
}
