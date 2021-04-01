package stack.leet_code_173;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/1 21:26
 * @Desc :
 */
public class BSTIterator2 {
    Deque<TreeNode> stack = new LinkedList<>();

    public BSTIterator2(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if (node.right != null) {
            TreeNode rightNode = node.right;
            while (rightNode != null) {
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
