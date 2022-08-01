package tree.dfs.leet_code_104;

import java.util.ArrayDeque;
import java.util.Deque;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 18:00
 * @Desc :
 */
public class MaxDepthOfBinaryTree4 {
    public int maxDepth(TreeNode root) {
        int count = 0;
        if (root == null) {
            return count;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode treeNode = queue.pop();
                TreeNode l;
                TreeNode r;
                if ((l = treeNode.left) != null) {
                    queue.addLast(l);
                }

                if ((r = treeNode.right) != null) {
                    queue.addLast(r);
                }
            }
            count++;
        }
        return count;


    }
}
