package tree.bfs.leet_code_199;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 22:33
 * @Desc :  199. 二叉树的右视图 https://leetcode.cn/problems/binary-tree-right-side-view/
 * <p>
 * 题解：https://leetcode.cn/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
 */
public class RightSideView3 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (res.size() == depth) {
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth, res);
        dfs(root.left, depth, res);
    }


}
