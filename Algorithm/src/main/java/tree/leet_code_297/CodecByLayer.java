package tree.leet_code_297;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/14/21 9:53 PM
 * @Desc :通过 层级遍历 的方式实现 二叉树的 序列化与反序列化（https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/）
 */
public class CodecByLayer {
    public static final String SEP = ",";
    public static final String NULL = "#";

    /**
     * 把一棵二叉树序列化成字符串
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        // 初始化队列，将 root 加入 队列
        Queue<TreeNode> q = new LinkedList<>();
        // 类似 addAll();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            // 层级遍历代码位置---start
            if (cur == null) {
                sb.append(NULL).append(SEP);
                continue;
            }
            sb.append(cur.val).append(SEP);
            // 层级遍历代码位置---end

            q.offer(cur.left);
            q.offer(cur.right);
        }
        return sb.toString();
    }


    /**
     * 把字符串反序列化成二叉树
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(SEP);
        // 第一个元素就是 root 值
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        // 队列 q 记录父节点，将 root 加入队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for (int i = 1; i < nodes.length; ) {
            // 队列中，存的都是父节点
            TreeNode parent = q.poll();
            // 父节点对应的左侧子节点的值
            String left = nodes[i++];
            if (!left.equals(NULL)) {
                parent.left = new TreeNode(Integer.parseInt(left));
                q.offer(parent.left);
            } else {
                parent.left = null;
            }

            // 父节点对应的右侧子节点的值
            String rightValue = nodes[i++];
            if (!rightValue.equals(NULL)) {
                parent.right = new TreeNode(Integer.parseInt(rightValue));
                q.offer(parent.right);
            } else {
                parent.right = null;
            }

        }
        return root;

    }

}
