package tree.leet_code_662;

import java.io.PrintStream;
import java.io.PushbackInputStream;
import java.util.HashMap;
import java.util.Map;

import array.leet_code_11.MaxArea;
import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  8/15/21 1:26 PM
 * @Desc : 二叉树的最大宽度
 */
public class WidthOfBinaryTree5 {
    int ans = 0;
    Map<Integer,Integer> left;
    public int widthOfBinaryTree(TreeNode root){
        left = new HashMap<>();
        dfs(root,0,0);
        return ans;

    }

    public void dfs(TreeNode root,int depth,int pos){
        if(root==null){
            return;
        }
        PrintStream out = System.out;
        out.println();

        left.computeIfAbsent(depth,x->pos);
        ans = Math.max(ans,pos-left.get(depth)+1);
        dfs(root.left,depth+1,2*pos);
        dfs(root.right,depth+1,2*pos+1);
    }
}
