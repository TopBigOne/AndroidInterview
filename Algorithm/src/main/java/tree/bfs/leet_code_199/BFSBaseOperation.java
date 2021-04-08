package tree.bfs.leet_code_199;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/5 01:08
 * @Desc : 二叉树，BFS 最基本的操作,层级遍历；
 */
public class BFSBaseOperation {
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                temp.add(node.val);
                TreeNode l = node.left;
                TreeNode r = node.right;
                if (l != null) {
                    queue.offer(l);
                }
                if (r != null) {
                    queue.offer(r);
                }
            }
            result.add(temp);
        }

        return result;


    }


}
