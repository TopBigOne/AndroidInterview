package tree.leet_code_106;

import java.util.HashMap;
import java.util.Map;

import tree.TreeNode;


/**
 * @author : dev
 * @version :
 * @Date :  4/18/21 9:38 PM
 * @Desc : 从中序与后序遍历序列构造二叉树 （https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/）
 * <p>
 * 题解：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/solution/hou-xu-bian-li-python-dai-ma-java-dai-ma-by-liwe-2/
 */
public class BuildTree {
    private int[] postorder;
    private Map<Integer, Integer> hash;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int postLen = postorder.length;
        if (inLen != postLen) {
            throw new RuntimeException("输入错误");
        }
        this.postorder = postorder;
        hash = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            hash.put(inorder[i], i);
        }
        return buildTree(0, inLen - 1, 0, postLen - 1);
    }

    private TreeNode buildTree(int inLeft, int inRight, int postLeft, int postRight) {
        if (inLeft > inRight || postLeft > postRight) {
            return null;
        }
        int pivot = postorder[postRight];
        int pivotIndex = hash.get(pivot);
        TreeNode root = new TreeNode(pivot);
        root.left = buildTree(inLeft, pivotIndex - 1, postLeft,
                postRight - inRight + pivotIndex - 1);

        root.right = buildTree(pivotIndex + 1, inRight,
                postRight - inRight + pivotIndex, postRight - 1);
        return root;

    }


}
