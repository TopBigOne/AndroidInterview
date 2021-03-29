package stack.leet_code_331;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  2021/3/26 15:27
 * @Desc :给定一个字符串，判断这个字符串是否为一个有效的二叉树
 */
public class IsValidSerialization3 {
    public boolean isValidSerialization(String preloader) {
        String nullNode = "#";
        if (preloader == null || preloader.length() == 0) {
            return false;
        }
        String[] strs = preloader.split(",");
        int strLength = strs.length;
        String charFirst = strs[0];

        if (charFirst.equals(nullNode) && strLength > 1) {
            return false;
        }
        if (charFirst.equals(nullNode)) {
            return true;
        }
        Deque<String> stack = new LinkedList<>();
        int start = 0;
        while (start < strLength) {
            String currChar = strs[start];
            // 遇到不是空节点的（#）直接入栈
            if (!currChar.equals(nullNode)) {
                stack.push(currChar);
                start++;
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

            start++;
        }
        return stack.size() == 1 && stack.peek().equals(nullNode);
    }


    public boolean isValidSerialization3(String preloader) {
        if (preloader == null || preloader.length() == 0) {
            return false;
        }
        String nullNode = "#";
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
        String nullNode = "#";
        String[] strs = preloader.split(",");
        int length = strs.length;
        String firstChar = strs[0];
        if (firstChar.equals(nullNode) && length > 1) {
            return false;
        }
        if (firstChar.equals(nullNode)) {
            return true;
        }
        int index = 0;
        Deque<String> stack = new LinkedList<>();
        while (index < length) {
            String curChar = strs[index];
            if (curChar.equals(nullNode)) {
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
