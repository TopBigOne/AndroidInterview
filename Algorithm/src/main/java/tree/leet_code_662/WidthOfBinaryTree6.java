package tree.leet_code_662;

import java.util.HashMap;
import java.util.Map;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/3 16:05
 * @Desc :
 */
public class WidthOfBinaryTree6 {

    Map<Integer, Integer> map;
    int res = 0;

    public int widthOfBinaryTree(TreeNode root) {
        map = new HashMap<>();
        dfs(root, 0, 0);
        return res;

    }

    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }

        map.put(depth, pos);
        res = Math.max(res, pos - map.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}
