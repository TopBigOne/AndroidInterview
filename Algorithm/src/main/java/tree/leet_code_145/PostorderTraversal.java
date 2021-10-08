package tree.leet_code_145;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/2 17:53
 * @Url :   https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 * @Level :  easy  medium hard
 * @Desc : 二叉树的后续遍历
 * @Counter :
 * @Answer :
 */
public class PostorderTraversal {
    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode root, List<Integer> result) {
        if(root==null) return;
        dfs(root.left,result);
        dfs(root.right,result);
        result.add(root.val);
    }
}
