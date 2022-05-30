package tree.bfs.offer_32_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/28 15:34
 * @Desc :
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        // 尾插法
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                //从头取
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                temp.add(node.val);
                TreeNode l = node.left;
                TreeNode r = node.right;
                if (l != null) {
                    queue.add(l);
                }
                if (r != null) {
                    queue.add(r);
                }
            }
            result.add(temp);
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                temp.add(node.val);

                TreeNode l = node.left;
                TreeNode r = node.right;
                if (l != null) {
                    queue.add(l);
                }
                if (r != null) {
                    queue.add(r);
                }
            }

            result.add(temp);
        }

        return result;

    }


}
