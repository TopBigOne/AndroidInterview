package stack.single_invoke_stack.leet_code_255;

import java.beans.EventHandler;
import java.util.Stack;

/**
 * @author : dev
 * @version :
 * @Date :  9/28/21 9:54 AM
 * @Desc : 验证二叉搜索树的前序遍历  https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/
 */
public class VerifyPreorder2 {
    public boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int curValue : preorder) {
            int index = stack.size() - 1;
            if (curValue < min) {
                return false;
            }

            while (index != -1 && curValue < stack.get(index--)) {
                min = stack.pop();
            }
            stack.add(curValue);
        }
        return true;
    }
}
