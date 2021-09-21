package stack.single_invoke_stack.offer_33;

import java.util.Stack;

/**
 * @author :  dev
 * @version :
 * @Date :    2021/9/19 21:02
 * @Url :   https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * @Level :    medium
 * @Desc : 二叉搜索树的后序遍历序列：  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，
 * 否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @Counter :   4
 * @Answer : https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
 * https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/55ja2j/
 * <p>
 * <p>
 * 试一下 单调栈解法
 */
public class VerifyPostorder2 {
    public boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        // 从后向前遍历
        int length = postorder.length - 1;
        for (int i = length; i >= 0; i--) {
            int curr = postorder[i];
            if (curr > root) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() > curr) {
                root = stack.pop();
            }
            stack.add(curr);
        }

        return true;
    }

    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--) {
            int curr = postorder[i];
            if (curr > root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() > curr) {
               root = stack.pop();
            }
            stack.add(curr);

        }

        return true;

    }


}
