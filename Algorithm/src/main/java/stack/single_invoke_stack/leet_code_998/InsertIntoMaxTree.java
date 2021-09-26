package stack.single_invoke_stack.leet_code_998;

import tree.TreeNode;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/24 23:27
 * @Url : https://leetcode-cn.com/problems/maximum-binary-tree-ii/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 *
 *
 * 参考：数组转树：https://leetcode-cn.com/problems/maximum-binary-tree/
 */
public class InsertIntoMaxTree {

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if(root==null||root.val <val){
            TreeNode temp = new TreeNode(val);
            temp.left = root;
            return temp;
        }
        root.right = insertIntoMaxTree(root.right,val);
        return root;

    }
}
