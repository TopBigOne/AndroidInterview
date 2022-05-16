package tree.interview.inorderSuccessor_04_06;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/5/16 17:03
 * @Desc :
 */
public class InorderSuccessor2 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root==null) {
            return null;
        }

        // step 1 : 以递归的方式，在右子树上找到 符合p 节点的 切入点
        if (root.val <= p.val){
            return inorderSuccessor(root.right, p);
        }
        // step 2: 开始真正的查找
        TreeNode leftNode = inorderSuccessor(root.left, p);
        return leftNode==null ? root : leftNode;
    }
}
