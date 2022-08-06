package linked_list.leet_code_114;

import java.util.Stack;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/6 15:59
 * @Desc :
 */
public class Flatten2 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (curr.right != null) {
                stack.push(curr.right);
            }

            if (curr.left != null) {
                stack.push(curr.left);
            }
            if (!stack.isEmpty()) {
                curr.right = stack.peek();
            }
            curr.left = null;

        }


    }
}
