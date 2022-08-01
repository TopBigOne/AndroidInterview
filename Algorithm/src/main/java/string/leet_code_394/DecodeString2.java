package string.leet_code_394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 14:44
 * @Desc :
 */
public class DecodeString2 {
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        int repeatTimes = 0;
        for (char currChar : s.toCharArray()) {
            // case 1: [
            if (currChar == '[') {
                numStack.addLast(repeatTimes);
                strStack.addLast(res.toString());
                repeatTimes = 0;
                res = new StringBuilder();
                continue;
            }
            // case 2: ]
            if (currChar == ']') {
                StringBuilder temp = new StringBuilder();
                int currRepeat = numStack.removeLast();
                for (int i = 0; i < currRepeat; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(strStack.removeLast() + temp);
                continue;
            }
            // case 3: 字符
            if (currChar >= '0' && currChar <= '9') {
                repeatTimes = repeatTimes * 10 + Integer.parseInt(currChar + "");
                continue;
            }
            // case 4: normal char
            res.append(currChar);
        }
        return res.toString();


    }
}
