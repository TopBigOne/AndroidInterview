package tree.leet_code_144;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/12 16:20
 * @Url : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @Level : easy
 * @Desc : 二叉树的前序遍历
 * @Counter : 4
 * @Answer :
 */
public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }

}
