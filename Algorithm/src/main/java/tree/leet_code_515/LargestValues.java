package tree.leet_code_515;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/25/21 10:11 PM
 * @Desc :  在每个树行中找最大值 （https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/）
 */
public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }

                int currVlaue = node.val;
                maxValue = Math.max(maxValue, currVlaue);
                TreeNode l = node.left;
                TreeNode r = node.right;

                if (l != null) {
                    queue.offer(l);
                }
                if (r != null) {
                    queue.offer(r);
                }
            }
            result.add(maxValue);
        }

        return result;
    }

    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int maxVale = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                int currValue = node.val;
                maxVale = Math.max(maxVale, currValue);
                TreeNode l = node.left;
                TreeNode r = node.right;
                if (l != null) {
                    queue.add(l);
                }
                if (r != null) {
                    queue.add(r);
                }
            }

            result.add(maxVale);
        }
        return result;
    }
}
