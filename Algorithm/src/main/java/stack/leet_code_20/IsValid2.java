package stack.leet_code_20;

import java.util.ArrayDeque;
import java.util.Deque;

import javax.xml.ws.FaultAction;

/**
 * @author : dev
 * @version :
 * @Date :  7/8/21 12:10 AM
 * @Desc :
 * <p>
 * 题解：https://www.youtube.com/watch?v=o7lQWD8FiIA
 */
public class IsValid2 {
    public boolean isValid(String s) {
        int len;
        // base corner
        if (s == null || (len = s.length()) == 0 ||  (len&1)==0) {
            return false;
        }

        // '('，')'，'{'，'}'，'['，']'
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 1:左边的符号，就做 push 操作
            if (c == '(' ||
                    c == '{' ||
                    c == '[') {
                stack.push(c);
                continue;
            }
            // 2: 判断与右边的 字符能否匹配上；（为了邂逅啊...）
            if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
                continue;
            }
            if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
                continue;
            }

            // 以上 3 个 if 都没有匹配好的话，那还有什么可谈的，，，分手，，分手，，，你就是不配，，，
            return false;

        }

        // 栈，是否为空，空的话，就 ok 啦，，
        return stack.isEmpty();

    }
}
