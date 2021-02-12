package tree;

/**
 * @author : dev
 * @version :
 * @Date :  2/12/21 3:12 PM
 * @Desc :  a binary tree node.
 */
public class TreeNode extends BasicTreeNode<Integer> {
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        super(val);
    }

    @Override
    public BasicTreeNode<Integer> left() {
        return left;
    }

    @Override
    public BasicTreeNode<Integer> right() {
        return right;
    }
}
