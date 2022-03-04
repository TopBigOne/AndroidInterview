package string.xiaomi;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/2/21 20:01
 * @Url :
 * @Level :  easy  medium hard
 * @Desc :
 * @Counter :
 * @Answer :
 */
public class DeleteDuplicateChar {

    public static void main(String[] args) {

        DeleteDuplicateChar deleteDuplicateChar = new DeleteDuplicateChar();
        //  String str = "abccbef";
        String str = "abccdp";
        String result = deleteDuplicateChar.delete(str);
        System.out.println("***************: " + result);

    }

    /**
     * 16. 删除给定的字符串中的相邻重复字符，比如如下示例：
     * eg1：输入 abccbef ,输出aef,
     * eg2：输入 abccdp ,输出 abdp,
     *
     * @param str
     */
    public String delete(String str) {
        // ? 什么时候终止探测循环体？
        Deque<Character> stack = new ArrayDeque<>();
        for (char currChar : str.toCharArray()) {
            boolean isCanPush = true;
            // check
            while (!stack.isEmpty() && stack.peek() == currChar) {
                stack.pop();
                isCanPush = false;
            }
            // put
            if (isCanPush) {
                stack.push(currChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
