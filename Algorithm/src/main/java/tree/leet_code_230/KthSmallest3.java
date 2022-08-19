package tree.leet_code_230;

import java.util.PriorityQueue;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/17 23:27
 * @Desc :
 */
public class KthSmallest3 {


    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k == 0) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        help(root, k, maxHeap);
        return maxHeap.peek();
    }

    private void help(TreeNode root, int k, PriorityQueue<Integer> maxHeap) {
        if (root == null) {
            return;
        }
        help(root.left, k, maxHeap);
        if (k > maxHeap.size()) {
            maxHeap.add(root.val);
        } else {

            if (root.val < maxHeap.peek()) {
                maxHeap.remove(maxHeap.peek());
                maxHeap.add(root.val);
            }
        }
        help(root.right, k, maxHeap);

    }

}
