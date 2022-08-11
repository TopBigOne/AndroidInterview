package tree.bst.leet_code_958;

import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/11 14:18
 * @Desc :
 */
public class IsCompleteTree2 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isHasNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (isHasNull && node != null) {
                return false;
            }
            if (node == null) {
                isHasNull = true;
                continue;
            }


            queue.offer(node.left);
            queue.offer(node.right);

        }
        return true;

    }

    public boolean isCompleteTree2(TreeNode root) {
        if (root == null) {
            return false;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isHadNull = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null && isHadNull) {
                return false;

            }
            if (node == null) {
                isHadNull = true;
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);

        }


        return true;

    }
}
