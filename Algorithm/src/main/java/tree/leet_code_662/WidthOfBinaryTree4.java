package tree.leet_code_662;

import org.ietf.jgss.Oid;

import java.util.HashMap;
import java.util.Map;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  8/14/21 8:32 PM
 * @Desc : 有点感觉了，
 */
public class WidthOfBinaryTree4 {
    int ans;
    Map<Integer, Integer> left;

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    /**
     * 使用前序遍历
     *
     * @param root
     * @param depth
     * @param pos
     */
    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        left.computeIfAbsent(depth, integer -> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
