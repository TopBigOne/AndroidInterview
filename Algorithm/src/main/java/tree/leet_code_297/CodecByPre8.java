package tree.leet_code_297;

import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/15/22 13:16 PM
 * @Desc :通过 前序遍历 的方式实现 二叉树的 序列化与反序列化（https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/）
 */
public class CodecByPre8 {

    public static final String NULL = "#";
    public static final String SEP = ",";

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }
    public TreeNode deserialize(String data){
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);

    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }


}
