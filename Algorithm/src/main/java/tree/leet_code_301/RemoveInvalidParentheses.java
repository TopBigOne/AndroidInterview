package tree.leet_code_301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : dev
 * @version :
 * @Date :  11/29/21 9:25 PM
 * @Desc :   删除无效括号：https://leetcode-cn.com/problems/remove-invalid-parentheses/
 * 给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * <p>
 * <p>
 * <p>
 * 题解：
 */
public class RemoveInvalidParentheses {

    private final Set<String> set = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        char[] ss = s.toCharArray();
        int open = 0;
        int close = 0;
        // 获取应该去除的左右括号数
        for (char c : ss) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        // 回溯
        backTracking(ss, new StringBuilder(), 0, 0, 0, open, close);
        return new ArrayList<>(set);
    }

    /**
     * 分别对字符串中的每一位置的字符进行处理，最终获得符合要求的字符串加入集合中
     *
     * @param ss       字符串数组
     * @param sb       存储当前处理过且未去除字符法人字符串
     * @param index    当前处理的字符串位置
     * @param open     当前 sb 中存储的左括号数
     * @param close    当前 sb 中存储的右括号数
     * @param openRem  当前需要去除的额左括号数
     * @param closeRem 当前需要去除的右括号数
     */
    private void backTracking(char[] ss, StringBuilder sb, int index, int open, int close, int openRem, int closeRem) {
        // 所有的字符都处理完毕
        if (index == ss.length) {
            // 如果应去除的左右括号数都变为 0 ，则将 sb 插入 set
            if (openRem == 0 && closeRem == 0) {
                set.add(sb.toString());
            }
            return;
        }

        // 去掉当前位置的字符（括号）。并处理下一个字符
        if (ss[index] == '(' && openRem > 0 || ss[index] == ')' && closeRem > 0) {
            backTracking(ss, sb, index + 1, open, close, openRem - ((ss[index] == '(') ? 1 : 0),
                    closeRem - (ss[index] == ')' ? 1 : 0));

            // 不去掉当前位置字符
            // 将当前位置字符插入 sb
            sb.append(ss[index]);
            // 当前位置不为括号，则直接处理下一个字符
            if (ss[index] != '(' && ss[index] != ')') {
                backTracking(ss, sb, index + 1, open, close, openRem, closeRem);
            } else if (ss[index] == '(') {
                backTracking(ss, sb, index + 1, open + 1, close, openRem, closeRem);
            } else if (open > close) {
                backTracking(ss, sb, index + 1, open, close + 1, openRem, closeRem);
            }
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
