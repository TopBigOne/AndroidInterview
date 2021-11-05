package tree.leet_code_536;

import tree.TreeNode;

import java.util.Stack;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/10/17 23:41
 * @Url :
 * @Level :    medium
 * @Desc :
 * @Counter :
 * @Answer :  https://leetcode-cn.com/problems/construct-binary-tree-from-string/solution/java-shi-yong-stack-by-zxy0917/
 * 相似题目
 */
public class Str2tree {
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) return null;

        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') stack.pop();
            else if (s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '-') {
                int start = i;
                //找到根元素的值
                while (i < s.length() - 1 && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                TreeNode root = new TreeNode(Integer.parseInt(s.substring(start, i + 1)));
                //获取父节点
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) parent.left = root;
                    else parent.right = root;
                }

                //压栈
                stack.push(root);
            }
        }
        if (stack.isEmpty()) return null;
        return stack.peek();
    }

    public TreeNode str2tree2(String s) {
        int length = 0;
        if (s == null || (length = s.length()) == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char currChar = s.charAt(i);

            if (currChar == ')') {
                stack.pop();
                continue;
            }
            if (currChar > '0' && currChar <= '9' || currChar == '-') {

                int start = i;
                while (i < length && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') {
                    i++;
                }
                TreeNode root = new TreeNode(Integer.parseInt(s.substring(start, i + 1)));
                // 获取父节点
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = root;

                    } else {
                        parent.right = root;
                    }
                }

                stack.push(root);
            }
        }
        if (stack.isEmpty()) return null;
        return stack.peek();

    }


}
