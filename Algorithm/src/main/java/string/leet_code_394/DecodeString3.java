package string.leet_code_394;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 14:56
 * @Desc :
 */
public class DecodeString3 {

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString3 decodeString = new DecodeString3();
        String result = decodeString.decodeString(s);

        System.err.println("result : " + result.equals("accaccacc"));
    }

    public String decodeString(String s) {
        Deque<Integer> repeatStack = new ArrayDeque<>();
        Deque<String> strStack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int repeatCount = 0;
        for (char currChar : s.toCharArray()) {
            // case 1: [ left
            if (currChar == '[') {
                repeatStack.addLast(repeatCount);
                strStack.addLast(res.toString());
                repeatCount = 0;
                res = new StringBuilder();
                continue;
            }
            // case 2: ] right
            if (currChar == ']') {
                StringBuilder temp = new StringBuilder();
                int currRepeat = repeatStack.removeLast();
                for (int i = 0; i < currRepeat; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(strStack.removeLast() + temp);
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
