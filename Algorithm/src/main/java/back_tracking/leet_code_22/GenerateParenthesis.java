package back_tracking.leet_code_22;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : dev
 * @version :
 * @Date :  6/5/21 11:50 PM
 * @Desc :  leetcode 22 括号生成# 字节半年 24 次 https://leetcode-cn.com/problems/generate-parentheses/
 *
 *
 * 题解：https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu-lun-da/
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<>();
        if (n == 0)
            return result.get(0);
        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        result.add(list1);

        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }
            }
            result.add(temp);
        }
        return result.get(n);



    }
}
