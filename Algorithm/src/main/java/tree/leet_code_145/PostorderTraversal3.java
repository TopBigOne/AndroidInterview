package tree.leet_code_145;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/12 16:53
 * @Desc :
 */
public class PostorderTraversal3 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);

            TreeNode left = node.left;
            if (left != null) {
                stack.push(node.left);
            }


            TreeNode right = node.right;
            if (right != null) {
                stack.push(right);
            }
        }

        Collections.reverse(res);
        return res;


    }
}
