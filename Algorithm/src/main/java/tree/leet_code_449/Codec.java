package tree.leet_code_449;

import tree.TreeNode;

import java.util.ArrayDeque;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/12 23:41
 * @Url : https://leetcode-cn.com/problems/serialize-and-deserialize-bst/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 *
 * https://leetcode-cn.com/problems/serialize-and-deserialize-bst/solution/xu-lie-hua-he-fan-xu-lie-hua-er-cha-sou-suo-shu-2/
 */
public class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = postorder(root, new StringBuilder());
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.isEmpty())
            return null;
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for (String s : data.split("\\s+"))
            nums.add(Integer.valueOf(s));
        return helper(Integer.MIN_VALUE, Integer.MAX_VALUE, nums);
    }

    public StringBuilder postorder(TreeNode root, StringBuilder sb) {
        if (root == null)
            return sb;
        postorder(root.left, sb);
        postorder(root.right, sb);
        sb.append(root.val);
        sb.append(' ');
        return sb;
    }

    public TreeNode helper(Integer lower, Integer upper, ArrayDeque<Integer> nums) {
        if (nums.isEmpty())
            return null;
        int val = nums.getLast();
        if (val < lower || val > upper)
            return null;

        nums.removeLast();
        TreeNode root = new TreeNode(val);
        root.right = helper(val, upper, nums);
        root.left = helper(lower, val, nums);
        return root;
    }


}
