package tree.bfs.leet_code_199;

import tree.TreeNode;

import java.util.*;

/**
 * @author : dev
 * @version :
 * @Date :  2021/4/5 01:08
 * @Desc : 二叉树，BFS 最基本的操作,层级遍历；
 */
public class BFSBaseOperation {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(7);
        root.right.right = new TreeNode(8);
        BFSBaseOperation bfsBaseOperation = new BFSBaseOperation();
        List<List<Integer>> result = bfsBaseOperation.levelOrder3(root);
        System.out.println("result: " + result);
    }

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


    /**
     * 二叉树的层级遍历
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // step 1:
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

                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(temp);
        }
        return result;
    }


    public List<List<Integer>> levelOrder3(TreeNode root) {
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
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {

                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            result.add(temp);
        }
        return result;

    }

}
