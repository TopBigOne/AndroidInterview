package tree.leet_code_94;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 12:05
 * @Desc :
 */
public class InorderTraversal4 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }


            root = stack.pop();
            res.add(root.val);
            root = root.right;

        }
        return res;

    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                // 先存
                stack.push(root);
                root = root.left;
            }

            // 再用
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;

    }
}
