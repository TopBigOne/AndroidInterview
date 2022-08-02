package string.leet_code_394;

import java.util.LinkedList;

/**
 * @author :  dev
 * @version :
 * @Date :   2022/1/2 23:56
 * @Url :
 * @Level :    medium
 * @Desc :  394. 字符串解码 https://leetcode.cn/problems/decode-string/
 * @Counter :
 * @Answer :https://leetcode-cn.com/problems/decode-string/solution/decode-string-fu-zhu-zhan-fa-di-gui-fa-by-jyd/
 */
public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString decodeString = new DecodeString();
        String result = decodeString.decodeString(s);
        System.err.println("result : " + result);
    }

    /**
     * "3[a2[c]]"
     * accaccacc
     * <p>
     * "2[abc] 3[cd] ef"
     * abcabccdcdcdef
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();

        LinkedList<String> stack_res = new LinkedList<>();

        for (Character currChar : s.toCharArray()) {
            if (currChar == '[') {
                // 将当前 multi 和 res 入栈，并分别置空置 00
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                // multi和res 分别置空置 00
                multi = 0;
                res = new StringBuilder();
            } else if (currChar == ']') {
                StringBuilder tmp = new StringBuilder();

                // 是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2
                int cur_multi = stack_multi.removeLast();
                for (int i = 0; i < cur_multi; i++) {
                    tmp.append(res);
                }
                // 上一个字符串+ 重复以后的字符串
                res = new StringBuilder(stack_res.removeLast() + tmp);
            } else if (currChar >= '0' && currChar <= '9') {
                // 当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
                multi = multi * 10 + Integer.parseInt(currChar + "");
            } else {
                // 就是普通的字符，在 res 尾部添加 c
                res.append(currChar);
            }
        }
        return res.toString();

    }


}
