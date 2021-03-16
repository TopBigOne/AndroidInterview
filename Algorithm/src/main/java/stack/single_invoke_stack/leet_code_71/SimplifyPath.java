package stack.single_invoke_stack.leet_code_71;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author : dev
 * @version :
 * @Date :  3/16/21 9:05 PM
 * @Desc :  简化路径（https://leetcode-cn.com/problems/simplify-path/solution/）
 * 题解：https://leetcode-cn.com/problems/simplify-path/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-18/
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        String[] dirs = path.split("/");
        Deque<String> deque = new LinkedList<>();

        //1.先作为栈，入栈和出栈
        for (String dir : dirs) {
            //".."表示切换到父目录，故要使当前目录即栈顶出栈
            if (!deque.isEmpty() && "..".equals(dir)) {
                deque.pop();
            } else if (!"".equals(dir)
                    && !".".equals(dir)
                    && !"..".equals(dir)) {
                deque.push(dir);
            }
        }

        //特判为空时，返回根目录
        if (deque.isEmpty()) {
            return "/";
        }

        //2.作为队列，进行路径的拼接
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollLast());
        }

        return sb.toString();
    }

    public String simplifyPath2(String path) {
        String[] dirs = path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (String dir : dirs) {
            if (!deque.isEmpty() && "..".equals(dir)) {
                deque.pop();
                continue;
            }
            if (!"".equals(dir)
                    && !".".equals(dir)
                    && !"..".equals(dir)) {
                deque.push(dir);
            }
        }

        if (deque.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append("/").append(deque.pollLast());
        }

        return sb.toString();

    }


}
