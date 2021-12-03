package string.leet_code_1446;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  12/1/21 10:31 AM
 * @Desc : https://leetcode-cn.com/problems/consecutive-characters/submissions/
 * <p>
 * 双指针
 * https://leetcode-cn.com/problems/consecutive-characters/solution/gong-shui-san-xie-jian-dan-shuang-zhi-zh-xtv6/
 */
public class MaxPower {
    public static void main(String[] args) {
        String s = "abbbcccc";
        MaxPower maxPower = new MaxPower();
        int result = maxPower.maxPower(s);
        System.out.println("result : " + result);
    }

    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        int res = 0;
        for (char currChar : chars) {
            if (stack.size() > 0) {
                char peekChar = stack.peekFirst();
                if (peekChar == currChar) {
                    count++;
                } else {
                    count = 0;
                }
            }
            stack.offerFirst(currChar);
            res = Math.max(res, count);
        }
        return res + 1;
    }

    public int maxPower2(String s) {
        char[] chars = s.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();
        int count = 0;
        int res = 0;
        for (char c : chars) {
            if (!stack.isEmpty() && stack.peekFirst() == c) {
                count++;
            } else {
                count = 0;
            }
            stack.offerFirst(c);
            res = Math.max(res, count);
        }

        return res + 1;

    }
}
