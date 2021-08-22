package tree.leet_code_662;

import java.util.HashMap;
import java.util.Map;

import javax.swing.table.TableRowSorter;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  8/11/21 1:21 AM
 * @Desc :
 */
public class WidthOfBinaryTree3 {
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
        left.computeIfAbsent(depth, integer -> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
