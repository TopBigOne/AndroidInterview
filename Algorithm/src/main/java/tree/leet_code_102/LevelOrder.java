package tree.leet_code_102;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

import sun.awt.image.ImageWatched;
import ten_sort.lock.TempLock;
import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/19/21 7:09 PM
 * @Desc : 二叉树层序遍历（https://leetcode-cn.com/problems/binary-tree-level-order-traversal/）
 * <p>
 * 自上而下，二叉树的层级遍历
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                temp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
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
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(temp);

        }
        return result;
    }


    public List<List<Integer>> levelOrder3(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) {
            return  result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node==null) {
                    continue;
                }

                temp.add(node.val);

                TreeNode l = node.left;
                if (l != null) {
                    queue.add(l);
                }
                TreeNode r = node.right;
                if (r != null) {
                    queue.add(r);
                }

            }

            result.add(temp);

        }
        return  result;


    }


}
