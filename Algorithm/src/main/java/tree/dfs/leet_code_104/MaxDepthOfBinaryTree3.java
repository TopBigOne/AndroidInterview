package tree.dfs.leet_code_104;

import java.util.Deque;
import java.util.LinkedList;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/31 19:44
 * @Desc :
 */
public class MaxDepthOfBinaryTree3 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        //创建一个队列
        Deque<TreeNode> deque = new LinkedList<>();
        deque.push(root);
        int count = 0;
        while (!deque.isEmpty()) {
            //每一层的个数
            int size = deque.size();
            while (size-- > 0) {
                TreeNode cur = deque.pop();
                if (cur.left != null){
                    deque.addLast(cur.left);
                }
                if (cur.right != null){
                    deque.addLast(cur.right);
                }
            }
            count++;
        }
        return count;
    }

}
