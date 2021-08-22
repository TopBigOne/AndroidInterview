package tree.leet_code_662;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.swing.table.TableRowSorter;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  8/11/21 12:36 AM
 * @Desc :  二叉树的最大宽度；leetcode 662 : 二叉树的最大宽度 medium:https://leetcode-cn.com/problems/maximum-width-of-binary-tree/
 *
 */
public class WidthOfBinaryTree2 {
    int ans ;
    Map<Integer,Integer> left;

    /**
     * 按照深度优先的顺序，我们记录每个节点的 position 。对于每一个深度，第一个到达的位置会被记录在 left[depth] 中。
     *
     * 然后对于每一个节点，它对应这一层的可能宽度是 pos - left[depth] + 1 。我们将每一层这些可能的宽度去一个最大值就是答案。
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root){
        ans = 0;
        left = new HashMap<>();
        dfs(root,0,0);
        return ans;
    }

    public void dfs(TreeNode root,int depth,int pos){
        if(root==null){
            return;
        }
        left.computeIfAbsent(depth, integer -> pos);
        ans = Math.max(ans,pos-left.get(depth)+1);

        dfs(root.left,depth+1,2*pos);
        dfs(root.right,depth+1,2*pos+1);

    }
}
