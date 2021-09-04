package tree.leet_code_700;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/3 11:26
 * @Url : https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * @Desc : 二叉搜索树中的搜索:  给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
 * @Level :  easy
 * @Counter :
 * @Answer :
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (val > root.val) {
            root = searchBST(root.right, val);
        } else {
            root = searchBST(root.left, val);
        }
        return root;
    }
}
