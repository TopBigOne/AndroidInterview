package stack.single_invoke_stack.leet_code_316;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  3/12/21 9:07 PM
 * @Desc : 去除重复字母
 * 题解： https://leetcode-cn.com/problems/remove-duplicate-letters/solution/zhan-by-liweiwei1419/
 */
public class RemoveDuplicateLetter {
    public String removeDuplicateLetters(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        char[] charArray = s.toCharArray();
        int[] lastIndex = new int[26];
        for (int i = 0; i < len; i++) {
            lastIndex[charArray[i] - 'a'] = i;
        }

        Deque<Character> stack = new ArrayDeque<>(len);
        stack.addLast('a');
        boolean[] visited = new boolean[26];
        for (int i = 0; i < len; i++) {
            char currentChar = charArray[i];
            if (visited[currentChar - 'a']) {
                continue;
            }

            Character lastChar;
            while ((lastChar = stack.peekLast()) != null && currentChar < lastChar && lastIndex[lastChar - 'a'] > i) {
                char top = stack.removeLast();
                visited[top - 'a'] = false;
            }

            stack.addLast(currentChar);
            visited[currentChar - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int size = stack.size();
        for (int i = 0; i < size - 1; i++) {
            stringBuilder.insert(0, stack.removeLast());
        }
        return stringBuilder.toString();

    }
}
