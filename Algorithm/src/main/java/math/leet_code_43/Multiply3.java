package math.leet_code_43;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/1 18:55
 * @Desc :
 */
public class Multiply3 {
    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        Multiply3 multiply = new Multiply3();
        String result = multiply.multiply3(num1, num2);
        System.err.println("result : " + result);
    }

    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = p1 + 1;

                int sum = mul + res[p2];
                // 取余
                res[p2] = sum % 10;
                // 进位
                res[p1] += sum / 10;
            }
        }

        // in vase zero at prefix
        int index = 0;
        while (index < res.length && res[index] == 0) {
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (index < res.length) {
            sb.append(res[index]);
            index++;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public String multiply2(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = p1 + 1;
                int sum = mul + res[p2];
                // 普通位数相加
                res[p2] = sum % 10;
                // 进位累加
                res[p1] += sum / 10;
            }
        }
        int index = 0;
        int length = res.length;
        while (index < length && res[index] == 0) {
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (index < length) {
            sb.append(res[index]);
            index++;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public String multiply3(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int len = m + n;
        int[] res = new int[len];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = p1 + 1;
                int sum = mul + res[p2];
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

    public String multiply4(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int len = m + n;
        int[] res = new int[len];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = p1 + 1;
                int sum = mul + res[p2];
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
