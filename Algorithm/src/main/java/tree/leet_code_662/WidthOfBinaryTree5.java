package tree.leet_code_662;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  8/15/21 1:26 PM
 * @Desc : 二叉树的最大宽度
 */
public class WidthOfBinaryTree5 {
    int ans = 0;
    Map<Integer, Integer> leftPosMap;

    public int widthOfBinaryTree(TreeNode root) {
        leftPosMap = new HashMap<>();
        dfs(root, 0, 0);
        return ans;

    }

    /**
     *
     * @param root
     * @param depth
     * @param pos 节点的编号
     */
    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }

        leftPosMap.putIfAbsent(depth, pos);

        // 中-->左--->右
        ans = Math.max(ans, (pos - leftPosMap.get(depth)) + 1);

        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
