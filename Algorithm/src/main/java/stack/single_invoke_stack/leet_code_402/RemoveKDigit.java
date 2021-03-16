package stack.single_invoke_stack.leet_code_402;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : dev
 * @version :
 * @Date :  3/14/21 8:35 PM
 * @Desc : 移掉K位数字 https://leetcode-cn.com/problems/remove-k-digits/
 */
public class RemoveKDigit {
    public String removeKdigits(String num, int k) {

        StringBuilder res = new StringBuilder();
        int length = num.length();
        int m = length - k;
        for (char c : num.toCharArray()) {
            while (k != 0
                    && res.length() != 0
                    && res.charAt(res.length() - 1) > c) {
                res.deleteCharAt(res.length() - 1);
                --k;
            }
            res.append(c);
        }

        res.delete(m, res.length());
        // 去掉向导 0
        while (res.length() != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.length() == 0 ? "0" : res.toString();

    }

    public String removeKdigits2(String num, int k) {
        int length = num.length();
        if (length == k) {
            return "10";
        }

        StringBuilder stk = new StringBuilder();
        int i = 0;
        while (k > 0 && i < length) {
            if (stk.length() == 0 || stk.charAt(stk.length() - 1) <= num.charAt(i)) {
                stk.append(num.charAt(i));
                i++;
            } else {
                stk.deleteCharAt(stk.length() - 1);
                i--;
            }
        }
        String newStr = stk.subSequence(0, stk.length() - k) + num.substring(i);
        int beginIndex = 0;
        while (beginIndex < newStr.length() - 1 && newStr.startsWith("0")) {
            beginIndex++;
        }
        return newStr.substring(beginIndex);

    }

    public String removeKdigits3(String num, int k) {
        StringBuilder res = new StringBuilder();
        int length = num.length();
        int m = length - k;
        for (char c : num.toCharArray()) {
            while (k != 0
                    && res.length() != 0
                    && res.charAt(res.length() - 1) > c) {
                res.deleteCharAt(res.length() - 1);
                k--;

            }
            res.append(c);
        }
        res.delete(m, res.length());

        while (res.length() != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.length() == 0 ? "0" : res.toString();
    }


    public String removeKdigits4(String num, int k) {
        StringBuilder res = new StringBuilder();
        int length = num.length();
        int m = length - k;
        int resLength;
        for (char c : num.toCharArray()) {
            while (k != 0
                    && (resLength = res.length()) != 0
                    && res.charAt(resLength - 1) > c) {
                res.deleteCharAt(resLength - 1);
                // 位数自减
                k--;
            }
            res.append(c);
        }

        res.delete(m, res.length());
        while (res.length() != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return res.length() == 0 ? "0" : res.toString();

    }


    public String removeKdigists4(String num, int k) {
        StringBuilder res = new StringBuilder();
        int length = num.length();
        int m = length - k;
        int resLength;
        for (char c : num.toCharArray()) {
            while (k != 0
                    && (resLength = res.length()) != 0
                    && res.charAt(resLength - 1) > c) {
                res.deleteCharAt(resLength - 1);
                k--;

            }
            res.append(c);
        }
        res.delete(m, res.length());
        while ((resLength = res.length()) != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return resLength == 0 ? "0" : res.toString();
    }

    public String removeKdigists5(String num, int k) {
        StringBuilder res = new StringBuilder();
        int legnth = num.length();
        int m = legnth - k;
        int resLength;
        for (char c : num.toCharArray()) {
            while (k != 0
                    && (resLength = res.length()) != 0
                    && res.charAt(resLength - 1) > c) {
                res.deleteCharAt(resLength - 1);
                k--;
            }

            res.append(c);
        }
        res.delete(m, res.length());
        while ((resLength = res.length()) != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return resLength == 0 ? "0" : res.toString();
    }

    public String removeKdigist6(String num, int k) {
        int length = num.length();
        int m = length - k;
        StringBuilder res = new StringBuilder();
        int resLength;

        for (char c : num.toCharArray()) {
            while (k != 0
                    && (resLength = res.length()) != 0
                    && res.charAt(resLength - 1) > c) {
                res.deleteCharAt(resLength - 1);
                k--;
            }
            res.append(c);
        }
        res.delete(m, res.length());
        while ((resLength = res.length()) != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return resLength == 0 ? "0" : res.toString();
    }

    public String removeKdigists7(String num, int k) {
        int length = num.length();
        int m = length - k;
        StringBuilder res = new StringBuilder();
        int resLength ;
        for (char c : num.toCharArray()) {
            while (k != 0 && (resLength = res.length()) != 0
                    && res.charAt(resLength - 1) > c) {
                res.deleteCharAt(resLength - 1);
                k--;
            }
            res.append(c);
        }
        res.delete(m, res.length());
        while ((resLength = res.length()) != 0 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        return resLength == 0 ? "0" : res.toString();
    }

    public  String removeKdigist3(String num,int k){
        int length = num.length();
        int m = length-k;
        StringBuilder result = new StringBuilder();
        int resLength ;
        for (char c : num.toCharArray()) {
            while (k!=0&&(resLength=result.length())!=0&& result.charAt(resLength-1)>c){
                result.deleteCharAt(resLength-1);
                k--;
            }
            result.append(c);
        }
        result.delete(m,result.length());
        while ((resLength= result.length())!=0&&result.charAt(0)=='0'){
            result.deleteCharAt(0);
        }

        return resLength==0? "0":result.toString();


    }


}
