package tree.leet_code_297;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/17/21 5:58 PM
 * @Desc :297. 二叉树的序列化与反序列化  : https://leetcode.cn/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/solution/shou-hui-tu-jie-gei-chu-dfshe-bfsliang-chong-jie-f/
 */


public class Codec {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        return root.val + "," + leftSerialize + rightSerialize;
    }

    public TreeNode deserialize(String data) {
        String[] temp = data.split(",");
        Deque<String> dp = new LinkedList<>(Arrays.asList(temp));
        return buildTree(dp);
    }

    private TreeNode buildTree(Deque<String> dp) {
        // 返回当前节点
        String s = dp.poll();
        if (s.equals("X")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildTree(dp);
        root.right = buildTree(dp);
        return root;
    }
}
