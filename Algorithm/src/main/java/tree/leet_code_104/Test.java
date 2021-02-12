package tree.leet_code_104;

import tree.TreeNode;
import tree.util.XYLog;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/21 3:18 PM
 * @Desc :
 */
public class Test {
    /**
     *  二叉树结构如下：备注，为了可视化的效果，空节点用 nil 表示
     *
     *         3
     *     /       \
     *    9         20
     *  /    \     /   \
     * nil   nil  15    7
     * 1：首先，要明白，这个解法，就是一个递归调用，其内部，还是借用了 java 的操作数栈；
     * 2：费点力气，手动还原一下调用栈；
     * a:  maxDepth(root.right);
     *    这行代码执行以后，栈的就是：
     *    -------
     *    |  nil |
     *    -------
     *    |  20 |
     *    -------
     *    |  7  |
     *    -------
     *
     * b : maxDepth(root.left);
     *    栈结构如下
     *    ------
     *    |  9 |
     *    ------
     *    | nil|
     *    -------
     *    | 15 |
     *    ------
     * 请注意，上面的栈结构是理想化情况，在递归的时候，nil 节点是空节点，将会被 rerutn 掉,不计数；
     * 以 maxDepth(root.left) 方法调用为例：
     * 在操作数栈中， 栈的弹出依次是 9---->15;
     * 每次弹出，都用一个 depth 来计数，表示栈的深度；经过 2 次弹栈操作；depth 的值是 2，
     * 再加上 root 节点（depth+1），那就是 3；
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
       root.left = new TreeNode(9);
      //  root.left.left = new TreeNode(32);
         root.left.right = new TreeNode(66);

        root.right = new TreeNode(20);
       //root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        XYLog.d(root);

        MaxDepthOfBianryTree tree = new MaxDepthOfBianryTree();
        int result = tree.maxDepth(root);
        System.out.println("result:" + result);

    }
}
