package palindrome.leet_code_125;

/**
 * @author : dev
 * @version :
 * @Date :  2022/8/27 12:53
 * @Desc :125. 验证回文串 https://leetcode.cn/problems/valid-palindrome/
 */
public class IsPalindrome {

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        String s = "A man, a plan, a canal: Panama";
        s = "race a car";
        boolean result = isPalindrome.isPalindrome(s);
        System.err.println("result : " + result);

    }

    /**
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
     * 短语正着读和反着读都一样。
     * 则可以认为该短语是一个回文串。
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);

            boolean c1 = Character.isDigit(currChar);
            boolean c2 = currChar >= 'A' && currChar <= 'Z';
            boolean c3 = currChar >= 'a' && currChar <= 'z';
            if (c1) {
                sb.append(currChar);
                continue;
            }
            if (c2) {
                currChar = Character.toLowerCase(currChar);
                sb.append(currChar);
                continue;
            }
            if (c3) {
                sb.append(currChar);
            }
        }

        int left = 0;
        int right = sb.length() - 1;
        while (left <= right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
