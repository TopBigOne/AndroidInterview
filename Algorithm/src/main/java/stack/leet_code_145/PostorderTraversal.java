package stack.leet_code_145;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  3/7/21 8:05 PM
 * @Desc : 二叉树 后续遍历 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/submissions/
 */
public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(16);
        help(root,result);
        return result;
    }

    /**
     * 使用最low的方式，用递归实现了后序遍历，牛逼的还是要学会使用栈
     * @param root
     * @param result
     */
    private void help(TreeNode root, List<Integer> result) {
        if (root==null) {
            return;
        }
        help(root.left,result);
        help(root.right,result);
        result.add(root.val);
    }


}
