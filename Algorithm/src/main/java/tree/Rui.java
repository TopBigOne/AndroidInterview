package tree;

import java.util.ArrayList;
import java.util.List;

import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  3/16/21 11:23 AM
 * @Desc :
 */
public class Rui {
    List<Integer> result = new ArrayList<>();
    public List<Integer> bfs(TreeNode tree) {
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(tree);
        return a(treeNodes);

    }

    public List<Integer> a(List<TreeNode> list) {
        if(list.size()==0){
            return null;
        }
        List<TreeNode> list1 = new ArrayList<>();
        for (int x = 0; x < list.size(); x++) {
            result.add(list.get(x).val);

            if (list.get(x).left != null) {
                list1.add(list.get(x).left);
            }

            if (list.get(x).right != null) {
                list1.add(list.get(x).right);
            }
        }
        a(list1);
        return result;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(7);
        root.right.right= new TreeNode(20);
        root.right.left.left = new TreeNode(6);
        root.right.right.right= new TreeNode(30);
        XYLog.d(root);

        Rui rui = new Rui();
        List<Integer> list = rui.bfs(root);
        System.out.println("result: "+list);

    }
}
