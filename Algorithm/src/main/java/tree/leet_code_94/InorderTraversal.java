package tree.leet_code_94;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :  2021/6/12 15:21
 * @Url :  https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 * @Level : easy
 * @Desc : 中序遍历, 着重看一下使用堆栈的方式来解决这个问题
 * @Counter :
 * @Answer : 4次
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 先左边
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 处理右边
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 处理右边
            root = stack.pop();
            result.add(root.val);
            root = root.right;

        }

        return result;
    }


}
