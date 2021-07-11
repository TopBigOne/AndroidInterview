package stack.leet_code_20;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  2/27/21 21:11 AM
 * @Desc : 有效的括号（https://leetcode-cn.com/problems/valid-parentheses/）
 * 题解：(https://leetcode-cn.com/problems/valid-parentheses/solution/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/)
 */
public class IsValid {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        map.put('?', '?');


        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) stack.addLast(c);
            else if (map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }

    public boolean isValid2(String s) {
        Map<Character, Character> map = new HashMap<>(16);
        map.put('{', '}');
        map.put('[', ']');
        map.put('(', ')');
        map.put('?', '?');

        if (s.length() > 0 && !map.containsKey(s.charAt(0))) {
            return false;

        }

        Deque<Character> stack = new ArrayDeque<>();
        stack.add('?');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.addLast(c);
            }
            if (map.get(stack.removeLast()) != c) {
                return false;
            }
        }

        return stack.size() == 1;

    }


}


