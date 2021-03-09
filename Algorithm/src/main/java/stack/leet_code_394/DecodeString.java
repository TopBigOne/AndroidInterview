package stack.leet_code_394;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  3/9/21 6:52 PM
 * @Desc : 字符串解码：https://leetcode-cn.com/problems/decode-string/
 * 题解：https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
 * 视频：https://www.bilibili.com/video/BV1N4411u7ma?from=search&seid=6306896758854197181
 */
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;

        // 存放数字
        LinkedList<Integer> numberStack = new LinkedList<>();
        //
        LinkedList<String> strStack = new LinkedList<>();
        char[] rawChar = s.toCharArray();
        for (Character c : rawChar) {
            if (c == '[') {
                numberStack.addLast(multi);
                strStack.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = numberStack.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(strStack.removeLast() + tmp);
            } else if (c >= '0' && c <= '9') {// c 为数字
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                res.append(c);
            }
        }

        return res.toString();

    }


    public String decodeString2(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder tail = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //  is number.
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                numStack.push(num);

            } else if (c == '[') {
                strStack.push(tail.toString());
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder(strStack.pop());
                int repeatedTimes = numStack.pop();
                for (int j = 0; j < repeatedTimes; j++) {
                    tmp.append(tail);
                }
                tail = tmp;

            } else {
                tail.append(c);
            }
        }
        return tail.toString();

    }

}
