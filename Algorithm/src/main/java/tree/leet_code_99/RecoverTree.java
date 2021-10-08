package tree.leet_code_99;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/9/30 23:49
 * @Url : https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @Level :    medium
 * @Desc : 恢复二叉搜索树
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 * -----------------------------------------------------------------------------
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 * -----------------------------------------------------------------------------
 * @Counter : 3
 * @Answer : https://leetcode-cn.com/problems/recover-binary-search-tree/solution/san-chong-jie-fa-xiang-xi-tu-jie-99-hui-fu-er-cha-/
 */
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        // zho
        dfs(root,list);
        TreeNode x = null;
        TreeNode y = null;
        //扫面遍历的结果，找出可能存在错误交换的节点x和y
        for(int i=0;i<list.size()-1;++i) {
            if(list.get(i).val>list.get(i+1).val) {
                y = list.get(i+1);
                if(x==null) {
                    x = list.get(i);
                }
            }
        }
        //如果x和y不为空，则交换这两个节点值，恢复二叉搜索树
        if(x!=null && y!=null) {
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }
    }

    /**
     * 中序遍历二叉树，并将遍历的结果保存到list中
      * @param node node
     * @param list data
     */
    private void dfs(TreeNode node,List<TreeNode> list) {
        if(node==null) {
            return;
        }
        dfs(node.left,list);
        list.add(node);
        dfs(node.right,list);
    }

}
