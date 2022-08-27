package tree.leet_code_103;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/30 22:12
 * @Desc :
 */
public class ZigzagLevelOrder2 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {

            List<Integer> temp = new ArrayList<>();
            TreeNode node;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.pollFirst();
                if (node == null) {
                    continue;
                }
                temp.add(node.val);
                if (node.left != null) {
                    queue.offerLast(node.left);
                }
                if (node.right != null) {
                    queue.offerLast(node.right);
                }
            }

            if ((index & 1) == 0) {

                Collections.reverse(temp);
            }
            result.add(temp);
            index++;
        }


        return result;


    }
}
