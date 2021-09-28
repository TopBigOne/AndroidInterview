package stack.single_invoke_stack.leet_code_255;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

import javax.swing.text.html.HTMLWriter;

/**
 * @author : dev
 * @version :
 * @Date :  9/27/21 7:26 PM
 * @Desc :  leet code 255 （单调栈） 验证前序遍历序列二叉树：https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/
 * <p>
 * 题解：https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/solution/python3-tu-jie-by-ml-zimingmeng/
 */
public class VerifyPreorder {
    public boolean verifyPreorder(int[] preorder) {
        int len = preorder.length;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;

        for (int currValue : preorder) {
            if (currValue < min) {
                // 这里，根节点小于右子树，不符合搜索二叉树定义，即：右子树递增
                return false;
            }
            int index = stack.size() - 1;
            while (index != -1 && currValue > stack.get(index)) {
                min = stack.pop();
            }
            stack.add(currValue);
        }

        return true;

    }

    public boolean verifyPreorder2(int[] preorder) {
        int len = preorder.length;
        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int curValue : preorder) {
            int index = stack.size() - 1;
            if (curValue < min) {
                return false;
            }
            while (index != -1 && curValue > stack.get(index--)) {
                min = stack.pop();
            }
            stack.add(curValue);
        }
        return true;

    }

}
