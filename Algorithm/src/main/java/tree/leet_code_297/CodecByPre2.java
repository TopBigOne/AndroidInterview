package tree.leet_code_297;


import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/14/22 9:41 PM
 * @Desc :通过 前序遍历 的方式实现 二叉树的 序列化与反序列化（https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/）
 */
public class CodecByPre2 {

    public static final String SEP = ",";
    public static final String NULL = "#";

    /**
     * 序列化成字符串
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
        // 前序遍历--start
        sb.append(root.val);
        // 追加一个逗号
        sb.append(SEP);
        // 前序遍历--end；
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /**
     * 把字符串反序列化成二叉树
     *
     * @param data 字符串
     * @return 树节点
     */
    public TreeNode deserialize(String data) {
        LinkedList<String> stringLinkedList = new LinkedList<>();
        for (String s : data.split(SEP)) {
            stringLinkedList.addLast(s);
        }
        return deserialize(stringLinkedList);
    }

    /**
     * 前序遍历
     *
     * @param nodes
     * @return
     */
    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        // pre---start
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        // pre---end
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }

}
