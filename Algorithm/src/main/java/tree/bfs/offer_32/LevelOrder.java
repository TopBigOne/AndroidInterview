package tree.bfs.offer_32;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import tree.TreeNode;
import tree.TreeNodeFactory;
import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/28 15:18
 * @Desc :
 */
public class LevelOrder {
    public static void main(String[] args) {

        Integer[] integers = {3, 9, 20, null, null, 15, 7,};

        TreeNode treeNode = TreeNodeFactory.build(integers);
        XYLog.d(treeNode);
        LevelOrder levelOrder = new LevelOrder();
        int[] result = levelOrder.levelOrder(treeNode);
        System.err.println("result :" + Arrays.toString(result));

    }

    @SuppressWarnings("NewApi")
    public int[] levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result.stream().mapToInt(a -> a).toArray();
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode tempNode = stack.pollFirst();
            int val = tempNode.val;
            result.add(val);
            if (tempNode.left != null) {
                stack.add(tempNode.left);
            }
            if (tempNode.right != null) {
                stack.add(tempNode.right);
            }
        }

        return result.stream().mapToInt(a -> a).toArray();

    }


}
