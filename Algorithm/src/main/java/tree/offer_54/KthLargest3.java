package tree.offer_54;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/11 15:04
 * @Desc :
 */
public class KthLargest3 {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res.get(k - 1);
    }

    private void dfs(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }

        dfs(root.left, res);
        res.add(0, root.val);
        dfs(root.right, res);
    }
}
