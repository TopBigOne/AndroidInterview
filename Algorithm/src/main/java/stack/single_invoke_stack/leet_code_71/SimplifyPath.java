package stack.single_invoke_stack.leet_code_71;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : dev
 * @version :
 * @Date :  3/16/21 9:05 PM
 * @Desc :  简化路径（https://leetcode-cn.com/problems/simplify-path/solution/）
 * 题解：https://leetcode-cn.com/problems/simplify-path/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-18/
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * <p>
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 返回简化后得到的 规范路径 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 * <p>
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * 示例 3：
 * <p>
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 * <p>
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
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

    public String simplifyPath3(String path) {
        String SPLIT_SYMBLE_LEFT = "/";
        String SPLIT_SYMBLE_ONE = ".";
        String SPLIT_SYMBLE_TWO = "..";
        String[] dirs = path.split(SPLIT_SYMBLE_LEFT);
        Deque<String> deque = new LinkedList<>();
        for (String dir : dirs) {
            if (!deque.isEmpty() && SPLIT_SYMBLE_TWO.equals(dir)) {
                deque.pop();
                continue;
            }
            if (!"".equals(dir)
                    && !SPLIT_SYMBLE_ONE.equals(dir)
                    && !SPLIT_SYMBLE_TWO.equals(dir)) {
                deque.push(dir);
            }

        }

        if (deque.isEmpty()) {
            return SPLIT_SYMBLE_LEFT;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(SPLIT_SYMBLE_LEFT).append(deque.pollLast());

        }

        return sb.toString();
    }


    public String simplifyPath4(String path) {
        String left = "/";
        String noneDot = "";
        String oneDot = ".";
        String twoDot = "..";
        Deque<String> deque = new LinkedList<>();
        String[] dirs = path.split(left);
        for (String dir : dirs) {
            if (!deque.isEmpty() && twoDot.equals(dir)) {
                deque.pop();
                continue;
            }

            if (!noneDot.equals(dir) && !oneDot.equals(dir) && !twoDot.equals(dir)) {
                deque.push(dir);
            }
        }

        if (deque.isEmpty()) {
            return left;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(left).append(deque.pollLast());

        }

        return sb.toString();
    }

    public String simplifyPath5(String path) {
        String lef = "/";
        String nodeDot = "";
        String oneDot = ".";
        String twoDot = "..";
        String[] dirs = path.split(lef);
        Deque<String> queue = new LinkedList<>();
        for (String dir : dirs) {
            if (!queue.isEmpty() && twoDot.equals(dir)) {
                queue.pop();
                continue;
            }
            if (!nodeDot.equals(dir) && !oneDot.equals(dir) && !twoDot.equals(dir)) {
                queue.push(dir);
            }
        }
        if (queue.isEmpty()) {
            return lef;
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(lef).append(queue.pollLast());

        }
        return sb.toString();
    }

    public String simplifyPath6(String path) {
        String left = "/";
        String noneDot = "";
        String oneDot = ".";
        String twoDot = "..";
        Deque<String> deque = new LinkedList<>();
        String[] dirs = path.split(left);
        for (String dir : dirs) {
            if (!deque.isEmpty() && twoDot.equals(dir)) {
                deque.pop();
                continue;
            }
            if (!noneDot.equals(dir) && !oneDot.equals(dir) && !twoDot.equals(dir)) {
                deque.push(dir);
            }
        }

        if (deque.isEmpty()) {
            return left;
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(left).append(deque.pollLast());

        }

        return sb.toString();

    }


    public String simplifyPath7(String path) {
        String left = "/";
        String noneDot = "";
        String oneDot = ".";
        String twoDot = "..";
        Deque<String> queue = new LinkedList<>();
        String[] dirs = path.split(left);
        for (String dir : dirs) {
            if (!queue.isEmpty() && twoDot.equals(dir)) {
                queue.pop();
                continue;
            }
            if (!noneDot.equals(dir) && !oneDot.equals(dir) && !twoDot.equals(dir)) {
                queue.push(dir);
            }

        }
        if (queue.isEmpty()) {
            return left;
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(left).append(queue.pollLast());
        }

        return sb.toString();

    }

    public String simplifyPath8(String path) {
        String left = "/";
        String noneDot = "";
        String oneDot = ".";
        String twoDot = "..";
        Deque<String> deque = new ArrayDeque<>();
        String[] dirs = path.split(left);
        for (String dir : dirs) {
            if (!deque.isEmpty() && twoDot.equals(dir)) {
                deque.pop();
                continue;
            }
            if (!noneDot.equals(dir) && !oneDot.equals(dir) && !twoDot.equals(dir)) {
                deque.push(dir);
            }
        }

        if (deque.isEmpty()) {
            return left;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(left).append(deque.pollLast());
        }

        return sb.toString();

    }


}
