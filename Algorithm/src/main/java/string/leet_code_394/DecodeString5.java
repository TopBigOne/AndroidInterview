package string.leet_code_394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 12:13
 * @Desc :  394. 字符串解码 https://leetcode.cn/problems/decode-string/
 */
public class DecodeString5 {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString5 decodeString = new DecodeString5();
        String result = decodeString.decodeString(s);
        System.err.println("result : " + result);
    }

    /**
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int repeatCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            // case 1: left [
            if (currChar == '[') {
                numStack.addLast(repeatCount);
                strStack.addLast(sb.toString());
                repeatCount = 0;
                sb = new StringBuilder();
                continue;
            }

            // case 2: right ]
            if (currChar == ']') {
                StringBuilder temp = new StringBuilder();
                int count = numStack.removeLast();
                for (int i1 = 0; i1 < count; i1++) {
                    temp.append(sb);
                }
                sb = new StringBuilder(strStack.removeLast() + temp);
                continue;
            }

            // case 3: number char
            if (currChar >= '0' && currChar <= '9') {
                repeatCount = repeatCount * 10 + Integer.parseInt(currChar + "");
                continue;
            }

            // case 4: normal char
            sb.append(currChar);

        }
        return sb.toString();

    }
}
