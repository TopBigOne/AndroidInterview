package tree.leet_code_301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/11/29 23:41
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class RemoveInvalidParentheses2 {

    public static final char LEFT_PARENTHESIS = '(';
    public static final char RIGHT_PARENTHESIS = ')';
    private final Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        int open = 0;
        int close = 0;
        for (char c : ss) {
            if (c == LEFT_PARENTHESIS) {
                open++;
            } else if (c == RIGHT_PARENTHESIS) {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }
        backTracking(ss, new StringBuilder(), 0, 0, 0, open, close);
        return new ArrayList<>(set);
    }

    private void backTracking(char[] ss, StringBuilder sb, int index, int open, int close, int openRem, int closeRem) {
        if (index == ss.length) {
            if (openRem == 0 && closeRem == 0) {
                set.add(sb.toString());
            }
            return;
        }

        char currentChar = ss[index];
        boolean isLeft = currentChar == LEFT_PARENTHESIS;
        boolean isRight = currentChar == RIGHT_PARENTHESIS;
        if (isLeft && openRem > 0 || isRight && closeRem > 0) {
            int tempOpen = openRem - (isLeft ? 1 : 0);
            int tempClose = closeRem - (isRight ? 1 : 0);

            backTracking(ss, sb, index + 1, open, close, tempOpen, tempClose);
        }
        sb.append(currentChar);
        if (currentChar != LEFT_PARENTHESIS && currentChar != RIGHT_PARENTHESIS) {
            backTracking(ss, sb, index + 1, open, close, openRem, closeRem);
        } else if (isLeft) {
            backTracking(ss, sb, index + 1, open + 1, close, openRem, closeRem);
        } else if (open > close) {
            backTracking(ss, sb, index + 1, open, close + 1, openRem, closeRem);
        }
        sb.deleteCharAt(sb.length() - 1);

    }


}
