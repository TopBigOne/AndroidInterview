package tree.leet_code_297;

import java.util.LinkedList;

import com.jar.lock.TempLock;
import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2/14/22 9:41 PM
 * @Desc :通过 前序遍历 的方式实现 二叉树的 序列化与反序列化（https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/）
 */
public class CodecByPre3 {
    public static final String SEP = ",";
    public static final String NULL = "#";

    public String serialize(TreeNode root) {
//        if (root == null) {
//            return "";
//        }
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(root.val).append(SEP);
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
        LinkedList<String> linkedList = new LinkedList<>();
        for (String s : data.split(SEP)) {
            linkedList.addLast(s);
        }

        return deserialize(linkedList);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes==null) {
            return null;
        }
        // pre --start
        String first= nodes.removeFirst();
        if (first.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(first));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }

}
