package single_invoke_stack.leet_code_20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author : dev
 * @version :
 * @Date :  3/14/21 7:45 PM
 * @Desc :有效的括号：https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValid {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
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
}
