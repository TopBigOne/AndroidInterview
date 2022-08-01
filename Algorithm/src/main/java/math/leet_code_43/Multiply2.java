package math.leet_code_43;

import java.util.Arrays;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 18:30
 * @Desc :
 */
public class Multiply2 {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        // at most (m + n) digits
        int[] res = new int[m + n];
        // start from the rightmost digit
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // the index of multiply at res
                int p1 = i + j;
                int p2 = i + j + 1;
                // add results to res
                int sum = mul + res[p2];
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }
        }

        // in case zeros at prefix
        int i = 0;
        while (i < res.length && res[i] == 0) {
            i++;
        }
        // convert result to String
        StringBuilder sb = new StringBuilder();
        for (; i < res.length; i++) {
            sb.append(res[i]);
        }

        return sb.toString().length() == 0 ? "0" : sb.toString();
    }

    public String multiply2(String num1, String num2) {
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();
        int n1 = chs1.length, n2 = chs2.length;
        char[] res = new char[n1 + n2];
        Arrays.fill(res, '0');

        for (int j = n2 - 1; j >= 0; j--) {
            for (int i = n1 - 1; i >= 0; i--) {
                int product = (chs1[i] - '0') * (chs2[j] - '0');

                int tmp = res[i + j + 1] - '0' + product;
                res[i + j + 1] = (char) (tmp % 10 + '0');
                res[i + j] = (char) ((res[i + j] - '0' + tmp / 10) + '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean seen = false;
        for (char c : res) {
            if (c == '0' && !seen) continue;
            sb.append(c);
            seen = true;
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
