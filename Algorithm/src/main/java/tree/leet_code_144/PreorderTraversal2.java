package tree.leet_code_144;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/21 10:02
 * @Url : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class PreorderTraversal2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null) {
            return result;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
        return result;
    }
}
