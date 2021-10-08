package tree.leet_code_99;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/1 14:55
 * @Url : https://leetcode-cn.com/problems/recover-binary-search-tree/
 * @Level :    medium
 * @Desc : 恢复二叉搜索树
 * @Counter : 3
 * @Answer : https://leetcode-cn.com/problems/recover-binary-search-tree/solution/san-chong-jie-fa-xiang-xi-tu-jie-99-hui-fu-er-cha-/
 */
public class RecoverTree2 {
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        //使用中序遍历
        dfs(root, list);
        TreeNode x = null;
        TreeNode y = null;
        // 扫描遍历结果，找出可能存在交换的节点x和y
        for (int i = 0; i < list.size() - 1; i++) {
            int currValue = list.get(i).val;
            int nextValue = list.get(i + 1).val;
            if(currValue>nextValue){
                y = list.get(i+1);
                if(x==null){
                    x = list.get(i);
                }

            }

        }
        // 如果x和y不为空，则交换这两个节点值，恢复二叉树
        if(x!=null&&y!=null){
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }
    }
    private void dfs(TreeNode node ,List<TreeNode> list){
        if(node==null)  return;
        dfs(node.left,list);
        list.add(node);
        dfs(node.right,list);
    }

}
