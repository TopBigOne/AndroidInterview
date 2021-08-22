package tree.offer_36;

import java.time.temporal.ChronoUnit;

import tree.Node;

/**
 * @author : dev
 * @version :
 * @Date :  8/4/21 1:08 AM
 * @Desc :
 */
public class TreeToDoublyList2 {
    private  Node pre;
    private  Node head;

    public Node treeToDoublyList(Node root) {

        if (root==null) {
            return null;
        }
        dfs(root);
        head.left = pre;
        pre.right = head;

        return head;

    }

    private void dfs(Node root) {
        if(root==null){
            return;
        }
        dfs(root.left);
        if(pre==null){
            pre =root;
        }else {
            head.right = root;
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }


}
