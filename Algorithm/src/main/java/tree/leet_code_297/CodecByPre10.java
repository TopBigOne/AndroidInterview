package tree.leet_code_297;

import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/6 13:50
 * @Desc :
 */
public class CodecByPre10 {

    public static final String EMPTYNODE = "#";
    public static final String DOT = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(EMPTYNODE).append(DOT);
            return;
        }
        sb.append(root.val).append(DOT);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(DOT)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String first = nodes.removeFirst();
        if (first.equals(EMPTYNODE)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }



}
