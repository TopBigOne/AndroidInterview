package tree.bfs.leet_code_429;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  2/25/21 7:19 PM
 * @Desc :N叉数的层序遍历（https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/）
 */
public class NTreeLevelOrder {
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == null) {
                    continue;
                }

                temp.add(node.val);

                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            result.add(temp);
        }

        return result;
    }


}
