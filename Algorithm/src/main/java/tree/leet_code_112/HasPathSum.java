package tree.leet_code_112;

import java.util.Stack;
import java.util.TreeMap;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/10/21 12:41 AM
 * @Desc : 路径总和：https://leetcode-cn.com/problems/path-sum/
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            if (curNode.left == null && curNode.right == null) {
                if (curNode.val == targetSum) {
                    return true;
                }
            }

            if (curNode.right != null) {
                curNode.right.val = curNode.val + curNode.right.val;
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                curNode.val = curNode.val + curNode.left.val;
                stack.push(curNode.left);
            }

        }

        return false;

    }
}
