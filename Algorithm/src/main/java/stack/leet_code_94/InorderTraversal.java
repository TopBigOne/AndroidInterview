package stack.leet_code_94;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  3/2/21 6:15 PM
 * @Desc : 二叉树的中序遍历（https://leetcode-cn.com/problems/binary-tree-inorder-traversal/）
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(result, root);
        return result;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }

    private void helper2(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        helper2(list, root.left);
        list.add(root.val);
        helper2(list, root.right);

    }

    private void helper3(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        helper3(list, root.left);
        list.add(root.val);
        helper3(list, root.right);
    }
}
