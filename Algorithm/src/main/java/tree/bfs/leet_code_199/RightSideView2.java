package tree.bfs.leet_code_199;

import java.util.ArrayList;
import java.util.List;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/6 22:11
 * @Desc :  199. 二叉树的右视图 https://leetcode.cn/problems/binary-tree-right-side-view/
 * <p>
 * 题解：https://leetcode.cn/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
 */
public class RightSideView2 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, 0, res);
        return res;

    }

    private void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        //  如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
        if (depth == res.size()) {
            res.add(root.val);
        }
        depth++;
        // 先访问右子树
        dfs(root.right, depth, res);
        // 当右子树为空的时候，再使用左子树
        dfs(root.left, depth, res);
    }

}
