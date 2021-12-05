package array.leet_code_58;

/**
 * @author :  dev
 * @version :
 * @Date :   2021/12/2 23:29
 * @Url : https://leetcode-cn.com/problems/length-of-last-word/solution/
 * @Level :  easy
 * @Desc :
 * @Counter :
 * @Answer : https://leetcode-cn.com/problems/length-of-last-word/solution/hua-jie-suan-fa-58-zui-hou-yi-ge-dan-ci-de-chang-d/
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s = "Hello World";
        s = "   fly me   to   the moon  ";
        s = "day";
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        int result = lengthOfLastWord.lengthOfLastWord(s);
        System.out.println("result : " + result);

    }

    /**
     * 不行的题解（周广亚写的）
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {

        int result = 0;
        int length = s.length();
        int right = 0;
        if (length == 1 && s.charAt(0) != ' ') {
            return 1;
        }
        if (length == 2 && s.charAt(0) != ' ' && s.charAt(1) == ' ') {
            return 1;
        }


        for (int i = length - 1; i >= 0; i--) {
            char currChar = s.charAt(i);

            if (right == 0 && currChar != ' ') {
                right = i;
            }
            if (right != 0 && currChar == ' ') {
                result = right - i;
                break;
            }

        }
        return result;

    }

    public int lengthOfLastWord2(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' '){
            end--;
        }
        if (end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' '){
            start--;
        }
        return end - start;

    }

}
