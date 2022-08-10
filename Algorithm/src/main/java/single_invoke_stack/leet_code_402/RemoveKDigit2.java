package single_invoke_stack.leet_code_402;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/10 15:27
 * @Desc : 402. 移掉 K 位数字 : https://leetcode.cn/problems/remove-k-digits/
 */
public class RemoveKDigit2 {
    public String removeKdigits(String num, int k) {

        StringBuilder stack = new StringBuilder();
        int remain = num.length() - k;

        int stackLength = 0;
        for (char currChar : num.toCharArray()) {
            while (k != 0 && (stackLength = stack.length()) != 0
                    && stack.charAt(stackLength - 1) > currChar) {
                stack.deleteCharAt(stackLength - 1);
                k--;
            }
            stack.append(currChar);
        }
        stack.delete(remain, stack.length());
        while ((stackLength = stack.length()) != 0 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }
        return stackLength == 0 ? "0" : stack.toString();


    }

    public String removeKdigits2(String num, int k) {
        StringBuilder stack = new StringBuilder();
        int stackLen = 0;
        int remain = num.length()-k;
        for (char currChar : num.toCharArray()) {
            while (k != 0 && (stackLen = stack.length()) != 0 &&
                    stack.charAt(stackLen - 1) > currChar) {
                stack.deleteCharAt(stackLen - 1);
                k--;
            }
            stack.append(currChar);
        }
        stack.delete(remain, stack.length());
        while ((stackLen = stack.length()) != 0 && stack.charAt(0) == '0') {
            stack.deleteCharAt(0);
        }
        return stackLen == 0 ? "0" : stack.toString();


    }
}
