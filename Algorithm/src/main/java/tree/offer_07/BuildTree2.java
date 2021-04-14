package tree.offer_07;

import com.top.jar.chapter_001.t_04.pet.Pet;

import java.util.TreeMap;

import tree.TreeNode;

/**
 * @author : dev
 * @version :
 * @Date :  4/14/21 11:30 PM
 * @Desc :
 */
public class BuildTree2 {
    private int pre, in = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelp(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }

    private TreeNode buildTreeHelp(int[] preorder, int[] inorder, long stop) {
        if (pre == preorder.length) {
            return null;
        }
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTreeHelp(preorder, inorder, rootValue);
        root.right = buildTreeHelp(preorder, inorder, stop);
        return root;
    }

    private TreeNode  buildTreeHelp2(int [] preorder,int [] inorder,int stop){
        if(pre==preorder.length){
            return  null;
        }
        if(inorder[in] ==stop){
            in++;
            return null;
        }
        int rootValue = preorder[pre++];
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTreeHelp2(preorder,inorder,rootValue);
        root.right = buildTreeHelp2(preorder,inorder,stop);
        return root;
    }
}
