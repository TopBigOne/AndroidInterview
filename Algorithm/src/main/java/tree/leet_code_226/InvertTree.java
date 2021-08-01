package tree.leet_code_226;

import java.util.LinkedList;

import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  7/30/21 11:38 PM
 * @Desc :  字节 5 次：  leet_code 226 : 翻转二叉树： https://leetcode-cn.com/problems/invert-binary-tree/solution/
 * <p>
 * 题解：https://leetcode-cn.com/problems/invert-binary-tree/solution/dong-hua-yan-shi-liang-chong-shi-xian-226-fan-zhua/
 */
public class InvertTree {
    /**
     * 迭代解法
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }


    /**
     * 迭代解法
     *
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right =temp;

            TreeNode l = node.left;
            TreeNode r = node.right;
            if (l != null) queue.offer(l);
            if (r != null) queue.offer(r);
        }


        // 返回处理完的节点
        return root;

    }


}
