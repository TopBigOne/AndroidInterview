package tree.leet_code_450;

import tree.TreeNode;
import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  2/14/21 12:34 AM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    private static void test1() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(4);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        //  XYLog.d(root);

        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(root, 8);
        //  XYLog.d(root);
    }

    private static void test2() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(4);

        root.right = new TreeNode(8);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(7);
        XYLog.d(root);

        DeleteNode deleteNode = new DeleteNode();
        deleteNode.deleteNode(root, 8);
        XYLog.d(root);
    }


}
