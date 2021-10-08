package tree.offer_32;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/6 23:33
 * @Url : https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class LevelOrder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        LevelOrder levelOrder = new LevelOrder();
        int[] result = levelOrder.levelOrder(root);
        System.out.println("result : "+ Arrays.toString(result));


    }

    public int[] levelOrder(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node==null) {
                continue;
            }
            temp.add(node.val);
            System.out.println("curr value :"+node.val);


            TreeNode left = node.left;
            if (left != null) {
                stack.addLast(left);
            }

            TreeNode right = node.right;
            if (right != null) {
                stack.addLast(right);
            }

        }

        return temp.stream().mapToInt(value -> value).toArray();

    }
}
