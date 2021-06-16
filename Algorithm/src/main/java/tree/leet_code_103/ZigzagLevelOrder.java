package tree.leet_code_103;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;



/**
 * @author :  dev
 * @version :
 * @Date :   2021/5/28 17:36
 * @Url :  https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 * @Level : easy medium hard
 * @Desc :  二叉树的锯齿形层序遍历
 * @Counter :31
 * @Answer : https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/solution/bfshe-dfsliang-chong-jie-jue-fang-shi-by-184y/
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int order = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            TreeNode node;
            for (int i = 0; i < size; i++) {
                node = queue.pollFirst();
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

            if ((order & 1) == 0) {
                Collections.reverse(temp);
            }
            order++;
            result.add(temp);
        }

        return result;

    }

}
