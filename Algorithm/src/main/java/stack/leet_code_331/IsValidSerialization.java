package stack.leet_code_331;

import java.util.Deque;
import java.util.LinkedList;

/*
 *  repo init -u https://mirrors.tuna.tsinghua.edu.cn/git/AOSP/platform/manifest -b android-11.0.0_r9 --depth=1 --platform=auto
 * @author : dev
 * @version :
 * @Date :  2021/3/26 14:32
 * @Desc : 验证：二叉树前序遍历序列化
 * 两种思路，一个是利用栈，一个是利用树的度。
 * 这个类的主要解法是利用 栈；
 *
 * 题解（https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt/）
 */


public class IsValidSerialization {
    /*
     * 利用栈
     *
     * @param
     * @return
     */
    public boolean isValidSerialization1(String s) {
        // 空节点
        String nullNode = "#";
        if (s == null || s.length() == 0) {
            return true;
        }

        String[] str = s.split(",");
        int strLength = str.length;
        String charFirst = str[0];
        if (nullNode.equals(charFirst) && strLength > 1) {
            return false;
        }
        if (nullNode.equals(charFirst)) {
            return true;
        }

        Deque<String> stack = new LinkedList<>();
        int start = 0;
        while (start < strLength) {
            String c = str[start];
            if (!nullNode.equals(c)) {
                // 遇到的不是'#'，直接入栈
                stack.push(c);
                start++;
                continue;
            }
            // 遇到'#'，当前栈顶也是'#'，弹出2个字符，压入1个'#'
            if (nullNode.equals(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                continue;
            }
            // start 位置不动，继续处理当前字符'#'，循环判断是否依旧满足2）
            // 栈顶不是'#'，直接入栈
            stack.push(c);
            start++;
        }

        return stack.size() == 1 && nullNode.equals(stack.peek());


    }


    public boolean isValidSerialization3(String preloader) {
        String nullNode = "#";
        if (preloader == null || preloader.length() == 0) {
            return false;
        }
        String[] strs = preloader.split(",");
        int strLength = strs.length;
        String firstChar = strs[0];
        if (firstChar.equals(nullNode) && strLength > 1) {
            return false;
        }
        if (firstChar.equals(nullNode)) {
            return true;
        }
        Deque<String> stack = new LinkedList<>();
        int index = 0;
        while (index < strLength) {
            String currChar = strs[index];
            // 遇到不是空节点的（#）直接入栈
            if (!currChar.equals(nullNode)) {
                stack.push(currChar);
                index++;
                continue;
            }
            if (nullNode.equals(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(currChar);
            index++;
        }

        return stack.size() == 1 && stack.peek().equals(nullNode);
    }

    public boolean isValidSerialization4(String preloader) {
        if (preloader == null || preloader.length() == 0) {
            return false;
        }
        String[] strs = preloader.split(",");
        int length = strs.length;
        String firstChar = strs[0];
        String nullNode = "#";
        if (firstChar.equals(nullNode) && length > 1) {
            return false;
        }

        if (firstChar.equals(nullNode)) {
            return true;
        }
        Deque<String> stack = new LinkedList<>();
        int index = 0;
        while (index < length) {
            String curChar = strs[index];
            if (!curChar.equals(nullNode)) {
                stack.push(curChar);
                index++;
                continue;
            }

            if (nullNode.equals(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(curChar);
            index++;
        }
        return stack.size() == 1 && stack.peek().equals(nullNode);

    }


    public boolean isValidSerialization5(String preloader) {
        if (preloader == null || preloader.length() == 0) {
            return false;
        }
        String[] str = preloader.split(",");
        String nullNode = "#";
        int length = str.length;
        String firstStr = str[0];
        if (firstStr.equals(nullNode) && length > 1) {
            return false;
        }

        if (firstStr.equals(nullNode)) {
            return true;
        }

        int index = 0;
        Deque<String> stack = new LinkedList<>();
        while (index < length) {
            String curChar = str[index];
            if (!curChar.equals(nullNode)) {
                stack.push(curChar);
                index++;
                continue;
            }
            if (curChar.equals(stack.peek())) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
                continue;
            }
            stack.push(curChar);
            index++;
        }
        return stack.size() == 1 && stack.peek().equals(nullNode);
    }



}








