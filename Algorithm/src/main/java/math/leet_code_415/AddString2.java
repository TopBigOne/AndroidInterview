package math.leet_code_415;

/**
 * @author : dev
 * @version :
 * @Date :  2022/7/20 02:45
 * @Desc :
 */
public class AddString2 {
    public static void main(String[] args) {
        AddString2 addString2 = new AddString2();
        String num1 = "41", num2 = "123";
        String result = addString2.addStrings(num1, num2);
        System.err.println("result: " + result);


    }

    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (len1 >= 0 || len2 >= 0) {
            int x = len1 >= 0 ? num1.charAt(len1) - '0' : 0;
            int y = len2 >= 0 ? num2.charAt(len2) - '0' : 0;

            System.err.println("x: " + x + " , y: " + y);
            int sum = x + y + carry;
            carry = sum / 10;
            stringBuilder.append(sum % 10);

            len1--;
            len2--;
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();

    }

    public String addStrings2(String num1, String num2) {
        int m = num1.length() - 1;
        int n = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (m >= 0 || n >= 0) {
            int x = m < 0 ? 0 : num1.charAt(m--) - '0';
            int y = n < 0 ? 0 : num2.charAt(n--) - '0';
            int sum = x + y + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();

    }
}
