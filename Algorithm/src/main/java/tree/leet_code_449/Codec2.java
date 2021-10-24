package tree.leet_code_449;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/12 23:53
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class Codec2 {

    /**
     * 序列化，使用后续遍历
     *
     * @param root
     * @return
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = postOrder(root, new StringBuilder());
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 后序遍历
     *
     * @param root
     * @param sb
     * @return
     */
    private StringBuilder postOrder(TreeNode root, StringBuilder sb) {
        if (root == null) return sb;
        postOrder(root.left, sb);
        postOrder(root.right, sb);
        sb.append(root.val).append(' ');
        return sb;
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Deque<Integer> nums = new ArrayDeque<>();
        for (String s : data.split("\\s+")) {
            nums.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    private TreeNode helper(int minValue, int maxValue, Deque<Integer> nums) {
        if (nums.isEmpty()) return null;
        // 获取最后一个元素
        int val = nums.getLast();
        if (val < minValue || val > maxValue) {
            return null;
        }
        // 移除最后一个元素
        nums.removeLast();
        // 开始构建树
        TreeNode root = new TreeNode(val);
        root.right = helper(val, maxValue, nums);
        root.left = helper(minValue, val, nums);
        return root;
    }
}
