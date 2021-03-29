package stack.leet_code_331;

import java.util.Deque;
import java.util.LinkedList;

/*
 * @author : dev
 * @version :
 * @Date :  2021/3/26 14:32
 * @Desc :
 * 两种思路，一个是利用栈，一个是利用树的度。
 *
 * 题解（https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree/solution/pai-an-jiao-jue-de-liang-chong-jie-fa-zh-66nt/）
 */


public class IsValidSerialization2 {

    /**
     * 利用栈
     * @param s
     * @return
     */
    public static boolean isValidSerialization(String s) {
        if (s == null || s.length() == 0) return true;
        String[] str = s.split(",");
        int n = str.length;
        if ("#".equals(str[0]) && n > 1) return false;
        if ("#".equals(str[0])) return true;

        Deque<String> stack = new LinkedList<>();
        int i = 0;
        while ( i < n ) {
            String c = str[i];
            // 遇到的不是'#'，直接入栈
            if (!"#".equals(c)) {
                stack.push(c);
                i++;
            } else {
                // 遇到'#'，当前栈顶也是'#'，弹出2个字符，压入1个'#'
                if ("#".equals(stack.peek())){
                    stack.pop();
                    if (stack.isEmpty()) return false;
                    stack.pop();
                    // i 位置不动，继续处理当前字符'#'，循环判断是否依旧满足2）
                    // 栈顶不是'#'，直接入栈
                } else {
                    stack.push(c);
                    i++;
                }
            }
        }
        return stack.size() == 1 && "#".equals(stack.peek());
    }






    /**
     *
     * 对于任何有向图，所有顶点的出度之和总是等于入度之和，我们把二叉树看作一个连通无环的有向图，
     * 也应该满足这个条件。非空节点的入度总是为1，出度在0-2之间。
     * 但是在这里可以这样规定：
     * 将非空节点的入度设为1，出度设为2，空节点的入度设为1，出度设为0.
     * 扫描字符串，计算累加出度和（in）以及入度和(out)，如果中途出现入度和（in）大于出度和（out）的情况
     * ,说明不满足二叉树的先序序列。扫描结束后out不等于in,不满足图的性质，更不符合二叉树的性质。
     *
     *

     * @param preorder
     * @return
     */
    public boolean isValidSerialization2(String preorder) {
        char[] str=preorder.toCharArray();
        int out=0,in=-1;
        for(int i=0;i<str.length;i++){
            if(str[i]==',') continue;
            in++;
            if(out<in) return false;
            if(str[i]<='9'&&str[i]>='0'){
                out+=2;
                while(i<str.length-1&&str[i+1]>='0'&&str[i+1]<='9') i++;
            }
        }
        return out==in;
    }



}
