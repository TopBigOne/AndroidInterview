package math.leet_code_43;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/2 11:02
 * @Desc :
 */
public class Multiply4 {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int len = m + n;
        int[] res = new int[len];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = p1 + 1;
                int sum = res[p2] + mul;
                res[p2] = sum % 10;
                res[p1] += sum / 10;
            }

        }
        int index = 0;
        while (index < len && res[index] == 0) {
            index++;
        }
        StringBuilder sb = new StringBuilder();

        while (index < len) {
            sb.append(res[index]);
            index++;
        }
        return sb.length() == 0 ? "0" : sb.toString();


    }
}
