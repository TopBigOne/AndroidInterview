package tree.leet_code_145;


import tree.TreeNode;

import java.util.*;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/2 18:04
 * @Url :   https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @Level :  easy
 * @Desc : 二叉树的后续遍历 ：迭代解法
 * @Counter :
 * @Answer :
 * <p>
 * 以下开始开始正文：
 * <p>
 * 二叉树深度优先遍历
 * 前序遍历： 144.二叉树的前序遍历
 * 后序遍历： 145.二叉树的后序遍历
 * 中序遍历： 94.二叉树的中序遍历
 * 二叉树广度优先遍历
 * 层序遍历：102.二叉树的层序遍历
 * 先帮大家明确一下二叉树的遍历规则
 */
public class PostorderTraversal2 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            TreeNode left = node.left;
            if (left != null) {
                stack.push(left);
            }

            TreeNode right = node.right;
            if (right != null) {
                stack.push(right);
            }
        }

        Collections.reverse(result);
        return result;
    }

    public List<Integer> postorderTraversal12(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }

        }
        Collections.reverse(result);
        return result;
    }
}
