package tree.leet_code_662;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  8/5/21 11:58 PM
 * @Desc :   leetcode 662 : 二叉树的最大宽度 medium:https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 *
 * 题解：https://leetcode-cn.com/problems/maximum-width-of-binary-tree/solution/er-cha-shu-zui-da-kuan-du-by-leetcode/
 */
public class WidthOfBinaryTree {
    int ans;
    Map<Integer, Integer> left;

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }

        // 对于每一个深度，第一个遇到的节点是最左边的节点，最后一个到达的节点是最右边的节点。
        left.computeIfAbsent(depth, x -> pos);

        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
