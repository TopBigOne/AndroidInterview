package tree.bfs.leet_code_103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/24/21 1:04 AM
 * @Desc : 二叉树锯齿遍历（https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/）
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> reuslt = new ArrayList<>();
        if (root == null) {
            return reuslt;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean isToRight = true;
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
                    queue.offer(l);
                }
                if (r != null) {
                    queue.offer(r);
                }
            }

            if (isToRight) {
                isToRight = false;
            } else {
                Collections.reverse(temp);
                isToRight = true;
            }
            reuslt.add(temp);
        }
        return reuslt;

    }

}
