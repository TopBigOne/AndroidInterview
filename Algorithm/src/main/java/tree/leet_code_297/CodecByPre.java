package tree.leet_code_297;

import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/14/21 9:10 PM
 * @Desc :通过 前序遍历 的方式实现 二叉树的 序列化与反序列化（https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/）
 */
public class CodecByPre {
    public static final String SEP = ",";
    public static final String NULL = "#";

    /**
     * 把一棵二叉树序列化成字符串
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        // 前序遍历位置 -- start
        sb.append(root.val).append(SEP);
        // 前序遍历位置 -- end

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * 把字符串反序列化成二叉树
     *
     * @param data
     * @return
     */
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            // 尾插法
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /**
     * 辅助函数，通过 nodes 到列表构造二叉树
     *
     * @param nodes
     * @return
     */
    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // 前序遍历位置----start
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        // 前序遍历位置----end
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

}
