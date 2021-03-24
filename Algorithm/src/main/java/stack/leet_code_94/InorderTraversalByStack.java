package stack.leet_code_94;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  3/2/21 6:47 PM
 * @Desc : 利用栈，实现树的中序遍历
 * 题解在二（https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/di-gui-he-fei-di-gui-liang-chong-jie-fa-by-sdwwld/）
 */
public class InorderTraversalByStack {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 出栈
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 出栈
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 出栈
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal4(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            // 入栈
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 出栈
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal5(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 出栈
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

        return list;
    }


}
