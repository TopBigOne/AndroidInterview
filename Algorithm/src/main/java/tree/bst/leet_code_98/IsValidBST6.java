package tree.bst.leet_code_98;

import tree.TreeNode;


/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 10:56
 * @Desc : 98 : 验证二叉搜索树（https://leetcode-cn.com/problems/validate-binary-search-tree/）
 * 中序遍历时，判断当前节点是否大于中序遍历的前一个节点，如果大于，说明满足 BST，继续遍历；否则直接返回 false。
 */
public class IsValidBST6 {
    int pre = Integer.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        return help(root);
    }

    public boolean help(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

}
