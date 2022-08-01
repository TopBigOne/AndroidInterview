package string.leet_code_394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 16:05
 * @Desc :
 */
public class DecodeString4 {
    public String decodeString(String s) {
        Deque<Integer> numsStack = new ArrayDeque<>();
        Deque<String> strString = new ArrayDeque<>();
        int repeatCount = 0;
        StringBuilder res = new StringBuilder();
        for (char currChar : s.toCharArray()) {
            // case 1: left char '['
            if (currChar == '[') {
                numsStack.addLast(repeatCount);
                strString.addLast(res.toString());
                repeatCount = 0;
                res = new StringBuilder();
                continue;
            }
            // case 2: right char ']'
            if (currChar == ']') {
                StringBuilder temp = new StringBuilder();
                int count = numsStack.removeLast();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(strString.removeLast() + temp);
                continue;
            }
            // case 3: number char
            if (currChar >= '0' && currChar <= '9') {
                repeatCount = repeatCount * 10 + Integer.parseInt(currChar + "");
                continue;
            }
            // case 4: normal char
            res.append(currChar);

        }

        return res.toString();

    }
}
