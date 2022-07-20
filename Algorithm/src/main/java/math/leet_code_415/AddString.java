package math.leet_code_415;

/**
 * @author : dev
 * @version :
 * @Date :  5/30/21 11:16 PM
 * @Desc : leetcode  415 :字符串相加：字节半年 10 次：https://leetcode-cn.com/problems/add-strings/
 * <p>
 * 题解：https://leetcode-cn.com/problems/add-strings/solution/add-strings-shuang-zhi-zhen-fa-by-jyd/
 */
public class AddString {

    public static void main(String[] args) {
        AddString addString = new AddString();
        String n1 = "678";
        String n2 = "345";

        String result = addString.addStrings(n1, n2);
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("result : " + result);
        System.out.println("'0' : " + '0');
    }

    public String addStrings(String num1, String num2) {
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;

        int result = 0;
        int digit = 0;
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (len1 >= 0 || len2 >= 0) {
            int x = len1 < 0 ? 0 : num1.charAt(len1) - '0';
            int y = len2 < 0 ? 0 : num2.charAt(len2) - '0';
            System.out.println("x: " + x + " , y: " + y);
            // 每一位的寄过
            int sum = x + y + digit;
            // 进位
            digit = sum / 10;
            // 个位，十位，百位上的数
            sum = sum % 10;
            sb.append(sum);
            len1--;
            len2--;
        }
        if (digit > 0) {
            sb.append(digit);
        }

        return String.valueOf(sb.reverse());
    }

    public String addStrings2(String nums1, String nums2) {
        StringBuilder res = new StringBuilder();
        int i = nums1.length() - 1;
        int j = nums2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? nums1.charAt(i) - '0' : 0;
            int y = j >= 0 ? nums2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }

        if (carry == 1) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    public String addStrings3(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            stringBuilder.append(sum % 10);
            i--;
            j--;

        }
        if (carry > 0) {
            stringBuilder.append(carry);
        }
        return stringBuilder.reverse().toString();


    }

}
