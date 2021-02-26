package tree.leet_code_515;

import tree.TreeNode;
import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  2/26/21 9:05 PM
 * @Desc :
 */
public class Test {
    public static void main(String[] args) {

        TreeNode root =new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left= new TreeNode(5);
        root.left.right= new TreeNode(3);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);
        XYLog.d(root);






        LargestValues largestValues = new LargestValues();
        largestValues.largestValues(root);

        int a = 10;


        int val = Math.max(-2,0);
        System.out.println("val: "+val);

    }
}
