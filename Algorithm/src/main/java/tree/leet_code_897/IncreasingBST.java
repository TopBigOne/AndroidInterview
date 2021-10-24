package tree.leet_code_897;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/8 23:48
 * @Url : https://leetcode-cn.com/problems/increasing-order-search-tree/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class IncreasingBST {
    TreeNode dummy = new TreeNode(-1);
    TreeNode pre = dummy;
    public TreeNode increasingBST(TreeNode root) {
        help( root);
        return dummy.right;

    }

    private void help( TreeNode root) {
        if (root==null) {
            return;
        }
        help(root.left);
        root.left=null;
        pre.right = root;
        pre = root;
        help(root.right);

    }

}
