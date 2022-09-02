package string.leet_code_541;

/**
 * @author : dev
 * @version :
 * @Date :  2022/9/2 11:50
 * @Desc :
 */
public class ReverseString {
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String s = "abcdefg";
        int k = 2;
        String result = reverseString.reverseStr(s, k);
        if ("bacdfeg".equals(result)) {
            System.err.println("well done");
        } else {
            System.err.println("the code is in failure");

        }
    }

    /**
     * 输入：s = "abcdefgh", k = 3
     * **********012 345 67
     * 输出：    "abc def gh "
     *
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int len = s.length() - 1;
        int interval = k - 1;
        for (int i = 0; i < len; i += 2 * k) {
            int end = i + interval;

            end = Math.min(end, len);

            reverse(sb, i, end);
        }
        return sb.toString();
    }

    public void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
        System.out.println("sb:  " + sb.toString());
    }

}
