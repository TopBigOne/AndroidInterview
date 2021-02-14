package tree.leet_code_297;

import tree.TreeNode;
import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  2/14/21 11:32 PM
 * @Desc :
 */
public class Test3 {
    public static void main(String[] args) {
        CodecByPre3 codecByPre2 = new CodecByPre3();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        XYLog.d(root);
        String result = codecByPre2.serialize(root);
        System.out.println("result:"+result);
    }

}
