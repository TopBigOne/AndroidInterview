package tree.leet_code_257;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/16/21 12:10 AM
 * @Desc : 字节半年考了 8 次：二叉树的所有路径：https://leetcode-cn.com/problems/binary-tree-paths/\\\
 *
 */
public class BinaryTreePath {
    public List<String> binaryPaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }
        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }

    private void dfs2(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
            return;
        }

        dfs(root.left, path + root.val + "->", res);
        dfs(root.right, path + root.val + "->", res);
    }
}
