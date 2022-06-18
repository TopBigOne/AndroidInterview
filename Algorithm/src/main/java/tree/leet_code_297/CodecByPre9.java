package tree.leet_code_297;

import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/6/18 16:53
 * @Desc : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/solution/
 */
public class CodecByPre9 {
    // 空节点
    String emptyNode = "#";
    // 节点分割点
    String dot = ",";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(emptyNode);
            sb.append(dot);
            return;
        }
        sb.append(root.val).append(emptyNode);
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : data.split(dot)) {
            linkedList.addLast(s);
        }
        return deserialize(linkedList);
    }

    private TreeNode deserialize(LinkedList<String> linkedList) {
        if (linkedList.isEmpty()) {
            return null;
        }
        String first = linkedList.removeFirst();
        if (first.equals(emptyNode)) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(linkedList);
        root.right = deserialize(linkedList);

        return root;


    }


}
